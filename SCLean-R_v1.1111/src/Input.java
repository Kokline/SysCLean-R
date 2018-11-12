public class Input 
{
	/*-----CADASTRO-----*/
	
	//RETORNA UM OBJETO PESSOA CARREGADO
	public static Person cadastrarFuncionario() {
		Person funcionario = new Person();
		boolean aux = false;
		
		funcionario.active = 'Y';
		
		System.out.println("\nInforma��es Pessoais-------");
		
		do {
			if(aux == false) {
				System.out.println("Funcion�rio j� cadastrado no sistema! \nTente novamente!");
			}
			
			funcionario.cpf = Ltp2Utils.recebeString("\nCPF: ");
			aux = Searches.keyVerify(funcionario.cpf, "W"); // verificar se cpf existe
		} while (aux);
		
		
		funcionario.nome = Ltp2Utils.capitalize(Ltp2Utils.recebeString("\nNOME: "));
		funcionario.sobrenome = Ltp2Utils.recebeString("\nSOBRENOME: ");
		funcionario.genero = Ltp2Utils.recebeCharUpperCase("\nGENERO: ");
		funcionario.dataNascimento = Ltp2Utils.recebeString("\nDATA DE NASCIMENTO: ");
		
		System.out.println("\nEndere�o-------------------");
		funcionario.rua = Ltp2Utils.recebeString("\nRUA: ");
		funcionario.numero = Ltp2Utils.recebeString("\nN�: ");
		funcionario.cep = Ltp2Utils.recebeString("\nCEP: ");
		funcionario.bairro = Ltp2Utils.recebeString("\nBAIRRO: ");
		funcionario.cidade = Ltp2Utils.recebeString("\nCIDADE: ");
		funcionario.estado = Ltp2Utils.recebeString("\nESTADO: ");
		
		System.out.println("\nRela��o com a Empresa------");
		funcionario.empresaRelacao = Ltp2Utils.recebeString("\nOCUPA��O NA EMPRESA: ");
		funcionario.registro = Ltp2Utils.recebeString("\nREGISTRO: ");
		funcionario.ramoAtividade = "Coleta e Reciclagem";
		funcionario.dataRegistro = Ltp2Utils.getTime();
		
		return funcionario;
	}
	
	//RETORNA UM OBJETO PESSOA CARREGADO
	public static Person cadastrarCliente() 
	{
		Person cliente = new Person();
		boolean aux = false;
		
		cliente.active = 'Y';
		
		System.out.println("\nInforma��es Pessoais-------");
		
		do {
			if(aux == false) {
				System.out.println("Cliente j� cadastrado no sistema! \nTente novamente!");
			}
			
			cliente.cpf = Ltp2Utils.recebeString("\nCPF: ");
			aux = Searches.keyVerify(cliente.cpf, "C"); // verificar se cpf existe
		} while (aux);
		
		cliente.nome = Ltp2Utils.recebeString("\nNOME: ");
		cliente.sobrenome = Ltp2Utils.recebeString("\nSOBRENOME: ");
		cliente.genero = Ltp2Utils.recebeCharUpperCase("\nGENERO: ");
		cliente.dataNascimento = Ltp2Utils.recebeString("\nDATA DE NASCIMENTO: ");
		
		System.out.println("\nEndere�o-------------------");
		cliente.rua = Ltp2Utils.recebeString("\nRUA: ");
		cliente.numero = Ltp2Utils.recebeString("\nN�: ");
		cliente.cep = Ltp2Utils.recebeString("\nCEP: ");
		cliente.bairro = Ltp2Utils.recebeString("\nBAIRRO: ");
		cliente.cidade = Ltp2Utils.recebeString("\nCIDADE: ");
		cliente.estado = Ltp2Utils.recebeString("\nESTADO: ");
		
		int registro = Load.totalCustomers() + 1;
		
		System.out.println("\nRela��o com a Empresa------");
		cliente.empresaRelacao = "Cliente";
		cliente.registro = String.valueOf(registro);
		cliente.ramoAtividade = Ltp2Utils.recebeString("\nRamo de Atividade: ");
		cliente.dataRegistro = Ltp2Utils.getTime();
		
		return cliente;
	}
	
	public static Garbage cadastrarLixo() 
	{
		Garbage lixo = new Garbage();
		
		lixo.ativo = 'Y';
		
		lixo.id = Load.totalGarbage() + 1;
        lixo.descricao = Ltp2Utils.recebeString("\nNOME ou DESCRI��O: ");
        lixo.peso = (float)Ltp2Utils.recebeFloat("\nPESO: ");
        lixo.tipo = Menu.getType();
        lixo.status = Menu.getStatus();
        lixo.categoria = Menu.getCategory();
        lixo.data = Ltp2Utils.getTime();
 
		return lixo;
	}
	
	public static Sale registerSale() 
	{
		Sale sale = new Sale();
		
		boolean exit = true;
		
		String idW = "", idC = "";
		
		System.out.println("\n\nInforme qual tipo de lixo ser� vendido!");
		String category = "";
		category = Menu.getCategory_WhithCancel();
		
		if(!category.equals("")) {
			float weight = 0, price = 0;
			
			do {
				if(exit == false) { System.out.println("\n\n**** PESO ULTRAPASSA O ESTOQUE! ****"); }
				
				weight = Ltp2Utils.recebeFloat("Informe o Peso desejado: ");
				
				exit = Searches.weightGarbageVerify(weight, category);
			}while(!exit);
			
			do {
				if(exit == false) { System.out.println("\n\n**** Vendedor n�o encontrado! ****"); }
				
				idW = Ltp2Utils.recebeString("\nInforme a Identifica��o do vendedor: ");
				
				if(Searches.keyVerify(idW, "W") == false) { exit = false; }
				else { exit = true; }
			}while(!exit);
			
			do {
				if(exit == false) { System.out.println("\n\n**** CLIENTE n�o encontrado! ****"); }
				
				idC = Ltp2Utils.recebeString("\nInforme a Identifica��o do CLIENTE: ");
				
				if(Searches.keyVerify(idC, "C") == false) { exit = false; }
				else { exit = true; }
			}while(!exit);
			
			
			price = Info.calcSale(category, weight);
			
			sale.id 			= Load.totalSale() + 1;
			sale.idSalesman 	= idW;
			sale.idCustomer 	= idC;
			sale.dataRegistro 	= Ltp2Utils.getTime();
			sale.category 		= category;
			sale.totalPrice 	= price;
			sale.totalWeight	= weight;
		}else {
			return null;
		}
 
		return sale;
	}
}
