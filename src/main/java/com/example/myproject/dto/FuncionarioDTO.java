package com.example.myproject.dto;

public class FuncionarioDTO extends PessoaDTO {

    private Long matricula;
    
    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
