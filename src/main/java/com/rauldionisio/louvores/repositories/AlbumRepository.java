package com.rauldionisio.louvores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{

	List<Album>findByNameContainingIgnoreCase(String name);
	
}
