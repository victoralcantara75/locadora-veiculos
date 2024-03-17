package com.mycompany.app;

public class CarroPequeno extends VeiculoImpl {

	public CarroPequeno(String placa, String modelo, double potencia) {
		super(placa, modelo, potencia);
		this.setValorDiaria(100.0);
	}
	
}