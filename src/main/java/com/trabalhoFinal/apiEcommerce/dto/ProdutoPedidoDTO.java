package com.trabalhoFinal.apiEcommerce.dto;

public class ProdutoPedidoDTO {

	private String nome;
	private Double quantidade;
	private Double valor;
	private Integer id_produto;

	
	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ProdutoPedidoDTO [nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}

}
