package com.mycompany.app;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
			
		Scanner scanner = new Scanner(System.in);

		int opcaoMenu;
		Data data = new Data();

		do {
			System.out.println("*------------------------------------------*\n1 - CADASTRAR VEÍCULO\n2 - EDITAR VEÍCULOS\n3 - BUSCAR VEÍCULO\n4 - CADASTRAR CLIENTE\n5 - ALTERAR CLIENTE\n6 - ALUGAR VEÍCULO\n7 - DEVOLVER VEÍCULO \n\n0 - SAIR\n*------------------------------------------*\n");
			opcaoMenu = Integer.parseInt(scanner.nextLine());

			switch (opcaoMenu) {
				//CADASTRAR VEICULO
				case 1:
					try{
						System.out.println("Digite o tipo (Pequeno, Medio, SUV): ");
						String tipo = scanner.nextLine().toUpperCase();
						VeiculoImpl veiculo = VeiculoImpl.criarVeiculo(scanner, data, tipo);
						data.getVeiculos().add(veiculo);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
					
				//EDITAR VEICULOS
				case 2:
					try{
						data.imprimirTodosOsVeiculos();
						VeiculoImpl.alterarVeiculo(scanner, data);
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					break; 
				
				//BUSCAR VEICULOS
				case 3:
					System.out.println("Digite o nome para buscar:");
					String nome = scanner.nextLine().toUpperCase();
					List<VeiculoImpl> results = new ArrayList<>();
					data.getVeiculos().forEach(veiculo -> {
						if (veiculo.getModelo().contains(nome))
							results.add(veiculo);
					});
					results.forEach(veiculo -> veiculo.imprimir());
					break;
					
				//CADASTRAR CLIENTE
				case 4:
					
					try{
						Cliente cliente = Cliente.criarCliente(scanner, data);
						data.getClientes().add(cliente);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				
				//ALTERAR CLIENTE
				case 5:
					
					try{
						data.imprimirTodosOsClientes();
						Cliente.alterarCliente(scanner, data);
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
	
				//ALUGAR VEICULO
				case 6:
					try{
						data.imprimirTodosOsVeiculos();
						System.out.println("Digite a placa do veiculo para alugar: ");
						String placa = scanner.nextLine().toUpperCase();
						Optional<VeiculoImpl> optVeiculo = data.acharVeiculo(placa);
						VeiculoImpl veiculo = optVeiculo.orElseThrow(() -> new Exception("Veiculo não encontrado"));
						
						data.imprimirTodosOsClientes();
						System.out.println("Digite o código do cliente que ira alugar: ");
						String codigo = scanner.nextLine().toUpperCase();
						Optional<Cliente> optCliente = data.acharCliente(codigo);
						Cliente cliente = optCliente.orElseThrow(() -> new Exception("Cliente não encontrado"));
						
						System.out.println("Digite o local da retirada: ");
						String local = scanner.nextLine().toUpperCase();
						
						System.out.println("Digite a data da retirada (dia/mes/ano hr:min): ");
						String datahora = scanner.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
						
						Aluguel aluguel = veiculo.alugar(cliente, local, LocalDateTime.parse(datahora, formatter));
						data.getAlugueis().add(aluguel);
						System.out.println("Aluguel realizado com sucesso!");
						
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					
					
					break;
					
				//DEVOLVER VEICULO
				case 7:
					try{
						data.imprimirTodosOsAlugueisAbertos();
						
						System.out.println("Digite a placa do carro para devolver: ");
						String placa = scanner.nextLine().toUpperCase();
						Optional<VeiculoImpl> optVeiculo = data.acharVeiculo(placa);
						VeiculoImpl veiculo = optVeiculo.orElseThrow(() -> new Exception("Veiculo não encontrado"));
						
						System.out.println("Digite o local de devolucão: ");
						String local = scanner.nextLine().toUpperCase();
						
						System.out.println("Digite a data da entrega (dia/mes/ano hr:min): ");
						String datahora = scanner.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
						
						Aluguel aluguel = veiculo.devolver(data, local, LocalDateTime.parse(datahora, formatter));
						System.out.println("Veiculo devolvido com sucesso");
						System.out.println("Preco total: " + aluguel.calcularPreco());
						
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
				
					break;
				
				default:
					System.out.println("Opção inválida.");
			}
			
			System.out.println("Pressione qualquer tecla para continuar...");
			scanner.nextLine();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  
			
		} while (opcaoMenu != 0);
	}

}