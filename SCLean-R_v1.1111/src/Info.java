public class Info 
{
	public static boolean keyVerify(String key, String type) {
		boolean checked = true;
		Person[] person = null;
		
		if(type.equals("C")) { person = Load.loadCustomers(); }
		else if(type.equals("W")) { person = Load.loadWorkers(); }
		
		for (int i = 0; i < person.length; i++) {
			if(key.equals(person[i].cpf)) {
				checked = false;
			}
		}
		
		return checked;
	}
	//-----------------------------------------------------------------------------------------------------------
	
	
	static String[] titulos = { "ID:-------------- ",
								"NOME:------------ ", 
								"PESO:------------ ", 
								"TIPO:------------ ", 
								"STATUS:---------- ", 
								"CATEGORIA:------- ",
								"DATA DE REGISTRO: "};
	
	/*
	 * TIPO R->Reciclavel | NR->Não Reciclavel
	 * STATUS I->incinerar, V->venda
	 */
	
	//colunas:-----------ID | NOME | PESO | TIPO | STATUS | CATEGORIA
	static String[][] table = {	{"1", "Y", "Latas", "20", "R", "V", "Metais", "05/09/18 12:40"}, 
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
	
	public static void listarInfoLixo(int opc) 
	{
		/*
		 * 1 -> "" - MOSTRAR TODOS
		 * R  - MOSTRAR RECICLAVEIS
		 * NR - MOSTRAR NÃO RECICLAVEIS
		 */
		String info = "", tipo = "";

		if(opc == 2) { tipo = "R"; }
		else if(opc == 3){ tipo = "NR"; }
		else { tipo = ""; }
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < 8; j++) {
				
				if(tipo.equals(""))
					info += titulos[j] + table[i][j] + "\n";
				
				else if(tipo.equals(table[i][3]))
					info += titulos[j] + table[i][j] + "\n";
			}
			info += "\n";
		}
		
		System.out.print(info);
	}
	
	public static float infoPeso(String which) 
	{
		float peso = 0;
		
		if(which.equals("O")) which = "Orgânicos";
		else if(which.equals("PP")) which = "Papeis";
		else if(which.equals("P")) which = "Plásticos";
		else if(which.equals("VI")) which = "Vidros";
		else if(which.equals("M")) which = "Metais";
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < 6; j++) 
			{
				switch (j) {
				case 2:
					//POR TIPO
					if(which.equals(table[i][3]))
						peso += Float.parseFloat(table[i][2]);
					//TODOS
					else if(which.equals("")) 
						peso += Float.parseFloat(table[i][2]);
					
					//POR STATUS
					if(which.equals(table[i][4]))
						peso += Float.parseFloat(table[i][2]);
					
					//POR CATEGORIA
					if(which.equals(table[i][5]))
						peso += Float.parseFloat(table[i][2]);
					break;

				default:
					break;
				}
			}
		}
		
		return peso;
	}
}
