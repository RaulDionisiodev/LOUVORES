package DTO;

import java.util.HashSet;
import java.util.Set;

public class MusicDTO {

	private Long id;
	private String name;
	private String lyrics;
	private Long artistId;
	private Long albumId;
	private Long styleId;
	private Set<Long>momentIds = new HashSet<>();
	
	public MusicDTO() {}

	public MusicDTO(Long id, String name, String lyrics, Long artistId, Long albumId, Long styleId) {
		this.id = id;
		this.name = name;
		this.lyrics = lyrics;
		this.artistId = artistId;
		this.albumId = albumId;
		this.styleId = styleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Set<Long> getMomentIds() {
		return momentIds;
	}

	public void setMomentIds(Set<Long> momentIds) {
		this.momentIds = momentIds;
	}

}
