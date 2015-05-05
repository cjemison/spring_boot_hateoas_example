package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.DogPersistence;
import persistence.datatype.DogBO;

@Service
public class DogServiceImpl implements DogService {
    private final static Logger LOGGER = LoggerFactory.getLogger(DogServiceImpl.class);
    @Autowired
    private DogPersistence dogPersistence;

    @Override
    @Transactional
    public DogBO save(final DogBO dogBO) {
        return dogPersistence.save(dogBO);
    }

    @Override
    @Transactional
    public Iterable<DogBO> save(List<DogBO> list) {
        LOGGER.info("List: {}", list);
        return dogPersistence.save(list);
    }

    @Override
    public List<DogBO> findAll() {
        return dogPersistence.findAll();
    }


    @Override
    public DogBO findById(final Long id) {
        return dogPersistence.findById(id);
    }
}