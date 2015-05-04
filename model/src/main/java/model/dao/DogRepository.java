package model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.entities.Dog;

@Repository
public interface DogRepository extends PagingAndSortingRepository<Dog, Long> {

}
