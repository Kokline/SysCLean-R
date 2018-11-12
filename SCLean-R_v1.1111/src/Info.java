public class Info 
{
	// PESO PARA CÁLCULO ESTATÍSTICO
	public static void informWeight(String[][] table) 
	{
		float weight[] = new float[11];
		
		// MODELO EXEMPLO ARRAY
		/*		 0  |   1    |    2   |   3  |   4  |   5    |     6     |      7
		 * 		 ID | ACTIVE |  NOME  | PESO | TIPO | STATUS | CATEGORIA | DATA REGISTRO
			   { "1",  "Y",   "Latas",  "20",  "NR",   "V",    "Metais",  "05/09/18 12:40"},
		*/
		
		//PARAMETRO VÁLIDOS
				/*
				 * "" - CALCULAR P/ TODOS -> LIVRE NA ESTRURURA DE REPETIÇÃO
				 * 
				 * TIPO-------------------------- / --> POS 4 ARRAY
				 * R  - CALCULAR RECICLAVEIS
				 * NR - CALCULAR NÃO RECICLAVEIS
				 * 
				 * STATUS------------------------ / --> POS 5 ARRAY
				 * I  - CALCULAR P/ INCINERADOR
				 * V  - CALCULAR P/ VENDAS
				 * 
				 * CATEGORIA--------------------- / --> POS 6 ARRAY
				 * Plásticos  - CALCULAR P/ PLÁSTICO
				 * Vidros 	  - CALCULAR P/ VIDRO
				 * Metais	  - CALCULAR P/ METAL
				 * Papeis 	  - CALCULAR P/ PAPEL
				 * Orgânicos  - CALCULAR P/ ORGÂNICO
				 * Borracha	  - CALCULAR P/ BORRACHA
				 */
		
		for (int i = 0; i < table.length; i++) {
			// TODOS - TODOS OS PESOS REGISTRADOS NA MATRIZ
			weight[0] += Float.parseFloat(table[i][3]);
			
			for (int j = 0; j < 8; j++) 
			{
				// POR TIPO - POSIÇÃO i4 DA MATRIZ
				if(j == 4) {
					if(table[i][4].equals("NR"))
						weight[1] += Float.parseFloat(table[i][3]);
					else if(table[i][4].equals("R"))
						weight[2] += Float.parseFloat(table[i][3]);
					
				}
				// POR STATUS - POSIÇÃO i5 DA MATRIZ
				else if(j == 5) {
					if(table[i][5].equals("I"))
						weight[3] += Float.parseFloat(table[i][3]);
					else if(table[i][5].equals("V"))
						weight[4] += Float.parseFloat(table[i][3]);
				}
				// POR CATEGORIA - POSIÇÃO i6 DA MATRIZ
				else if(j == 6) {
					if(table[i][6].equals("Orgânicos"))
						weight[5] += Float.parseFloat(table[i][3]);
					else if(table[i][6].equals("Papeis"))
						weight[6] += Float.parseFloat(table[i][3]);
					else if(table[i][6].equals("Plásticos"))
						weight[7] += Float.parseFloat(table[i][3]);
					else if(table[i][6].equals("Vidros"))
						weight[8] += Float.parseFloat(table[i][3]);
					else if(table[i][6].equals("Metais"))
						weight[9] += Float.parseFloat(table[i][3]);
					else if(table[i][6].equals("Borracha"))
						weight[10] += Float.parseFloat(table[i][3]);
				}
			}
		}
		
		Printer.get_statistics_weight(weight);
		informDate(table);
		
		getFinancialStatistics(weight);
	}
	
	// DATAS PARA CÁLCULO ESTATÍSTICO
	public static void informDate(String[][] table) 
	{
		float monthsWeight[] = new float[12];
		int month = 0;
		
		for (int i = 0; i < table.length; i++) {
			month = Ltp2Utils.getMonth(table[i][7]);
			
			//System.out.println(month);

			if(month == 1)	
				monthsWeight[0] += Float.parseFloat(table[i][3]);
			else if(month == 2)
				monthsWeight[1] += Float.parseFloat(table[i][3]);
			else if(month == 3)
				monthsWeight[2] += Float.parseFloat(table[i][3]);
			else if(month == 4)
				monthsWeight[3] += Float.parseFloat(table[i][3]);
			else if(month == 5)
				monthsWeight[4] += Float.parseFloat(table[i][3]);
			else if(month == 6)
				monthsWeight[5] += Float.parseFloat(table[i][3]);
			else if(month == 7)
				monthsWeight[6] += Float.parseFloat(table[i][3]);
			else if(month == 8)
				monthsWeight[7] += Float.parseFloat(table[i][3]);
			else if(month == 9)
				monthsWeight[8] += Float.parseFloat(table[i][3]);
			else if(month == 10)
				monthsWeight[9] += Float.parseFloat(table[i][3]);
			else if(month == 11)
				monthsWeight[10] += Float.parseFloat(table[i][3]);
			else 
				monthsWeight[11] += Float.parseFloat(table[i][3]);
		}
		
		get_statisticsPerMonth_weight(monthsWeight);
	}
	
	static String months[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	
	public static void get_statisticsPerMonth_weight(float[] weight) 
	{	
		String results = "";
		
		for (int i = 0; i < weight.length; i++) {
			if(weight[i] != 0) {
				results += "Mês de " + months[i] + " ----- " +Ltp2Utils.masWeight(weight[i]) + " de Lixo Recolhido\n";
			}
		}
		
		Printer.print_statisticsPerMonth_weight(results);
	}
	
	// ESTATÍSTICA FINANCEIRA
	public static void getFinancialStatistics(float[] weight) 
	{	
		/*
		Medias de valores em R$ - Kg

		0,41 papel
		0,53 plástico
		1,25 vidro
		2,65 metal
		0,25 borracha
		*/
		
		float[] values = new float[5];

		float total = 0;
		
		values[0] = weight[6] * (float)0.41;
		values[1] = weight[7] * (float)0.53;
		values[2] = weight[8] * (float)1.25;
		values[3] = weight[9] * (float)2.65;
		values[4] = weight[10] * (float)0.25;
				
		for (int i = 0; i < values.length; i++) { total += values[i]; }
				
		Printer.printFinancialStatistics(values, total);
	}
	
	/*
	 * --------------------------------------------------------------------------------------------------
	 * CALCULATING VALUES FOR SALES----------------------------------------------------------------------
	 * --------------------------------------------------------------------------------------------------
	 */
	
	public static float calcSale(String category, float weight) 
	{
		float price = 0; 
		/*
		1 - Borracha 0,25 Borracha
	 	2 - Metal 	 2,65 Metais
		3 - Papel 	 0,41 Papeis
		4 - Plastico 0,53 Plásticos
		5 - Vidro 	 1,25 Vidros
		 */
		
		if(category.equals("Borracha")) { price = weight * (float)0.25; }
		else if(category.equals("Metais")) { price = weight * (float)2.65; }
		else if(category.equals("Papeis")) { price = weight * (float)0.41; }
		else if(category.equals("Plásticos")) { price = weight * (float)0.53; }
		else if(category.equals("Vidros")) { price = weight * (float)1.25; }
		
		return price;
	}
}
