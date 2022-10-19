package com.switchfully.funiversity.service;

import com.switchfully.funiversity.api.ProfessorAlreadyExists;
import com.switchfully.funiversity.api.ProfessorMapper;
import com.switchfully.funiversity.api.dtos.CreateProfessorDTO;
import com.switchfully.funiversity.api.dtos.ProfessorDTO;
import com.switchfully.funiversity.api.dtos.UpdateProfessorDTO;
import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.domain.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        professorRepository.getAll().stream()
                .filter(professor -> professor.getFirstname().equals(professorToCreate.getFirstname()) && professor.getLastname().equals(professorToCreate.getLastname()))
                .findFirst()
                .ifPresent(s ->
                {
                    throw new ProfessorAlreadyExists(professorToCreate.toString());
                });
        Professor professorToSave = professorMapper.mapDtoToProfessor(professorToCreate);
        Professor savedProfessor = professorRepository.save(professorToSave);
        return professorMapper.mapProfessorToDTO(savedProfessor);
    }

    public List<ProfessorDTO> getAllProfessorDTO() {
        return professorRepository.getAll().stream()
                .map(professorMapper::mapProfessorToDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorDTO(String id) {
        return professorMapper.mapProfessorToDTO(professorRepository.getById(id));
    }

    public ProfessorDTO updateProfessor(UpdateProfessorDTO updateProfessorDTO, String id) {
        Professor professorToUpdate = professorRepository.getById(id);
        professorToUpdate.setFirstname(updateProfessorDTO.getFirstname());
        professorToUpdate.setLastname(updateProfessorDTO.getLastname());
        return professorMapper.mapProfessorToDTO(professorToUpdate);
    }

    public void deleteProfessor(String id) {
        professorRepository.deleteFromRepository(id);
    }
}
