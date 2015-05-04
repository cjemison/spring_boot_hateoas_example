package web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.dao.DogRepository;
import model.entities.Dog;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class SampleController {
    @Autowired
    private DogRepository dogRepository;

    @RequestMapping("/")
    public HttpEntity<?> index() {

        List<Dog> list = new ArrayList<Dog>();

        int cnt = Math.abs(new Random().nextInt() % 25);
        for (int i = 0; i < cnt; i++) {
            Dog d = new Dog();
            d.setName(UUID.randomUUID().toString());
            list.add(d);
        }
        dogRepository.save(list);
        Resource<Wrapper> resource = new Resource<>(new Wrapper(dogRepository.findAll()));
        resource.add(linkTo(SampleController.class).slash("/").withSelfRel());
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
