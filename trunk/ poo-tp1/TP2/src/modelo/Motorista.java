package modelo;

import javax.persistence.*;

@Entity
@Table(name="motorista")
@AttributeOverrides({
    @AttributeOverride(name="NOME", column=@Column(name="nome")),
    @AttributeOverride(name="ENDERECO", column=@Column(name="endereco")),
    @AttributeOverride(name="TELEFONE", column=@Column(name="telefone"))
})
public class Motorista extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
	private String cnh;
    @Column()
	private int locacao;
	
	public Motorista(String nome, String cpf, String cnh) {
		super(nome, cpf);
		this.cnh = cnh;
	}

	public String getCnh() {
		return cnh;
	}
	
	public int getLocacao() {
		return locacao;
	}
	
	public void setLocacao(int locacao) {
		this.locacao = locacao;
	}
	
}
