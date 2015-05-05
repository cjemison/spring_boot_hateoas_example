package web.assembler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import model.entities.DogEO;
import persistence.datatype.DogBO;
import web.controller.SampleController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class DogAssembler extends ResourceAssemblerSupport<DogBO, Resource> {

    public DogAssembler() {
        super(DogEO.class, Resource.class);
    }

    public List<Resource> toResources(List<DogBO> dogEOList) {
        List<Resource> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dogEOList)) {
            for (DogBO dogEO : dogEOList) {
                list.add(toResource(dogEO));
            }
        }
        return list;
    }


    @Override
    public Resource toResource(final DogBO entity) {
        Resource<DogBO> resource = new Resource<>(entity);
        resource.add(linkTo(SampleController.class).slash(entity.getId().toString()).withSelfRel());
        return resource;
    }
}
