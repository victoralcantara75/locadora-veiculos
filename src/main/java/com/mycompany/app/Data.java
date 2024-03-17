package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Data {
	
	private List<Cliente> clientes;
	private List<VeiculoImpl> veiculos;
	private List<Aluguel> alugueis;
	
	public Data() {
	    this.clientes = new ArrayList<>();
		this.veiculos = new ArrayList<>();
		this.alugueis = new ArrayList<>();
	}
	
	public List<Cliente> getClientes() {
	    return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
	    this.clientes = clientes;
	}
	
	public List<VeiculoImpl> getVeiculos() {
	    return veiculos;
	}

	public void setVeiculos(List<VeiculoImpl> veiculos) {
	    this.veiculos = veiculos;
	}
	
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void imprimirTodosOsClientes(){
		clientes.forEach(cliente -> cliente.imprimir());
	}
	
	public void imprimirTodosOsVeiculos(){
		veiculos.forEach(veiculo -> veiculo.imprimir());
	}
	
	public void imprimirTodosOsAlugueisAbertos(){
		alugueis.stream().filter(aluguel -> aluguel.getDataEntrega() == null).forEach(aluguel -> aluguel.imprimir());
	}
	
	public Optional<Cliente> acharCliente(String codigo){
		return clientes.stream().filter(cliente -> cliente.getIdentificador().equals(codigo)).findFirst();
	}
	
	public Optional<VeiculoImpl> acharVeiculo(String placa){
		return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equals(placa)).findFirst();
	}
	
	public Optional<Aluguel> acharAluguel(String placa){
		return alugueis.stream()
						.filter(aluguel -> Objects.equals(aluguel.getVeiculo().getPlaca(), placa))
						.filter(aluguel -> aluguel.getDataEntrega() == null)
						.findFirst();
	}
	
}