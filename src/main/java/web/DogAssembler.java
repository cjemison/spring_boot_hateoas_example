package web;


import model.entities.DogEO;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class DogAssembler extends ResourceAssemblerSupport<DogEO, Resource> {

    public DogAssembler() {
        super(DogEO.class, Resource.class);
    }

    public List<Resource> toResources(List<DogEO> dogEOList) {
        List<Resource> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dogEOList)) {
            for (DogEO dogEO : dogEOList) {
                list.add(toResource(dogEO));
            }
        }
        return list;
    }


    @Override
    public Resource toResource(final DogEO entity) {
        Resource<DogEO> resource = new Resource<>(entity);
        resource.add(linkTo(SampleController.class).slash(entity.getId().toString()).withSelfRel());
        return resource;
    }
}
