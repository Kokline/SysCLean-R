
public class Menu {
	
	public static int opc(int range) {
		int key = 0;
		do {
			if(key > range || key < 0) { System.out.println("\nOp��o inv�lida. Tente Novamente."); }
			key = Ltp2Utils.recebeIntValidoMenu("");
		}while(key > range || key < 0);
		
		return key;
	}
	
	/*
	 * MENU -> PRINCIPAL
	 */
	public static void mostrarOpcoes() {
		System.out.println("\n-----MENU DE OP��ES-----\n"
				  + "\n 	1 - Listagnes"
				  + "\n 	2 - Cadastros"
				  + "\n 	3 - Busca Avan�ada"
				  + "\n 	4 - Estat�sticas"
				  + "\n 	5 - Registrar LIXO"
				  + "\n 	------------------"
				  + "\n 	6 - Alterar"
				  + "\n 	7 - Excluir"
				  + "\n 	------------------"
				  + "\n 	8 - VENDER LIXO"
				  + "\n	0 - sair\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> CERTEZA?
	 */
	
	public static int doYouWantToDoThis() {
		System.out.println("\nQuer mesmo fazer isso?\n"
				  + "\n 	1 - SIM"
				  + "\n 	2 - N�O"
				  + "\n	0 - Retornar ao menu principal\n\n");
		
		if(Ltp2Utils.recebeInt("Op��o: ") == 1) { return 1; }
		else { return -2; }
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> CADASTRO
	 */
	
	public static void mostrarSubMenu_Cadastro() {
		System.out.println("\n-----Op��es de listagem de registros-----\n"
				  + "\n 	1 - Cadastrar Funcion�rio"
				  + "\n 	2 - Cadastrar Cliente"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> LISTAGEM
	 */
	
	public static void mostrarSubMenu_Lista() {
		System.out.println("\n-----Op��es de listagem de registros-----\n"
				  + "\n 	1 - Listar Funcion�rios"
				  + "\n 	2 - Listar Clientes"
				  + "\n 	3 - Listar Lixo Registrado"
				  + "\n 	4 - Listar Vendas"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	public static void mostrarSubMenu_LixoRegistrado() {
		System.out.println("\n-----Op��es de Tipos de Lixo-----\n"
				  + "\n 	1 - Mostrar todos"
				  + "\n 	2 - Somente Recicl�vel"
				  + "\n 	3 - Somente N�O Reciclavel"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> ESTAT�STICO
	 */
	
	public static void mostrarSubMenu_Estatistica() {
		System.out.println("\n-----Op��es de informa��es estat�sticas-----\n"
				  + "\n 	1 - Lixo (Quantidade)"
				  + "\n 	2 - Financeiro"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------

	/*
	 * MENU -> ALTERAR
	 */
	
	public static void showSubMenu_Change() {
		System.out.println("\n------------ALTERAR INFORMA��ES-------------\n"
				  + "\n 	1 - Alterar Funcion�rio"
				  + "\n 	2 - Alterar Cliente"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------

	/*
	 * MENU -> EXCLUIR
	 */
	
	public static void showSubMenu_Delete() {
		System.out.println("\n------------DELETAR INFORMA��ES-------------\n"
				  + "\n 	1 - Deletar Funcion�rio"  
				  + "\n 	2 - Deletar Cliente"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> UPDATE CLIENTES
	 */
	public static void showSubMenu_UpdateWorkers() {
		System.out.println("\n-----INFORMA��ES QUE PODEM SER ALTERADAS-----\n"
				  +"*********************************************\n"
				  + "\n 	1 - Nome"
				  + "\n 	2 - Sobrenome"
				  + "\n 	3 - Ramo de Atividade"
				  + "\n 	4 - Rua"
				  + "\n 	5 - N�"
				  + "\n 	6 - CEP"
				  + "\n 	7 - Bairro"
				  + "\n 	8 - Cidade"
				  + "\n 	9 - Estado"
				  + "\n       10 - Genero"
				  + "\n       11 - Data de Nascimento"
				  + "\n       12 - Ocupa��o na Empresa"
				  + "\n       13 - Registro"
				  + "\n       -----------------------"
				  + "\n	0 - Finalizar\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> UPDATE CLIENTES
	 */
	public static void showSubMenu_UpdateCustomers() {
		System.out.println("\n-----INFORMA��ES QUE PODEM SER ALTERADAS-----\n"
				  +"*********************************************\n"
				  + "\n 	1 - Nome"
				  + "\n 	2 - Sobrenome"
				  + "\n 	3 - Ramo de Atividade"
				  + "\n 	4 - Rua"
				  + "\n 	5 - N�"
				  + "\n 	6 - CEP"
				  + "\n 	7 - Bairro"
				  + "\n 	8 - Cidade"
				  + "\n 	9 - Estado"
				  + "\n       10 - Genero"
				  + "\n       11 - Data de Nascimento"
				  + "\n       -----------------------"
				  + "\n	0 - Finalizar\n\n");
	}
	
	//-------------------------------------------------------------------------
	//PARAMETRO V�LIDOS PARA REGISTRO DE LIXO
			/*
			 * TIPO--------------------------
			 * "" - CALCULAR P/ TODOS
			 * R  - CALCULAR RECICLAVEIS
			 * NR - CALCULAR N�O RECICLAVEIS
			 * 
			 * STATUS------------------------
			 * I  - CALCULAR P/ INCINERADOR
			 * V  - CALCULAR P/ VENDAS
			 * 
			 * CATEGORIA---------------------
			 * P  - CALCULAR P/ PL�STICO
			 * VI - CALCULAR P/ VIDRO
			 * M  - CALCULAR P/ METAL
			 * PP - CALCULAR P/ PAPEL
			 * O  - CALCULAR P/ ORG�NICO
			 */
	
	public static String getType() {
		String result = "";
		System.out.println("\n-----Op��es de Tipo de Lixo-----\n"
				  + "\n 	1 - Lixo Recicl�vel"
				  + "\n 	2 - Lixo N�o Recicl�vel\n");
		
		int key = opc(2);
		
		if(key == 1) { result = "R"; }
		else { result = "NR"; }
		
		return result;
	}
	
	public static char getStatus() {
		char result = ' ';
		System.out.println("\n-----Op��es de Status do Lixo-----\n"
				  + "\n 	1 - Incinerador"
				  + "\n 	2 - Vendas\n");
		
		int key = opc(2);
		
		if(key == 1) { result = 'I'; }
		else { result = 'V'; }
		
		return result;
	}
	
	public static String getCategory() 
	{
		String result = "";
		System.out.println("\n-----Op��es de Tipo de Lixo-----\n"
				  + "\n		1 - Borracha"
				  + "\n 		2 - Metal"
				  + "\n		3 - Papel"
				  + "\n		4 - Plastico"
				  + "\n		5 - Vidro\n");
		
		// CHECA SE A OP��O � V�LIDA
				int key = opc(5);
		
			 if(key == 1) { result = "Borracha"; }
		else if(key == 2) { result = "Metais"; }
		else if(key == 3) { result = "Papeis"; }
		else if(key == 4) { result = "Pl�sticos"; }
		else if(key == 5) { result = "Vidros"; }
		
		return result;
	}
	
	public static String getCategory_WhithCancel() 
	{
		String result = "";
		System.out.println("\n-----Op��es de Tipo de Lixo-----\n"
				  + "\n		1 - Borracha"
				  + "\n 		2 - Metal"
				  + "\n		3 - Papel"
				  + "\n		4 - Plastico"
				  + "\n		5 - Vidro"
				  + "\n		0 - Cancelar a Venda!\n");
		
		// CHECA SE A OP��O � V�LIDA
				int key = opc(5);
		
			 if(key == 1) { result = "Borracha"; }
		else if(key == 2) { result = "Metais"; }
		else if(key == 3) { result = "Papeis"; }
		else if(key == 4) { result = "Pl�sticos"; }
		else if(key == 5) { result = "Vidros"; }
		
		return result;
	}
}
