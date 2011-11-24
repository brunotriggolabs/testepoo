package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    
    @Column(unique = true, nullable = false)
    @Id
    protected String cpf;
    @Column(name = "NOME", nullable = false)
    protected String nome;
    @Column(name = "ENDERECO")
    protected String endereco;
    @Column(name = "TELEFONE")
    protected String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
