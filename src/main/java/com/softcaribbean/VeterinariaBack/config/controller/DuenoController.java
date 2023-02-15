package com.softcaribbean.VeterinariaBack.config.controller;

import com.softcaribbean.VeterinariaBack.config.controller.errors.ApplicationCustomException;
import com.softcaribbean.VeterinariaBack.dto.Dueno;
import com.softcaribbean.VeterinariaBack.dto.Paciente;
import com.softcaribbean.VeterinariaBack.service.DuenoService;
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
public class DuenoController {

    private Logger log = LoggerFactory.getLogger(PacienteController.class);

    private static final String ENITY_NAME = "Dueno";

    private final DuenoService duenoService;

    public DuenoController(DuenoService duenoService) {
        this.duenoService = duenoService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/dueno")
    public ResponseEntity<ResponseMessage<Dueno>> create(@Validated @RequestBody Dueno dueno) throws ApplicationCustomException {
        log.debug("REST request to save dueño : {} ", dueno);
        Dueno duenoFind = duenoService.findOne(dueno.getNmid());
        if(duenoFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Dueno result = duenoService.save(dueno);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/dueno")
    public ResponseEntity<ResponseMessage<Dueno>> update(@Validated @RequestBody Dueno dueno) throws ApplicationCustomException {
        log.debug("REST request to update dueño : {} ", dueno);

        if(dueno.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Dueno result = duenoService.update(dueno);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dueno")
    public ResponseEntity<ResponseMessage<List<Dueno>>> getAllResponse(){
        log.debug("REST request to get all dueños");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, duenoService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dueno/{nmid}")
    public ResponseEntity<ResponseMessage<Dueno>> getOneResponse(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get dueño : {}", nmid);
        Dueno dueno = duenoService.findOne(nmid);
        if(dueno == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, dueno));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/dueno/{nmid}")
    public ResponseEntity<ResponseMessage<Dueno>> delete(@PathVariable int nmid) {
        log.debug("REST request to delete dueño : {}", nmid);
        duenoService.delete(nmid);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null));
    }



}
