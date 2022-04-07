import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int a,b,multiplicacao;
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			Hello stub= (Hello) registry.lookup("Servidor");

			System.out.println("Invocando metodo do server");
			
			System.out.println("Digite o primeiro n°: ");
			a = read.nextInt();
			
			System.out.println("Digite o segundo n°: ");
			b = read.nextInt();
			
			multiplicacao = stub.multiplica(a, b);
			System.out.println("Server: O valor da multiplicação é  " + multiplicacao);
			
			read.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}