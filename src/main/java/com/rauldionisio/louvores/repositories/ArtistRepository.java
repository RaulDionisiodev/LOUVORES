package com.rauldionisio.louvores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{
	
	List<Artist>findByNameContainingIgnoreCase(String name);

}
