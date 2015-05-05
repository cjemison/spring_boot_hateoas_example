package service;


import java.util.List;

import persistence.datatype.DogBO;

public interface DogService {
    DogBO save(final DogBO dogBO);

    DogBO findById(final Long id);

    Iterable<DogBO> save(final List<DogBO> list);

    List<DogBO> findAll();
}
