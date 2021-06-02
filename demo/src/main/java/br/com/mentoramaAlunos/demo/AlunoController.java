package br.com.mentoramaAlunos.demo;



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

    @GetMapping
    public Object findAlunos(@RequestParam(required = false)String nome ){
        return alunos;
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable("id") Integer id){
        return this.alunos.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody()final Aluno aluno){
        if(aluno.getId() == null){
            aluno.setId(alunos.size()+1);
        }
        alunos.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody final Aluno aluno){
        alunos.stream().
                filter(x -> x.getId().
                        equals(aluno.getId())).
                forEach(x -> x.setNome(aluno.getNome()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        alunos.removeIf(x -> x.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}