package situacao;

public class Quitado implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		
		System.out.println("O empr�stimo deste cliente foi quitado.");
	}
	
}
