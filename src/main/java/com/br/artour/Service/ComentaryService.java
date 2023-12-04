package com.br.artour.Service;

import com.br.artour.Entity.Comentary;
import com.br.artour.Exception.EstablishmentNotFoundException;
import com.br.artour.Mapper.ComentaryRequestToEntity;
import com.br.artour.Model.ComentaryRequest;
import com.br.artour.Repository.ComentaryRepository;
import com.br.artour.Repository.EstablishmentRepository;
import com.br.artour.Repository.UserRepository;
import com.br.artour.Response.ComentaryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentaryService {

    private ComentaryRepository comentaryRepository;

    private UserRepository userRepository;

    private EstablishmentRepository establishmentRepository;

    public List<ComentaryResponse> getAllComentary() {
        List<Comentary> comments = comentaryRepository.findAll();
        List<ComentaryResponse> commentsResponse = new ArrayList<>();
        for (Comentary comentary : comments) {
            var user = userRepository.findById(comentary.getUser().getId());
            var establishment = establishmentRepository.findById(comentary.getEstablishment().getId());
            commentsResponse.add(new ComentaryResponse(
                    comentary.getId(),
                    comentary.getTitle(),
                    comentary.getContent(),
                    null,
                    comentary.getApproved() == 0 ? "Aguardando Análise" : comentary.getApproved() == 1 ? "Reprovado" : comentary.getApproved() == 2 ? "Aprovado" : "",
                    user.get().getName(),
                    establishment.get().getName()));
        }
        return commentsResponse;
    }

    public ResponseEntity<Long> createComentery(ComentaryRequest request){
        var user= userRepository.findById(request.getUser_id()).orElseThrow(RuntimeException::new);
        var establishment= establishmentRepository.findById(request.getEstablishment_id()).orElseThrow(RuntimeException::new);
        var entity= new ComentaryRequestToEntity().map(request);
        entity.setUser(user);
        entity.setEstablishment(establishment);

        var id = comentaryRepository.save(entity).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
    public ResponseEntity<Comentary> updateComentary(Long id, ComentaryRequest request){
        var user= userRepository.findById(request.getUser_id()).orElseThrow(RuntimeException::new);
        var establishment= establishmentRepository.findById(request.getEstablishment_id()).orElseThrow(EstablishmentNotFoundException::new);
        var record= comentaryRepository.findById(id).orElseThrow(RuntimeException::new);
        record= new ComentaryRequestToEntity().mapUpdate(request,record);
        record.setUser(user);
        record.setEstablishment(establishment);
        comentaryRepository.save(record);


        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteComentary(Long id){

        comentaryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<ComentaryResponse> getComentaryById(Long id) {
        Comentary comentary = comentaryRepository.findById(id).orElse(null);
        if (comentary != null) {
            var user = userRepository.findById(comentary.getUser().getId());
            var establishment = establishmentRepository.findById(comentary.getEstablishment().getId());
            ComentaryResponse comentaryResponse = new ComentaryResponse(
                    comentary.getId(),
                    comentary.getTitle(),
                    comentary.getContent(),
                    null,
                    comentary.getApproved() == 0 ? "Aguardando Análise" : comentary.getApproved() == 1 ? "Reprovado" : comentary.getApproved() == 2 ? "Aprovado" : "",
                    user.get().getName(),
                    establishment.get().getName());
            return new ResponseEntity<>(comentaryResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> setApprovedComentary(Long id, Integer approvedCode) {
        var comentary = comentaryRepository.findById(id).orElse(null);
        if (comentary != null) {
            comentary.setApproved(approvedCode);
            comentaryRepository.save(comentary);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<ComentaryResponse> getApprovedCommentsFromEstablishment(Long idEstablishment) {
        List<Comentary> comments = comentaryRepository.getApprovedCommentsFromEstablishment(idEstablishment);
        List<ComentaryResponse> commentsResponse = new ArrayList<>();
        for (Comentary comentary : comments) {
            var user = userRepository.findById(comentary.getUser().getId());
            var establishment = establishmentRepository.findById(comentary.getEstablishment().getId());
            commentsResponse.add(new ComentaryResponse(
                    comentary.getId(),
                    comentary.getTitle(),
                    comentary.getContent(),
                    null,
                    comentary.getApproved() == 0 ? "Aguardando Análise" : comentary.getApproved() == 1 ? "Reprovado" : comentary.getApproved() == 2 ? "Aprovado" : "",
                    user.get().getName(),
                    establishment.get().getName()));
        }
        return commentsResponse;
    }
}
