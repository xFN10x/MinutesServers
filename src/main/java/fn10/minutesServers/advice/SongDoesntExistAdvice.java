package fn10.minutesServers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fn10.minutesServers.exceptions.SongDoesntExistException;

@RestControllerAdvice
public class SongDoesntExistAdvice {

    @ExceptionHandler(SongDoesntExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String SongNotFoundHandler(SongDoesntExistException ex) {
        return ex.getMessage();
    }

}
