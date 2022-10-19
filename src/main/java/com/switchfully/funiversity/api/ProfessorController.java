package com.switchfully.funiversity.api;

import com.switchfully.funiversity.api.dtos.CreateProfessorDTO;
import com.switchfully.funiversity.api.dtos.ProfessorDTO;
import com.switchfully.funiversity.api.dtos.UpdateProfessorDTO;
import com.switchfully.funiversity.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {

    private final Logger myLogger = LoggerFactory.getLogger(ProfessorController.class);
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProfessorDTO createProfessor(@RequestBody CreateProfessorDTO professorToCreate) {
        myLogger.info("Creation method createProfessor is called.");
        return professorService.getProfessorDTO(professorToCreate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = "application/json")
    public List<ProfessorDTO> getAllProfessors() {
        myLogger.info("Handler method getAllProfessors is called.");
        return professorService.getAllProfessorDTO();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = "application/json", path = "{id}")
    public ProfessorDTO getProfessorWithID(@PathVariable String id){
        myLogger.info("Handler method getProfessorWithID called with id: " + id);
        return professorService.getProfessorDTO(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = "application/json", produces = "application/json", path = "{id}")
    public ProfessorDTO updateProfessorWithID(@RequestBody UpdateProfessorDTO updateProfessorDTO, @PathVariable String id) {
        myLogger.info("Update method updateProfessorWithID called on id: " + id + "\nwith new data: " + updateProfessorDTO.toString());
        return professorService.updateProfessor(updateProfessorDTO, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "{id}")
    public void deleteProfessorWithID(@PathVariable String id) {
        myLogger.info("Handler method deleteProfessorWithID called on id: " + id );
        professorService.deleteProfessor(id);
    }
}
