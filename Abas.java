package Janela;
package Componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;

import Componentes.Abas;
import Componentes.Menu;
import janela.Janela;

public class Janela extends JFrame{
	
	public Janela(){	
		setTitle("Janela1");
		setSize(450,350);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout();
	}
		
	private void setLayout() {
	
		Abas abas = new Abas();
		JTabbedPane abasLayout = abas.setLayout(Janela.this);
		
		
		Menu menu = new Menu(abas);
		
		setJMenuBar(menu.setLayout(Janela.this));
		add(abasLayout);

	}
}
// Menu
public class Menu {
	private Abas abas;
	
	public Menu() {
		
	}
	
	public Menu(Abas abas) {
		this.abas = abas; 
	}
	
	public JMenuBar setLayout(JFrame frame) {
		
		JMenuBar menu = new JMenuBar();
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem sair = new JMenuItem("Sair",KeyEvent.VK_I);
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		menuArquivo.add(sair);
		
		JMenu menuEditar = new JMenu("Editar");
		
		JMenuItem limparCampos = new JMenuItem("Limpar tudo");
		limparCampos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abas.clearTextFields();
			}
		});
		
		JCheckBoxMenuItem exibirMoedas = new JCheckBoxMenuItem("Exibir Moedas");
		exibirMoedas.setSelected(true);
		exibirMoedas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (exibirMoedas.isSelected()){
					abas.setVisibleTabs("Moeda", true);
				}
				else{
					abas.setVisibleTabs("Moeda", false);
				}
			}
		});
		
		JCheckBoxMenuItem exibirTemperaturas = new JCheckBoxMenuItem("Exibir Temperaturas");
		exibirTemperaturas.setSelected(true);
		exibirTemperaturas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (exibirTemperaturas.isSelected()){
					abas.setVisibleTabs("Temperatura", true);
				}
				else{
					abas.setVisibleTabs("Temperatura", false);
				}
			}
		});
		
		JCheckBoxMenuItem exibirComprimentos = new JCheckBoxMenuItem("Exibir Comprimentos");
		exibirComprimentos.setSelected(true);
		exibirComprimentos.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (exibirComprimentos.isSelected()){
					abas.setVisibleTabs("Comprimento", true);
				}
				else{
					abas.setVisibleTabs("Comprimento", false);
				}
			}
		});
		
		menuEditar.add(limparCampos);
		menuEditar.addSeparator();
		menuEditar.add(exibirMoedas);
		menuEditar.add(exibirTemperaturas);
		menuEditar.add(exibirComprimentos);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		JMenuItem desenvolvedores = new JMenuItem("Desenvolvedores",KeyEvent.VK_S);
		JMenuItem repositorioGit = new JMenuItem("Repositório do Git Hub",KeyEvent.VK_S);
		JMenuItem sobre = new JMenuItem("Sobre",KeyEvent.VK_S);
		
		menuAjuda.add(desenvolvedores);
		menuAjuda.add(repositorioGit);
		menuAjuda.add(sobre);
		
		menu.add(menuArquivo);
		menu.add(menuEditar);
		menu.add(menuAjuda);
		
		return menu;
	}
	
}
//Abas


public class Abas{
	private JPanel painelMoeda;
	private JPanel painelTemperatura;
	private JPanel painelComprimento;
	private JTabbedPane tabPane;
	private static List<JTextField> listaCampos = new ArrayList<JTextField>();
	
	public Abas(){	
		
	}
		
	public JTabbedPane setLayout(JFrame frame) {
		this.painelMoeda = criarPanelMoeda();
		this.painelTemperatura = criarPanelTemperatura();
		this.painelComprimento = criarPanelComprimento();
		
		tabPane = new JTabbedPane();
		setVisibleTabs("Moeda", true);
		setVisibleTabs("Temperatura", true);
		setVisibleTabs("Comprimento", true);
		
		return this.tabPane;
	}
	
	public void setVisibleTabs(String titulo, boolean visible){
		if (titulo == "Moeda" && visible == true){
			this.tabPane.addTab("Moeda", null, this.painelMoeda,"Conversão de moeda");
		}
		else if (titulo == "Temperatura" && visible == true){
			this.tabPane.addTab("Temperatura", null, this.painelTemperatura,"Conversão de temperatura");
		}
		else if (titulo == "Comprimento" && visible == true){
			this.tabPane.addTab("Comprimento", null, this.painelComprimento,"Conversão de comprimento");
		}
		else if (visible == false){
			this.tabPane.removeTabAt(this.tabPane.indexOfTab(titulo));
		}
	}
	
