import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Load {
	private static int total;
	private static String myDB_Workers = "dataBaseWorkers.fmp";
    private static String myDB_Customers = "dataBaseCustomers.fmp";
    private static String myDB_Garbage = "dataBaseGarbage.fmp";
    private static Person[] funcionarios = new Person[totalWorkers()];
    private static Person[] clientes = new Person[totalCustomers()];
    private static Garbage[] lixos = new Garbage[totalGarbage()];
    private static RandomAccessFile arq;
	
	/*
	 * WORKERS...............................................................
	 */
	
	public static int totalWorkers() {
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(myDB_Workers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			while (true) {
				Person funcionario = new Person();
				//READING ALL INFORMATION
				funcionario.nome 			= arq.readUTF();
				funcionario.sobrenome 		= arq.readUTF();
				funcionario.cpf 			= arq.readUTF();
				funcionario.empresaRelacao 	= arq.readUTF();
				funcionario.registro 		= arq.readUTF();
				funcionario.rua 			= arq.readUTF();
				funcionario.numero 			= arq.readUTF();
				funcionario.cep 			= arq.readUTF();
				funcionario.bairro 			= arq.readUTF();
				funcionario.cidade 			= arq.readUTF();
				funcionario.estado 			= arq.readUTF();
				funcionario.genero 			= arq.readChar();
				funcionario.active 			= arq.readChar();
				funcionario.dataNascimento 	= arq.readUTF();
				funcionario.dataRegistro 	= arq.readUTF();
				total++;
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Person[] loadWorkers() {
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(myDB_Workers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			
			while (true) {
				Person funcionario = new Person();
				//READING ALL INFORMATION
				funcionario.nome 			= arq.readUTF();
				funcionario.sobrenome 		= arq.readUTF();
				funcionario.cpf 			= arq.readUTF();
				funcionario.empresaRelacao 	= arq.readUTF();
				funcionario.registro 		= arq.readUTF();
				funcionario.rua 			= arq.readUTF();
				funcionario.numero 			= arq.readUTF();
				funcionario.cep 			= arq.readUTF();
				funcionario.bairro 			= arq.readUTF();
				funcionario.cidade 			= arq.readUTF();
				funcionario.estado 			= arq.readUTF();
				funcionario.genero 			= arq.readChar();
				funcionario.active 			= arq.readChar();
				funcionario.dataNascimento 	= arq.readUTF();
				funcionario.dataRegistro 	= arq.readUTF();

				funcionarios[i++] = funcionario;
			}
			
		} catch (EOFException e) {
			System.out.println("\nLista de funcionários carregada!\n\n");
			total = 0;
			return funcionarios;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		total = 0;
		return funcionarios;
	}
	
	/*
	 * CUSTOMERS...............................................................
	 */
	
	public static int totalCustomers() {
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(myDB_Customers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			while (true) {
				Person cliente = new Person();
				//READING ALL INFORMATION
				cliente.nome 			= arq.readUTF();
				cliente.sobrenome 		= arq.readUTF();
				cliente.cpf 			= arq.readUTF();
				cliente.empresaRelacao 	= arq.readUTF();
				cliente.registro 		= arq.readUTF();
				cliente.ramoAtividade	= arq.readUTF();
				cliente.rua 			= arq.readUTF();
				cliente.numero 			= arq.readUTF();
				cliente.cep 			= arq.readUTF();
				cliente.bairro 			= arq.readUTF();
				cliente.cidade 			= arq.readUTF();
				cliente.estado 			= arq.readUTF();
				cliente.genero 			= arq.readChar();
				cliente.active 			= arq.readChar();
				cliente.dataNascimento 	= arq.readUTF();
				cliente.dataRegistro 	= arq.readUTF();
				total++;
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Person[] loadCustomers() {
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(myDB_Customers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			
			while (true) {
				Person cliente = new Person();
				//READING ALL INFORMATION
				cliente.nome 			= arq.readUTF();
				cliente.sobrenome 		= arq.readUTF();
				cliente.cpf 			= arq.readUTF();
				cliente.empresaRelacao 	= arq.readUTF();
				cliente.registro 		= arq.readUTF();
				cliente.ramoAtividade	= arq.readUTF();
				cliente.rua 			= arq.readUTF();
				cliente.numero 			= arq.readUTF();
				cliente.cep 			= arq.readUTF();
				cliente.bairro 			= arq.readUTF();
				cliente.cidade 			= arq.readUTF();
				cliente.estado 			= arq.readUTF();
				cliente.genero 			= arq.readChar();
				cliente.active 			= arq.readChar();
				cliente.dataNascimento 	= arq.readUTF();
				cliente.dataRegistro 	= arq.readUTF();

				clientes[i++] = cliente;
			}
			
		} catch (EOFException e) {
			System.out.println("\nLista de clientes carregada!\n\n");
			total = 0;
			return clientes;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		total = 0;
		return clientes;
	}
	
	/*
	 * CUSTOMERS...............................................................
	 */
	
	public static int totalGarbage() {
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(myDB_Garbage, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			while (true) {
				Garbage lixo = new Garbage();
				//READING ALL INFORMATION
				lixo.id 		= arq.readInt();
				lixo.ativo 		= arq.readChar();
				lixo.descricao 	= arq.readUTF();
				lixo.peso 		= arq.readFloat();
				lixo.tipo 		= arq.readUTF();
				lixo.status 	= arq.readChar();
				lixo.categoria	= arq.readUTF();
				lixo.data 		= arq.readUTF();
				total++;
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Garbage[] loadGarbage() {
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(myDB_Garbage, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			
			while (true) {
				Garbage lixo = new Garbage();
				//READING ALL INFORMATION
				lixo.id 		= arq.readInt();
				lixo.ativo 		= arq.readChar();
				lixo.descricao 	= arq.readUTF();
				lixo.peso 		= arq.readFloat();
				lixo.tipo 		= arq.readUTF();
				lixo.status 	= arq.readChar();
				lixo.categoria	= arq.readUTF();
				lixo.data 		= arq.readUTF();

				lixos[i++] = lixo;
			}
			
		} catch (EOFException e) {
			System.out.println("\nLista de lixo carregada!\n\n");
			total = 0;
			return lixos;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		total = 0;
		return lixos;
	}
}
