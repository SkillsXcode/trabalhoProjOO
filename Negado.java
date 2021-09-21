package situacao;

public class Negado implements SituacaoEmprestimo {


	@Override
	public void acao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		System.out.println("Infelizmente o seu empréstimo foi negado!");
	}

}
