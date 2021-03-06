package modelo;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "tipoveiculo")
public class TipoVeiculo implements Serializable {

    @Column()
    protected double precokm;
    @Column()
    protected double taxaBase;
    @Id
    @Column(unique = true, nullable = false)
    protected String tipo;

    public TipoVeiculo() {
    }

    public TipoVeiculo(String tipo, double precoKm, double taxaBase) {
        this.tipo = tipo;
        this.precokm = precoKm;
        this.taxaBase = taxaBase;
    }

    public double getTaxaBase() {
        return taxaBase;
    }

    public double getPrecokm() {
        return precokm;
    }

    public String getTipo() {
        return tipo;
    }
}
