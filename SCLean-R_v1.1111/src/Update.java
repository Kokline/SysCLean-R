import java.io.RandomAccessFile;

public class Update 
{
	public static void updateWorker(String cpfWorker) {
		RandomAccessFile arq;
		
		Person oldWorker = new Person();
		Person newWorker = new Person();
		
		long pointer;
		
		try {

			boolean exit = false, noChanged = true;
			int key = 0;
			
			arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");

			pointer = Searches.searchWorkerByTheCodPointer(cpfWorker);

			if(pointer > -1) {
				arq.seek(pointer);
				
				oldWorker.active 			= arq.readChar();
				oldWorker.nome 				= arq.readUTF();
				oldWorker.sobrenome 		= arq.readUTF();
				oldWorker.cpf 				= arq.readUTF();
				oldWorker.empresaRelacao 	= arq.readUTF();
				oldWorker.registro 			= arq.readUTF();
				oldWorker.ramoAtividade		= arq.readUTF();
				oldWorker.rua 				= arq.readUTF();
				oldWorker.numero 			= arq.readUTF();
				oldWorker.cep 				= arq.readUTF();
				oldWorker.bairro 			= arq.readUTF();
				oldWorker.cidade 			= arq.readUTF();
				oldWorker.estado 			= arq.readUTF();
				oldWorker.genero 			= arq.readChar();
				oldWorker.dataNascimento 	= arq.readUTF();
				oldWorker.dataRegistro 		= arq.readUTF();
				
				System.out.println("\n==============================");
				System.out.println("Código: " + oldWorker.cpf);
				newWorker.cpf = oldWorker.cpf;
				
				newWorker.nome 				= oldWorker.nome;
				newWorker.sobrenome 		= oldWorker.sobrenome;
				newWorker.ramoAtividade 	= oldWorker.ramoAtividade;
				newWorker.rua 				= oldWorker.rua;
				newWorker.numero 			= oldWorker.numero;
				newWorker.cep 				= oldWorker.cep;
				newWorker.bairro 			= oldWorker.bairro;
				newWorker.cidade 			= oldWorker.cidade;
				newWorker.estado 			= oldWorker.estado;
				newWorker.genero		 	= oldWorker.genero;
				newWorker.dataNascimento 	= oldWorker.dataNascimento;
				
				do {
					Menu.showSubMenu_UpdateWorkers();
					key = Menu.opc(13);
					
					if(key == 0) { exit = true; }
					
					switch (key) {
					case 1:
						System.out.println("\nNome: " + oldWorker.nome);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.nome = Ltp2Utils.recebeString("Informe o novo NOME: ");
							noChanged = false;
						}else {
							newWorker.nome = oldWorker.nome;
						}
						break;
					case 2:
						System.out.println("\nSobrenome: " + oldWorker.sobrenome);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.sobrenome = Ltp2Utils.recebeString("Informe o novo SOBRENOME: ");
							noChanged = false;
						}else {
							newWorker.sobrenome = oldWorker.sobrenome;
						}
						break;
					case 3:
						System.out.println("\nRamo de Atividade: " + oldWorker.ramoAtividade);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.ramoAtividade = Ltp2Utils.recebeString("Informe o novo Ramo de Atividade: ");
							noChanged = false;
						}else {
							newWorker.ramoAtividade = oldWorker.ramoAtividade;
						}
						break;
					case 4:
						System.out.println("\nRua: " + oldWorker.rua);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.rua = Ltp2Utils.recebeString("Informe a nova RUA: ");
							noChanged = false;
						}else {
							newWorker.rua = oldWorker.rua;
						}
						break;
					case 5:
						System.out.println("\nNº: " + oldWorker.numero);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.numero = Ltp2Utils.recebeString("Informe o novo Nº: ");
							noChanged = false;
						}else {
							newWorker.numero = oldWorker.numero;
						}
						break;
					case 6:
						System.out.println("\nCEP: " + oldWorker.cep);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.cep = Ltp2Utils.recebeString("Informe o novo CEP: ");
							noChanged = false;
						}else {
							newWorker.cep = oldWorker.cep;
						}
						break;
					case 7:
						System.out.println("\nBairro: " + oldWorker.bairro);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.bairro = Ltp2Utils.recebeString("Informe o novo BAIRRO: ");
							noChanged = false;
						}else {
							newWorker.bairro = oldWorker.bairro;
						}
						break;
					case 8:
						System.out.println("\nCidade: " + oldWorker.cidade);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.cidade = Ltp2Utils.recebeString("Informe o novo CIDADE: ");
							noChanged = false;
						}else {
							newWorker.cidade = oldWorker.cidade;
						}
						break;
					case 9:
						System.out.println("\nEstado: " + oldWorker.estado);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.estado = Ltp2Utils.recebeString("Informe o novo ESTADO: ");
							noChanged = false;
						}else {
							newWorker.estado = oldWorker.estado;
						}
						break;
					case 10:
						System.out.println("\nGenero: " + oldWorker.genero);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.genero = Ltp2Utils.recebeCharUpperCase("Informe o novo GENERO: ");
							noChanged = false;
						}else {
							newWorker.genero = oldWorker.genero;
						}
						break;
					case 11:
						System.out.println("\nData de Nascimento: " + oldWorker.dataNascimento);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.dataNascimento = Ltp2Utils.recebeString("Informe a nova Data de Nascimento: ");
							noChanged = false;
						}else {
							newWorker.dataNascimento = oldWorker.dataNascimento;
						}
						break;
					case 12:
						System.out.println("\nOcupação na Empresa: " + oldWorker.empresaRelacao);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.empresaRelacao = Ltp2Utils.recebeString("Informe a nova OCUPAÇÃO NA EMPRESA: ");
							noChanged = false;
						}else {
							newWorker.empresaRelacao = oldWorker.empresaRelacao;
						}
						break;
					case 13:
						System.out.println("\nRegistro: " + oldWorker.registro);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newWorker.registro = Ltp2Utils.recebeString("Informe o novo Registro: ");
							noChanged = false;
						}else {
							newWorker.registro = oldWorker.registro;
						}
						break;

					default:
						break;
					}
					
				}while(!exit);

				newWorker.active = 'Y';
				newWorker.dataRegistro = oldWorker.dataRegistro;
			
			if(noChanged == false) {
				if(Ltp2Utils.recebeSouN("\n----\nConfirmar as alterações? (S/N)") == 'S' && noChanged == false){
					Delete.deleteWorker(oldWorker.cpf, false);
					Record.salvarFuncionario(newWorker);
				}

				}else if(noChanged == true){
					System.out.println("\n !! Funcionário não cadastrado !!");
				}
			}
				
			arq.close();

		} catch (Exception e) {
			System.err.println("Erro ao abrir o arquivo!");
		}
	}
	
	//=============================================================================================
	
	public static void updateCustomer(String cpfCustomer) {
		RandomAccessFile arq;
		
		Person oldCustomer = new Person();
		Person newCustomer = new Person();
		
		long pointer;
		
		try {

			boolean exit = false, noChanged = true;
			int key = 0;
			
			arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");

			pointer = Searches.searchCustomerByTheCodPointer(cpfCustomer);

			if(pointer > -1) {
				arq.seek(pointer);
				
				oldCustomer.active 			= arq.readChar();
				oldCustomer.nome 			= arq.readUTF();
				oldCustomer.sobrenome 		= arq.readUTF();
				oldCustomer.cpf 			= arq.readUTF();
				oldCustomer.empresaRelacao 	= arq.readUTF();
				oldCustomer.registro 		= arq.readUTF();
				oldCustomer.ramoAtividade	= arq.readUTF();
				oldCustomer.rua 			= arq.readUTF();
				oldCustomer.numero 			= arq.readUTF();
				oldCustomer.cep 			= arq.readUTF();
				oldCustomer.bairro 			= arq.readUTF();
				oldCustomer.cidade 			= arq.readUTF();
				oldCustomer.estado 			= arq.readUTF();
				oldCustomer.genero 			= arq.readChar();
				oldCustomer.dataNascimento 	= arq.readUTF();
				oldCustomer.dataRegistro 	= arq.readUTF();
				
				System.out.println("\n==============================");
				System.out.println("Código: " + oldCustomer.cpf);
				newCustomer.cpf = oldCustomer.cpf;
				
				newCustomer.nome 			= oldCustomer.nome;
				newCustomer.sobrenome 		= oldCustomer.sobrenome;
				newCustomer.ramoAtividade 	= oldCustomer.ramoAtividade;
				newCustomer.rua 			= oldCustomer.rua;
				newCustomer.numero 			= oldCustomer.numero;
				newCustomer.cep 			= oldCustomer.cep;
				newCustomer.bairro 			= oldCustomer.bairro;
				newCustomer.cidade 			= oldCustomer.cidade;
				newCustomer.estado 			= oldCustomer.estado;
				newCustomer.genero		 	= oldCustomer.genero;
				newCustomer.dataNascimento 	= oldCustomer.dataNascimento;
				
				do {
					Menu.showSubMenu_UpdateCustomers();
					key = Menu.opc(11);
					
					if(key == 0) { exit = true; }
					
					switch (key) {
					case 1:
						System.out.println("\nNome: " + oldCustomer.nome);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.nome = Ltp2Utils.recebeString("Informe o novo NOME: ");
							noChanged = false;
						}else {
							newCustomer.nome = oldCustomer.nome;
						}
						break;
					case 2:
						System.out.println("\nSobrenome: " + oldCustomer.sobrenome);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.sobrenome = Ltp2Utils.recebeString("Informe o novo SOBRENOME: ");
							noChanged = false;
						}else {
							newCustomer.sobrenome = oldCustomer.sobrenome;
						}
						break;
					case 3:
						System.out.println("\nRamo de Atividade: " + oldCustomer.ramoAtividade);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.ramoAtividade = Ltp2Utils.recebeString("Informe o novo Ramo de Atividade: ");
							noChanged = false;
						}else {
							newCustomer.ramoAtividade = oldCustomer.ramoAtividade;
						}
						break;
					case 4:
						System.out.println("\nRua: " + oldCustomer.rua);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.rua = Ltp2Utils.recebeString("Informe a nova RUA: ");
							noChanged = false;
						}else {
							newCustomer.rua = oldCustomer.rua;
						}
						break;
					case 5:
						System.out.println("\nNº: " + oldCustomer.numero);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.numero = Ltp2Utils.recebeString("Informe o novo Nº: ");
							noChanged = false;
						}else {
							newCustomer.numero = oldCustomer.numero;
						}
						break;
					case 6:
						System.out.println("\nCEP: " + oldCustomer.cep);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.cep = Ltp2Utils.recebeString("Informe o novo CEP: ");
							noChanged = false;
						}else {
							newCustomer.cep = oldCustomer.cep;
						}
						break;
					case 7:
						System.out.println("\nBairro: " + oldCustomer.bairro);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.bairro = Ltp2Utils.recebeString("Informe o novo BAIRRO: ");
							noChanged = false;
						}else {
							newCustomer.bairro = oldCustomer.bairro;
						}
						break;
					case 8:
						System.out.println("\nCidade: " + oldCustomer.cidade);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.cidade = Ltp2Utils.recebeString("Informe o novo CIDADE: ");
							noChanged = false;
						}else {
							newCustomer.cidade = oldCustomer.cidade;
						}
						break;
					case 9:
						System.out.println("\nEstado: " + oldCustomer.estado);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.estado = Ltp2Utils.recebeString("Informe o novo ESTADO: ");
							noChanged = false;
						}else {
							newCustomer.estado = oldCustomer.estado;
						}
						break;
					case 10:
						System.out.println("\nGenero: " + oldCustomer.genero);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.genero = Ltp2Utils.recebeCharUpperCase("Informe o novo GENERO: ");
							noChanged = false;
						}else {
							newCustomer.genero = oldCustomer.genero;
						}
						break;
					case 11:
						System.out.println("\nData de Nascimento: " + oldCustomer.dataNascimento);
						if(Ltp2Utils.recebeSouN("Deseja Alterar? (S/N)") == 'S'){
							newCustomer.dataNascimento = Ltp2Utils.recebeString("Informe a nova Data de Nascimento: ");
							noChanged = false;
						}else {
							newCustomer.dataNascimento = oldCustomer.dataNascimento;
						}
						break;

					default:
						break;
					}
					
				}while(!exit);

				newCustomer.empresaRelacao = oldCustomer.empresaRelacao;
				newCustomer.registro = oldCustomer.registro;
				newCustomer.active = 'Y';
				newCustomer.dataRegistro = oldCustomer.dataRegistro;
			
				if(Ltp2Utils.recebeSouN("\n----\nConfirmar as alterações? (S/N)")=='S' && noChanged == false){
					Delete.deleteCustomer(oldCustomer.cpf, false);
					Record.salvarCliente(newCustomer);
				}

			}else if(noChanged == true){
				System.out.println("\n !! Cliente não cadastrado !!");
			}
				
			arq.close();

		} catch (Exception e) {
			System.err.println("Erro ao abrir o arquivo!");
		}
	}
}
