package com.dnlg.projectsharingapi;

// import java.util.ArrayList;
import java.util.Arrays;
// import java.util.List;

// import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dnlg.projectsharingapi.exception.EntityNotFoundException;
import com.dnlg.projectsharingapi.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler({ EntityNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // @ExceptionHandler({MethodArgumentNotValidException.class})
    // protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    //     List<String> errors = new ArrayList<>();
    //     ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
    //     return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    // }


}
