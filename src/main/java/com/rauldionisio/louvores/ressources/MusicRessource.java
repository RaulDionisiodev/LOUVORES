package com.rauldionisio.louvores.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.services.MusicService;

@RestController
@RequestMapping(value ="/music")
public class MusicRessource {
	
	@Autowired
	private MusicService service;
	
	@GetMapping
	public ResponseEntity<List<Music>>findAll(){
		List<Music> body = service.findAll();
		return ResponseEntity.ok(body);
	}

}
