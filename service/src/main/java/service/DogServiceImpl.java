package service;

import model.entities.DogEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private

    @Override
    public DogBO save(DogBO dogBO) {
        DogEO dogEO = dogAssembler.toEntity(dogBO);
    }
}
