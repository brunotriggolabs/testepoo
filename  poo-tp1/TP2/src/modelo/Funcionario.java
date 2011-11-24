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

    private String cargo;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String cargo) {
        super(nome, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }
    //TODO adicionar métodos do Funcionário
}
