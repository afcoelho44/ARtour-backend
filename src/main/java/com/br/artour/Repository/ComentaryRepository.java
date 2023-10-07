package com.br.artour.Repository;

import com.br.artour.Entity.Comentary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentaryRepository extends JpaRepository<Comentary,Long> {
}
