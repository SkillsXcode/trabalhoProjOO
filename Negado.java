package situacao;

public class Negado implements SituacaoEmprestimo {


	@Override
	public void acao(Emprestimo emprestimo) {
		
		System.out.println("Infelizmente o seu empr�stimo foi negado! Tente em outro momento.");
	}

}
