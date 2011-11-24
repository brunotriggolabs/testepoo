package modelo;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
    
    @Id   
    @Column(unique = true, nullable = false)
    private String placa;
    @Column()
    private String marca;
    @Column()
    private String modelo;
    @Column()
    private String cor;
    @Column()
    private String tipo;
    @Column()
    private String opcionais;
    @Column()
    private String observacoes;
    @Column()
    private boolean disponivel;
    @Column()
    private int locacao;

    public Veiculo() {
    }

    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.disponivel = true;
        this.locacao = 0;
        
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setOpicionais(String opcionais) {
        this.opcionais = opcionais;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setLocacao(int locacao) {
        this.locacao = locacao;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public int getLocacao() {
        return locacao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getOpicionais() {
        return opcionais;
    }

    public String getPlaca() {
        return placa;
    }

}