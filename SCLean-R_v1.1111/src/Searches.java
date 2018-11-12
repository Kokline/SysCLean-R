import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Searches {
	static RandomAccessFile arq;
	
	public static long searchWorkerByTheCodPointer(String cpfWorker) {
		Person worker = new Person();
		long pointer;
		
		try {
			
			arq = new RandomAccessFile(DBAccessName.myDB_Workers, "rw");
			
			while (true) {
				pointer = arq.getFilePointer();

				//READING ALL INFORMATION
				worker.active 			= arq.readChar();
				worker.nome 			= arq.readUTF();
				worker.sobrenome 		= arq.readUTF();
				worker.cpf 				= arq.readUTF();
				worker.empresaRelacao 	= arq.readUTF();
				worker.registro 		= arq.readUTF();
				worker.ramoAtividade	= arq.readUTF();
				worker.rua 				= arq.readUTF();
				worker.numero 			= arq.readUTF();
				worker.cep 				= arq.readUTF();
				worker.bairro 			= arq.readUTF();
				worker.cidade 			= arq.readUTF();
				worker.estado 			= arq.readUTF();
				worker.genero 			= arq.readChar();
				worker.dataNascimento 	= arq.readUTF();
				worker.dataRegistro 	= arq.readUTF();

				if (worker.cpf.equals(cpfWorker) && worker.active == 'Y') {
					arq.close();
					return pointer;
				}
			}

		} catch (EOFException e) {
			return -1;
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!\n");
		}

		return -1;
	}
	
	public static long searchCustomerByTheCodPointer(String cpfCustomer) {
		Person customer = new Person();
		long pointer;
		
		try {
			
			arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");
			
			while (true) {
				pointer = arq.getFilePointer();

				//READING ALL INFORMATION
				customer.active 		= arq.readChar();
				customer.nome 			= arq.readUTF();
				customer.sobrenome 		= arq.readUTF();
				customer.cpf 			= arq.readUTF();
				customer.empresaRelacao = arq.readUTF();
				customer.registro 		= arq.readUTF();
				customer.ramoAtividade	= arq.readUTF();
				customer.rua 			= arq.readUTF();
				customer.numero 		= arq.readUTF();
				customer.cep 			= arq.readUTF();
				customer.bairro 		= arq.readUTF();
				customer.cidade 		= arq.readUTF();
				customer.estado 		= arq.readUTF();
				customer.genero 		= arq.readChar();
				customer.dataNascimento = arq.readUTF();
				customer.dataRegistro 	= arq.readUTF();

				if (customer.cpf.equals(cpfCustomer) && customer.active == 'Y') {
					arq.close();
					return pointer;
				}
			}

		} catch (EOFException e) {
			return -1;
		} catch (IOException e) {
			System.err.println("Erro ao abrir o arquivo!\n");
		}

		return -1;
	}
	
	/*
	 * --------------------------------------------------------------------------------------------------
	 * CHECKING SOME INFORMATIONS------------------------------------------------------------------------
	 * --------------------------------------------------------------------------------------------------
	 */
	
	// VERIFICADOR DE CHAVES - SE JÁ EXISTE NA BASE DE DADOS
	public static boolean keyVerify(String key, String type) {
		boolean checked = false;
		Person[] person = null;
		
		if(type.equals("C")) { person = Load.loadCustomers(); }
		else if(type.equals("W")) { person = Load.loadWorkers(); }
		
		for (int i = 0; i < person.length; i++) {
			if(key.equals(person[i].cpf) && person[i].active == 'Y') { checked = true; break; }
		}
		
		return checked;
	}
	
	public static boolean weightGarbageVerify(float weight, String category) {
		boolean checked = false;
		Garbage[] garbage = Load.loadGarbage();
		
		for (int i = 0; i < garbage.length; i++) {
			if(category.equals(garbage[i].categoria) && garbage[i].peso >= weight) { checked = true; break; }
		}
		
		return checked;
	}
}
























