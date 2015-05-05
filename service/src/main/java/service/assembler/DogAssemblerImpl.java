package service.assembler;

import model.entities.DogEO;
import org.springframework.stereotype.Component;
import service.datatype.DogBO;

@Component
public class DogAssemblerImpl extends AbstractAssembler<DogEO, DogBO> implements DogAssembler {
    @Override
    public DogBO toViewObject(DogEO dogEO) {
        return null;
    }

    @Override
    public DogEO toEntity(DogBO dogBO) {
        DogEO dogEO = new DogEO();
        dogEO.setId(dogBO.getId());
        dogEO.setName(dogBO.getName());
        return null;
    }
}
