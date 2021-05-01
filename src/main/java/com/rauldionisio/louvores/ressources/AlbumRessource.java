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

import com.rauldionisio.louvores.entities.Album;
import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.services.AlbumService;
import com.rauldionisio.louvores.services.ArtistService;
import com.rauldionisio.louvores.services.StyleService;

import DTO.AlbumDTO;

@RestController
@RequestMapping(value ="/album")
public class AlbumRessource {
	
	@Autowired
	private AlbumService service;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private StyleService styleService;
	
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
	
	@ResponseBody
	@RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String>insert(@RequestBody AlbumDTO albumDto){
		Album album = new Album();
		Artist artist = artistService.findById(albumDto.getArtistId());
		Style style = styleService.findById(albumDto.getStyleId()).orElse(null);
		
		album.setName(albumDto.getName());
		album.setArtist(artist);
		album.setStyle(style);
		
		try {
			album = service.insert(album);
				return ResponseEntity.status(HttpStatus.CREATED).body("Album inserido com sucesso");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao inserir Album");
			}
	}

}
