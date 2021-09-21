package situacao;

import java.math.BigDecimal;

public class Aprovado implements SituacaoEmprestimo {
	BigDecimal jurosTeste = new BigDecimal("0.12"); //lembrar de tirar, teste
	
	public Aprovado(BigDecimal jurosTeste) {
		this.jurosTeste = jurosTeste;
	}

	@Override
	public void acao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		
		calcularIndiceJuros(jurosTeste, emprestimo);
	}
	
	public void calcularIndiceJuros(BigDecimal indice, Emprestimo emprestimo) {
		emprestimo.setValor(indice.multiply(emprestimo.getValor()));
	}

}
