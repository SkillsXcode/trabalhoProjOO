package situacao;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		int opcao;
		Scanner entrada = new Scanner(System.in);		
		
		BigDecimal valorEmprestado = new BigDecimal("10000.00");
		BigDecimal jurosFicticio = new BigDecimal("0.12");
		Beneficiado beneficiadoGenerico = new Beneficiado("Breno", "139.092.023-239", "20.032.932-9", "2345-678");
		Emprestimo emprestimo = new Emprestimo(23655, beneficiadoGenerico, valorEmprestado);
		
		Quitado quite = new Quitado();
		Aprovado aprovado = new Aprovado(jurosFicticio, valorEmprestado);
		Negado negado = new Negado();
		EmAberto emAberto = new EmAberto();
		
		Random pseudoRegraNegocio = new Random();
		int bitAleatorio = pseudoRegraNegocio.nextInt(2);

		do {
			
			System.out.println();
			System.out.println("Bem-vindo(a) ao banco Calote S.A.!");		
			System.out.println("1 - Solicitar um empr�stimo;");
			System.out.println("2 - Quitar um empr�stimo;");
			System.out.println("3 - Verificar situa��o do empr�stimo.");
			System.out.println("0 - Sair.");
			System.out.println("Escolha uma das op��es acima: ");
			
			opcao = entrada.nextInt();
			
			switch(opcao) {
				case 1:
					if (bitAleatorio == 1) {//aprovado
						emprestimo.setSituacao(aprovado);
					} else {
						emprestimo.setSituacao(negado);
					}
					break;
				case 2:
						emprestimo.setSituacao(quite);
					break;
				case 3:
						emprestimo.setSituacao(emAberto);
					break;
				case 0:
					opcao = 0;
					break;
				default:
					System.out.println("Insira apenas as op��es apresentadas!");
			}
			
		} while(opcao != 0);	
	}
}
