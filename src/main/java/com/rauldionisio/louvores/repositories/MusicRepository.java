package com.rauldionisio.louvores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.entities.Style;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>{

	List<Music>findByNameContainingIgnoreCase(String name);
	
	List<Music>findByArtist(Artist artist);
	
	@Query("SELECT m FROM Music m "
			+ "INNER JOIN m.momentList moment "
			+ "where LOWER(moment.description) like  LOWER(concat('%',?1,'%'))")
	List<Music>getByMoment(String moment);
	
	List<Music> findByStyle(Style style);
	
	
	
}
