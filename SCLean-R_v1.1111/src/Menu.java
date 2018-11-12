public class Menu {
	
	public static int opc(int range) {
		int key = 0;
		do {
			if(key > range) { System.out.println("\nOpções inválidas. Tente Novamente."); }
			key = Ltp2Utils.recebeIntValidoMenu("");
		}while(key > range);
		
		return key;
	}
	
	/*
	 * MENU -> PRINCIPAL
	 */
	public static void mostrarOpcoes() {
		System.out.println("-----MENU DE OPÇÕES-----\n"
				  + "\n 	1 - Listagens"
				  + "\n 	2 - Cadastros"
				  + "\n 	3 - Busca Avançada"
				  + "\n 	4 - Estatísticas"
				  + "\n 	5 - Registrar LIXO"
				  + "\n	0 - sair\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> CADASTRO
	 */
	
	public static void mostrarSubMenu_Cadastro() {
		System.out.println("\n-----Opções de listagem de registros-----\n"
				  + "\n------------------Cadastro-------------------"
				  + "\n1 - Cadastrar Funcionário"
				  + "\n2 - Cadastrar Cliente"
				  + "\n------------------Exclusão-------------------"
				  + "\n3 - Excluir Funcionario"
				  + "\n4 - Excluir Cliente"
				  + "\n0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> BUSCA AVANÇADA
	 */
	
	public static void mostrarSubMenu_Busca() {
		System.out.println("\n-----Opções de busca avançada-----\n"
				  + "\n 	1 - Buscar Funcionario."
				  + "\n 	2 - Buscar Cliente."
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------	
	
	/*
	 * MENU -> LISTAGEM
	 */
	
	public static void mostrarSubMenu_Lista() {
		System.out.println("\n-----Opções de listagem de registros-----\n"
				  + "\n 	1 - Listar Funcionários"
				  + "\n 	2 - Listar Clientes"
				  + "\n 	3 - Listar Lixo Registrado"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	public static void mostrarSubMenu_LixoRegistrado() {
		System.out.println("\n-----Opções de Tipos de Lixo-----\n"
				  + "\n 	1 - Mostrar todos"
				  + "\n 	2 - Somente Reciclável"
				  + "\n 	3 - Somente NÃO Reciclavel"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	/*
	 * MENU -> ESTATÍSTICO
	 */
	
	public static void mostrarSubMenu_Estatistica() {
		System.out.println("\n-----Opções de informações estatísticas-----\n"
				  + "\n 	1 - Lixo (Quantidade)"
				  + "\n 	2 - Financeiro"
				  + "\n	0 - Retornar ao menu principal\n\n");
	}
	
	//-------------------------------------------------------------------------
	
	//PARAMETRO VÁLIDOS PARA REGISTRO DE LIXO
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
	
	public static String getType() {
		String result = "";
		System.out.println("\n-----Opções de Tipo de Lixo-----\n"
				  + "\n 	1 - Lixo Reciclável"
				  + "\n 	2 - Lixo Não Reciclável");
		
		int key = opc(2);
		
		if(key == 1) { result = "R"; }
		else { result = "NR"; }
		
		return result;
	}
	
	public static char getStatus() {
		char result = ' ';
		System.out.println("\n-----Opções de Status do Lixo-----\n"
				  + "\n 	1 - Incinerador"
				  + "\n 	2 - Vendas");
		
		int key = opc(2);
		
		if(key == 1) { result = 'I'; }
		else { result = 'V'; }
		
		return result;
	}
	
	public static String getCategory() {
		String result = "";
		System.out.println("\n-----Opções de Tipo de Lixo-----\n"
				  + "\n 	1 - Metal"
				  + "\n 	2 - Orgânico"
				  + "\n		3 - Papel"
				  + "\n		4 - Plastico"
				  + "\n		5 - Vidro");
		
		int key = opc(5);
		
		if(key == 1) { result = "Metal"; }
		else if(key == 2) { result = "Orgânico"; }
		else if(key == 3) { result = "Papel"; }
		else if(key == 4) { result = "Plástico"; }
		else { result = "Vidro"; }
		
		return result;
	}
}
