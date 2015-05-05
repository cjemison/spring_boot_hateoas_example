package web.assembler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import web.controller.SampleController;
import web.datatype.DogVO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class DogAssembler extends ResourceAssemblerSupport<DogVO, Resource> {

    public DogAssembler() {
        super(DogVO.class, Resource.class);
    }

    public List<Resource> toResources(List<DogVO> dogEOList) {
        List<Resource> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dogEOList)) {
            for (DogVO dogEO : dogEOList) {
                list.add(toResource(dogEO));
            }
        }
        return list;
    }


    @Override
    public Resource toResource(final DogVO entity) {
        Resource<DogVO> resource = new Resource<>(entity);
        resource.add(linkTo(SampleController.class).slash(entity.getId().toString()).withSelfRel());
        return resource;
    }
}
