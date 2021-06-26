package br.com.mentoramaAlunos.demo.controllers;


import br.com.mentoramaAlunos.demo.excepts.DidntFindExcept;
import br.com.mentoramaAlunos.demo.excepts.DidntRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceAluno {
    final static Logger LOGGER = LoggerFactory.getLogger(ControllerAdviceAluno.class);

    @ExceptionHandler(DidntFindExcept.class)
    public ResponseEntity<String> DidntFindExcept(final DidntFindExcept e){
        LOGGER.error(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DidntRegister.class)
    public ResponseEntity<String> DidntRegister(final DidntRegister e){
        LOGGER.error("Cadastro com erro");
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
