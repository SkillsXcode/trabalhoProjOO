package situacao;

public class EmAberto implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		System.out.println("Vai pagar não, caloteiro?");
	}

}
