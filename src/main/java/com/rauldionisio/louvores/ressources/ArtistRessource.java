package com.rauldionisio.louvores.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.services.ArtistService;
import com.rauldionisio.louvores.services.StyleService;

import DTO.ArtistDTO;

@RestController
@RequestMapping(value ="/artist")
public class ArtistRessource {
	
	@Autowired
	private ArtistService service;
	
	@Autowired
	private StyleService styleService;
	
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
	
	@ResponseBody
	@RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String>insert(@RequestBody ArtistDTO artistDto){
		List<Artist> artists = service.findByName(artistDto.getName()); 
		
		if(artists.isEmpty()) {
			Artist artist = new Artist();
			artist.setName(artistDto.getName());
			artist.setStyle(styleService.findById(artistDto.getstyleId()).orElse(null));
			try {
			artist = service.insert(artist);
				return ResponseEntity.status(HttpStatus.CREATED).body("Artista inserido com sucesso");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao inserir Artista");
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Artista já existente");

		}
	}

}
