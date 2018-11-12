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
			tipo = Ltp2Utils.recebeInt("Escolha de 1 à 3 a opção: ");
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
			
			key = Menu.opc(5);
			
			switch (key) 
			{
				case 1:
					Menu.mostrarSubMenu_Lista();
					key = Menu.opc(3);
					
					if(key == 1) { 
						//FUNCIONARIOS
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
						//CLIENTES
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
						//VAR TIPO
						/*
						 * 1 -> "" - MOSTRAR TODOS
						 * 2 -> R  - MOSTRAR RECICLAVEIS
						 * 3 -> NR - MOSTRAR NÃO RECICLAVEIS
						 */
						
						//CLIENTES
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
						
						/*
						//------------------
						Info.listarInfoLixo(controlarMenu_LixoRegistrado());
						
						String menuPrincipal = "";
						do {
							menuPrincipal = Ltp2Utils.recebeString("Retornar o menu principal? \nS p/ sim N p/ não:").toUpperCase();
							if(menuPrincipal.equals("N")) {
								Info.listarInfoLixo(controlarMenu_LixoRegistrado());
							}
						}while(!menuPrincipal.equals("S"));
						*/
					}
					break;
				case 2:
					Menu.mostrarSubMenu_Cadastro();
					key = Menu.opc(4);
					
					if(key == 1) {
						//CADASTRAR FUNCIONÁRIO
						Record.salvarFuncionario(cadastrarFuncionario());
					}else if(key == 2) {
						//CADASTRAR CLIENTES
						Record.salvarCliente(cadastrarCliente());
					} else if(key == 3) {
						//EXCLUIR FUNCIONARIO
						Record.excluirFuncionario(Ltp2Utils.verificaCPF(""));										
					} else if(key == 4) {
						//EXCLUIR EXCLUIR
						Record.excluirCliente(Ltp2Utils.verificaCPF(""));
					}
					
					break;
				case 3:
					Menu.mostrarSubMenu_Busca();
					key = Menu.opc(2);
					
					if(key == 1) {
						Person func = Record.buscarFuncionarioPeloCPF(Ltp2Utils.recebeInt("Digite o CPF do Funcionario:"));
						Printer.printWorkers(func);						
					}else if (key == 2) {
						Person cli = Record.buscarClientePeloCPF(Ltp2Utils.recebeInt("Digite o CPF do Cliente:"));
						Printer.printCustomers(cli);
					}
					break;
				case 4:
					Menu.mostrarSubMenu_Estatistica();
					key = Menu.opc(2);
					
					if(key == 1) {
						//LIXO (QTT)
						System.out.print("\n\n" + estatisticas() + "\n\n");
					}else {
						
					}
					break;
				case 5:
					/*
					String[][] table = {	{"1", "Y", "Latas", "20", "R", "V", "Metais", "05/09/18 12:40"}, 
							{"2", "Y", "Papelão", "0.95", "R", "I", "Papeis", "02/10/18 18:51"}, 
							{"3", "Y", "Papel carbono", "2", "NR", "V", "Papeis", "15/09/18 13:23"}, 
							{"4", "Y", "Garrafas de bebidas", "485", "R", "V", "Vidros", "06/10/18 18:51"}, 
							{"5", "Y", "Cabos de panela", "130", "NR", "I", "Plásticos", "05/10/18 19:51"},
							{"6", "Y", "Pilhas", "931.8", "NR", "V", "Metais", "06/10/18 18:51"},
							{"7", "Y", "Adesivos", "193", "NR", "I", "Papeis", "05/10/18 12:35"},
							{"8", "Y", "Potes de alimentos", "39", "R", "V", "Plásticos", "15/09/18 23:40"},
							{"9", "Y", "Ferragens", "2380", "R", "V", "Metais", "06/10/18 18:55"},
							{"10", "Y", "Revistas", "995.15", "R", "V", "Papeis", "06/10/18 18:59"}, 
							{"11", "N", "Jornal", "75.0", "R", "I", "Papeis", "29/10/18 16:26"} };
					
					for (int i = 0; i < table.length; i++) {
						
						String info[] = new String[8];
						
						for (int j = 0; j < 8; j++) {
							System.out.print(table[i][j] + "\n");
							info[j] = table[i][j];
						}
						Record.salvarLixo(cadastrarLixo(info));
					}
					*/
					
					Record.salvarLixo(cadastrarLixo());
					
					break;
				default:
					exit = Ltp2Utils.confirmaSaida();
					break;
			}
			
		} while (exit);
		
		
		System.out.println("\n\nObrigado por usar um systema da FeMP Sistemas LTDA");
	}
	
	/*-----LISTAGEM-----*/
	
	public void listarUsuario() 
	{
		
	}
	
	public void listarInfoColetaReciclagem() 
	{
		
	}
	
	/*-----CADASTRO-----*/
	
	//RETORNA UM OBJETO PESSOA CARREGADO
	public static Person cadastrarFuncionario() {
		Person funcionario = new Person();
		boolean aux = true;
		
		System.out.println("\nInformações Pessoais-------");
		
		do {
			if(aux == false) {
				System.out.println("Funcionário já cadastrado no sistema! \nTente novamente!");
			}
			
			funcionario.cpf = Ltp2Utils.verificaCPF("\n");
			aux = Info.keyVerify(funcionario.cpf, "W");
		} while (!aux);
		
		
		funcionario.nome = Ltp2Utils.recebeString("\nNOME: ");
		funcionario.sobrenome = Ltp2Utils.recebeString("\nSOBRENOME: ");
		funcionario.cpf = Ltp2Utils.verificaCPF("\n");
		funcionario.genero = Ltp2Utils.recebeCharUpperCase("\nGENERO: ");
		funcionario.dataNascimento = Ltp2Utils.recebeString("\nDATA DE NASCIMENTO: ");
		
		System.out.println("\nEndereço-------------------");
		funcionario.rua = Ltp2Utils.recebeString("\nRUA: ");
		funcionario.numero = Ltp2Utils.recebeString("\nNº: ");
		funcionario.cep = Ltp2Utils.recebeString("\nCEP: ");
		funcionario.bairro = Ltp2Utils.recebeString("\nBAIRRO: ");
		funcionario.cidade = Ltp2Utils.recebeString("\nCIDADE: ");
		funcionario.estado = Ltp2Utils.recebeString("\nESTADO: ");
		
		System.out.println("\nRelação com a Empresa------");
		funcionario.empresaRelacao = Ltp2Utils.recebeString("\nOCUPAÇÃO NA EMPRESA: ");
		funcionario.registro = Ltp2Utils.recebeString("\nREGISTRO: ");
		funcionario.active = 'Y';
		funcionario.dataRegistro = Ltp2Utils.getTime();
		
		return funcionario;
	}
	
	//RETORNA UM OBJETO PESSOA CARREGADO
	public static Person cadastrarCliente() 
	{
		Person cliente = new Person();
		boolean aux = true;
		
		System.out.println("\nInformações Pessoais-------");
		
		do {
			if(aux == false) {
				System.out.println("Cliente já cadastrado no sistema! \nTente novamente!");
			}
			
			cliente.cpf = Ltp2Utils.verificaCPF("\n");
			aux = Info.keyVerify(cliente.cpf, "C");
		} while (!aux);
		
		System.out.println("\nInformações Pessoais-------");
		cliente.nome = Ltp2Utils.recebeString("\nNOME: ");
		cliente.sobrenome = Ltp2Utils.recebeString("\nSOBRENOME: ");
		cliente.genero = Ltp2Utils.recebeCharUpperCase("\nGENERO M/F: ");
		cliente.dataNascimento = Ltp2Utils.recebeString("\nDATA DE NASCIMENTO: ");
		
		System.out.println("\nEndereço-------------------");
		cliente.rua = Ltp2Utils.recebeString("\nRUA: ");
		cliente.numero = Ltp2Utils.recebeString("\nNº: ");
		cliente.cep = Ltp2Utils.recebeString("\nCEP: ");
		cliente.bairro = Ltp2Utils.recebeString("\nBAIRRO: ");
		cliente.cidade = Ltp2Utils.recebeString("\nCIDADE: ");
		cliente.estado = Ltp2Utils.recebeString("\nESTADO: ");
		
		int registro = Load.totalCustomers() + 1;
		
		System.out.println("\nRelação com a Empresa------");
		cliente.empresaRelacao = "Cliente";
		cliente.registro = String.valueOf(registro);
		cliente.ramoAtividade = Ltp2Utils.recebeString("\nRamo de Atividade: ");
		cliente.active = 'Y';
		cliente.dataRegistro = Ltp2Utils.getTime();
		
		return cliente;
	}
	
	public static Garbage cadastrarLixo() 
	{
		Garbage lixo = new Garbage();
		
		lixo.id = Load.totalGarbage() + 1;
		lixo.ativo = 'Y';
        lixo.descricao = Ltp2Utils.recebeString("\nNOME ou DESCRIÇÃO: ");
        lixo.peso = Ltp2Utils.recebeFloat("\nPESO: ");
        lixo.tipo = Menu.getType();
        lixo.status = Menu.getStatus();
        lixo.categoria = Menu.getCategory();
        lixo.data = Ltp2Utils.getTime();
        
		/*
        lixo.id = Integer.parseInt(lx[0]);
        lixo.ativo = lx[1].charAt(0);
        lixo.descricao = lx[2];
        lixo.peso = Float.parseFloat(lx[3]);
        lixo.tipo = lx[4];
        lixo.status = lx[5].charAt(0);
        lixo.categoria = lx[6];
        lixo.data = lx[7];
        */
		
		return lixo;
	}
	
	public void registrarColetaReciclagem() 
	{
		
	}
	
	/*-----FUNCIONALIDADES-----*/
	
	//RETORNA UMA STRING PARA IMPRESSÃO
	public static String estatisticas() {
		String resultados = "";
		
		resultados += "**********************************************"
					+ "\n-----------------ESTATÍSTICAS-----------------\n"
					+ "**********************************************\n\n";
		
		//PARAMETRO VÁLIDOS
		/*
		 * TIPO--------------------------
		 * "" - CALCULAR P/ TODOS
		 * R  - CALCULAR RECICLAVEIS
		 * NR - CALCULAR NÃO RECICLAVEIS
		 * 
		 * STATUS------------------------
		 * I  - CALCULAR P/ INCINERADOR
		 * V  - CALCULAR P/ VENDAS
		 * 
		 * CATEGORIA---------------------
		 * P  - CALCULAR P/ PLÁSTICO
		 * VI - CALCULAR P/ VIDRO
		 * M  - CALCULAR P/ METAL
		 * PP - CALCULAR P/ PAPEL
		 * O  - CALCULAR P/ ORGÂNICO
		 */
		
		resultados += "------Registro de peso total por TIPO------\n\n";
		resultados += "Peso Bruto Total:--- " + Info.infoPeso("") + "Kg";
		resultados += "\nLixo Não Reciclável: " + Info.infoPeso("NR") + "Kg";
		resultados += "\nLixo Reciclável:---- " + Info.infoPeso("R") + "Kg";
		
		resultados += "\n\n\n------Registro de peso total por STATUS------\n";
		resultados += "\nLixo para incinerar: " + Info.infoPeso("I") + "Kg";
		resultados += "\nLixo para venda:---- " + Info.infoPeso("V") + "Kg";
		
		resultados += "\n\n\n-----Registro de peso total por CATEGORIA-----\n";
		resultados += "\nOrgânico: " + Info.infoPeso("O") + "Kg";
		resultados += "\nPapel:--- " + Info.infoPeso("PP") + "Kg";
		resultados += "\nPlástico: " + Info.infoPeso("P") + "Kg";
		resultados += "\nVidro:--- " + Info.infoPeso("VI") + "Kg";
		resultados += "\nMetal:--- " + Info.infoPeso("M") + "Kg";
		
		resultados += "\n\n**********************************************\n";
		
		return resultados;
	}
}
