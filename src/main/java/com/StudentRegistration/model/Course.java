package com.StudentRegistration.model;

import java.util.List;

public record Course (String id, String name, String description, List<String> steps) {

    public void setId(String id){

    }
}
