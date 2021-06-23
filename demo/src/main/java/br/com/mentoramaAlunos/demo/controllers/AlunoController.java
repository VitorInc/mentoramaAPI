package br.com.mentoramaAlunos.demo.controllers;



import br.com.mentoramaAlunos.demo.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
public class AlunoController {


    List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {
        Aluno aluno1 = new Aluno(1, "Renatinho", 10);
        Aluno aluno2 = new Aluno(2, "Paulo Henrrique", 9);
        Aluno aluno3 = new Aluno(3, "Ramirez", 11);

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
    }





}