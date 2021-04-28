package com.rauldionisio.louvores.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Style;

@Repository
public interface StyleRepository extends JpaRepository<Style, Integer>{

	List<Style>findByDescriptionContainingIgnoreCase(String descripiton);
	
	Optional<Style> findById(Long id);
	
	
}
