package com.mycompany.app;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Aluguel {
	
	private Cliente cliente;
	private VeiculoImpl veiculo;
	private LocalDateTime dataLocacao;
	private LocalDateTime dataEntrega;
	private String localLocacao;
	private String localEntrega; 
	
	
	public Aluguel(Cliente cliente, VeiculoImpl veiculo, LocalDateTime dataLocacao, String localLocacao) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataLocacao = dataLocacao;
		this.localLocacao = localLocacao; 
	}
	
	public void imprimir() {
	    System.out.println("Cliente: " + cliente.getNome());
	    System.out.println("Veiculo: " + veiculo.getPlaca());
	    System.out.println("Data de Locação: " + dataLocacao);
		System.out.println("Local de Locação: " + localLocacao);
	    System.out.println("Data de Entrega: " + dataEntrega);
	    System.out.println("Local de Entrega: " + localEntrega);
	}
	
	public double calcularPreco(){
		
		long diferencaMinutos = ChronoUnit.MINUTES.between(dataLocacao, dataEntrega);
		double dias = (double) diferencaMinutos / 1440;
		dias = Math.ceil(dias);
		double total = dias * this.getVeiculo().getValorDiaria();
		
		if (this.getCliente().getTipo().equals("PF") && dias > 5)
			total -= total * 0.05;
		else if (this.getCliente().getTipo().equals("PJ") && dias > 3)
			total -= total * 0.1;
		
		return total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public VeiculoImpl getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoImpl veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocalcao(LocalDateTime dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public LocalDateTime getDataEntrega() {
	    return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
	    this.dataEntrega = dataEntrega;
	}

	public String getLocalLocacao() {
	    return localLocacao;
	}

	public void setLocalLocacao(String localLocacao) {
	    this.localLocacao = localLocacao;
	}

	public String getLocalEntrega() {
	    return localEntrega;
	}

	public void setLocalEntrega(String localEntrega) {
	    this.localEntrega = localEntrega;
	}
	
}