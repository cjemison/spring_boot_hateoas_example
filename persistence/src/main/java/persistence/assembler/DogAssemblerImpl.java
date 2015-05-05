package persistence.assembler;

import org.springframework.stereotype.Component;

import model.entities.DogEO;
import persistence.datatype.DogBO;

@Component
public class DogAssemblerImpl extends AbstractAssembler<DogEO, DogBO> implements DogAssembler {
    @Override
    public DogBO toBusinessObject(DogEO dogEO) {
        return new DogBO.Builder()
                .setId(dogEO.getId())
                .setName(dogEO.getName()).build();
    }

    @Override
    public DogEO toEntity(DogBO dogBO) {
        DogEO dogEO = new DogEO();
        dogEO.setId(dogBO.getId());
        dogEO.setName(dogBO.getName());
        return dogEO;
    }
}
