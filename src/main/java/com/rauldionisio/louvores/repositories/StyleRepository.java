package com.rauldionisio.louvores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Style;

@Repository
public interface StyleRepository extends JpaRepository<Style, Integer>{

}
