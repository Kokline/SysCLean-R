import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Load {
	private static int total;
    private static Person[] funcionarios = new Person[totalWorkers()];
    private static Person[] clientes = new Person[totalCustomers()];
    private static Garbage[] lixos = new Garbage[totalGarbage()];
    private static Sale[] sales = new Sale[totalSale()];
    private static RandomAccessFile arq;
	
	/*
	 * WORKERS...............................................................
	 */
	
	public static int totalWorkers() {
		Person funcionario;
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Workers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			while (true) {
				funcionario = new Person();
				//READING ALL INFORMATION
				funcionario.active 			= arq.readChar();
				funcionario.nome 			= arq.readUTF();
				funcionario.sobrenome 		= arq.readUTF();
				funcionario.cpf 			= arq.readUTF();
				funcionario.empresaRelacao 	= arq.readUTF();
				funcionario.registro 		= arq.readUTF();
				funcionario.ramoAtividade	= arq.readUTF();
				funcionario.rua 			= arq.readUTF();
				funcionario.numero 			= arq.readUTF();
				funcionario.cep 			= arq.readUTF();
				funcionario.bairro 			= arq.readUTF();
				funcionario.cidade 			= arq.readUTF();
				funcionario.estado 			= arq.readUTF();
				funcionario.genero 			= arq.readChar();
				funcionario.dataNascimento 	= arq.readUTF();
				funcionario.dataRegistro 	= arq.readUTF();
				
				if(funcionario.active != 'N') {
					total++;
				}
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Person[] loadWorkers() {
		Person funcionario;
		funcionarios = new Person[totalWorkers()];
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Workers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			
			while (true) {
				funcionario = new Person();
				//READING ALL INFORMATION
				funcionario.active 			= arq.readChar();
				funcionario.nome 			= arq.readUTF();
				funcionario.sobrenome 		= arq.readUTF();
				funcionario.cpf 			= arq.readUTF();
				funcionario.empresaRelacao 	= arq.readUTF();
				funcionario.registro 		= arq.readUTF();
				funcionario.ramoAtividade	= arq.readUTF();
				funcionario.rua 			= arq.readUTF();
				funcionario.numero 			= arq.readUTF();
				funcionario.cep 			= arq.readUTF();
				funcionario.bairro 			= arq.readUTF();
				funcionario.cidade 			= arq.readUTF();
				funcionario.estado 			= arq.readUTF();
				funcionario.genero 			= arq.readChar();
				funcionario.dataNascimento 	= arq.readUTF();
				funcionario.dataRegistro 	= arq.readUTF();

				if(funcionario.active != 'N') {
					funcionarios[i++] = funcionario;
				}
			}
			
		} catch (EOFException e) {
			//System.out.println("\nLista de funcionários carregada!\n\n");
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
		Person cliente;
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			while (true) {
				cliente = new Person();
				//READING ALL INFORMATION
				cliente.active 			= arq.readChar();
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
				cliente.dataNascimento 	= arq.readUTF();
				cliente.dataRegistro 	= arq.readUTF();
				
				if(cliente.active != 'N') {
					total++;
				}
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Person[] loadCustomers() {
		Person cliente;
		clientes = new Person[totalCustomers()];
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);

			while (true) {
				cliente = new Person();
				//READING ALL INFORMATION
				cliente.active 			= arq.readChar();
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
				cliente.dataNascimento 	= arq.readUTF();
				cliente.dataRegistro 	= arq.readUTF();

				if(cliente.active != 'N') {
					clientes[i++] = cliente;
				}
			}
			
		} catch (EOFException e) {
			//System.out.println("\nLista de clientes carregada!\n\n");
			total = 0;
			return clientes;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		total = 0;
		i = 0;
		return clientes;
	}
	
	/*
	 * GARBAGE...............................................................
	 */
	
	public static int totalGarbage() {
		Garbage lixo;
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Garbage, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			while (true) {
				lixo = new Garbage();
				//READING ALL INFORMATION
				lixo.ativo 		= arq.readChar();
				lixo.id 		= arq.readInt();
				lixo.descricao 	= arq.readUTF();
				lixo.peso 		= arq.readFloat();
				lixo.tipo 		= arq.readUTF();
				lixo.status 	= arq.readChar();
				lixo.categoria	= arq.readUTF();
				lixo.data 		= arq.readUTF();
				
				if(lixo.ativo != 'N') {
					total++;
				}
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Garbage[] loadGarbage() {
		Garbage lixo;
		lixos = new Garbage[totalGarbage()];
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Garbage, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			
			while (true) {
				lixo = new Garbage();
				//READING ALL INFORMATION
				lixo.ativo 		= arq.readChar();
				lixo.id 		= arq.readInt();
				lixo.descricao 	= arq.readUTF();
				lixo.peso 		= arq.readFloat();
				lixo.tipo 		= arq.readUTF();
				lixo.status 	= arq.readChar();
				lixo.categoria	= arq.readUTF();
				lixo.data 		= arq.readUTF();

				if(lixo.ativo != 'N') {
					lixos[i++] = lixo;
				}
			}
			
		} catch (EOFException e) {
			//System.out.println("\nLista de lixo carregada!\n\n");
			total = 0;
			return lixos;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		total = 0;
		return lixos;
	}
	
	/*
	 * SALE...............................................................
	 */
	public static int totalSale() {
		Sale sale;
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Sales, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			total = 0;
			
			
			//WRITING INTO THE FILE
			while (true) {
				sale = new Sale();
				//READING ALL INFORMATION
				sale.id 			= arq.readInt();
				sale.idSalesman 	= arq.readUTF();
				sale.idCustomer 	= arq.readUTF();
				sale.dataRegistro 	= arq.readUTF();
				sale.category 		= arq.readUTF();
				sale.totalPrice 	= arq.readFloat();
				sale.totalWeight	= arq.readFloat();

				total++;
			}
			
		} catch (EOFException e) {
			return total;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		
		return total;
	}
	
	public static Sale[] loadSale() {
		Sale sale;
		sales = new Sale[totalSale()];
		int i = 0;
		
		try {
			//OPPENING FILE
			arq = new RandomAccessFile(DBAccessName.myDB_Sales, "rw");
			
			//SENDING TO THE END OF FILE
			arq.seek(0);
			
			while (true) {
				sale = new Sale();
				//READING ALL INFORMATION
				sale.id 			= arq.readInt();
				sale.idSalesman 	= arq.readUTF();
				sale.idCustomer 	= arq.readUTF();
				sale.dataRegistro 	= arq.readUTF();
				sale.category 		= arq.readUTF();
				sale.totalPrice 	= arq.readFloat();
				sale.totalWeight	= arq.readFloat();
				
				sales[i++] = sale;
			}
			
		} catch (EOFException e) {
			//System.out.println("\nLista de VENDAS carregada!\n\n");
			total = 0;
			return sales;
		} catch (IOException e) {
			System.err.println("-----------------------\nFalha ao tentar abrir o arquivo, \ncontate o administrador!!\n-----------------------");
		}
		total = 0;
		return sales;
	}
}
