package br.com.mentoramaAlunos.demo.service;

import br.com.mentoramaAlunos.demo.entity.Aluno;
import br.com.mentoramaAlunos.demo.excepts.DidntFindExcept;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoService {


    public AlunoService() {
        this.alunoList = new ArrayList<>();
    }

    public List<Aluno>allAlunosList(String nome, Integer idade, Integer id){
        List<Aluno> filtered;
        if((nome != null) && (idade == null) && (id == null)){
            filtered = this.listStudentName(nome);
        }
        else if((nome == null) && (idade != null) && (id == null)){
            filtered = this.listStudentAge(idade);
        }
        else if((nome == null) && (idade == null) && (id != null)){
            filtered = this.listStudentId(id);
        }else{
            filtered = this.alunoList;
        }
        if(filtered.isEmpty()){
            throw new DidntFindExcept();
        }else{
            return filtered;
        }
    }

    public List<Aluno> listStudentName(final String nome) {
        return filteredByName(nome);
    }

    public List<Aluno> listStudentAge(final Integer idade) {
        return filteredByAge(idade);
    }

    public List<Aluno> listStudentId(final Integer id) {
        return filteredById(id);
    }

    public Aluno found(final Integer id){
        if(insideList(id)){
            return this.alunoList.get(id.intValue()-1);
        }else {
            throw new DidntFindExcept();
        }
    }

    public Boolean register(Aluno aluno){
        aluno.setId((int) this.alunoList.size()+1);
        return this.alunoList.add(aluno);
    }

    public Boolean delete (Integer id){
        if(insideList(id)){
            this.alunoList.remove(id.intValue()-1);
            return true;
        }
        return false;
    }



    private List<Aluno> alunoList;

    private List<Aluno> filteredById(Integer id) {
        return this.alunoList.stream().filter(aluno -> aluno.getId().equals(id)).collect(Collectors.toList());
    }

    private List<Aluno> filteredByAge(Integer idade) {
        return this.alunoList.stream().filter(aluno -> aluno.getIdade().equals(idade)).collect(Collectors.toList());
    }

    private List<Aluno> filteredByName(String nome) {
        return this.alunoList.stream().filter(aluno -> aluno.getNome().contains(nome)).collect(Collectors.toList());
    }

    private Boolean insideList(Integer id){
        return ((this.alunoList.size() >= id)&& (id>0));
    }

    private Boolean updtName(Integer id, String nome){
        if(nome != null){
            this.alunoList.get(id.intValue()-1).setNome(nome);
            return true;
        }
        return false;
    }
    private Boolean updtIdade(Integer id, Integer idade){
        if(idade != null){
            this.alunoList.get(id.intValue()-1).setIdade(idade);
            return true;
        }
        return false;
    }

}
