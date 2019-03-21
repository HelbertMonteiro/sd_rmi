

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControleRMI extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI {
    
    private final JTextField ctDesordem, ctOrdem;
    private final JTextArea  ctBanco;
    private List<String> listaBanco;

    public ControleRMI(JTextField ctDesordem, JTextField ctOrdem, JTextArea ctBanco) throws java.rmi.RemoteException {
        super();
        this.ctDesordem = ctDesordem;
        this.ctOrdem    = ctOrdem;
        this.ctBanco    = ctBanco;
    }

    @Override
    public String NOrdenados(String desordem) throws java.rmi.RemoteException {
        listaBanco = new ArrayList<>();
        ctBanco.setText("");
        String ordem = new Ordem().ordenar(desordem);
        ctDesordem.setText(desordem);
        ctOrdem.setText(ordem);
        listaBanco = new Ordem().listaBanco();
        for(int i = 0; i < listaBanco.size(); i++){
            ctBanco.append("Lista " + (i + 1) + ": " + listaBanco.get(i).toString() + "\n");
        }
        return ordem;
    }

}
