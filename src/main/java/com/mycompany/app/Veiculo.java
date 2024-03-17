package com.mycompany.app;

import java.time.LocalDateTime;

public interface Veiculo {
	
	public Aluguel alugar(Cliente cliente, String local, LocalDateTime dateTime);
	public Aluguel devolver(Data data, String local, LocalDateTime dateTime) throws Exception;
	public void imprimir();
	
}