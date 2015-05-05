package persistence.assembler;

import model.entities.DogEO;
import org.springframework.stereotype.Component;
import persistence.datatype.DogBO;

@Component
public class DogAssemblerImpl extends Assembler<DogEO, DogBO> implements DogAssembler {
    @Override
    public DogBO toBusinessObject(DogEO dogEO) {
        return new DogBO.Builder().setId(dogEO.getId()).setName(dogEO.getName()).build();
    }

    @Override
    public DogEO toEntity(DogBO dogBO) {
        DogEO dogEO = new DogEO();
        dogEO.setId(dogBO.getId());
        dogEO.setName(dogBO.getName());
        return null;
    }
}
