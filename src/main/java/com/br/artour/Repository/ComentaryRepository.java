package com.br.artour.Repository;

import com.br.artour.Entity.Comentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentaryRepository extends JpaRepository<Comentary,Long> {

    @Query("SELECT u FROM Comentary u WHERE u.establishment.id = :idEstablishment AND u.approved = 3")
    List<Comentary> getApprovedCommentsFromEstablishment(Long idEstablishment);
}
