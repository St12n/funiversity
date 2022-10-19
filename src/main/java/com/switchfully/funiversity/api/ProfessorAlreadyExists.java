package com.switchfully.funiversity.api;

public class ProfessorAlreadyExists extends IllegalArgumentException {
    public ProfessorAlreadyExists(String professor) {
        super("There is already a professor with this name created: " + professor);
    }
}
