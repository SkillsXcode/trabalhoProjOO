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
		}
		
	}

	private void negar() {
		if(validaNegado()) {
			this.situacao = new Negado();
			this.situacao.acao(this);
		}
		

		// impedir de outras ações sejam acionadas quando o empréstimo for negado
	}

	private void quitar() {
		this.situacao = new Quitado();
		this.situacao.acao(this);
		// instanciar um quitado

	}
	
	public void setSituacao(SituacaoEmprestimo situacao) {

		if (situacao instanceof Quitado) {
			quitar();
		} else if (situacao instanceof Negado) {
			negar();
		} else if (situacao instanceof EmAberto) {
			
			if(validaEmAberto()) {
				this.situacao = new EmAberto();
				this.situacao.acao(this);
			}
			
		} else if (situacao instanceof Aprovado) {
			aprovar();
		}

	}
	
	/* No contexto de produção, esses if's seriam reduzidos pelo Strategy, 
	porém o foco do trabalho não é esse e a aplicação desse padrão comprometeria a
	demonstração do State */
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
	
	protected boolean validaEmAberto() {
		if (situacao instanceof Quitado) {
			System.out.println("Empréstimo quitado, informe ao cliente!");
		} else if (situacao instanceof Negado) {
			System.out.println("Empréstimo negado, informe ao cliente!");
		} else {
			return true;
		}
		return false;
	}
	
	protected boolean validaNegado() {
		if (situacao instanceof Quitado) {
			System.out.println("Empréstimo quitado, informe ao cliente!");
		} else if (situacao instanceof EmAberto) {
			System.out.println("Empréstimo em aberto, informe ao cliente!");
		} else if (situacao instanceof Aprovado) {
			System.out.println("Este empréstimo já foi aprovado!");
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

	
}
