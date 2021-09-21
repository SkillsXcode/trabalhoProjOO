package situacao;

public class EmAberto implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		
		System.out.println("O empréstimo consta em aberto.");
	}

}
