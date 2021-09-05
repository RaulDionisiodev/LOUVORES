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
	
	// TODO - testar isso no mysql quando acabar pq o h2 não aceita collate
//	@Query(value = "select * from music m "
//			+ "inner join MUSIC_MOMENT_LIST mml on m.id = mml.music_id "
//			+ "inner join MOMENT mom on mom.id = mml.moment_list_id "
//			+ "where mom.description like  CAST LOWER(concat('%',?1,'%'))"
//			+ " COLLATE Latin1_General_CI_AI", nativeQuery = true)
//	List<Music>getByMoment(String moment);
	
	List<Music> findByStyle(Style style);
	
	@Query("SELECT m FROM Music m "
			+ "WHERE m.lyrics like concat('%',?1,'%')")
	List<Music>getbyLirycs(String part);
	
	@Query(value = "SELECT top(10) m.name as name, a.name as artist , ar.name as album "
			+ "FROM music m "
			+ "inner join Album a on a.id = m.album_id "
			+ "inner join Artist ar on  ar.id = m.artist_id "
			+ "ORDER BY m.id DESC", nativeQuery = true)
	List<String[]>getLastTemMusics();
	
	
}
