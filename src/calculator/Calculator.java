package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class Calculator {

	public JFrame frmCalculator;
	public JTextField txtField;
	private JTextField calc;
	
	double firstNumber = 0;
	double secondNumber = 0;
	double result;
	int operatorCount;
	String operator;
	String operatorStorage;
	String answer;
	String calcString = " ";
	private JTextField textAns;
	private JTextField txtAnswer;
	double number;
	private JTextField txtM1;
	private JTextField txtM2;
	private JTextField M1Field;
	private JTextField M2Field;
	double Memory1;
	double Memory2;
	int memoryCount;
	boolean equalsClick;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Calculator() {
		initialize();
	}

	//Frame Contents
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.getContentPane().setBackground(new Color(220, 220, 220));
		frmCalculator.setBounds(100, 100, 470, 615);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		Image icon = Toolkit.getDefaultToolkit().getImage("calculator-outline.png");
	    frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rhyde\\eclipse-workspace\\Calculator_Main\\img\\calculator-outline.png"));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		
		calc = new JTextField();
		calc.setForeground(new Color(0, 0, 0));
		calc.setBackground(new Color(255, 255, 255));
		calc.setEditable(false);
		calc.setFont(new Font("Tahoma", Font.BOLD, 16));
		calc.setHorizontalAlignment(SwingConstants.RIGHT);
		calc.setBounds(24, 16, 396, 26);
		calc.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frmCalculator.getContentPane().add(calc);
		calc.setColumns(10);
		
		txtM1 = new JTextField();
		txtM1.setText("M1:");
		txtM1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtM1.setEditable(false);
		txtM1.setColumns(10);
		txtM1.setBackground(Color.WHITE);
		txtM1.setBounds(27, 89, 36, 26);
		frmCalculator.getContentPane().add(txtM1);
		txtM1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		txtM2 = new JTextField();
		txtM2.setText("M2:");
		txtM2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtM2.setEditable(false);
		txtM2.setColumns(10);
		txtM2.setBackground(Color.WHITE);
		txtM2.setBounds(121, 89, 36, 26);
		frmCalculator.getContentPane().add(txtM2);
		txtM2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		M1Field = new JTextField();
		M1Field.setHorizontalAlignment(SwingConstants.RIGHT);
		M1Field.setEditable(false);
		M1Field.setColumns(10);
		M1Field.setBackground(Color.WHITE);
		M1Field.setBounds(62, 89, 45, 26);
		frmCalculator.getContentPane().add(M1Field);
		M1Field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		M2Field = new JTextField();
		M2Field.setHorizontalAlignment(SwingConstants.RIGHT);
		M2Field.setEditable(false);
		M2Field.setColumns(10);
		M2Field.setBackground(Color.WHITE);
		M2Field.setBounds(156, 89, 45, 26);
		frmCalculator.getContentPane().add(M2Field);
		M2Field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		txtAnswer = new JTextField();
		txtAnswer.setBackground(new Color(255, 255, 255));
		txtAnswer.setEditable(false);
		txtAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAnswer.setText("Answer:");
		txtAnswer.setColumns(10);
		txtAnswer.setBounds(285, 89, 69, 26);
		txtAnswer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frmCalculator.getContentPane().add(txtAnswer);
		
		textAns = new JTextField();
		textAns.setBackground(new Color(255, 255, 255));
		textAns.setEditable(false);
		textAns.setHorizontalAlignment(SwingConstants.RIGHT);
		textAns.setBounds(351, 89, 69, 26);
		textAns.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frmCalculator.getContentPane().add(textAns);
		textAns.setColumns(10);
		btnClear.setBackground(new Color(211, 211, 211));
		btnClear.setFont(new Font("Arial", Font.PLAIN, 20));
		btnClear.setBounds(15, 251, 206, 50);
		frmCalculator.getContentPane().add(btnClear);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Calculator.class.getResource("/img/backspace.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backspace();
			}
		});
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(226, 251, 100, 50);
		frmCalculator.getContentPane().add(btnBack);
		
		JButton btnDivide = new JButton("");
		btnDivide.setIcon(new ImageIcon(Calculator.class.getResource("/img/divide.png")));
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorCount++;
				divide();
			}
		});
		btnDivide.setBackground(new Color(211, 211, 211));
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDivide.setBounds(331, 251, 100, 50);
		frmCalculator.getContentPane().add(btnDivide);
		
		//Number 7 button
		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(255, 255, 255));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newEq();
				String DisplayString = txtField.getText() + btn7.getText();
				txtField.setText(DisplayString);
			}
		});
		btn7.setFont(new Font("Arial", Font.PLAIN, 21));
		btn7.setBounds(15, 307, 100, 50);
		frmCalculator.getContentPane().add(btn7);
		
		//Number 8 button
		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(255, 255, 255));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newEq();
				String DisplayString = txtField.getText() + btn8.getText();
				txtField.setText(DisplayString);
			}
		});
		btn8.setFont(new Font("Arial", Font.PLAIN, 21));
		btn8.setBounds(121, 307, 100, 50);
		frmCalculator.getContentPane().add(btn8);
		
		//Number 9 button
		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(255, 255, 255));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn9.getText();
				txtField.setText(DisplayString);
			}
		});
		btn9.setFont(new Font("Arial", Font.PLAIN, 21));
		btn9.setBounds(226, 307, 100, 50);
		frmCalculator.getContentPane().add(btn9);
		
		JButton btnMultiply = new JButton("");
		btnMultiply.setIcon(new ImageIcon(Calculator.class.getResource("/img/multiply (1).png")));
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorCount++;
				multiply();
			}
		});
		btnMultiply.setBackground(new Color(211, 211, 211));
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMultiply.setBounds(331, 307, 100, 50);
		frmCalculator.getContentPane().add(btnMultiply);
		
		//Number 4 button
		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(255, 255, 255));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn4.getText();
				txtField.setText(DisplayString);
			}
		});
		btn4.setFont(new Font("Arial", Font.PLAIN, 21));
		btn4.setBounds(15, 364, 100, 50);
		frmCalculator.getContentPane().add(btn4);
		
		//number 5 Button
		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(255, 255, 255));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn5.getText();
				txtField.setText(DisplayString);
			}
		});
		btn5.setFont(new Font("Arial", Font.PLAIN, 21));
		btn5.setBounds(121, 364, 100, 50);
		frmCalculator.getContentPane().add(btn5);
		
		//Number 6 button
		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(255, 255, 255));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn6.getText();
				txtField.setText(DisplayString);
			}
		});
		btn6.setFont(new Font("Arial", Font.PLAIN, 21));
		btn6.setBounds(226, 364, 100, 50);
		frmCalculator.getContentPane().add(btn6);
		
		JButton btnMinus = new JButton("");
		btnMinus.setIcon(new ImageIcon(Calculator.class.getResource("/img/substract.png")));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorCount++;
				minus();
			}
		});
		btnMinus.setBackground(new Color(211, 211, 211));
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMinus.setBounds(331, 364, 100, 50);
		frmCalculator.getContentPane().add(btnMinus);
		
		//Number 1 button
		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(255, 255, 255));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn1.getText();
				txtField.setText(DisplayString);
			}
		});
		btn1.setFont(new Font("Arial", Font.PLAIN, 21));
		btn1.setBounds(15, 420, 100, 50);
		frmCalculator.getContentPane().add(btn1);
		
		//Number 2 button
		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(255, 255, 255));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn2.getText();
				txtField.setText(DisplayString);
			}
		});
		btn2.setFont(new Font("Arial", Font.PLAIN, 21));
		btn2.setBounds(121, 420, 100, 50);
		frmCalculator.getContentPane().add(btn2);
		
		//Number 3 button
		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(255, 255, 255));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn3.getText();
				txtField.setText(DisplayString);
			}
		});
		btn3.setFont(new Font("Arial", Font.PLAIN, 21));
		btn3.setBounds(226, 420, 100, 50);
		frmCalculator.getContentPane().add(btn3);
		
		JButton btnPlus = new JButton("");
		btnPlus.setIcon(new ImageIcon(Calculator.class.getResource("/img/add.png")));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorCount++;
				plus();
			}
		});
		btnPlus.setBackground(new Color(211, 211, 211));
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlus.setBounds(331, 420, 100, 50);
		frmCalculator.getContentPane().add(btnPlus);
		
		JButton btn0 = new JButton("0");
		btn0.setBackground(new Color(255, 255, 255));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				String DisplayString = txtField.getText() + btn0.getText();
				txtField.setText(DisplayString);
			}
		});
		btn0.setFont(new Font("Arial", Font.PLAIN, 21));
		btn0.setBounds(121, 475, 100, 50);
		frmCalculator.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.setForeground(Color.WHITE);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DisplayString = txtField.getText() + btnDot.getText();
				txtField.setText(DisplayString);
			}
		});
		btnDot.setBackground(new Color(211, 211, 211));
		btnDot.setFont(new Font("Arial", Font.BOLD, 26));
		btnDot.setBounds(226, 475, 100, 50);
		frmCalculator.getContentPane().add(btnDot);
		
		//Equals button
		JButton btnEquals = new JButton("");
		btnEquals.setIcon(new ImageIcon(Calculator.class.getResource("/img/equal.png")));
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equal();
			}
		});
		btnEquals.setBackground(new Color(211, 211, 211));
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEquals.setBounds(331, 475, 100, 50);
		frmCalculator.getContentPane().add(btnEquals);
		
		
		//Invert button (Positive Negative)
		JButton btnPosNeg = new JButton("+ -");
		btnPosNeg.setForeground(Color.WHITE);
		btnPosNeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double invert = Double.parseDouble(String.valueOf(txtField.getText()));
				invert = invert * (-1);
				txtField.setText(String.valueOf(invert));
			}
		});
		btnPosNeg.setBackground(new Color(211, 211, 211));
		btnPosNeg.setFont(new Font("Arial", Font.PLAIN, 22));
		btnPosNeg.setBounds(15, 475, 100, 50);
		frmCalculator.getContentPane().add(btnPosNeg);
		
		//Mod button
		JButton btnMod = new JButton("Mod");
		btnMod.setForeground(Color.WHITE);
		btnMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					operatorCount++;
					mod();
				}
		});
		btnMod.setFont(new Font("Arial", Font.PLAIN, 20));
		btnMod.setBackground(new Color(211, 211, 211));
		btnMod.setBounds(15, 193, 100, 50);
		frmCalculator.getContentPane().add(btnMod);
		
		JButton btnMem1 = new JButton("M1");
		btnMem1.setBackground(new Color(244, 164, 96));
		btnMem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtField.setText(Double.toString(Memory1));
			}
		});
		btnMem1.setBounds(259, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMem1);
		
		JButton btnMem2 = new JButton("M2");
		btnMem2.setBackground(new Color(244, 164, 96));
		btnMem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField.setText(Double.toString(Memory2));
			}
		});
		btnMem2.setBounds(347, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMem2);
		
		JButton btnMemClear = new JButton("MC");
		btnMemClear.setBackground(new Color(244, 164, 96));
		btnMemClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M1Field.setText(null);
				M2Field.setText(null);
				Memory1=0;
				Memory2=0;
				memoryCount=0;
				txtM1.setText(null);
				txtM2.setText(null);
			}
		});
		btnMemClear.setBounds(81, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMemClear);
		
		JButton btnMemAdd = new JButton("M+");
		btnMemAdd.setBackground(new Color(244, 164, 96));
		btnMemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoryCount++;
				if(memoryCount % 2 == 1) {
					Memory1 = Double.parseDouble(txtField.getText());
					M1Field.setText(Double.toString(Memory1));
					txtM1.setText("M1:");
				} else {
					Memory2 = Double.parseDouble(txtField.getText());
					M2Field.setText(Double.toString(Memory2));
					txtM2.setText("M2:");
				}
			}
		});
		btnMemAdd.setBounds(172, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMemAdd);
		
		txtField = new JTextField();
		txtField.setBackground(new Color(255, 255, 255));
		txtField.setEditable(false);
		txtField.setHorizontalAlignment(SwingConstants.RIGHT);
		txtField.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtField.setBounds(15, 38, 405, 50);
		frmCalculator.getContentPane().add(txtField);
		txtField.setColumns(10);
		txtField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(15, 16, 416, 109);
		frmCalculator.getContentPane().add(textPane);
		
		JButton btnRoot = new JButton("");
		btnRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				root();
			}
		});
		btnRoot.setIcon(new ImageIcon(Calculator.class.getResource("/img/square-root.png")));
		btnRoot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRoot.setBackground(new Color(211, 211, 211));
		btnRoot.setBounds(121, 193, 100, 50);
		frmCalculator.getContentPane().add(btnRoot);
		
		JButton btnPercent = new JButton("");
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnPercent.setIcon(new ImageIcon(Calculator.class.getResource("/img/percent.png")));
		btnPercent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPercent.setBackground(new Color(211, 211, 211));
		btnPercent.setBounds(226, 193, 100, 50);
		frmCalculator.getContentPane().add(btnPercent);
		
		JButton button = new JButton("2");
		button.setForeground(Color.WHITE);
		button.setIcon(new ImageIcon(Calculator.class.getResource("/img/multiply_small.png")));
		button.setFont(new Font("Arial", Font.PLAIN, 17));
		button.setBackground(new Color(211, 211, 211));
		button.setBounds(331, 193, 100, 50);
		frmCalculator.getContentPane().add(button);
	}
	
	//Functionality calls	
	public void backspace() {
		String bckSpace = null;
		
		if(txtField.getText().length()>0) {
			StringBuilder stringBuilder = new StringBuilder(txtField.getText());
			stringBuilder.deleteCharAt(txtField.getText().length()-1);
			bckSpace = stringBuilder.toString();
			txtField.setText(bckSpace);
		}
	}
	
	public void clear() {
		txtField.setText(null);
		calcString = "";
		calc.setText(null);
		textAns.setText(null);
		result = 0;
		answer = "";
		firstNumber = 0;
		secondNumber = 0;
		operatorCount = 0;
	}
	
	public void divide() {
		operatorStorage = operator;
		operator = "/";
		display();
		firstNumber = Double.parseDouble(txtField.getText());
		txtField.setText("");
	}
	
	public void multiply() {
		operatorStorage = operator;
		operator = "*";
		display();
		firstNumber = Double.parseDouble(txtField.getText());
		txtField.setText("");
	}
	
	public void minus() {
		operatorStorage = operator;
		operator = "-";
		display();
		firstNumber = Double.parseDouble(txtField.getText());	
		txtField.setText("");
	}
	
	public void plus() {
		operatorStorage = operator;
		operator = "+";
		display();
		firstNumber = Double.parseDouble(txtField.getText());
		txtField.setText("");
		
	}
	
	public void mod() {
		operatorStorage = operator;
		operator = "%";
		display();
		firstNumber = Double.parseDouble(txtField.getText());
		txtField.setText("");
	}
	
	public void root() {
		number = Double.parseDouble(txtField.getText());
		calcString = "\u221A" + number; 
		calc.setText(calcString);
		result = Math.sqrt(number);
		answer = String.format("%.2f", result);
		txtField.setText(answer);
		equalsClick = true;
	}
	
	
	public void display() {
		String stringResult;
		txtAnswer.setText("Answer:");
		
		//Calculation Display Field
		number = Double.parseDouble(txtField.getText());
		if(operatorStorage == "\u221A") {
			calcString = calcString + " " + operatorStorage + " " + number; 
			calc.setText(calcString);
		} else {
			calcString = calcString + " " + number + " " + operator; 
			calc.setText(calcString);
		}
		
		
		//Answer Display Field
		System.out.println("Operator Count: " + operatorCount);
		if(operatorCount == 1) {
			String numberString = Double.toString(number);
			textAns.setText(numberString);
		} else {
			firstNumber = Double.parseDouble(textAns.getText());
			switch (operatorStorage) {
			case "+":
				result = firstNumber + number;
				break;
			case "-":
				result = firstNumber - number;
				break;
			case "/":
				result = firstNumber / number;
				break;
			case "*":
				result = firstNumber * number;
				break;
			case "%":
				result = firstNumber % number;
				break;
			}
			stringResult = Double.toString(result);
			textAns.setText(stringResult);
		}
	}
	
	public void newEq() {
		if(equalsClick == true) {
			txtField.setText(null);
			calc.setText(null);
			calcString = " ";
			equalsClick = false;
		}
	}
	
	public void equal() {
		secondNumber = Double.parseDouble(txtField.getText());
		calcString = calcString + " " + secondNumber;
		
		
		firstNumber = Double.parseDouble(textAns.getText());
		switch (operator) {
			case "+":
				result = firstNumber + secondNumber;
				answer = String.format("%.2f", result);
				txtField.setText(answer);
				break;
			case "-":
				result = firstNumber - secondNumber;
				answer = String.format("%.2f", result);
				txtField.setText(answer);
				break;
			case "/":
				result = firstNumber / secondNumber;
				answer = String.format("%.2f", result);
				txtField.setText(answer);
				break;
			case "*":
				result = firstNumber * secondNumber;
				answer = String.format("%.2f", result);
				txtField.setText(answer);
				break;
			case "%":
				result = firstNumber % secondNumber;
				answer = String.format("%.2f", result);
				txtField.setText(answer);
				break;
			case "":
				calcString = " ";
				break;
		}
		equalsClick = true;
		calc.setText(calcString);
		textAns.setText(null);
		txtAnswer.setText(null);
		result = 0;
		answer = "";
		firstNumber = 0;
		secondNumber = 0;
		operatorCount = 0;
	}
}
