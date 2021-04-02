package com.rauldionisio.louvores.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.services.ArtistService;

@RestController
@RequestMapping(value ="/artist")
public class ArtistRessource {
	
	@Autowired
	private ArtistService service;
	
	@GetMapping
	public ResponseEntity<List<Artist>>findAll(){
		List<Artist> body = service.findAll();
		return ResponseEntity.ok(body);
	}
	
	@ResponseBody
	@RequestMapping(path = "/findByname", method = RequestMethod.GET)
	public ResponseEntity<List<Artist>>findbyname(@RequestParam("name") String name){
		List<Artist> artists = service.findByName(name);
		return ResponseEntity.ok(artists);
		
	}

}
