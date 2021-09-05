package com.rauldionisio.louvores.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.DTO.MusicDetailsDTO;
import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.repositories.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository repository;
	
	public List<Music>findAll(){
		return repository.findAll();
	}
	
	public List<Music>findByName(String name){
		return repository.findByNameContainingIgnoreCase(name);
	}
	
	public List<Music>findByArtist(Artist artist){
		return repository.findByArtist(artist);
	}
	
	public List<Music>findByMoment(String moment){
		return repository.getByMoment(moment);
	}
	
	public List<Music>findByStyle(Style style){
		return repository.findByStyle(style);
	}
	
	public List<Music>findByLyrics(String lyrics){
		return repository.getbyLirycs(lyrics);
	}
	
	public Music insert(Music music) {
		return repository.save(music);
	}
	
	public List<MusicDetailsDTO>getLastTemMusics(){
		List<MusicDetailsDTO> dtoList = new ArrayList<>();
		List<String[]> musics = repository.getLastTemMusics();
		for(String[] music: musics) {
			MusicDetailsDTO dto = new MusicDetailsDTO();
			dto.setName(music[0]);
			dto.setArtist(music[1]);
			dto.setAlbum(music[2]);
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}

}
