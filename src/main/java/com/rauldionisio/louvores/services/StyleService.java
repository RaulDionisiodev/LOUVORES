package com.rauldionisio.louvores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.entities.Moment;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.repositories.MomentRepository;
import com.rauldionisio.louvores.repositories.StyleRepository;

@Service
public class StyleService {
	
	@Autowired
	private StyleRepository repository;
	
	public List<Style>findAll(){
		return repository.findAll();
	}
	
	public List<Style>findByName(String name){
		return repository.findByDescriptionContainingIgnoreCase(name);
	}
	

}