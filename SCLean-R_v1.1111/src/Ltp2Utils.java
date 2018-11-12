import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ltp2Utils 
{
	static Scanner leia = new Scanner(System.in);
	
	int    a;
	float  b;
	String c;
	char   d;

	// Recebe uma String qualquer, captura uma String, converte em inteiro e catch se possui apenas inteiros e retorna inteiro.
    public static int recebeIntValidoMenu (String txt) {
        int numero=0;
        boolean valido;
 
        do {
            System.out.println("Escolha uma opção: ");
        txt = leia.nextLine();
            try{
                numero = Integer.parseInt(txt);
                System.out.println("Opção digitada: " + txt);
                    valido = true;
 
                } catch (NumberFormatException E){
                    System.out.println("O texto digitado não pode ser convertido em numero! Digite Novamente.");
                valido = false;
            }
        } while (!valido);
        return  numero;
    }       
 
    // Recebe uma String qualquer, captura uma String, converte em inteiro, catch se tem apenas numeros e retorna a String numerica.
    public static String recebeStringNumerica (String txt) {
        int numero=0;
        boolean valido;
 
        do {
            txt = leia.nextLine();
                try{
                    numero = Integer.parseInt(txt);
                    System.out.println(txt);
                    valido = true;
 
                } catch (NumberFormatException E){
                    System.out.println(txt);
                    System.out.println("O texto digitado não pode ser convertido em numero! Digite Novamente.");
                valido = false;
            }
        } while (!valido);
        return  Integer.toString(numero);
    }
	
	// INT-----
	public static int recebeInt (String txt) {
		System.out.print(txt);
		return leia.nextInt();
	}
	
	// FLOAT-----
	public static float recebeFloat (String txt) {
		System.out.print(txt);
		return leia.nextFloat();
	}
	
	// CHAR-----
	public static char recebeChar (String txt) {
		System.out.print(txt);
		return leia.next().charAt(0);
	}
	
	public static char recebeCharLowerCase (String txt) {
		System.out.print(txt);
		return leia.next().toLowerCase().charAt(0);
	}
	
	public static char recebeCharUpperCase (String txt) {
		System.out.print(txt);
		return leia.next().toUpperCase().charAt(0);
	}
	
	// STRING-----
	public static String recebeString (String txt) {
		String valor="";
		
		System.out.println(txt);
		valor = leia.nextLine();
		
		if(!valor.equals("")) {
			return valor;
		}else {
			//Para caso o buffer tiver cheio (Limpar o buffer)
			return leia.nextLine();
		}
	}
	
	public static String recebeStringLowerCase (String txt) {
		System.out.print(txt);
		return leia.nextLine().toLowerCase();
	}
	
	public static String recebeStringUpperCase (String txt) {
		System.out.print(txt);
		return leia.nextLine().toUpperCase();
	}
	
	// CAPITALIZE
	public static String capitalize(String texto) {
		//Trocar todo o texto para minusculo
		texto = texto.toLowerCase();
		
		//Variável Auxiliar
		String novoTexto = "";
		
		//Pega a primeira letra, converte na tabela ASCII 
		//e depois faz o typecast para mostrar a letra novamente
		novoTexto += (char)(texto.charAt(0)-32);
		
		for (int i = 1; i < texto.length(); i++) {
			if(texto.charAt(i-1)==' ') {
				novoTexto += (char)(texto.charAt(i)-32);
			}else {
				novoTexto += texto.charAt(i);
			}
		}
		
		return novoTexto;
	}
	
	// BETWEEN NUMBERS
	public static float recebeFloatEntreIntervalos(String texto, int menor, int maior) {
		float valor = 0;
		
		do {
			valor = recebeFloat(texto);
			if(valor < menor || valor > maior) {
				System.out.println("O valor deve ser entre ("+menor+") e ("+maior+")");
			}
		} while (valor < menor || valor > maior);
		
		return valor;
	}
	
	public static char recebeSouN(String texto) {
		char opcao;
		do {
			opcao = Ltp2Utils.recebeCharUpperCase(texto);
			if(opcao != 'S' && opcao != 'N') {
				System.out.println("Você deve informar S ou N");
			}
		} while (opcao != 'S' && opcao != 'N');
		
		return opcao;
	}
	
	public static char converterBooleanParaSouN(boolean b) {
		if(b == true) {
			return 'S';
		}else {
			return 'N';
		}
	}
	
	// BOOL-----
	public static boolean converterSouNParaBoolean(char c) {
		if(c == 'S' || c == 's') {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean confirmaSaida () {
		char resp;
		
		do {
			resp = recebeCharUpperCase("\nDeseja continuar (S/N): ");
			
			if(resp == 'S') { return true; }
			else if(resp == 'N') { return false; }
			else { System.out.println("Valor requerido S ou N: "); }
			
		}while(true);
	}
	
	public static boolean validarNumeroPositivo (float num) {;
		if(num > 0) { return true; }
		else { return false; }
	}
	
	// DATE--------
	public static String getTime() 
	{
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yy HH:mm");
		
		return formatador.format(data);
	}
	
	public static int getMonth(String date) {
		String month = "";	
		month = String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4));
		return Integer.parseInt(month);
	}
	
	// MASKS------
	public static String maskMoney(float value) 
	{
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("R$ #,###.00");	
		return df.format(value);
	}
	
	public static String masWeight(float value) 
	{
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,###.00 Kg");
		return df.format(value);
	}
}
