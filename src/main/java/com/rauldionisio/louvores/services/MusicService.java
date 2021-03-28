package com.rauldionisio.louvores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.repositories.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository repository;
	
	public List<Music>findAll(){
		return repository.findAll();
	}


}
