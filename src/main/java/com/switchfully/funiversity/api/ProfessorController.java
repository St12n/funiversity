package com.switchfully.funiversity.api;

import com.switchfully.funiversity.api.dtos.CreateProfessorDTO;
import com.switchfully.funiversity.api.dtos.ProfessorDTO;
import com.switchfully.funiversity.api.dtos.UpdateProfessorDTO;
import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.domain.ProfessorRepository;
import com.switchfully.funiversity.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProfessorDTO createProfessor(@RequestBody CreateProfessorDTO professorToCreate) {
        return professorService.getProfessorDTO(professorToCreate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = "application/json")
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessorDTO();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = "application/json", path = "{id}")
    public ProfessorDTO getProfessorWithID(@PathVariable String id){
        return professorService.getProfessorDTO(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(consumes = "application/json", produces = "application/json", path = "{id}")
    public ProfessorDTO updateProfessorWithID(@RequestBody UpdateProfessorDTO updateProfessorDTO, @PathVariable String id) {
        return professorService.updateProfessor(updateProfessorDTO, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "{id}")
    public void deleteProfessorWithID(@PathVariable String id) {
        professorService.deleteProfessor(id);
    }
}
