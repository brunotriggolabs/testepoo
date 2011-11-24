package modelo;

import javax.persistence.*;

public class TipoVeiculo {

    @Column()
    protected double precokm;
    @Column()
    protected double taxaBase;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    protected String tipo;

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
