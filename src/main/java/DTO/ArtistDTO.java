package DTO;

public class ArtistDTO {
	
	private Long id;
	private String name;
	private Long style_id;
	
	public ArtistDTO() {}

	public ArtistDTO(Long id, String name, Long style_id) {
		this.id = id;
		this.name = name;
		this.style_id = style_id;
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

	public Long getStyle_id() {
		return style_id;
	}

	public void setStyle_id(Long style_id) {
		this.style_id = style_id;
	}
	

}
