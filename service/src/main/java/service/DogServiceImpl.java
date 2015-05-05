package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistence.DogPersistence;
import persistence.datatype.DogBO;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogPersistence dogPersistence;

    @Override
    public DogBO save(final DogBO dogBO) {
        return dogPersistence.save(dogBO);
    }

    @Override
    public List<DogBO> findAll() {
        return dogPersistence.findAll();
    }
}