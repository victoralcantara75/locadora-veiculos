package com.mycompany.app;

public class CarroMedio extends VeiculoImpl {

	public CarroMedio(String placa, String modelo, double potencia) {
		super(placa, modelo, potencia);
		this.setValorDiaria(150.0);
	}
}