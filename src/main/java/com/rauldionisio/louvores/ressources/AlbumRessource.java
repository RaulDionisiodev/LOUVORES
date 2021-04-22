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

import com.rauldionisio.louvores.entities.Album;
import com.rauldionisio.louvores.services.AlbumService;

@RestController
@RequestMapping(value ="/album")
public class AlbumRessource {
	
	@Autowired
	private AlbumService service;
	
	
	@GetMapping
	public ResponseEntity<List<Album>>findAll(){
		List<Album> body = service.findAll();
		return ResponseEntity.ok(body);
	}
	
	@ResponseBody
	@RequestMapping(path = "/findByname", method = RequestMethod.GET)
	public ResponseEntity<List<Album>>findbyname(@RequestParam("name") String name){
		List<Album> Album = service.findByName(name);
		return ResponseEntity.ok(Album);
		
	}

}
