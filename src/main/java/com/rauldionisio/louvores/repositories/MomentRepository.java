package com.rauldionisio.louvores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rauldionisio.louvores.entities.Moment;

@Repository
public interface MomentRepository extends JpaRepository<Moment, Integer>{

}
