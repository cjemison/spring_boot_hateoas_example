package persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import model.dao.DogRepository;
import model.entities.DogEO;
import persistence.assembler.DogAssembler;
import persistence.datatype.DogBO;

@Component
public class DogPersistenceImpl implements DogPersistence {
    private final static Logger LOGGER = LoggerFactory.getLogger(DogPersistenceImpl.class);
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

    @Override
    public Iterable<DogBO> save(List<DogBO> list) {
        LOGGER.debug("List: {}", list);
        Iterable<DogEO> dogEOList = dogAssembler.toEntityList(list);
        LOGGER.debug("Response: {}", dogEOList);
        return dogAssembler.toBusinessList(dogRepository.save(dogEOList));
    }

    @Override
    public DogBO findById(final Long id) {
        return dogAssembler.toBusinessObject(dogRepository.findOne(id));
    }
}
