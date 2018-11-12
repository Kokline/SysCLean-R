public class Menu {
	
	public static int opc(int range) {
		int key = 0;
		do {
			if(key > range) { System.out.println("\nOp��es inv�lidas. Tente Novamente."); }
			key = Ltp2Utils.recebeIntValidoMenu("");
		}while(key > range);
		
		return key;
	}
	
	/*
	 * MENU -> PRINCIPAL
	 */
	public static void mostrarOpcoes() {
		System.out.println("-----MENU DE OP��ES-----\n"
				  + "\n 	1 - Listagens"
				  + "\n 	2 - Cadastros"
				  + "\n 	3 - Busca Avan�ada"
				  + "\n 	4 - Estat�sticas"
				  + "\n 	5 - Registrar LIXO"
				  + "\n	0 - sair\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> CADASTRO
	 */
	
	public static void mostrarSubMenu_Cadastro() {
		System.out.println("\n-----Op��es de listagem de registros-----\n"
				  + "\n------------------Cadastro-------------------"
				  + "\n1 - Cadastrar Funcion�rio"
				  + "\n2 - Cadastrar Cliente"
				  + "\n------------------Exclus�o-------------------"
				  + "\n3 - Excluir Funcionario"
				  + "\n4 - Excluir Cliente"
				  + "\n0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> BUSCA AVAN�ADA
	 */
	
	public static void mostrarSubMenu_Busca() {
		System.out.println("\n-----Op��es de busca avan�ada-----\n"
				  + "\n 	1 - Buscar Funcionario."
				  + "\n 	2 - Buscar Cliente."
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
				  + "\n 	2 - Lixo N�o Recicl�vel");
		
		int key = opc(2);
		
		if(key == 1) { result = "R"; }
		else { result = "NR"; }
		
		return result;
	}
	
	public static char getStatus() {
		char result = ' ';
		System.out.println("\n-----Op��es de Status do Lixo-----\n"
				  + "\n 	1 - Incinerador"
				  + "\n 	2 - Vendas");
		
		int key = opc(2);
		
		if(key == 1) { result = 'I'; }
		else { result = 'V'; }
		
		return result;
	}
	
	public static String getCategory() {
		String result = "";
		System.out.println("\n-----Op��es de Tipo de Lixo-----\n"
				  + "\n 	1 - Metal"
				  + "\n 	2 - Org�nico"
				  + "\n		3 - Papel"
				  + "\n		4 - Plastico"
				  + "\n		5 - Vidro");
		
		int key = opc(5);
		
		if(key == 1) { result = "Metal"; }
		else if(key == 2) { result = "Org�nico"; }
		else if(key == 3) { result = "Papel"; }
		else if(key == 4) { result = "Pl�stico"; }
		else { result = "Vidro"; }
		
		return result;
	}
}
