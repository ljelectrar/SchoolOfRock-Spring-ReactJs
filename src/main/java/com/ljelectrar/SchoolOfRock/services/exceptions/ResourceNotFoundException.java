package com.ljelectrar.SchoolOfRock.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVerionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found! Id: " + id);
    }

}
