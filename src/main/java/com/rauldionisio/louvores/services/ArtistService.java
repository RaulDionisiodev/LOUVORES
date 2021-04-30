package com.rauldionisio.louvores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	private ArtistRepository repository;
	
	public List<Artist>findAll(){
		return repository.findAll();
	}
	
	public List<Artist>findByName(String name){
		return repository.findByNameContainingIgnoreCase(name);
	}
	
	public Artist insert(Artist artist) {
		return repository.save(artist);
	}
	
	public Artist findById(Long id) {
		return repository.findById(id);
	}


}
