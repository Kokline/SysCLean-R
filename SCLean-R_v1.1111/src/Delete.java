import java.io.IOException;
import java.io.RandomAccessFile;

public class Delete {
	public static void deleteWorker(String cpfWorker, boolean abort) {
		long pointer;
		
		try {

			RandomAccessFile arq = new RandomAccessFile(DBAccessName.myDB_Workers, "rw");

			pointer = Searches.searchWorkerByTheCodPointer(cpfWorker);

			if(abort == true) {
				if(Menu.doYouWantToDoThis() == -2) { pointer = -2; }
			}
			
			if(pointer > -1) {
				arq.seek(pointer);
				arq.writeChar('N');
				System.out.println("\nFuncion�rio EXCLU�DO com sucesso!\n");
			}
			else if(pointer == -2){
				System.out.println("\n\nOPERA��O ABORTADA!\n\n");
			}else {
				System.out.println("Funcion�rio n�o cadastrado!\n");
			}
				
			arq.close();

		} catch (IOException e) {
			System.err.println("---> Erro ao abrir o arquivo!\n\n");
		}
	}
	
	public static void deleteCustomer(String cpfCustomer, boolean abort) {
		long pointer;
		
		try {

			RandomAccessFile arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");

			pointer = Searches.searchCustomerByTheCodPointer(cpfCustomer);

			if(abort == true) {
				if(Menu.doYouWantToDoThis() == -2) { pointer = -2; }
			}
			
			if(pointer > -1) {
				arq.seek(pointer);
				arq.writeChar('N');
				System.out.println("\nCliente EXCLU�DO com sucesso!\n");
			}
			else if(pointer == -2){
				System.out.println("\n\nOPERA��O ABORTADA!\n\n");
			}else {
				System.out.println("Cliente n�o cadastrado!\n");
			}
				
			arq.close();

		} catch (IOException e) {
			System.err.println("---> Erro ao abrir o arquivo!\n\n");
		}
	}
}
