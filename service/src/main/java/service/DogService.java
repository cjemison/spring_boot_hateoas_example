package service;


import java.util.List;

import persistence.datatype.DogBO;

public interface DogService {
    DogBO save(final DogBO dogBO);

    List<DogBO> findAll();
}
