package com.rauldionisio.louvores.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Album implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne 
	@JsonIgnoreProperties({"style"})
	private Artist artist;
	
	@ManyToOne
	@JoinColumn(name="style_id")
	@JsonProperty("album_style")
	private Style style;
	
	@OneToMany
	@JsonIgnoreProperties({"lyrics", "album", "artist"})
	private List<Music>musicList = new ArrayList<>();


	public Album() {}

	
	public Album(Long id, String name, Artist artist, Style style) {
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.style = style;
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


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	

	public Style getStyle() {
		return style;
	}


	public void setStyle(Style style) {
		this.style = style;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + "]";
	}
	
}
