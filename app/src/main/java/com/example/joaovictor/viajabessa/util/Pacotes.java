package com.example.joaovictor.viajabessa.util;

import java.io.Serializable;

/**
 * Created by joaovictor on 16/05/2015.
 */
public class Pacotes implements Serializable {
    private String titulos;
    private String valores;
    private String url_imagens;
    private String descricao;
    private String id_pacote;

    public Pacotes(String titulos, String valores, String url_imagens, String descricao, String id_pacote) {
        this.titulos = titulos;
        this.valores = valores;
        this.url_imagens = url_imagens;
        this.descricao = descricao;
        this.id_pacote = id_pacote;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }

    public String getUrl_imagens() {
        return url_imagens;
    }

    public void setUrl_imagens(String url_imagens) {
        this.url_imagens = url_imagens;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getId_pacote() {
        return id_pacote;
    }

    public void setId_pacote(String id_pacote) {
        this.id_pacote = id_pacote;
    }
}
