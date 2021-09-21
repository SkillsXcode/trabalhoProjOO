package situacao;

import java.math.BigDecimal;

public class Emprestimo {

	private BigDecimal valor;
	private Beneficiado beneficiado;
	private int numeroContrato;
	private SituacaoEmprestimo situacao;

	public Emprestimo(int numeroContrato, Beneficiado beneficiado, BigDecimal valor) {
		this.numeroContrato = numeroContrato;
		this.beneficiado = beneficiado;
		this.valor = valor;
	}

	private void aprovar() { 
		if (validaAprovacao()) {
			System.out.println("Insira uma taxa: ");
			BigDecimal jurosFicticio = new BigDecimal("0.12");
			this.situacao = new Aprovado(jurosFicticio, getValor());
			this.situacao.acao(this);
		}
	}

	private void negar() {
		if (validaNegado()) {
			this.situacao = new Negado();
			this.situacao.acao(this);
		}
	}

	private void quitar() {
		if (validaQuitado()) {
			this.situacao = new Quitado();
			this.situacao.acao(this);
		}
	}

	public void setSituacao(SituacaoEmprestimo situacao) {

		if (situacao instanceof Quitado) {
			if (this.situacao == null) {
				System.out.println("Primeiro realize um empréstimo, antes de quitá-lo.");
			}else {
				quitar();
			}
		} else if (situacao instanceof Negado) {
			negar();
		} else if (situacao instanceof EmAberto) {
			if (validaEmAberto()) {
				this.situacao = new EmAberto();
				this.situacao.acao(this);
			}
		} else if (situacao instanceof Aprovado) {
			aprovar();
		}
	}

	/*
	 * No contexto de produção, esses if's seriam reduzidos pelo Strategy, porém o
	 * foco do trabalho não é esse e a aplicação desse padrão comprometeria a
	 * demonstração do State
	 */

	/* Necessário para manutenção da regra de negócio */

	public boolean validaAprovacao() {

		if (this.situacao instanceof Quitado) {
			System.out.println("Empréstimo quitado, informe ao cliente!");
		} else if (this.situacao instanceof Negado) {
			System.out.println("Empréstimo negado, informe ao cliente!");
		} else if (this.situacao instanceof EmAberto) {
			System.out.println("Empréstimo em aberto!");
		} else if (this.situacao instanceof Aprovado) {
			System.out.println("Empréstimo já aprovado!");
		} else {
			return true;
		}
		return false;
	}

	private boolean validaEmAberto() {
		
		if (this.situacao instanceof Quitado) {
			System.out.println("Empréstimo quitado, informe ao cliente!");
		} else if (this.situacao instanceof Negado) {
			System.out.println("Empréstimo negado, informe ao cliente!");
		} else {
			if (this.situacao instanceof Aprovado) {
				return true;
			} else {
				System.out.println("Operação Inválida!");
				return false;
			}
		}
		return false;
	}

	private boolean validaNegado() {

		if (this.situacao instanceof Quitado) {
			System.out.println("Empréstimo quitado, informe ao cliente!");
		} else if (this.situacao instanceof EmAberto) {
			System.out.println("Empréstimo em aberto, informe ao cliente!");
		} else if (this.situacao instanceof Aprovado) {
			System.out.println("Este empréstimo já foi aprovado!");
		} else {
			return true;
		}
		return false;
	}

	private boolean validaQuitado() {
		if (this.situacao instanceof Negado) {
			System.out.println("Empréstimo negado, informe ao cliente!");
		} else if (this.situacao instanceof EmAberto) {
			System.out.println("Empréstimo em aberto, informe ao cliente!");
		} else if (this.situacao instanceof Aprovado) {
			System.out.println("Este empréstimo já foi aprovado!");
		} else {
			return true;
		}
		return false;
	}

	private BigDecimal getValor() {
		return valor;
	}
}