package persistence;

import java.util.List;

import persistence.datatype.DogBO;

public interface DogPersistence {
    DogBO save(final DogBO dogBO);

    Iterable<DogBO> save(final List<DogBO> list);

    List<DogBO> findAll();

    DogBO findById(final Long id);
}
