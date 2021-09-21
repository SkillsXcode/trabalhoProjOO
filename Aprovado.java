package situacao;

import java.math.BigDecimal;

public class Aprovado implements SituacaoEmprestimo {
	
	BigDecimal juros;
	BigDecimal valorEmprestimo;
	
	public Aprovado(BigDecimal juros, BigDecimal valorEmprestimo) {
		this.juros = juros;
		this.valorEmprestimo = valorEmprestimo;
	}

	@Override
	public void acao(Emprestimo emprestimo) {
		System.out.println("Aprovado!");
		System.out.println("Valor a ser devolvido: " + 
							calcularIndiceJuros(juros, this.valorEmprestimo));
	}
	
	public BigDecimal calcularIndiceJuros(BigDecimal indice, BigDecimal emprestimo) {
		return emprestimo.multiply(indice);
	}
}
