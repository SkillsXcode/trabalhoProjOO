package situacao;

public class EmAberto implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		
		System.out.println("O empr�stimo consta em aberto.");
	}

}
