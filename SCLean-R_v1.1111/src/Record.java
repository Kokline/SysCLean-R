import java.io.IOException;
import java.io.RandomAccessFile;

public class Record {
    // GRAVAÇÃO DE FUNCIONÁRIOS
    public static void salvarFuncionario(Person funcionario){
        try {
            // OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(DBAccessName.myDB_Workers, "rw");
            
            // SENDING TO THE END OF FILE
            arq.seek(arq.length());
            
            // WRITING INTO THE FILE
            arq.writeChar(funcionario.active);
            arq.writeUTF(funcionario.nome);
            arq.writeUTF(funcionario.sobrenome);
            arq.writeUTF(funcionario.cpf);
            arq.writeUTF(funcionario.empresaRelacao);
            arq.writeUTF(funcionario.registro);
            arq.writeUTF(funcionario.ramoAtividade);
            arq.writeUTF(funcionario.rua);
            arq.writeUTF(funcionario.numero);
            arq.writeUTF(funcionario.cep);
            arq.writeUTF(funcionario.bairro);
            arq.writeUTF(funcionario.cidade);
            arq.writeUTF(funcionario.estado);
            arq.writeChar(funcionario.genero);
            arq.writeUTF(funcionario.dataNascimento);
            arq.writeUTF(funcionario.dataRegistro);
            
            arq.close();
            System.out.println("\n --> Funcionário Registrado! <--\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar funcionário!\n\n");
        }
    }
    
    // GRAVAÇÃO DE CLIENTES
    public static void salvarCliente(Person cliente){
        try {
            //OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(DBAccessName.myDB_Customers, "rw");

            //SENDING TO THE END OF FILE
            arq.seek(arq.length());
            
            //WRITING INTO THE FILE
            arq.writeChar(cliente.active);
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
            arq.writeUTF(cliente.dataNascimento);
            arq.writeUTF(cliente.dataRegistro);
            
            arq.close();
            System.out.println("\n --> Cliente Registrado! <--\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar cliente!\n\n");
        }
    }
    
    // GRAVAÇÃO DE LIXO
    public static void salvarLixo(Garbage lixo){
        try {
            //OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(DBAccessName.myDB_Garbage, "rw");
            
            //SENDING TO THE END OF FILE
            arq.seek(arq.length());
            
            //WRITING INTO THE FILE
            arq.writeChar(lixo.ativo);
            arq.writeInt(lixo.id);
            arq.writeUTF(lixo.descricao);
            arq.writeFloat(lixo.peso);
            arq.writeUTF(lixo.tipo);
            arq.writeChar(lixo.status);
            arq.writeUTF(lixo.categoria);
            arq.writeUTF(lixo.data);
            
            arq.close();
            System.out.println("\n --> Lixo Registrado no sistema! <--\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar lixo!\n\n");
        }
    }
    
 // GRAVAÇÃO DE VENDA
    public static void saveSale(Sale sale){
        try {
            //OPEN FILE
            RandomAccessFile arq = new RandomAccessFile(DBAccessName.myDB_Sales, "rw");
            
            //SENDING TO THE END OF FILE
            arq.seek(arq.length());
            
            //WRITING INTO THE FILE
            arq.writeInt(sale.id);
            arq.writeUTF(sale.idSalesman);
            arq.writeUTF(sale.idCustomer);
            arq.writeUTF(sale.dataRegistro);
            arq.writeUTF(sale.category);
            arq.writeFloat(sale.totalPrice);
            arq.writeFloat(sale.totalWeight);
            
            arq.close();
            System.out.println("\n --> VENDA Registrada no sistema! <--\n\n");
        } catch (IOException e) {
        	System.out.println("Erro ao tentar registrar VENDA!\n\n");
        }
    }
}
