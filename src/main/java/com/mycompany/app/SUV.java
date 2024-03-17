package com.mycompany.app;

public class SUV extends VeiculoImpl {

	public SUV(String placa, String modelo, double potencia) {
		super(placa, modelo, potencia);
		this.setValorDiaria(200.0);
	}
}