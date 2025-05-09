package com.example.myproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.myproject.model.Cobranca;
import com.example.myproject.model.TipoMorador;
import com.example.myproject.model.Unidade;

public class MoradorDTO extends PessoaDTO {
    private long id;
    private List<Unidade> unidade = new ArrayList<>();
    private Cobranca cobranca;
    private TipoMorador tipoMorador;

    public long getIdMorador() {
        return id;
    }

    public List<Unidade> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }

    public Cobranca getCobranca() {
        return cobranca == null ? null : cobranca;
    }

    public void setCobranca(Cobranca cobranca) {
        this.cobranca = cobranca;
    }

    public TipoMorador getTipoMorador() {
        return tipoMorador == null ? null : tipoMorador;
    }
    public void setTipoMorador(TipoMorador tipoMorador) {
        this.tipoMorador = tipoMorador;
    }
    
}
