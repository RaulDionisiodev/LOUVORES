package com.rauldionisio.louvores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Moment;

@Repository
public interface MomentRepository extends JpaRepository<Moment, Integer>{

	List<Moment> findByDescriptionContainingIgnoreCase(String description);
	
	Moment findById(Long id);
	
	@Query(value = "SELECT top (10) description FROM MOMENT order by id desc", 
			nativeQuery = true)
	List<String> getLastTemMoments();
	
	
}
