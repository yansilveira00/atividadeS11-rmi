import java.rmi.*;
 
public interface Hello extends Remote {
   public int multiplica(int a, int b) throws RemoteException;
}