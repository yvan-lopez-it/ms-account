package com.devsu.challenge.backend.apirest.accountapp.exceptions;

import java.io.Serial;
import org.springframework.web.client.HttpStatusCodeException;

public class ClienteNoEncontradoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1;

    public ClienteNoEncontradoException(String message) {
        super(message);
    }

    public ClienteNoEncontradoException(String message, HttpStatusCodeException exception) {
        super(message);
    }

}
