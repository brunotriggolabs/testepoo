package modelo;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String opicionais;
    @Column()
    private String observacoes;
    @Column()
    private int disponivel;
    @Column()
    private int locacao;
    @Column()
    private int numLocacoes;

    public Veiculo() {
    }

    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.disponivel = 1;
        this.locacao = 0;
        this.numLocacoes = 0;
    }

    public void setNumLocacoes(int numLocacoes) {
        this.numLocacoes = numLocacoes;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setOpicionais(String opicionais) {
        this.opicionais = opicionais;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setDisponivel(int disponivel) {
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

    public int getDisponivel() {
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
        return opicionais;
    }

    public String getPlaca() {
        return placa;
    }

    public int getNumLocacoes() {
        return numLocacoes;
    }
}
