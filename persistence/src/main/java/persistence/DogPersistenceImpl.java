package persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import model.dao.DogRepository;
import model.entities.DogEO;
import persistence.assembler.DogAssembler;
import persistence.datatype.DogBO;

@Component
public class DogPersistenceImpl implements DogPersistence {
    @Autowired
    private DogAssembler dogAssembler;
    @Autowired
    private DogRepository dogRepository;

    @Override
    public DogBO save(DogBO dogBO) {
        DogEO dogEO = dogRepository.save(dogAssembler.toEntity(dogBO));
        return dogAssembler.toBusinessObject(dogEO);
    }

    @Override
    public List<DogBO> findAll() {
        Iterable<DogEO> list = dogRepository.findAll();
        return Lists.newArrayList(dogAssembler.toBusinessList(list));
    }
}
