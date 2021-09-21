package situacao;
import java.math.BigDecimal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal valorEmprestado = new BigDecimal("10000.00");
		BigDecimal jurosFicticio = new BigDecimal("0.12");
		Beneficiado breno = new Beneficiado("Breno", "139.092.023-239", "20.032.932-9", "2345-678");
		Emprestimo emprestimo = new Emprestimo(23655, breno, valorEmprestado);
		
		Quitado quite = new Quitado();
		Aprovado aprv = new Aprovado(jurosFicticio);
		//Aprovado outroAprvTest = new Aprovado(jurosFicticio);
		Negado negado = new Negado();
		EmAberto emAberto = new EmAberto();
		
		/*System.out.println(aprv.getClass());
		
		if(outroAprvTest.getClass() == aprv.getClass()) System.out.println("AEEE, CASIN�O");
		
		quite.acao(emprestimo);
		aprv.acao(emprestimo);
		System.out.println(emprestimo.getValor());*/
		
		emprestimo.setSituacao(aprv);
		emprestimo.setSituacao(quite);
		emprestimo.setSituacao(aprv);
		emprestimo.setSituacao(negado);
		emprestimo.setSituacao(aprv);
		emprestimo.setSituacao(emAberto);
		// ^ adaptar para latch
		System.out.println(emprestimo.getValor());
		
		//pseudo-interface
		/*
		System.out.println();
		System.out.println("Bem-vindo(a) ao banco Calote S.A.!");		
		System.out.println("1 - Solicitar um empr�stimo;");
		System.out.println("2 - Pagar um empr�stimo;");
		System.out.println("3 - Verificar situa��o do empr�stimo.");
		System.out.println("Escolha uma das op��es acima: ");*/
		
		
		
		
		
		
		
		
	}

}
