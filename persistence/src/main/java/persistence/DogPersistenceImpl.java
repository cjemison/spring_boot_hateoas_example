package persistence;

import model.dao.DogRepository;
import model.entities.DogEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.assembler.DogAssembler;
import persistence.datatype.DogBO;

import java.util.List;

@Component
public class DogPersistenceImpl implements DogPersistence {
    @Autowired
    private DogAssembler dogAssembler;
    @Autowired
    private DogRepository dogRepository;

    @Override
    public DogBO save(DogBO dogBO) {
        DogEO dogEO = dogRepository.save(dogAssembler.toEntity(dogBO));
        return dogAssembler.toViewObject(dogEO);
    }

    @Override
    public List<DogBO> findAll() {

        Iterable<DogEO> list = dogRepository.findAll();
        return null;
    }
}
