package com.rauldionisio.louvores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.entities.Album;
import com.rauldionisio.louvores.repositories.AlbumRepository;


@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository repository;
	
	public List<Album>findAll(){
		return repository.findAll();
	}
	
	public List<Album>findByName(String name){
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Album insert(Album album) {
		return repository.save(album);
	}
	
	public Album findById(Long id) {
		return repository.findById(id);
	}

}
