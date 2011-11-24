package modelo;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
@AttributeOverrides({
    @AttributeOverride(name = "NOME", column =
    @Column(name = "nome")),
    @AttributeOverride(name = "ENDERECO", column =
    @Column(name = "endereco")),
    @AttributeOverride(name = "TELEFONE", column =
    @Column(name = "telefone"))
})
public class Cliente extends Pessoa {

    private ArrayList<Integer> locacao;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.locacao = new ArrayList<Integer>();
    }

    public Object[] tamanhoVetor() {
        return locacao.toArray();
    }

    public void addLocacao(int locacao) {
        this.locacao.add(locacao);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public void imprime() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        if (!this.telefone.contentEquals("null")) {
            System.out.println("Telefone: " + this.telefone);
        }
        if (!this.endereco.contentEquals("null")) {
            System.out.println("Endereço: " + this.endereco);
        }
        // Se a lista de clientes está vazia, nao imprime nada
        if (this.locacao.isEmpty()) {
            return;
        } else {
            // Caso contrário, imprime o ID de todas as locações realizadas
            System.out.println("ID das locações realizadas: ");
            for (int i = 0; i < this.locacao.size(); i++) {
                System.out.println(this.locacao.get(i));
            }
        }
        return;
    }
}
