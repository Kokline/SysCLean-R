public class Printer 
{	
	public static void printWorkers(Person funcionario) 
	{
		String genero = "", status = "";
		
		if(funcionario.genero == 'M') { genero = "Masculino"; }
		else { genero = "Feminino"; }
		
		if(funcionario.active == 'Y') { status = "Ativo"; }
		else { status = "Inativo"; }
		
		System.out.println("\n_________INFORMA��ES PESSOAIS_________"
						  +"\nNome: ------------------" + funcionario.nome + " " + funcionario.sobrenome
						  +"\nCPF: -------------------" + funcionario.cpf
						  +"\nGenero: ----------------" + genero
						  +"\nData de Nascimento: ----" + funcionario.dataNascimento
						  +"\n\n_______________ENDERE�O_______________"
						  +"\nRua: -------------------" + funcionario.rua
						  +"\nN�: --------------------" + funcionario.numero
						  +"\nCEP: -------------------" + funcionario.cep
						  +"\nBairro: ----------------" + funcionario.bairro
						  +"\nCidade: ----------------" + funcionario.cidade
						  +"\nEstado: ----------------" + funcionario.estado
						  +"\n\n_________SITUA��O NA EMPRESA__________"
						  +"\nCargo: -----------------" + funcionario.empresaRelacao
						  +"\nN� de Registro: --------" + funcionario.registro
						  +"\nStatus: ----------------" + status
						  +"\nData de Contrata��o: ---" + funcionario.dataRegistro);
	}
	
	public static void printCustomers(Person cliente) 
	{
		String genero = "", status = "";
		
		if(cliente.genero == 'M') { genero = "Masculino"; }
		else { genero = "Feminino"; }
		
		if(cliente.active == 'Y') { status = "Ativo"; }
		else { status = "Inativo"; }
		
		System.out.println("\n_________INFORMA��ES PESSOAIS_________"
						  +"\nNome: ------------------" + cliente.nome + " " + cliente.sobrenome
						  +"\nCPF: -------------------" + cliente.cpf
						  +"\nGenero: ----------------" + genero
						  +"\nData de Nascimento: ----" + cliente.dataNascimento
						  +"\n\n_______________ENDERE�O_______________"
						  +"\nRua: -------------------" + cliente.rua
						  +"\nN�: --------------------" + cliente.numero
						  +"\nCEP: -------------------" + cliente.cep
						  +"\nBairro: ----------------" + cliente.bairro
						  +"\nCidade: ----------------" + cliente.cidade
						  +"\nEstado: ----------------" + cliente.estado
						  +"\n\n_________SITUA��O NA EMPRESA__________"
						  +"\nN� de Registro: --------" + cliente.registro
						  +"\nRamo de Atividade: -----" + cliente.ramoAtividade
						  +"\nStatus: ----------------" + status
						  +"\nCliente desde: ---------" + cliente.dataRegistro);
	}
	
	public static void printGarbage(Garbage lixo, int option) 
	{	
		String type = "", status = "", strOption = "";
		
		if(lixo.tipo.equals("R")) { type = "Recicl�vel"; }
		else if(lixo.tipo.equals("NR")) { type = "N�o Recicl�vel"; }
		
		if(lixo.status == 'I') { status = "Para o Incinerador"; }
		else if(lixo.status == 'V') { status = "Vendas"; }
		
		if(option == 2) { strOption = "R"; }
		else if(option == 3) { strOption = "NR"; }
		
		if(lixo.tipo.equals(strOption) || strOption.equals("")) {
			System.out.println("\n_______INFORMA��ES DE DEMANDA_______"
							  +"\nID: -------------------------" + lixo.id
							  +"\nNOME / DESCRI��O: -----------" + lixo.descricao
							  +"\nPESO: -----------------------" + lixo.peso + " Kg"
							  +"\nTIPO DE LIXO: ---------------" + type
							  +"\nSTATUS: ---------------------" + status
							  +"\nCATEGORIA: ------------------" + lixo.categoria
							  +"\nDATA DE REGISTRO: -----------" + lixo.data
							  +"\n_________\n");
		}
	}
	
	public static void get_statistics_weight(float[] weight) {
		String results = "";
		
		results += "**********************************************"
					+ "\n-----------------ESTAT�STICAS-----------------\n"
					+ "**********************************************\n\n";
		
		results += "----Registro de peso total (todo o estoque)---\n\n";
		results +=   "Peso Bruto Total:--- " + Ltp2Utils.masWeight(weight[0]);
		
		results += "\n\n\n--------Registro de peso total por TIPO-------\n";
		results += "\nLixo N�o Recicl�vel: " + Ltp2Utils.masWeight(weight[1]);
		results += "\nLixo Recicl�vel:---- " + Ltp2Utils.masWeight(weight[2]);
		
		results += "\n\n\n-------Registro de peso total por STATUS------\n";
		results += "\nLixo para incinerar: " + Ltp2Utils.masWeight(weight[3]);
		results += "\nLixo para venda:---- " + Ltp2Utils.masWeight(weight[4]);
		
		results += "\n\n\n-----Registro de peso total por CATEGORIA-----\n";
		//results += "\nOrg�nico: " + Ltp2Utils.masWeight(weight[5]);
		results += "\nPapel:--- " + Ltp2Utils.masWeight(weight[6]);
		results += "\nPl�stico: " + Ltp2Utils.masWeight(weight[7]);
		results += "\nVidro:--- " + Ltp2Utils.masWeight(weight[8]);
		results += "\nMetal:--- " + Ltp2Utils.masWeight(weight[9]);
		results += "\nBorracha: " + Ltp2Utils.masWeight(weight[10]);
		
		System.out.print("\n\n" + results + "\n\n");
	}
	
	public static void print_statisticsPerMonth_weight(String results) 
	{	
		System.out.print("-----Quantidade de Lixo Recolhido Por M�s-----\n\n");
		System.out.println(results);
	}
	
	public static void printFinancialStatistics(float[] values, float total) {
		String results = "";

		results += "\n-----RENDIMENTO FINANCEIRO POR CATEGORIA------\n";
		results += "\nPapel:-------- " + Ltp2Utils.maskMoney(values[0]);
		results += "\nPl�stico:----- " + Ltp2Utils.maskMoney(values[1]);
		results += "\nVidro:-------- " + Ltp2Utils.maskMoney(values[2]);
		results += "\nMetal:-------- " + Ltp2Utils.maskMoney(values[3]);
		results += "\nBorracha:----- " + Ltp2Utils.maskMoney(values[4]);
		
		results += "\n\nTOTAIS: " + "R$" + Ltp2Utils.maskMoney(total);
			
		System.out.print(results);
		System.out.println("\n\n**********************************************\n**********************************************\n");
	}
	
	public static void printSales(Sale sale) {
		String results = "";
	
		System.out.println("\n\n			Nota compra FeMP Sistemas--");
		
		results +="\n\nID da venda: " + sale.id + " ----------\n";
		results +="\n	--Informa��es do Vendedor--\n\n"  + 	"______________CPF:   " + sale.idSalesman + "\n"
															+ 	"______________Nome:  " + "buscarInfo()" + "\n"
															+ 	"______________Cargo: " + "buscarInfo()" + "\n"; // (EX:.) buscar informa��o atrav�s do cpf // (EX:.) buscar nome atrav�s do cpf
		
		results +="\n	--Informa��es do Comprador--\n\n" + 	"______________CPF:       " + sale.idCustomer + "\n"
															+ 	"______________Nome:      " + "buscarInfo()" + "\n"
															+ 	"______________Atividade: " + "buscarInfo()" + "\n"; // (EX:.) buscar informa��o atrav�s do cpf // (EX:.) buscar nome atrav�s do cpf
		
		results +="\n * Data da compra: " + sale.dataRegistro + "\n";
		results +=" * Material comprado: " + sale.category + "\n";
		results +=" * Valor da compra: R$" + Ltp2Utils.maskMoney(sale.totalPrice) + "\n";
		results +=" * Peso do material comprado: " + Ltp2Utils.masWeight(sale.totalWeight) + "\n";
		
		System.out.print(results);
		System.out.println("\n\n**********************************************\n**********************************************\n");
	}
}
