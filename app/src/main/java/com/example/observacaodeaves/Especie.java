package com.example.observacaodeaves;

public class Especie {
    private String nomeCienntifico;
    private int imagem;
    private String nomePopular;

    public Especie(String nomePopular, String nomeCienntifico , int imagem){

        this.nomePopular = nomePopular;
        this.nomeCienntifico = nomeCienntifico;
        this.imagem = imagem;
    }

    public String getNomeCienntifico() {
        return nomeCienntifico;
    }

    public void setNomeCienntifico(String nomeCienntifico) {
        this.nomeCienntifico = nomeCienntifico;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }
}
