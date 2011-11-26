package modelo;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
@AttributeOverrides({
    @AttributeOverride(name = "NOME", column =
    @Column(name = "nome")),
    @AttributeOverride(name = "ENDERECO", column =
    @Column(name = "endereco")),
    @AttributeOverride(name = "TELEFONE", column =
    @Column(name = "telefone"))
})
public class Funcionario extends Pessoa {

    @Column
    private String cargo;
    @Column
    private String senha;
    @Column
    private int usuario;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String cargo, String senha, int usuario) {
        super(nome, cpf);
        this.cargo = cargo;
        this.senha = senha;
        this.usuario = usuario;
    }

    public String getCargo() {
        return this.cargo;
    }
}
