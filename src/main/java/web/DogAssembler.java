package web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import model.entities.Dog;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class DogAssembler extends ResourceAssemblerSupport<Dog, Resource> {

    public DogAssembler() {
        super(Dog.class, Resource.class);
    }

    public List<Resource> toResources(List<Dog> dogList) {
        List<Resource> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dogList)) {
            for (Dog dog : dogList) {
                list.add(toResource(dog));
            }
        }
        return list;
    }


    @Override
    public Resource toResource(final Dog entity) {
        Resource<Dog> resource = new Resource<>(entity);
        resource.add(linkTo(SampleController.class).slash("dog").slash(entity.getId().toString()).withSelfRel());
        return resource;
    }
}
