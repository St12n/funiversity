package com.switchfully.funiversity.api;

import com.switchfully.funiversity.api.dtos.CreateProfessorDTO;
import com.switchfully.funiversity.api.dtos.ProfessorDTO;
import com.switchfully.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDTO mapProfessorToDTO(Professor professor){
        return new ProfessorDTO()
                .setId(professor.getId())
                .setFirstname(professor.getFirstname())
                .setLastname(professor.getLastname());
    }

    public Professor mapDtoToProfessor(CreateProfessorDTO createProfessorDTO) {
        return new Professor(createProfessorDTO.getFirstname(), createProfessorDTO.getLastname());
    }
}
