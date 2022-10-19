package com.switchfully.funiversity.api.dtos;

public class UpdateProfessorDTO {

    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public UpdateProfessorDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UpdateProfessorDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
