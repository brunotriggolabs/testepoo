package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipolocacao")
public class TipoLocacao implements Serializable {

    @Id
    @Column
    private int tipo; //porKm ou Km livre
    @Column
    private double taxaBase;
    @Column
    private double precoKm;

    public TipoLocacao() {
    }

    public TipoLocacao(int tipo, Double taxa, Double precoKm) {
        this.tipo = tipo;
        this.taxaBase = taxa;
        this.precoKm = precoKm;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setTaxaBase(double taxaBase) {
        this.taxaBase = taxaBase;
    }

    public void setPrecoKm(double precoKm) {
        this.precoKm = precoKm;
    }

    public int getTipo() {
        return tipo;
    }

    public double getTaxaBase() {
        return taxaBase;
    }

    public double getPrecoKm() {
        return precoKm;
    }
}