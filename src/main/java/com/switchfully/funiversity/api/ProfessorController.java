package com.switchfully.funiversity.api;

import com.switchfully.funiversity.api.dtos.CreateProfessorDTO;
import com.switchfully.funiversity.api.dtos.ProfessorDTO;
import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.domain.ProfessorRepository;
import com.switchfully.funiversity.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