	public void LimparCampos(String titulo, boolean visible){
		if (titulo == "Moeda" && visible == true){
			this.tabPane.addTab("Moeda", null, this.painelMoeda,"Conversão de moeda");
		}
		else if (titulo == "Temperatura" && visible == true){
			this.tabPane.addTab("Temperatura", null, this.painelTemperatura,"Conversão de temperatura");
		}
		else if (titulo == "Comprimento" && visible == true){
			this.tabPane.addTab("Comprimento", null, this.painelComprimento,"Conversão de comprimento");
		}
		else if (visible == false){
			this.tabPane.removeTabAt(this.tabPane.indexOfTab(titulo));
		}
	}
	
    private static JPanel criarPanelMoeda() {
    	String itens [] = {"Real","Dolar","Euro"};
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
    	
    	JLabel labelDe = new JLabel("De");
    	labelDe.setBounds(35, 40, 50, 10);
		
		JComboBox<String> comboBoxDe = new JComboBox<String>(itens);
		comboBoxDe.setSelectedIndex(0);
		comboBoxDe.setBounds(45, 35, 100, 20);
    	
		JTextField campoDe = new JTextField(); 
		campoDe.setBounds(45, 55, 100, 20);
		listaCampos.add(campoDe);
		
		JLabel labelPara = new JLabel("Para");
    	labelPara.setBounds(200, 35, 50, 10);
		
		JComboBox<String> comboBoxPara = new JComboBox<String>(itens);
		comboBoxPara.setSelectedIndex(1);
		comboBoxPara.setBounds(235, 30, 100, 20);
				
		JTextField campoPara = new JTextField(); 
		campoPara.setBounds(235, 60, 100, 20);
		listaCampos.add(campoPara);
		
		JButton botaoConverter = new JButton("Converter"); 
		botaoConverter.setBounds(245, 100, 90, 20);
		botaoConverter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int de = comboBoxDe.getSelectedIndex();
				int para = comboBoxPara.getSelectedIndex();
				double valor = Double.parseDouble(campoDe.getText());
				double convertido = ConverterMoeda(valor, de, para);
				
				campoPara.setText("" + convertido);
			}
		});
		
		panel.add(labelDe);
		panel.add(comboBoxDe);
		panel.add(campoDe);
		panel.add(labelPara);
		panel.add(comboBoxPara);
		panel.add(campoPara);
		panel.add(botaoConverter);
		
    	return panel;
    }
    
    private static JPanel criarPanelTemperatura() {
    	String itens [] = {"Celsius","Kelvin","Fahrenheit"};
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
    	
    	JLabel labelDe = new JLabel("De");
    	labelDe.setBounds(30, 35, 50, 10);
		
		JComboBox<String> comboBoxDe = new JComboBox<String>(itens);
		comboBoxDe.setSelectedIndex(0);
		comboBoxDe.setBounds(50, 30, 100, 20);
    	
		JTextField campoDe = new JTextField(); 
		campoDe.setBounds(50, 60, 100, 20);
		listaCampos.add(campoDe);
		
		JLabel labelPara = new JLabel("Para");
    	labelPara.setBounds(200, 35, 50, 10);
		
		JComboBox<String> comboBoxPara = new JComboBox<String>(itens);
		comboBoxPara.setSelectedIndex(1);
		comboBoxPara.setBounds(235, 30, 100, 20);
				
		JTextField campoPara = new JTextField(); 
		campoPara.setBounds(235, 60, 100, 20);
		listaCampos.add(campoPara);
		
		JButton botaoConverter = new JButton("Converter"); 
		botaoConverter.setBounds(245, 100, 90, 20);
		botaoConverter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int de = comboBoxDe.getSelectedIndex();
				int para = comboBoxPara.getSelectedIndex();
				double valor = Double.parseDouble(campoDe.getText());
				double convertido = ConverterTemperatura(valor, de, para);
				
				campoPara.setText("" + convertido);
			}
		});
		
		panel.add(labelDe);
		panel.add(comboBoxDe);
		panel.add(campoDe);
		panel.add(labelPara);
		panel.add(comboBoxPara);
		panel.add(campoPara);
		panel.add(botaoConverter);
		
    	return panel;
    }
    
    private static JPanel criarPanelComprimento() {
    	String itens [] = {"Metro","Milímetro","Centímetro"};
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
    	
    	JLabel labelDe = new JLabel("De");
    	labelDe.setBounds(30, 35, 50, 10);
		
		JComboBox<String> comboBoxDe = new JComboBox<String>(itens);
		comboBoxDe.setSelectedIndex(0);
		comboBoxDe.setBounds(50, 30, 100, 20);
    	
		JTextField campoDe = new JTextField(); 
		campoDe.setBounds(50, 60, 100, 20);
		listaCampos.add(campoDe);
		
		JLabel labelPara = new JLabel("Para");
    		labelPara.setBounds(200, 35, 50, 10);
		
		JComboBox<String> comboBoxPara = new JComboBox<String>(itens);
		comboBoxPara.setSelectedIndex(1);
		comboBoxPara.setBounds(235, 30, 100, 20);
				
		JTextField campoPara = new JTextField(); 
		campoPara.setBounds(235, 60, 100, 20);
		listaCampos.add(campoPara);
		
		JButton botaoConverter = new JButton("Converter"); 
		botaoConverter.setBounds(245, 100, 90, 20);
		botaoConverter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int de = comboBoxDe.getSelectedIndex();
				int para = comboBoxPara.getSelectedIndex();
				double valor = Double.parseDouble(campoDe.getText());
				double convertido = ConverterComprimento(valor, de, para);
				
				campoPara.setText("" + convertido);
			}
		});
		
		panel.add(labelDe);
		panel.add(comboBoxDe);
		panel.add(campoDe);
		panel.add(labelPara);
		panel.add(comboBoxPara);
		panel.add(campoPara);
		panel.add(botaoConverter);
		
    	return panel;
    }
    
    private static double ConverterComprimento(double valor, int opcaoDe, int opcaoPara){

    	if (opcaoDe == 0 && opcaoPara == 1){
    		return (valor * 1000);
    	}
    	else if (opcaoDe == 1 && opcaoPara == 0){
    		return (valor / 1000);
    	}
    	else if (opcaoDe == 0 && opcaoPara == 2){
    		return (valor * 100);
    	}
    	else if (opcaoDe == 2 && opcaoPara == 0){
    		return (valor / 100);
    	}
    	else if (opcaoDe == 1 && opcaoPara == 2){
    		return (valor / 10);
    	}
    	else if (opcaoDe == 2 && opcaoPara == 1){
    		return (valor * 10);
    	}
    	return valor;
    }
    private static double ConverterTemperatura(double valor, int opcaoDe, int opcaoPara){
    	
    	if (opcaoDe == 0 && opcaoPara == 1){
    		return (valor + 273.15);
    	}
    	else if (opcaoDe == 1 && opcaoPara == 0){
    		return (valor - 273.15);
    	}
    	else if (opcaoDe == 0 && opcaoPara == 2){
    		return ((valor * 9/5) + 32);
    	}
    	else if (opcaoDe == 2 && opcaoPara == 0){
    		return ((valor - 32) * 5/9);
    	}
    	else if (opcaoDe == 1 && opcaoPara == 2){
    		return ((valor - 273.15) * 9/5 + 32);
    	}	
    	else if (opcaoDe == 2 && opcaoPara == 1){
    		return ((valor - 32) * 5/9 + 273.15);
    	}
    	return valor;
      }
    private static double ConverterMoeda(double valor, int opcaoDe, int opcaoPara){
    	
    	if (opcaoDe == 0 && opcaoPara == 1){
    		return (valor / 3.99);
    	}
    	else if (opcaoDe == 1 && opcaoPara == 0){
    		return (valor * 3.99);
    	}
    	else if (opcaoDe == 0 && opcaoPara == 2){
    		return (valor / 4.46);
    	}
    	else if (opcaoDe == 2 && opcaoPara == 0){
    		return (valor * 4.46);
    	}
    	else if (opcaoDe == 1 && opcaoPara == 2){
    		return (valor / 1.12);
    	}
    	else if (opcaoDe == 2 && opcaoPara == 1){
    		return (valor * 1.12);
    	}
    	return valor;
    }

    public void clearTextFields() {
		for (JTextField campo: listaCampos) {
			campo.setText("");
		}
	}
}