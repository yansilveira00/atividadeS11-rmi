import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer implements Hello {
	
	public static void main(String[] args) {
		try {
			HelloServer server = new HelloServer();
			//Exporta o server para o stub do RMI na porta 0
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Server inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	public int multiplica(int a, int b) throws RemoteException {
		System.out.println("Executando o método neste host, fazendo a multiplicação dos três numeros");
		
		int multiplicacao = a*b;
		
		return multiplicacao;
	}
}