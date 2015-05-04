package web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class SampleController {

    @RequestMapping("/")
    public HttpEntity<?> index() {

        List<String> list = new ArrayList<String>();

        int cnt = Math.abs(new Random().nextInt() % 50);
        for (int i = 0; i < cnt; i++) {
            list.add(UUID.randomUUID().toString());
        }
        Resource<Wrapper> resource = new Resource<>(new Wrapper(list));
        resource.add(linkTo(SampleController.class).slash("/").withSelfRel());
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
