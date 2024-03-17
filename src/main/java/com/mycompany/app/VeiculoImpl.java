package com.mycompany.app;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class VeiculoImpl implements Veiculo {

	private String placa;
	private String modelo;
	private double potencia;
	private double valorDiaria;
	private boolean disponivel;
	
	public VeiculoImpl(String placa, String modelo, double potencia){
		this.placa = placa;
		this.modelo = modelo;
		this.potencia = potencia;
		this.disponivel = true;
	}
	

	@Override
	public Aluguel alugar(Cliente cliente, String local, LocalDateTime dateTime) {
	
		this.setDisponivel(false);
		return new Aluguel(cliente, this, dateTime, local);
		
	}

	@Override
	public Aluguel devolver(Data data, String local, LocalDateTime dateTime) throws Exception {
		Optional<Aluguel> optAluguel = data.acharAluguel(this.getPlaca());
		Aluguel aluguel = optAluguel.orElseThrow(() -> new Exception("Nenhum aluguel aberto encontrado para a placa"));
		aluguel.setLocalEntrega(local);
		aluguel.setDataEntrega(dateTime);
		this.disponivel = true;
		return aluguel;
	}

	@Override
	public void imprimir() {
		System.out.println("------------------------");
		System.out.println("Placa: " + this.placa);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Potência: " + this.potencia);
		System.out.println("Valor Diária: " + this.valorDiaria);
		System.out.println("Disponível: " + this.disponivel);
	}
	
	public static VeiculoImpl criarVeiculo(Scanner scanner, Data data, String tipo) throws Exception{
		System.out.println("*------------------------------------------*");
		System.out.print("Digite a placa do carro: ");
		String placa = scanner.nextLine().toUpperCase();
		
		Optional<VeiculoImpl> optVeiculo = data.acharVeiculo(placa);
		if (optVeiculo.isPresent()){
			throw new Exception("Placa já cadastrado!");
		}
		
		System.out.print("Digite o nome do modelo: ");
		String modelo = scanner.nextLine().toUpperCase();
		System.out.print("Digite a potencia do motor (1.0, 1.4..): ");
		String potencia = scanner.nextLine();
		
		switch (tipo){
			case "PEQUENO":
				return new CarroPequeno(placa, modelo, Double.parseDouble(potencia));
			case "MEDIO":
				return new CarroMedio(placa, modelo, Double.parseDouble(potencia));
			case "SUV":
				return new SUV(placa, modelo, Double.parseDouble(potencia));
			default:
				return null;
		}
	}
	
	public static void alterarVeiculo(Scanner scanner, Data data) throws Exception {

		//Obtendo veiculo
		System.out.println("Placa do veiculo que deseja editar: ");
		String placa = scanner.nextLine();
		Optional<VeiculoImpl> optVeiculo = data.acharVeiculo(placa);
		VeiculoImpl veiculo = optVeiculo.orElseThrow(() -> new Exception("Placa invalida"));

		//Alterando veiculo
		System.out.println("Digite o novo modelo: ");
		String modelo = scanner.nextLine().toUpperCase();
		System.out.println("Digite a nova potencia: ");
		String potencia = scanner.nextLine();
		veiculo.setModelo(modelo);
		veiculo.setPotencia(Double.parseDouble(potencia));

	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}