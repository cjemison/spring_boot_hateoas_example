package model.dao;

import model.entities.DogEO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends PagingAndSortingRepository<DogEO, Long> {

}
