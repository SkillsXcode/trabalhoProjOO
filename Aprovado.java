package situacao;

import java.math.BigDecimal;

public class Aprovado implements SituacaoEmprestimo {
	BigDecimal jurosTeste; //lembrar de tirar, teste
	BigDecimal valorEmprestimo;
	
	public Aprovado(BigDecimal jurosTeste, BigDecimal valorEmprestimo) {
		this.jurosTeste = jurosTeste;
		this.valorEmprestimo = valorEmprestimo;
	}

	@Override
	public void acao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		System.out.println("Aprovado!");
		
		
		
		System.out.println("Valor a ser devolvido: " + 
							calcularIndiceJuros(jurosTeste, this.valorEmprestimo));
	
	}
	
	
	public BigDecimal calcularIndiceJuros(BigDecimal indice, BigDecimal emprestimo) {
		return emprestimo.multiply(indice);
	}

}
