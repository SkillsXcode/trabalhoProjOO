package situacao;

public class Quitado implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		
		System.out.println("O empréstimo deste cliente foi quitado.");
	}
	
}
