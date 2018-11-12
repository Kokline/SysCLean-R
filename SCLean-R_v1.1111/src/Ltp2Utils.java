import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ltp2Utils {
	static Scanner leia = new Scanner(System.in);

	int a;
	float b;
	String c;
	char d;

	// INT-----
	public static int recebeInt(String txt) {
		System.out.print(txt);
		return leia.nextInt();
	}
	
	//Recebe uma String qualquer, captura uma String, converte em inteiro e catch se possui apenas inteiros e retorna inteiro.
	public static int recebeIntValidoMenu (String txt) {
		int numero=0;
		boolean valido;

		do {
			System.out.println("Escolha uma opção: ");
			txt = leia.nextLine();
				try{
					numero = Integer.parseInt(txt);
					System.out.println(txt);
					valido = true;

				} catch (NumberFormatException E){
					System.out.println("O texto digitado não pode ser convertido em numero! Digite Novamente.");
					valido = false;
				}
			} while (!valido);
			return 	numero;
		}		

	//Recebe uma String qualquer, captura uma String, converte em inteiro, catch se tem apenas numeros e retorna a String numerica.
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
			return 	Integer.toString(numero);
		}
	
	//FLOAT-----
	public static float recebeFloat(String txt) {
		System.out.print(txt);
		return leia.nextInt();
	}

	// CHAR-----
	public static char recebeChar(String txt) {
		System.out.print(txt);
		return leia.next().charAt(0);
	}

	public static char recebeCharLowerCase(String txt) {
		System.out.print(txt);
		return leia.next().toLowerCase().charAt(0);
	}

	public static char recebeCharUpperCase(String txt) {
		System.out.print(txt);
		return leia.next().toUpperCase().charAt(0);
	}

	// STRING-----
	public static String recebeString(String txt) {
		String valor = "";

		System.out.println(txt);
		valor = leia.nextLine();

		if (!valor.equals("")) {
			return valor;
		} else {
			// Para caso o buffer tiver cheio (Limpar o buffer)
			return leia.nextLine();
		}
	}

	public static String recebeStringLowerCase(String txt) {
		System.out.print(txt);
		return leia.nextLine().toLowerCase();
	}

	public static String recebeStringUpperCase(String txt) {
		System.out.print(txt);
		return leia.nextLine().toUpperCase();
	}

	public static String capitalize(String texto) {
		// Trocar todo o texto para minusculo
		texto = texto.toLowerCase();

		// Variável Auxiliar
		String novoTexto = "";

		// Pega a primeira letra, converte na tabela ASCII
		// e depois faz o typecast para mostrar a letra novamente
		novoTexto += (char) (texto.charAt(0) - 32);

		for (int i = 1; i < texto.length(); i++) {
			if (texto.charAt(i - 1) == ' ') {
				novoTexto += (char) (texto.charAt(i) - 32);
			} else {
				novoTexto += texto.charAt(i);
			}
		}

		return novoTexto;
	}

	// BOOL-----
	public static boolean confirmaSaida() {
		char resp;

		do {
			resp = recebeCharUpperCase("\nDeseja continuar (S/N): ");

			if (resp == 'S') {
				return true;
			} else if (resp == 'N') {
				return false;
			} else {
				System.out.println("Valor requerido S ou N: ");
			}

		} while (true);
	}

	// NUMBERS-----
	public static boolean validarNumeroPositivo(float num) {
		boolean bool = true;

		if (num > 0) {
			bool = true;
		} else {
			bool = false;
		}

		return bool;
	}

	// DATE--------
	public static String getTime() {
		String date = "";

		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yy HH:mm");
		date = formatador.format(data);

		return date;
	}

	public static String getBetweenDates() {
		String date = "";
		// COMPARISON BETWEEN DATES
		Date dt = new Date("05/09/18 12:45");
		Date dt2 = new Date("05/09/18 12:40");

		if (dt.after(dt2)) {
			System.out.println("DT é antes!");
		} else {
			System.out.println("DT2 é antes!");
		}

		// System.out.println(dt);

		return date;
	}
	
	//Verifica se tem numeros, letras, a quantidade de digitos do cpf e retorna String numerica do cpf.
	public static String verificaCPF (String cpf) {
		int numero=0;
		boolean valido;
		
		do {
			System.out.println("Digite o CPF: ");
			cpf = leia.nextLine();
				try{
					numero = Integer.parseInt(cpf);
					System.out.println(cpf);
					valido = true;

				} catch (NumberFormatException E){
					System.out.println(cpf);
					System.out.println("O CPF são apenas numeros! Digite Novamente.");
					valido = false;
				}
			} while (!valido && !validarCpf(cpf));
		
			return 	Integer.toString(numero);
		}
	
	//Valida cpf por quantidade de numeros ou repetições incoerentes deles
	public static boolean validarCpf(String cpf) {
		int contador=0;
		
		for (int i = 0; i < cpf.length(); i++) {
			if (Character.isDigit(i)) {
				contador = contador++;
			}
		}
		
		if (contador != 11) {
			System.out.println("O CPF precisa ter 11 caracteres. Seu CPF possui: " +cpf.length() +".");
			return false;
		} else {
			for (int i = 0; i < 11; i++) {
				//Verificar se os dígitos são iguais
				if (cpf.charAt(0) == cpf.charAt(i)) {
					return false;
				} else {
					return true;
				}
			}
		}

		return true;
	}

	//Opções para estados.
	public enum Estados {

		RO(11,"Rondônia"),
		AC(12,"Acre"),
		AM(13,"Amazonas"),
		RR(14,"Roraima"),
		PA(15,"Pará"),
		AP(16,"Amapá"),
		TO(17,"Tocantins"),
		MA(21,"Maranhão"),
		PI(22,"Piauí"),
		CE(23,"Ceará"),
		RN(24,"Rio Grande do Norte"),
		PB(25,"Paraíba"),
		PE(26,"Pernambuco"),
		AL(27,"Alagoas"),
		SE(28,"Sergipe"),
		BA(29,"Bahia"),
		MG(31,"Minas Gerais"),
		ES(32,"Espírito Santo"),
		RJ(33,"Rio de Janeiro"),
		SP(35,"São Paulo"),
		PR(41,"Paraná"),
		SC(42,"Santa Catarina"),
		RS(43,"Rio Grande do Sul"),
		MS(50,"Mato Grosso do Sul"),
		MT(51,"Mato Grosso"),
		GO(52,"Goiás"),
		DF(53,"Distrito Federal");

		private final int codigoIbge;
		private final String nome;

		private Estados(int codigoIbge,String nome) {
			this.codigoIbge = codigoIbge;
			this.nome = nome;
		}
		
		public String getCodigo() {
			return Integer.toString(codigoIbge);
		}
		
		public String getNome(){
			return nome;
		}
		
		public int getCodigoIbge(){
			return codigoIbge;
		}
	}
}