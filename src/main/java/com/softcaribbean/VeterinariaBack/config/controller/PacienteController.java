package com.softcaribbean.VeterinariaBack.config.controller;

import com.softcaribbean.VeterinariaBack.config.controller.errors.ApplicationCustomException;
import com.softcaribbean.VeterinariaBack.dto.Paciente;
import com.softcaribbean.VeterinariaBack.service.PacienteService;
import com.softcaribbean.VeterinariaBack.util.MessagesConstants;
import com.softcaribbean.VeterinariaBack.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteController {
    private Logger log = LoggerFactory.getLogger(PacienteController.class);

    private static final String ENITY_NAME = "Paciente";
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/paciente")
    public ResponseEntity<ResponseMessage<Paciente>> create(@Validated @RequestBody Paciente paciente) throws ApplicationCustomException {
        log.debug("REST request to save paciente : {} ", paciente);
        Paciente pacienteFind = pacienteService.findOne(paciente.getNmid());
        if(pacienteFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Paciente result = pacienteService.save(paciente);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/paciente")
    public ResponseEntity<ResponseMessage<Paciente>> update(@Validated @RequestBody Paciente paciente) throws ApplicationCustomException {
        log.debug("REST request to update paciente : {} ", paciente);

        if(paciente.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Paciente result = pacienteService.update(paciente);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/paciente")
    public ResponseEntity<ResponseMessage<List<Paciente>>> getAllResponse(){
        log.debug("REST request to get all pacientes");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, pacienteService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/paciente/{nmid}")
    public ResponseEntity<ResponseMessage<Paciente>> getOneResponse(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get paciente : {}", nmid);
        Paciente paciente = pacienteService.findOne(nmid);
        if(paciente == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, paciente));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/paciente/{nmid}")
    public ResponseEntity<ResponseMessage<Paciente>> delete(@PathVariable int nmid) {
        log.debug("REST request to delete paciente : {}", nmid);
        pacienteService.delete(nmid);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null));
    }


}
