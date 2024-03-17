package com.mycompany.app;

import java.util.Optional;
import java.util.Scanner;

public class Cliente {
	
	private String identificador;
	private String nome;
	private String tipo; // "PF" ou "PJ"
	
	public Cliente(String identificador, String nome, String tipo) {
		this.identificador = identificador;
		this.nome = nome;
		this.tipo = tipo;
	}
		
	public String getIdentificador() {
		return identificador;
	}

	public void setidentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void imprimir() {
		System.out.println("----------------------------");
		System.out.println("Código: " + getIdentificador());
		System.out.println("Nome: " + getNome());
		System.out.println("Tipo: " + getTipo());
	}
	
	public static Cliente criarCliente(Scanner scanner, Data data) throws Exception{

		System.out.println("*------------------------------------------*");
		System.out.print("Digite o nome: ");
		String nomeCliente = scanner.nextLine().toUpperCase();
		System.out.print("Pessoa Física ou Pessoa Jurídica? (PF/PJ) ");
		String categoriaPessoa = scanner.nextLine().toUpperCase();
		String id;
		if (categoriaPessoa.equals("PF")){
			System.out.print("Digite o CPF: ");
			id = scanner.nextLine();
		} else if (categoriaPessoa.equals("PJ")){
			System.out.print("Digite o CNPJ: ");
			id = scanner.nextLine();
		}
		else throw new Exception("Categoria de cliente invalida!");

		Optional<Cliente> optCliente = data.acharCliente(id);
		if (optCliente.isPresent()){
			throw new Exception("CPF/CNPJ já cadastrado!");
		}

		return new Cliente(id, nomeCliente, categoriaPessoa);

	}

	public static void alterarCliente(Scanner scanner, Data data) throws Exception {

		//Obtendo cliente
		System.out.println("Código do cliente que deseja editar: ");
		String codigo = scanner.nextLine();
		Optional<Cliente> optCliente = data.acharCliente(codigo);
		Cliente cliente = optCliente.orElseThrow(() -> new Exception("Codigo invalido"));

		//Alterando cliente
		System.out.println("Digite o novo nome do cliente: ");
		String nome = scanner.nextLine().toUpperCase();
		cliente.setNome(nome);

	}
	
}