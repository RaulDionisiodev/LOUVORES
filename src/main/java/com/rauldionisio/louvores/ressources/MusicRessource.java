package com.rauldionisio.louvores.ressources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.rauldionisio.louvores.DTO.MusicDTO;
import com.rauldionisio.louvores.DTO.MusicDetailsDTO;
import com.rauldionisio.louvores.entities.Album;
import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.entities.Moment;
import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.services.AlbumService;
import com.rauldionisio.louvores.services.ArtistService;
import com.rauldionisio.louvores.services.MomentService;
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
	
	@Autowired
	private AlbumService albumservice;
	
	@Autowired
	private MomentService momentservice;
	
	
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

	@ResponseBody
	@RequestMapping(path = "/findBylyrics", method = RequestMethod.GET)
	public ResponseEntity<List<Music>>findBylyrics(@RequestParam("lyrics") String lyrics){
		List<Music> musicList = service.findByLyrics(lyrics);	
		return ResponseEntity.ok(musicList);
	}
	
	@ResponseBody
	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String>insert(@RequestBody MusicDTO musicDto){
		
		Artist artist = artistService.findById(musicDto.getArtistId());
		Album album = albumservice.findById(musicDto.getAlbumId());
		Style style = styleService.findById(musicDto.getStyleId()).orElse(null);
		Set<Moment> moments = new HashSet<>();
		
		for(Long ids : musicDto.getMomentIds()) {
			moments.add(momentservice.findById(ids));
		}
		
		Music music = new Music(null, musicDto.getName(), musicDto.getLyrics(), artist, album, style);
		music.getMomentList().addAll(moments);
		
		try {
			service.insert(music);
			album.getMusicList().add(music);
			albumservice.insert(album);
			return ResponseEntity.status(HttpStatus.CREATED).body("Música inserida com sucesso");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao inserir música");

		}
	}
	
	
	@ResponseBody
	@GetMapping(path = "/getLastTemMusics")
	public ResponseEntity<List<MusicDetailsDTO>>getLastTemMusics(){
		List<MusicDetailsDTO> musicList = service.getLastTemMusics();	
		return ResponseEntity.ok(musicList);
	}
	
}
