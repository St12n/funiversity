package com.switchfully.funiversity.api.dtos;

import com.switchfully.funiversity.domain.Professor;

public class ProfessorDTO {

    private String id;
    private String firstname;
    private String lastname;

    public String getId() {
        return id;
    }

    public ProfessorDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ProfessorDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ProfessorDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
