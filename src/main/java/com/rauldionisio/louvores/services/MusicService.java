package com.rauldionisio.louvores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.repositories.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository repository;
	
	public List<Music>findAll(){
		return repository.findAll();
	}
	
	public List<Music>findByName(String name){
		return repository.findByNameContainingIgnoreCase(name);
	}
	
	public List<Music>findByArtist(Artist artist){
		return repository.findByArtist(artist);
	}
	
	public List<Music>findByMoment(String moment){
		return repository.getByMoment(moment);
	}
	
	public List<Music>findByStyle(Style style){
		return repository.findByStyle(style);
	}
	
	public List<Music>findByLyrics(String lyrics){
		return repository.getbyLirycs(lyrics);
	}
	
	public Music insert(Music music) {
		return repository.save(music);
	}

}
