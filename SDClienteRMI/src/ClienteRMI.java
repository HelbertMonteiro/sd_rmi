

import java.applet.Applet;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteRMI extends Applet{

    public String enviar(String m) throws RemoteException{
        
        System.setSecurityManager(new RMISecurityManager());

        String URL = "//192.168.43.220:1099/ControleRMI";
        
        try {
            InterfaceRMI interfaceRMI = (InterfaceRMI) Naming.lookup(URL);
            return interfaceRMI.NOrdenados(m);
        } catch (HeadlessException | MalformedURLException | NotBoundException | RemoteException erro) {
            System.out.println("Erro em cliente: " + erro.getMessage());
            return null;
        }
    }
}
