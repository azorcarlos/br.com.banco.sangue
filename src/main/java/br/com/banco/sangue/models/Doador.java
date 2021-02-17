package br.com.banco.sangue.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import br.com.banco.sangue.helpers.Calculos;
import br.com.banco.sangue.helpers.DateString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class Doador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	private String nome;
	private String cpf;
	private String rg;
	private String data_nasc;
	private String sexo;
	private String mae;
	private String pai;
	private String email;
	private String cep;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone_fixo;
	private String celular;
	private Float   altura;
	private Integer peso;
	private String tipo_sanguineo;
	private Integer idade;
	private Float   imc;
	private Boolean   doador;

	@PrePersist
	public void execute() {
		
		//Idade
		final String dateFormat = "dd/MM/yyyy";
		this.setIdade(DateString.getIdade(DateString.getDateFormat(dateFormat, this.getData_nasc())));
		
		//Imc
		this.setImc(Calculos.calcularIMC(this.getPeso(), this.getAltura()));
		
		//Setar se é doador
		this.setDoador(Calculos.calulcarDoadores(this.getIdade(), this.getPeso()));
	
		
	}

	

}
