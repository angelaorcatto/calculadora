package calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfResult;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rbadicao = new JRadioButton("Adi\u00E7\u00E3o");
	JRadioButton rbsubtracao = new JRadioButton("Subtra\u00E7\u00E3o");
	JRadioButton rbmultiplicacao = new JRadioButton("Multiplica\u00E7\u00E3o");
	JRadioButton rbdivisao = new JRadioButton("Divis\u00E3o");
	CalculadoraMetodos cm = new CalculadoraMetodos();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 1");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmero.setBounds(10, 11, 79, 14);
		contentPane.add(lblNmero);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(99, 10, 86, 20);
		contentPane.add(tfNum1);
		tfNum1.setColumns(10);
		
		JLabel lblNmero_1 = new JLabel("N\u00FAmero 2");
		lblNmero_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmero_1.setBounds(10, 36, 79, 14);
		contentPane.add(lblNmero_1);
		
		tfNum2 = new JTextField();
		tfNum2.setColumns(10);
		tfNum2.setBounds(99, 41, 86, 20);
		contentPane.add(tfNum2);
		
		JComboBox cbOperacao = new JComboBox();
		cbOperacao.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				double num1;
				double num2;
				double total=0;
				
				
				num1 = Double.parseDouble(tfNum1.getText());
				num2 = Double.parseDouble(tfNum2.getText());
				
				cm.setValor1(num1);
				cm.setValor2(num2);
				
				if(cbOperacao.getSelectedIndex()==1){
					total = cm.adicao();
				}else if(cbOperacao.getSelectedIndex()==2){
					total = cm.subtracao();
				}else if(cbOperacao.getSelectedIndex()==3){
					total = cm.multiplicacao();
				}else if(cbOperacao.getSelectedIndex()==4){
					total = cm.divisao();
				}else{
					JOptionPane.showMessageDialog(null, "Não deu! Selecione uma opção.");
				}
				tfResult.setText(""+total);
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		cbOperacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Adi\u00E7\u00E3o", "Subtra\u00E7\u00E3o", "Multiplica\u00E7\u00E3o", "Divis\u00E3o"}));
		cbOperacao.setBounds(60, 86, 160, 20);
		contentPane.add(cbOperacao);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setBounds(61, 333, 79, 14);
		contentPane.add(lblResultado);
		
		tfResult = new JTextField();
		tfResult.setEditable(false);
		tfResult.setColumns(10);
		tfResult.setBounds(150, 332, 86, 20);
		contentPane.add(tfResult);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				
//				double num1;
//				double num2;
//				double total=0;
//				
//				
//				num1 = Double.parseDouble(tfNum1.getText());
//				num2 = Double.parseDouble(tfNum2.getText());
//				
//				
////				if(cbOperacao.getSelectedIndex()==1){
////					total = num1 + num2;
////				}else if(cbOperacao.getSelectedIndex()==2){
////					total = num1 - num2;
////				}else if(cbOperacao.getSelectedIndex()==3){
////					total = num1 * num2;
////				}else if(cbOperacao.getSelectedIndex()==4){
////					total = num1 / num2;
////				}else{
////					JOptionPane.showMessageDialog(null, "Não deu! Selecione uma opção.");
////				}
//				
				
//				if(rbadicao.isSelected()){
//					total = num1 + num2;
//				}else if(rbsubtracao.isSelected()){
//					total = num1 - num2;
//				}else if(rbmultiplicacao.isSelected()){
//					total = num1 * num2;
//				}else if(rbdivisao.isSelected()){
//					total = num1 / num2;
//				}
//				
				
//				
//				tfResult.setText(""+total);
			}
		});
		btnCalcular.setBounds(96, 265, 89, 23);
		contentPane.add(btnCalcular);
		
		
		buttonGroup.add(rbadicao);
		rbadicao.setSelected(true);
		rbadicao.setBounds(88, 123, 109, 23);
		contentPane.add(rbadicao);
		
		buttonGroup.add(rbsubtracao);
		rbsubtracao.setBounds(88, 151, 109, 23);
		contentPane.add(rbsubtracao);
		
		buttonGroup.add(rbmultiplicacao);
		rbmultiplicacao.setBounds(88, 177, 109, 23);
		contentPane.add(rbmultiplicacao);
	
		buttonGroup.add(rbdivisao);
		rbdivisao.setBounds(88, 203, 109, 23);
		contentPane.add(rbdivisao);
		
		table = new JTable();
		table.setBounds(235, 143, -72, 86);
		contentPane.add(table);
	}
}
