package com.StudentRegistration.model;

import com.StudentRegistration.model.Course;

import java.util.List;

public record Student (String id, String name, String description, List<Course> courses){



}
