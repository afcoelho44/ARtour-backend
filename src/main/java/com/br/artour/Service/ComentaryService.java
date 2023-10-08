package com.br.artour.Service;

import com.br.artour.Entity.Comentary;
import com.br.artour.Entity.User;
import com.br.artour.Mapper.ComentaryRequestToEntity;
import com.br.artour.Mapper.UserRequestToEntity;
import com.br.artour.Model.ComentaryRequest;
import com.br.artour.Model.UserRequest;
import com.br.artour.Repository.ComentaryRepository;
import com.br.artour.Repository.EstablishmentRepository;
import com.br.artour.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComentaryService {

    private ComentaryRepository comentaryRepository;

    private UserRepository userRepository;

    private EstablishmentRepository establishmentRepository;

    public List<Comentary> getAllComentary(){return comentaryRepository.findAll();}

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
        var record= comentaryRepository.findById(id).orElseThrow(RuntimeException::new);
        record= new ComentaryRequestToEntity().mapUpdate(request,record);
        comentaryRepository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteComentary(Long id){
        comentaryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
