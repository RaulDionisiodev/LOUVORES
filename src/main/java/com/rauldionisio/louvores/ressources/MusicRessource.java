package com.rauldionisio.louvores.ressources;

import java.util.ArrayList;
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
import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.services.ArtistService;
import com.rauldionisio.louvores.services.MusicService;
import com.rauldionisio.louvores.services.StyleService;

@RestController
@RequestMapping(value ="/music")
public class MusicRessource {
	
	@Autowired
	private MusicService service;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private StyleService styleService;
	
	
	@GetMapping
	public ResponseEntity<List<Music>>findAll(){
		List<Music> body = service.findAll();
		return ResponseEntity.ok(body);
	}
	
	@ResponseBody
	@RequestMapping(path = "/findByname", method = RequestMethod.GET)
	public ResponseEntity<List<Music>>findbyname(@RequestParam("name") String name){
		List<Music> music = service.findByName(name);
		return ResponseEntity.ok(music);
		
	}
	
	@ResponseBody
	@RequestMapping(path = "/findbyArtist", method = RequestMethod.GET)
	public ResponseEntity<List<Music>>findbyArtist(@RequestParam("name") String name){
		List <Artist> artists = artistService.findByName(name);
		
		List<Music> music = new ArrayList<>();
		
		artists.forEach( a -> {
			music.addAll(service.findByArtist(a));
		});
		return ResponseEntity.ok(music);
		
	}
	
	@ResponseBody
	@RequestMapping(path = "/findByMoment", method = RequestMethod.GET)
	public ResponseEntity<List<Music>>findByMoment(@RequestParam("momentName") String momentName){
		List<Music> musicList = service.findByMoment(momentName);	
		return ResponseEntity.ok(musicList);
	}
	
	@ResponseBody
	@RequestMapping(path = "/findbyStyle", method = RequestMethod.GET)
	public ResponseEntity<List<Music>>findbyStyle(@RequestParam("styleName") String styleName){
		
		List<Style> styleList = styleService.findByName(styleName);
		
		List<Music> music = new ArrayList<>();
		
		styleList.forEach( style -> {
			music.addAll(service.findByStyle(style));
		});
		return ResponseEntity.ok(music);
		
	}

}
