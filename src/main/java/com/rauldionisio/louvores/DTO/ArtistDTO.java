package com.rauldionisio.louvores.DTO;

public class ArtistDTO {
	
	private Long id;
	private String name;
	private Long styleId;
	
	public ArtistDTO() {}

	public ArtistDTO(Long id, String name, Long styleId) {
		this.id = id;
		this.name = name;
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

	public Long getstyleId() {
		return styleId;
	}

	public void setstyleId(Long styleId) {
		this.styleId = styleId;
	}
	

}
