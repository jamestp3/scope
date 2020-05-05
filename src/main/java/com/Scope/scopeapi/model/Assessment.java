package com.Scope.scopeapi.model;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class Assessment{

    private String type;
    private String details;

    public Assessment() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

