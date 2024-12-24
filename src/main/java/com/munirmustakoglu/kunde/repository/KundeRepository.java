package com.munirmustakoglu.kunde.repository;

import com.munirmustakoglu.kunde.entities.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundeRepository extends JpaRepository<Kunde, Integer> {
}
