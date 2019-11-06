package Main;

import javax.swing.SwingUtilities;

import Componentes.Abas;
import janela.Janela;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Janela janela =  new Janela();
				janela.show();
            }
        });
	}
	
}