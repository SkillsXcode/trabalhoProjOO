package situacao;
import java.math.BigDecimal;

public class Principal {

	public static void main(String[] args) {

		BigDecimal valorEmprestado = new BigDecimal("10000.00");
		BigDecimal jurosFicticio = new BigDecimal("0.12");
		Beneficiado breno = new Beneficiado("Breno", "139.092.023-239", "20.032.932-9", "2345-678");
		Emprestimo emprestimo = new Emprestimo(23655, breno, valorEmprestado);
		
		//aprovar e negar sob aleatoriedade de um bit
		Quitado quite = new Quitado();
		Aprovado aprv = new Aprovado(jurosFicticio, valorEmprestado);
		//Aprovado outroAprvTest = new Aprovado(jurosFicticio);
		Negado negado = new Negado();
		EmAberto emAberto = new EmAberto();
		
		/*System.out.println(aprv.getClass());
		
		if(outroAprvTest.getClass() == aprv.getClass()) System.out.println("AEEE, CASINÃO");
		
		quite.acao(emprestimo);
		aprv.acao(emprestimo);
		System.out.println(emprestimo.getValor());*/
		emprestimo.setSituacao(quite);
		emprestimo.setSituacao(negado);
		emprestimo.setSituacao(aprv);
		emprestimo.setSituacao(emAberto);
		
		
		//pseudo-interface
		/*
		System.out.println();
		System.out.println("Bem-vindo(a) ao banco Calote S.A.!");		
		System.out.println("1 - Solicitar um empréstimo;");
		System.out.println("2 - Pagar um empréstimo;");
		System.out.println("3 - Verificar situação do empréstimo.");
		System.out.println("Escolha uma das opções acima: ");*/
		
		
		
		
		
		
		
		
	}

}
