package situacao;

public class Quitado implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		System.out.println("O empréstimo deste cliente já foi quitado.");
	}
	
}
