package com.rauldionisio.louvores.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Style implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descripiton;
	
	public Style() {}

	public Style(Long id, String descripiton) {
		this.id = id;
		this.descripiton = descripiton;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripiton() {
		return descripiton;
	}

	public void setDescripiton(String descripiton) {
		this.descripiton = descripiton;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripiton == null) ? 0 : descripiton.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Style other = (Style) obj;
		if (descripiton == null) {
			if (other.descripiton != null)
				return false;
		} else if (!descripiton.equals(other.descripiton))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", descripiton=" + descripiton + "]";
	}
	

}
