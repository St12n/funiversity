package com.switchfully.funiversity.service;

import com.switchfully.funiversity.api.ProfessorMapper;
import com.switchfully.funiversity.api.dtos.CreateProfessorDTO;
import com.switchfully.funiversity.api.dtos.ProfessorDTO;
import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.domain.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorDTO getProfessorDTO(CreateProfessorDTO professorToCreate) {
        Professor professorToSave = professorMapper.mapDtoToProfessor(professorToCreate);
        Professor savedProfessor = professorRepository.save(professorToSave);
        return professorMapper.mapProfessorToDTO(savedProfessor);
    }
}
