package situacao;

public class Quitado implements SituacaoEmprestimo {

	@Override
	public void acao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		System.out.println("O empr�stimo deste cliente j� foi quitado.");
	}
	
}
