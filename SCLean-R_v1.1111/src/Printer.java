
public class Printer 
{	
	public static void printWorkers(Person funcionario) 
	{
		String genero = "", status = "";
		
		if(funcionario.genero == 'M') { genero = "Masculino"; }
		else { genero = "Feminino"; }
		
		if(funcionario.active == 'Y') { status = "Ativo"; }
		else { status = "Inativo"; }
		
		System.out.println("\n_________INFORMAÇÕES PESSOAIS_________"
						  +"\nNome: ------------------" + funcionario.nome + " " + funcionario.sobrenome
						  +"\nCPF: -------------------" + funcionario.cpf
						  +"\nGenero: ----------------" + genero
						  +"\nData de Nascimento: ----" + funcionario.dataNascimento
						  +"\n\n_______________ENDEREÇO_______________"
						  +"\nRua: -------------------" + funcionario.rua
						  +"\nNº: --------------------" + funcionario.numero
						  +"\nCEP: -------------------" + funcionario.cep
						  +"\nBairro: ----------------" + funcionario.bairro
						  +"\nCidade: ----------------" + funcionario.cidade
						  +"\nEstado: ----------------" + funcionario.estado
						  +"\n\n_________SITUAÇÃO NA EMPRESA__________"
						  +"\nCargo: -----------------" + funcionario.empresaRelacao
						  +"\nNº de Registro: --------" + funcionario.registro
						  +"\nStatus: ----------------" + status
						  +"\nData de Contratação: ---" + funcionario.dataRegistro);
	}
	
	public static void printCustomers(Person cliente) 
	{
		String genero = "", status = "";
		
		if(cliente.genero == 'M') { genero = "Masculino"; }
		else { genero = "Feminino"; }
		
		if(cliente.active == 'Y') { status = "Ativo"; }
		else { status = "Inativo"; }
		
		System.out.println("\n_________INFORMAÇÕES PESSOAIS_________"
						  +"\nNome: ------------------" + cliente.nome + " " + cliente.sobrenome
						  +"\nCPF: -------------------" + cliente.cpf
						  +"\nGenero: ----------------" + genero
						  +"\nData de Nascimento: ----" + cliente.dataNascimento
						  +"\n\n_______________ENDEREÇO_______________"
						  +"\nRua: -------------------" + cliente.rua
						  +"\nNº: --------------------" + cliente.numero
						  +"\nCEP: -------------------" + cliente.cep
						  +"\nBairro: ----------------" + cliente.bairro
						  +"\nCidade: ----------------" + cliente.cidade
						  +"\nEstado: ----------------" + cliente.estado
						  +"\n\n_________SITUAÇÃO NA EMPRESA__________"
						  +"\nNº de Registro: --------" + cliente.registro
						  +"\nRamo de Atividade: -----" + cliente.ramoAtividade
						  +"\nStatus: ----------------" + status
						  +"\nCliente desde: ---------" + cliente.dataRegistro);
	}
	
	public static void printGarbage(Garbage lixo, int option) 
	{	
		String type = "", status = "", strOption = "";
		
		if(lixo.tipo.equals("R")) { type = "Reciclável"; }
		else if(lixo.tipo.equals("NR")) { type = "Não Reciclável"; }
		
		if(lixo.status == 'I') { status = "Para o Incinerador"; }
		else if(lixo.status == 'V') { status = "Vendas"; }
		
		if(option == 2) { strOption = "R"; }
		else if(option == 3) { strOption = "NR"; }
		
		if(lixo.tipo.equals(strOption) || strOption.equals("")) {
			System.out.println("\n_______INFORMAÇÕES DE DEMANDA_______"
							  +"\nID: -------------------------" + lixo.id
							  +"\nNOME / DESCRIÇÃO: -----------" + lixo.descricao
							  +"\nPESO: -----------------------" + lixo.peso + " Kg"
							  +"\nTIPO DE LIXO: ---------------" + type
							  +"\nSTATUS: ---------------------" + status
							  +"\nCATEGORIA: ------------------" + lixo.categoria
							  +"\nDATA DE REGISTRO: -----------" + lixo.data
							  +"\n_________\n");
		}
	}
}
