package com.softcaribbean.VeterinariaBack.config.controller;

import com.softcaribbean.VeterinariaBack.config.controller.errors.ApplicationCustomException;
import com.softcaribbean.VeterinariaBack.dto.Veterinaria;
import com.softcaribbean.VeterinariaBack.service.VeterinariaService;
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
public class VeterinariaController {
    private Logger log = LoggerFactory.getLogger(VeterinariaController.class);

    private static final String ENITY_NAME = "Veterinaria";
    private final VeterinariaService veterinariaService;

    public VeterinariaController(VeterinariaService veterinariaService) {
        this.veterinariaService = veterinariaService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/veterinaria")
    public ResponseEntity<ResponseMessage<Veterinaria>> create(@Validated @RequestBody Veterinaria veterinaria) throws ApplicationCustomException {
        log.debug("REST request to save veterinaria : {} ", veterinaria);
        Veterinaria veterinariaFind = veterinariaService.findOne(veterinaria.getNmid());
        if(veterinariaFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Veterinaria result = veterinariaService.save(veterinaria);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/veterinaria")
    public ResponseEntity<ResponseMessage<Veterinaria>> update(@Validated @RequestBody Veterinaria veterinaria) throws ApplicationCustomException {
        log.debug("REST request to update veterinaria : {} ", veterinaria);

        if(veterinaria.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Veterinaria result = veterinariaService.update(veterinaria);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/veterinaria")
    public ResponseEntity<ResponseMessage<List<Veterinaria>>> getAllResponse(){
        log.debug("REST request to get all veterinaria");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, veterinariaService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/veterinaria/{nmid}")
    public ResponseEntity<ResponseMessage<Veterinaria>> getOneResponse(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get veterinaria : {}", nmid);
        Veterinaria veterinaria = veterinariaService.findOne(nmid);
        if(veterinaria == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, veterinaria));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/veterinaria/{nmid}")
    public ResponseEntity<ResponseMessage<Veterinaria>> delete(@PathVariable int nmid) {
        log.debug("REST request to delete veterinaria : {}", nmid);
        veterinariaService.delete(nmid);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null));
    }


}
