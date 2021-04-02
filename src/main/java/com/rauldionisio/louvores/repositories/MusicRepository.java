package com.rauldionisio.louvores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>{

	List<Music>findByNameContainingIgnoreCase(String name);
	
}
