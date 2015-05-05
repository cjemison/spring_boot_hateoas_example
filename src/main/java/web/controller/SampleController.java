package web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import persistence.datatype.DogBO;
import service.DogService;
import web.assembler.DogAssembler;
import web.datatype.DogVO;


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

        List<DogBO> dogBOList = dogService.findAll();

        List<DogVO> viewList = Lists.transform(dogBOList, new Function<DogBO, DogVO>() {
            @Override
            public DogVO apply(DogBO input) {
                DogVO dogVO = new DogVO.Builder().setId(input.getId()).setName(input.getName()).build();
                return dogVO;
            }
        });
        return new ResponseEntity<>(dogAssembler.toResources(viewList), HttpStatus.OK);
    }

    @RequestMapping(value = "/{dogId}", produces = {"application/json"})
    public HttpEntity<?> get(@PathVariable Long dogId) {
        DogBO dogBO = dogService.findById(dogId);
        LOGGER.debug("Entity: {}", dogBO);
        DogVO dogVO = new DogVO.Builder().setId(dogBO.getId()).setName(dogBO.getName()).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", "http://localhost:8080/" + dogVO.getId());
        ResponseEntity<?> responseEntity = new ResponseEntity<>(dogAssembler.toResource(dogVO), httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
}
