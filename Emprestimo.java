package situacao;

import java.math.BigDecimal;

public class Emprestimo {
	// abstrair para orquestrador
	private BigDecimal valor;
	private Beneficiado beneficiado;
	private int numeroContrato;
	private SituacaoEmprestimo situacao;

	// situação definida aleatoriamente

	public Emprestimo(int numeroContrato, Beneficiado beneficiado, BigDecimal valor) {
		this.numeroContrato = numeroContrato;
		this.beneficiado = beneficiado;
		this.valor = valor;
	}

	private void aprovar() { // alterar visibilidade
		if(validaAprovacao()) {
			System.out.println("Insira uma taxa: ");
			BigDecimal jurosFicticio = new BigDecimal("0.12");
			this.situacao = new Aprovado(jurosFicticio);
			System.out.println("Aprovado, defina a taxa de juros...");
		}
		
	}

	private void negar() {
		this.situacao = new Negado();
		this.situacao.acao(this);

		System.out.println("NEGADOOOO!");
		// impedir de outras ações sejam acionadas quando o empréstimo for negado
	}

	private void quitar() {
		this.situacao = new Quitado();
		this.situacao.acao(this);
		// instanciar um quitado

	}

	protected boolean validaAprovacao() {
		if (situacao instanceof Quitado) {
			System.out.println("Empréstimo quitado, informe ao cliente!");
		} else if (situacao instanceof Negado) {
			System.out.println("Empréstimo negado, informe ao cliente!");
		} else if (situacao instanceof EmAberto) {
			System.out.println("Empréstimo em aberto!");
		} else {
			return true;
		}
		return false;
	}

	protected BigDecimal getValor() {
		return valor;
	}

	protected void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setSituacao(SituacaoEmprestimo situacao) {

		// if(situacao == new Aprovado()) {}

		if (situacao instanceof Quitado) {
			quitar();
		} else if (situacao instanceof Negado) {
			negar();
		} else if (situacao instanceof EmAberto) {
			this.situacao = new EmAberto();
			this.situacao.acao(this);
		} else if (situacao instanceof Aprovado) {
			aprovar();
		}

	}
}
