package edu.faqi.dcoo.nota.regiaosul;

//Este é o padrão ESPECIALISTA
public class ItemNota {

	int quantidade;
	Produto produto;
	int codNotaFiscal;

	public ItemNota(Produto produto, int quantidade){
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
	
	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public int getCodNotaFiscal() {
		return codNotaFiscal;
	}

	public void setCodNotaFiscal(int codNotaFiscal) {
		this.codNotaFiscal = codNotaFiscal;
	}

	
	
	public Double getValorParcial() {		
		return this.getProduto().getPrecoMethod() * this.quantidade;
		
	}
	
	
}
