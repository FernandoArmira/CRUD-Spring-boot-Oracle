package com.app.CRUDOracle.dto;

import javax.validation.constraints.NotEmpty;

public class RequestDTO {
    @NotEmpty
    private int id;
    @NotEmpty
    private String name;


    public RequestDTO(@NotEmpty  int id, @NotEmpty String name) {

        super();

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
