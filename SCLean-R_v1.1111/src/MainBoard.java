//(SysCLean-R) SISTEMA DE COLETA DE LIXO E RECICLAGEM
		
/*
 * -----AGENTES COMUNICADORES-----
 * -------------------------------
 * 1º - USUARIO
 * 2º - LIXO
 * 3º - COLETA E RECICLAGEM
 * -------------------------------
 */

//LINK ÚTIL: https://www.capesesp.com.br/o-que-e-e-o-que-nao-e-reciclavel

public class MainBoard {

	//MOSTRA O SUB-MENU PARA A ESCOLHA DO TIPO DE LIXO
	public static int controlarMenu_LixoRegistrado() {
		int tipo = 0;
		do {
			Menu.mostrarSubMenu_LixoRegistrado();
			tipo = Ltp2Utils.recebeInt("Escolha uma opção: ");
		}while(tipo < 0 || tipo > 3);
		
		System.out.println("");
		
		return tipo;
	}
	
	//PRINCIPAL
	public static void main(String[] args)
	{
		System.out.println("****Bem vindo ao SysCLean-R****");
		System.out.println("_______________________________");
		System.out.println("Data atual: " + Ltp2Utils.getTime() + "\n\n");
		
		boolean exit = true;
		int key = 0;
		
		do {
			Menu.mostrarOpcoes();
			
			key = Menu.opc(11);
			
			switch (key) 
			{
				case 1:
					Menu.mostrarSubMenu_Lista();
					key = Menu.opc(4);
					
					if(key == 1) { 
						// FUNCIONARIOS
						Person[] funcionarios = Load.loadWorkers();
						
						System.out.println("*********************************************************");
						System.out.println("******************LISTA DE FUNCIONÁRIOS******************");
						
						int i;
						
						for (i = 0; i < funcionarios.length; i++) {
							Printer.printWorkers(funcionarios[i]);
							System.out.println("\n\n_________\n\n");
						}
						
						System.out.println("--------\nQuantidade de funcionários na empresa: " + i);
						System.out.println("\n********************************************************\n\n");
						
					}else if(key == 2) {
						// CLIENTES
						Person[] clientes = Load.loadCustomers();
						
						System.out.println("*********************************************************");
						System.out.println("********************LISTA DE CLIENTES********************");
						
						int i;
						
						for (i = 0; i < clientes.length; i++) {
							Printer.printCustomers(clientes[i]);
							System.out.println("\n\n_________\n\n");
						}
						
						System.out.println("--------\nQuantidade de clientes na empresa: " + i);
						System.out.println("\n********************************************************\n\n");
						
					}else if(key == 3) {
						// VAR TIPO
						/*
						 * 1 -> "" - MOSTRAR TODOS
						 * 2 -> R  - MOSTRAR RECICLAVEIS
						 * 3 -> NR - MOSTRAR NÃO RECICLAVEIS
						 */
						
						// CLIENTES
						Garbage[] lixo = Load.loadGarbage();
						
						System.out.println("********************************************************");
						
						//Menu.mostrarSubMenu_LixoRegistrado();
						int i, option = 0;
						
						do {
							option = controlarMenu_LixoRegistrado();
	
							if(option != 0) {
								for (i = 0; i < lixo.length; i++) {
									Printer.printGarbage(lixo[i], option);
								}
								
								System.out.println("--------\nQuantidade de estoques de lixo na empresa: " + i);
								System.out.println("\n********************************************************\n\n");
							}
						}while(option != 0);
						
					}else if(key == 4) {
						// VENDAS
						Sale[] sales = Load.loadSale();
						
						System.out.println("*********************************************************");
						System.out.println("********************LISTA DE CLIENTES********************");
						
						int i;
						
						for (i = 0; i < sales.length; i++) {
							Printer.printSales(sales[i]);
							System.out.println("\n\n_________\n\n");
						}
						
						System.out.println("--------\nQuantidade de clientes na empresa: " + i);
						System.out.println("\n********************************************************\n\n");
					}
					break;
				case 2:
					Menu.mostrarSubMenu_Cadastro();
					key = Menu.opc(2);
					
					if(key == 1) {
						// FUNCIONÁRIO
						Record.salvarFuncionario(Input.cadastrarFuncionario());
						
					}else if(key == 2) {
						// CLIENTES
						Record.salvarCliente(Input.cadastrarCliente());
					}
					
					break;
				case 3:
					
					break;
				case 4:
						Garbage[] lixo = Load.loadGarbage();
						String[][] garbageTotalInfo = new String[Load.totalGarbage()][8];
						
						for (int i = 0; i < lixo.length; i++) {
							garbageTotalInfo[i][0] = String.valueOf(lixo[i].id);
							garbageTotalInfo[i][1] = String.valueOf(lixo[i].ativo);
							garbageTotalInfo[i][2] = lixo[i].descricao;
							garbageTotalInfo[i][3] = String.valueOf(lixo[i].peso);
							garbageTotalInfo[i][4] = lixo[i].tipo;
							garbageTotalInfo[i][5] = String.valueOf(lixo[i].status);
							garbageTotalInfo[i][6] = lixo[i].categoria;
							garbageTotalInfo[i][7] = lixo[i].data;
						}
						
						Info.informWeight(garbageTotalInfo);
					break;
				case 5:
					Record.salvarLixo(Input.cadastrarLixo());
					break;
				case 6:
					Menu.showSubMenu_Change();
					key = Menu.opc(2);
					
					if(key == 1) {
						//FUNCIONÁRIO
						Update.updateWorker(Ltp2Utils.recebeString("Informe o CPF do Funcionário"));
						
					}else if(key == 2) {
						//CLIENTES
						Update.updateCustomer(Ltp2Utils.recebeString("Informe o CPF do Cliente"));
					}
					break;
				case 7:
					Menu.showSubMenu_Delete();
					key = Menu.opc(2);
					
					if(key == 1) {
						//FUNCIONÁRIO
						Delete.deleteWorker(Ltp2Utils.recebeString("Informe o CPF do Funcionário"), true);
						
					}else if(key == 2) {
						//CLIENTES
						Delete.deleteCustomer(Ltp2Utils.recebeString("Informe o CPF do Cliente"), true);
					}
				case 8:
					/*
					if(Record.saveSale(Input.registerSale() == null)) {
						key = 0;
						System.out.println("\n\n--> VENDA CANCELADA <--\n");
					}
					*/
					Record.saveSale(Input.registerSale());
					break;
					
				default:
					exit = Ltp2Utils.confirmaSaida();
					break;
			}
			
		} while (exit);
		
		
		System.out.println("\n\nObrigado por usar um systema da FeMP Sistemas LTDA");
	}
}
