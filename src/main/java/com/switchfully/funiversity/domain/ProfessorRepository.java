package com.switchfully.funiversity.domain;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProfessorRepository {

    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorRepository() {
        professorsById = new ConcurrentHashMap<>();
    }

    public Professor save(Professor professorToSave) {
        professorsById.put(professorToSave.getId(), professorToSave);
        return professorToSave;
    }

    public Professor getById(String id) throws IllegalArgumentException {
        var foundProfessor  = professorsById.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException("Cannot find professor with id: " + id);
        }
        return foundProfessor;
    }

    public Collection<Professor> getAll() {
        return professorsById.values();
    }

    public void deleteFromRepository(String id){
        professorsById.remove(id);
    }
}
