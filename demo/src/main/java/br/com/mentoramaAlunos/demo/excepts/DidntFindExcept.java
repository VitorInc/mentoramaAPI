package br.com.mentoramaAlunos.demo.excepts;

public class DidntFindExcept extends RuntimeException {
    public DidntFindExcept(){
        super("Not founded");
    }

}
