package com.rauldionisio.louvores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

}
