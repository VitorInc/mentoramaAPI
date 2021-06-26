package br.com.mentoramaAlunos.demo.controllers;




import br.com.mentoramaAlunos.demo.entity.Aluno;
import br.com.mentoramaAlunos.demo.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    List<Aluno> alunoList = new ArrayList<>();

    public AlunoController() {

        this.alunoService = new AlunoService();


    }
    @GetMapping
    public ResponseEntity<List<Aluno>> allAlunosList(@RequestParam(required = false) String nome,
                                              @RequestParam(value = "idade", required = false, defaultValue = "0") Integer idade,
                                                     @RequestParam(value = "id" , required = false,defaultValue = "0") Integer id){
        return new ResponseEntity(this.alunoService.allAlunosList(nome, idade,id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> found(@PathVariable Integer id){
        return new ResponseEntity(this.alunoService.found(id), HttpStatus.FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno register(@RequestBody Aluno aluno){
        return this.alunoService.register(aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable Integer id){
        return this.alunoService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                          @RequestParam(required = false) String nome, Integer idade){
        this.alunoService.update(id, nome, idade);}


}