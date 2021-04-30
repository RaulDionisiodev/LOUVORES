package DTO;

public class AlbumDTO {
	
	private Long id;
	private String name;
	private Long artistId;
	private Long styleId;
	
	public AlbumDTO() {}

	public AlbumDTO(Long id, String name, Long artistId, Long styleId) {
		this.id = id;
		this.name = name;
		this.artistId = artistId;
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

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}
}
