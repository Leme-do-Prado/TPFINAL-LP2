import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class Form extends Frame implements ActionListener {
	int i = 0;
	JFrame f;
	Label lblNome = new Label("Nome: "), lblIdade = new Label("Idade: "), lblPeso = new Label("Peso: "), lblAltura = new Label("Altura: "), lblObjetivo = new Label("Objetivo: ");
	TextField tfNomeAluno = new TextField(), tfIdadeAluno = new TextField(), tfPesoAluno = new TextField(), tfAlturaAluno = new TextField(), tfObjetivoAluno = new TextField();
	Button btIncluir = new Button("Incluir"), btLimpar = new Button("Limpar"), btApresentaDados = new Button("Apresenta Dados"), btSair = new Button("Sair");
	
	Form(String titulo, int largura, int altura, int colinic, int lininic){
		super(titulo);
		addWindowListener(new FechaJanela());
		setSize(largura,altura);
		setLocation(colinic,lininic);
		setLayout(new BorderLayout());
		
		Panel Panel1 = new Panel();
		Panel1.setLayout(new GridLayout(5, 2));
		Panel1.add(lblNome);
		Panel1.add(tfNomeAluno);
		Panel1.add(lblIdade);
		Panel1.add(tfIdadeAluno);
		Panel1.add(lblAltura);
		Panel1.add(tfAlturaAluno);
		Panel1.add(lblPeso);
		Panel1.add(tfPesoAluno);
		Panel1.add(lblObjetivo);
		Panel1.add(tfObjetivoAluno);
		add(Panel1, BorderLayout.NORTH);
		
		Panel Panel2 = new Panel();
		Panel2.setLayout(new FlowLayout());
		Panel2.add(btIncluir);
		Panel2.add(btLimpar);
		Panel2.add(btApresentaDados);
		Panel2.add(btSair);
		add(Panel2, BorderLayout.CENTER);
		
		btIncluir.addActionListener(this);
		btSair.addActionListener(this);
		btLimpar.addActionListener(this); 
		btApresentaDados.addActionListener(this);
		}
	
	public void ExibidorJson(String jsonConvert){
		f = new JFrame();
		JOptionPane.showMessageDialog(f, jsonConvert);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btIncluir) {
			String nome = tfNomeAluno.getText();
			int idade = Integer.parseInt(tfIdadeAluno.getText());
			float altura = Float.parseFloat(tfAlturaAluno.getText());
			float peso = Float.parseFloat(tfPesoAluno.getText());
			String objetivo = tfObjetivoAluno.getText();
			new Aluno(nome, idade, altura, peso, objetivo).insereAlunoDatabase();
		} else if(e.getSource()==btSair) {
			dispose(); 
			System.exit(0);
		} else if(e.getSource()==btLimpar) {
			tfNomeAluno.setText(null);
			tfIdadeAluno.setText(null);
			tfAlturaAluno.setText(null);
			tfPesoAluno.setText(null);
			tfObjetivoAluno.setText(null);
			
		} else if(e.getSource()==btApresentaDados) {
			String nome = tfNomeAluno.getText();
			int idade = Integer.parseInt(tfIdadeAluno.getText());
			float altura = Float.parseFloat(tfAlturaAluno.getText());
			float peso = Float.parseFloat(tfPesoAluno.getText());
			String objetivo = tfObjetivoAluno.getText();
			Gson gson = new Gson();
			String jsonConvert = gson.toJson(new Aluno(nome, idade, altura, peso, objetivo));
			ExibidorJson(jsonConvert);
		}
		
	}
	
}

