package persistence;

import persistence.datatype.DogBO;

import java.util.List;

public interface DogPersistence {
    DogBO save(final DogBO dogBO);

    List<DogBO> findAll();
}
