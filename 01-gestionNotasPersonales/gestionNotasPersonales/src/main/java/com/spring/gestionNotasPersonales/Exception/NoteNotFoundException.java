package com.spring.gestionNotasPersonales.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Excepcion lanzada cuando no se encuentra una nota por su ID
 * Retorna un HTTP 404 (NOT_FOUND) automaticamente
*/

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NoteNotFoundException(Long id){
        super(String.format("Nota no encontrada con id: %d", id));
    }

    public NoteNotFoundException(String message){
        super(message);
    }

    public NoteNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

}
