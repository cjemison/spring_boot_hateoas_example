package service;

import model.dao.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;
}
