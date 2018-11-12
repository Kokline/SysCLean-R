import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Record {
    private static String myDB_Workers = "dataBaseWorkers.fmp";
    private static String myDB_Customers = "dataBaseCustomers.fmp";
    private static String myDB_Garbage = "dataBaseGarbage.fmp";
    
    //CARREGAR LISTA DE FUNCIONARIOS
	public static void carregarListaFuncionario(Person[] listaFuncionario) {
		int i = 0;
		try {
			//ABIR ARQUIVO
	           RandomAccessFile arq = new RandomAccessFile(myDB_Workers, "rw");
			
			//ENVIA PARA O FINAL DO ARQUIVO PARA NÃO SOBREPOR DADOS
	            arq.seek(0);
			
			while (true) {
				Person person = new Person();
				//LER TODOS OS DADOS
		           person.nome = arq.readUTF();
		           person.sobrenome = arq.readUTF();
		           person.cpf = arq.readUTF();
		           person.empresaRelacao = arq.readUTF();
		           person.registro = arq.readUTF();
		           person.rua = arq.readUTF();
		           person.numero = arq.readUTF();
		           person.cep = arq.readUTF();
		           person.bairro = arq.readUTF();
		           person.cidade = arq.readUTF();
		           person.estado = arq.readUTF();
		           person.genero = arq.readChar();
		           person.active = arq.readChar();
		           person.dataNascimento = arq.readUTF();
		           person.dataRegistro = arq.readUTF();
		           
		           listaFuncionario[i++]=person;
			}
			
			//FECHAR E SALVAR
			 //arq.close();			
			
		} catch (EOFException e) {
			System.out.println("Lista carregada!");
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}
	}
	
	//CARREGAR LISTA DE CLIENTES
	public static void carregarListaCliente(Person[] listaCliente) {
		int i = 0;
		try {
			//ABIR ARQUIVO
	           RandomAccessFile arq = new RandomAccessFile(myDB_Customers, "rw");
			
	         //ENVIA PARA O FINAL DO ARQUIVO PARA NÃO SOBREPOR DADOS
	            arq.seek(0);
			
			while (true) {
				Person person = new Person();
				//LER TODOS OS DADOS
		           person.nome = arq.readUTF();
		           person.sobrenome = arq.readUTF();
		           person.cpf = arq.readUTF();
		           person.empresaRelacao = arq.readUTF();
		           person.registro = arq.readUTF();
		           person.rua = arq.readUTF();
		           person.numero = arq.readUTF();
		           person.cep = arq.readUTF();
		           person.bairro = arq.readUTF();
		           person.cidade = arq.readUTF();
		           person.estado = arq.readUTF();
		           person.genero = arq.readChar();
		           person.active = arq.readChar();
		           person.dataNascimento = arq.readUTF();
		           person.dataRegistro = arq.readUTF();
		           
		           listaCliente[i++]=person;
			}
			
			//FECHAR E SALVAR
			// arquivo.close();			
			
		} catch (EOFException e) {
			System.out.println("Lista carregada!");
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}
	}
    
    //GRAVAÇÃO DE FUNCIONÁRIOS
    public static void salvarFuncionario(Person funcionario){
        try {
            //OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(myDB_Workers, "rw");
            
            //SENDING TO THE END OF FILE
            arq.seek(0);
            
            //WRITING INTO THE FILE
            arq.writeUTF(funcionario.nome);
            arq.writeUTF(funcionario.sobrenome);
            arq.writeUTF(funcionario.cpf);
            arq.writeUTF(funcionario.empresaRelacao);
            arq.writeUTF(funcionario.registro);
            arq.writeUTF(funcionario.rua);
            arq.writeUTF(funcionario.numero);
            arq.writeUTF(funcionario.cep);
            arq.writeUTF(funcionario.bairro);
            arq.writeUTF(funcionario.cidade);
            arq.writeUTF(funcionario.estado);
            arq.writeChar(funcionario.genero);
            arq.writeChar(funcionario.active);
            arq.writeUTF(funcionario.dataNascimento);
            arq.writeUTF(funcionario.dataRegistro);
            
            arq.close();
            System.out.println("Funcionário Registrado!\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar funcionário!\n\n");
        }
    }
    
  //GRAVAÇÃO DE CLIENTES
    public static void salvarCliente(Person cliente){
        try {
            //OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(myDB_Customers, "rw");
            
            //SENDING TO THE END OF FILE
            arq.seek(0);
            
            //WRITING INTO THE FILE
            arq.writeUTF(cliente.nome);
            arq.writeUTF(cliente.sobrenome);
            arq.writeUTF(cliente.cpf);
            arq.writeUTF(cliente.empresaRelacao);
            arq.writeUTF(cliente.registro);
            arq.writeUTF(cliente.ramoAtividade);
            arq.writeUTF(cliente.rua);
            arq.writeUTF(cliente.numero);
            arq.writeUTF(cliente.cep);
            arq.writeUTF(cliente.bairro);
            arq.writeUTF(cliente.cidade);
            arq.writeUTF(cliente.estado);
            arq.writeChar(cliente.genero);
            arq.writeChar(cliente.active);
            arq.writeUTF(cliente.dataNascimento);
            arq.writeUTF(cliente.dataRegistro);
            
            arq.close();
            System.out.println("Cliente Registrado!\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar cliente!\n\n");
        }
    }
    
  //GRAVAÇÃO DE LIXO
    public static void salvarLixo(Garbage lixo){
        try {
            //OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(myDB_Garbage, "rw");
            
            //SENDING TO THE END OF FILE
            arq.seek(0);
            
            //WRITING INTO THE FILE
            arq.writeInt(lixo.id);
            arq.writeChar(lixo.ativo);
            arq.writeUTF(lixo.descricao);
            arq.writeFloat(lixo.peso);
            arq.writeUTF(lixo.tipo);
            arq.writeChar(lixo.status);
            arq.writeUTF(lixo.categoria);
            arq.writeUTF(lixo.data);
            
            arq.close();
            System.out.println("\nLixo Registrado no sistema!\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar lixo!\n\n");
        }
    }
    
	public static void imprimirFuncionario(Person funcionario) {
		System.out.println("*********************************************************");
		System.out.println("***********************FUNCIONARIO***********************");
		System.out.println("NOME        : " + funcionario.nome + " " + funcionario.sobrenome);
		System.out.println("CPF: " + funcionario.cpf);
		System.out.println("RELAÇÃO DA EMPRESA: " + funcionario.empresaRelacao);
		System.out.println("REGISTRO      : " + funcionario.registro);
		System.out.println("RAMO DE ATIVIDADES    : " + funcionario.ramoAtividade);
		System.out.println("RUA    : " + funcionario.rua);
		System.out.println("NUMERO    : " + funcionario.numero);
		System.out.println("CEP    : " + funcionario.cep);
		System.out.println("BAIRRO    : " + funcionario.bairro);
		System.out.println("CIDADE    : " + funcionario.cidade);
		System.out.println("ESTADO    : " + funcionario.estado);
		System.out.println("GENERO    : " + funcionario.genero);
		System.out.println("ATIVO    : " + funcionario.active);
		System.out.println("DATA DE NASCIMENTO    : " + funcionario.dataNascimento);
		System.out.println("DATA DE REGISTRO    : " + funcionario.dataRegistro);
		
		/* V2
		String genero = "", status = "";
		
		if(cliente.genero == 'M') { genero = "Masculino"; }
		else { genero = "Feminino"; }
		
		if(cliente.active == 'Y') { status = "Ativo"; }
		else { status = "Inativo"; }
		System.out.println("\n_________INFORMAÇÕES PESSOAIS_________"
				  +"\nNome: ------------------" + funcionario.nome + " " + funcionario.sobrenome
				  +"\nCPF: -------------------" + funcionario.cpf
				  +"\nGenero: ----------------" + funcionario.genero
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
				  +"\nStatus: ----------------" + funcionario.active
				  +"\nData de Contratação: ---" + funcionario.dataRegistro);
				  */
	}
	
	public static void imprimirCliente(Person cliente) {
		System.out.println("*********************************************************");
		System.out.println("*************************CLIENTE*************************");
		System.out.println("NOME        : " + cliente.nome + " " + cliente.sobrenome);
		System.out.println("CPF: " + cliente.cpf);
		System.out.println("RELAÇÃO DA EMPRESA: " + cliente.empresaRelacao);
		System.out.println("REGISTRO      : " + cliente.registro);
		System.out.println("RAMO DE ATIVIDADES    : " + cliente.ramoAtividade);
		System.out.println("RUA    : " + cliente.rua);
		System.out.println("NUMERO    : " + cliente.numero);
		System.out.println("CEP    : " + cliente.cep);
		System.out.println("BAIRRO    : " + cliente.bairro);
		System.out.println("CIDADE    : " + cliente.cidade);
		System.out.println("ESTADO    : " + cliente.estado);
		System.out.println("GENERO    : " + cliente.genero);
		System.out.println("ATIVO    : " + cliente.active);
		System.out.println("DATA DE NASCIMENTO    : " + cliente.dataNascimento);
		System.out.println("DATA DE REGISTRO    : " + cliente.dataRegistro);
		
		/* V2
		String genero = "", status = "";
		
		if(cliente.genero == 'M') { genero = "Masculino"; }
		else { genero = "Feminino"; }
		
		if(cliente.active == 'Y') { status = "Ativo"; }
		else { status = "Inativo"; }
		System.out.println("\n_________INFORMAÇÕES PESSOAIS_________"
				  +"\nNome: ------------------" + funcionario.nome + " " + funcionario.sobrenome
				  +"\nCPF: -------------------" + funcionario.cpf
				  +"\nGenero: ----------------" + funcionario.genero
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
				  +"\nStatus: ----------------" + funcionario.active
				  +"\nData de Contratação: ---" + funcionario.dataRegistro);
				  */
	}
	
	public static Person buscarClientePeloCPF(int cpf) {
		Person cli = new Person();
		
		try {

			RandomAccessFile arq = new RandomAccessFile(myDB_Customers, "rw");

			while (true) {

		           cli.nome = arq.readUTF();
		           cli.sobrenome = arq.readUTF();
		           cli.cpf = arq.readUTF();
		           cli.empresaRelacao = arq.readUTF();
		           cli.registro = arq.readUTF();
		           cli.rua = arq.readUTF();
		           cli.numero = arq.readUTF();
		           cli.cep = arq.readUTF();
		           cli.bairro = arq.readUTF();
		           cli.cidade = arq.readUTF();
		           cli.estado = arq.readUTF();
		           cli.genero = arq.readChar();
		           cli.active = arq.readChar();
		           cli.dataNascimento = arq.readUTF();
		           cli.dataRegistro = arq.readUTF();

				if (Integer.parseInt(cli.cpf) == cpf && cli.active == 'Y') {
					arq.close();
					return cli;
				}
			}

		} catch (EOFException e) {
			return null;
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}

		return null;
	}
	
	public static Person buscarFuncionarioPeloCPF(int cpf) {
		Person fun = new Person();
		
		try {

			RandomAccessFile arq = new RandomAccessFile(myDB_Workers, "rw");

			while (true) {

		           fun.nome = arq.readUTF();
		           fun.sobrenome = arq.readUTF();
		           fun.cpf = arq.readUTF();
		           fun.empresaRelacao = arq.readUTF();
		           fun.registro = arq.readUTF();
		           fun.rua = arq.readUTF();
		           fun.numero = arq.readUTF();
		           fun.cep = arq.readUTF();
		           fun.bairro = arq.readUTF();
		           fun.cidade = arq.readUTF();
		           fun.estado = arq.readUTF();
		           fun.genero = arq.readChar();
		           fun.active = arq.readChar();
		           fun.dataNascimento = arq.readUTF();
		           fun.dataRegistro = arq.readUTF();

				if (Integer.parseInt(fun.cpf) == cpf && fun.active == 'Y') {
					arq.close();
					return fun;
				}
			}

		} catch (EOFException e) {
			return null;
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}

		return null;
	}
	
	public static Person pesquisarFuncionarioID(Person[] listaFuncionario) {
		String cpf;
		
		cpf = Ltp2Utils.verificaCPF("");
		for (int i = 0; i < listaFuncionario.length; i++) {
			if(listaFuncionario[i].cpf.equals(cpf)) {
				return listaFuncionario[i];
			}
		}
		
		return null;
	}
	
	public static Person pesquisarClienteID(Person[] listaCliente) {
		String cpf;
		
		cpf = Ltp2Utils.verificaCPF("");
		for (int i = 0; i < listaCliente.length; i++) {
			if(listaCliente[i].cpf.equals(cpf)) {
				return listaCliente[i];
			}
		}
		
		return null;
	}
	
	public static void excluirCliente(String cpfCliente) {
		long pointer;
		
		try {

			RandomAccessFile arq = new RandomAccessFile(myDB_Customers, "rw");

			pointer = buscarClientePeloCodigoPointerCliente(cpfCliente);

			if(pointer>-1) {
				arq.seek(pointer);
				arq.writeChar('N');
				System.out.println("Cliente EXCLUÍDO com sucesso!");
			}else {
				System.out.println("Cliente não cadastrado!");
			}
				
			arq.close();

		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}
	}
	
	public static long buscarClientePeloCodigoPointerCliente(String cpf) {
		Person cli = new Person();
		long pointer;
		
		try {

			RandomAccessFile arq = new RandomAccessFile(myDB_Customers, "rw");

			while (true) {
				pointer = arq.getFilePointer();

		           cli.nome = arq.readUTF();
		           cli.sobrenome = arq.readUTF();
		           cli.cpf = arq.readUTF();
		           cli.empresaRelacao = arq.readUTF();
		           cli.registro = arq.readUTF();
		           cli.rua = arq.readUTF();
		           cli.numero = arq.readUTF();
		           cli.cep = arq.readUTF();
		           cli.bairro = arq.readUTF();
		           cli.cidade = arq.readUTF();
		           cli.estado = arq.readUTF();
		           cli.genero = arq.readChar();
		           cli.active = arq.readChar();
		           cli.dataNascimento = arq.readUTF();
		           cli.dataRegistro = arq.readUTF();

				if (cli.cpf == cpf && cli.active == 'Y') {
					arq.close();
					return pointer;
				}
			}

		} catch (EOFException e) {
			return -1;
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}

		return -1;
	}
	
	public static void excluirFuncionario(String cpfFuncionario) {
		long pointer;
		
		try {

			RandomAccessFile arq = new RandomAccessFile(myDB_Workers, "rw");

			pointer = buscarfuncionarioPeloCodigoPointerFuncionario(cpfFuncionario);

			if(pointer>-1) {
				arq.seek(pointer);
				arq.writeChar('N');
				System.out.println("funcionario EXCLUÍDO com sucesso!");
			}else {
				System.out.println("funcionario não cadastrado!");
			}
				
			arq.close();

		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}
	}
	
	public static long buscarfuncionarioPeloCodigoPointerFuncionario(String cpf) {
		Person func = new Person();
		long pointer;
		
		try {

			RandomAccessFile arq = new RandomAccessFile(myDB_Workers, "rw");

			while (true) {
				pointer = arq.getFilePointer();

		           func.nome = arq.readUTF();
		           func.sobrenome = arq.readUTF();
		           func.cpf = arq.readUTF();
		           func.empresaRelacao = arq.readUTF();
		           func.registro = arq.readUTF();
		           func.rua = arq.readUTF();
		           func.numero = arq.readUTF();
		           func.cep = arq.readUTF();
		           func.bairro = arq.readUTF();
		           func.cidade = arq.readUTF();
		           func.estado = arq.readUTF();
		           func.genero = arq.readChar();
		           func.active = arq.readChar();
		           func.dataNascimento = arq.readUTF();
		           func.dataRegistro = arq.readUTF();

				if (func.cpf == cpf && func.active == 'Y') {
					arq.close();
					return pointer;
				}
			}

		} catch (EOFException e) {
			return -1;
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!");
		}

		return -1;
	}
}
