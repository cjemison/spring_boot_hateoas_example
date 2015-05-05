package web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import persistence.datatype.DogBO;
import service.DogService;
import web.assembler.DogAssembler;


@RestController
public class SampleController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private DogAssembler dogAssembler;
    @Autowired
    private DogService dogService;

    @RequestMapping(value = "/", produces = {"application/json"})
    public HttpEntity<?> index() {
        List<DogBO> list = new ArrayList<>();
        for (int i = 0; i < Math.abs(new Random().nextInt() % 1000); i++) {
            DogBO d = new DogBO.Builder().setName(UUID.randomUUID().toString()).build();
            list.add(d);
        }
        LOGGER.debug("BO List: {}", list);
        dogService.save(list);
        return new ResponseEntity<>(dogAssembler.toResources(dogService.findAll()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{dogId}", produces = {"application/json"})
    public HttpEntity<?> get(@PathVariable Long dogId) {
        return new ResponseEntity<>(dogAssembler.toResource(dogService.findById(dogId)), HttpStatus.OK);
    }
}
