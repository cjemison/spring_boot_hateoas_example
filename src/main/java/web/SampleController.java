package web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.dao.DogRepository;
import model.entities.Dog;



@RestController
public class SampleController {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private DogAssembler dogAssembler;

    @RequestMapping(value = "/", produces = {"application/json"})
    @Transactional
    public HttpEntity<?> index() {

        List<Dog> list = new ArrayList<Dog>();

        int cnt = Math.abs(new Random().nextInt() % 25);
        for (int i = 0; i < cnt; i++) {
            Dog d = new Dog();
            d.setName(UUID.randomUUID().toString());
            list.add(d);
        }
        dogRepository.save(list);
        return new ResponseEntity<>(dogAssembler.toResources(list), HttpStatus.OK);
    }
}
