package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.JTextPane;

public class Calculator {

	public JFrame frmCalculator;
	public JTextField txtField;
	private JTextField calc;
	
	//Variables-----------------------------------------
	double firstNumber = 0; //used in final ..
	double secondNumber = 0; //.. equals calculation
	
	double result; //varies to dbAnswer in that display() compares the two
	double Memory1; //storage
	double Memory2; //storage
	double number;
	double dbAnswer = 0.0; //main storage for calculations
	int operatorCount; //counter
	int memoryCount; //counter
	int dotCount; //counter
	String operator;
	String operatorStorage;
	String answer;
	String calcString = " ";
	
	boolean equalsClick; //.. All
	boolean square; //represent
	boolean root; //flags
	boolean emptyString; //requiring a reaction ..
	
	private JTextField textAns;
	private JTextField txtAnswer;
	private JTextField txtM1;
	private JTextField txtM2;
	private JTextField M1Field;
	private JTextField M2Field;
	
	

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
		frmCalculator.setBounds(100, 100, 463, 579);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
	    frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("/img/calculator-outline.png")));		
		
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
		textAns.setText("-");
		
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
			
		
		//---------------------------------Clear and Back Button----------------------------------------
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Calculator.class.getResource("/img/backspace.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backspace();
			}
		});
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(226, 194, 205, 50);
		frmCalculator.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBackground(new Color(211, 211, 211));
		btnClear.setFont(new Font("Arial", Font.PLAIN, 20));
		btnClear.setBounds(15, 194, 206, 50);
		frmCalculator.getContentPane().add(btnClear);
		
		//---------------------------------Operator Buttons----------------------------------------------
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
		
		
		
		JButton btnPlus = new JButton("");
		btnPlus.setIcon(new ImageIcon(Calculator.class.getResource("/img/add.png")));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEq();
				operatorCount++;
				plus();
			}
		});
		btnPlus.setBackground(new Color(211, 211, 211));
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlus.setBounds(331, 420, 100, 50);
		frmCalculator.getContentPane().add(btnPlus);
		
		//Equals button
		JButton btnEquals = new JButton("");
		btnEquals.setIcon(new ImageIcon(Calculator.class.getResource("/img/equal.png")));
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equal(); //calls equals function
			}
		});
		btnEquals.setBackground(new Color(211, 211, 211));
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEquals.setBounds(331, 475, 100, 50);
		frmCalculator.getContentPane().add(btnEquals);
		
		//Invert button (Positive Negative)
		//Switches the displayed value between its inverse value
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
		btnMod.setBounds(15, 251, 100, 50);
		frmCalculator.getContentPane().add(btnMod);
		
		
		//Square Root button
		JButton btnRoot = new JButton("");
		btnRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				root();
			}
		});
		btnRoot.setIcon(new ImageIcon(Calculator.class.getResource("/img/square-root.png")));
		btnRoot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRoot.setBackground(new Color(211, 211, 211));
		btnRoot.setBounds(121, 251, 100, 50);
		frmCalculator.getContentPane().add(btnRoot);
		
		//Square function button
		JButton btnSquared = new JButton("\u00B2");
		btnSquared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				square();
			}
		});
		btnSquared.setForeground(Color.WHITE);
		btnSquared.setIcon(new ImageIcon(Calculator.class.getResource("/img/multiply_small.png")));
		btnSquared.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSquared.setBackground(new Color(211, 211, 211));
		btnSquared.setBounds(226, 251, 100, 50);
		frmCalculator.getContentPane().add(btnSquared);
		
		//---------------------------------Number Buttons------------------------------------------------
		//Number 0 button
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
		
		//Decimal point button
		JButton btnDot = new JButton(".");
		btnDot.setForeground(Color.WHITE);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dotCount++;
				if(dotCount == 1) {
					String DisplayString = txtField.getText() + btnDot.getText();
					txtField.setText(DisplayString);
				}				
			}
		});
		btnDot.setBackground(new Color(211, 211, 211));
		btnDot.setFont(new Font("Arial", Font.BOLD, 26));
		btnDot.setBounds(226, 475, 100, 50);
		frmCalculator.getContentPane().add(btnDot);
		
		//-----------------------------------Memory buttons-------------------------------------------
		
		//M1 and M2 will push a stored value onto the display
		JButton btnMem1 = new JButton("M1");
		btnMem1.setBackground(new Color(244, 164, 96));
		btnMem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtField.setText(Double.toString(Memory1)); //push to display
			}
		});
		btnMem1.setBounds(259, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMem1);

		JButton btnMem2 = new JButton("M2");
		btnMem2.setBackground(new Color(244, 164, 96));
		btnMem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField.setText(Double.toString(Memory2)); //push to display
			}
		});
		btnMem2.setBounds(347, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMem2);

		//MC will reset all values associated with storing memory
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
					try {
						Memory1 = Double.parseDouble(txtField.getText());
						M1Field.setText(Double.toString(Memory1));
						txtM1.setText("M1:");
					} catch (NumberFormatException | NullPointerException ex) {
						memoryCount = 0;
						equalsClick = true;
						textAns.setText("No Value");
						txtAnswer.setText("Error:");
						dbAnswer = 0.0;
						operatorCount = 0;
						newEq();
					}
				} else {
					try {
						Memory2 = Double.parseDouble(txtField.getText());
						M2Field.setText(Double.toString(Memory2));
						txtM2.setText("M2:");
					} catch (NumberFormatException | NullPointerException ex) {
						memoryCount = 0;
						equalsClick = true;
						textAns.setText("No Value");
						txtAnswer.setText("Error:");
						dbAnswer = 0.0;
						operatorCount = 0;
						newEq();
					}
				}
			}
		});
		btnMemAdd.setBounds(172, 148, 84, 29);
		frmCalculator.getContentPane().add(btnMemAdd);		
	}
	
	//---------------------------------------Functionality calls----------------------------------------------------------	
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
		dotCount = 0;
		dbAnswer = 0;
		txtAnswer.setText(null);
	}
	
	public void divide() {
		try {
			dotCount = 0;
			operatorStorage = operator;
			operator = "/";
			display();
			firstNumber = Double.parseDouble(txtField.getText());
			txtField.setText("");
		} catch (NumberFormatException | NullPointerException ex) {
			operatorCount = 0;
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}	
		
	}
	
	public void multiply() {
		try {
			dotCount = 0;
			operatorStorage = operator;
			operator = "*";
			display();
			firstNumber = Double.parseDouble(txtField.getText());
			txtField.setText("");
		} catch (NumberFormatException | NullPointerException ex) {
			operatorCount = 0;
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}		
	}
	
	public void minus() {
		try {
			dotCount = 0;
			operatorStorage = operator;
			operator = "-";
			display();
			firstNumber = Double.parseDouble(txtField.getText());	
			txtField.setText("");
		} catch (NumberFormatException | NullPointerException ex) {
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}
		
	}
	
	public void plus() {
		try {
			dotCount = 0;
			operatorStorage = operator;
			operator = "+";
			display();
			txtField.setText("");
		} catch (NumberFormatException | NullPointerException ex) {
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}		
	}
	
	public void mod() {
		try {
			operatorStorage = operator;
			operator = " mod ";
			display();
			txtField.setText("");
		} catch (NumberFormatException | NullPointerException ex) {
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}		
	}
	
	public void root() {
		try {
			number = Double.parseDouble(txtField.getText());
			operatorStorage = operator;
			operator = "\u221A"; //Unicode ROOT
			calcString = calcString + "(" + "\u221A" + number + ")";
			calc.setText(calcString);
			result = Math.sqrt(number);
			answer = String.format("%.2f", result);
			txtField.setText(answer);
			textAns.setText(answer);
			txtAnswer.setText("Answer:");
			root = true;
		} catch (NumberFormatException | NullPointerException ex) {
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}		
	}
	
	public void square() {
		try {
			number = Double.parseDouble(txtField.getText());
			operatorStorage = operator;
			operator = "\u00B2"; //Unicode SUBSCRIPT 2
			calcString = calcString + "(" + number + ")" + "\u00B2";
			calc.setText(calcString);
			result = number * number;
			answer = String.format("%.2f", result);
			txtField.setText(answer);
			textAns.setText(answer);
			txtAnswer.setText("Answer:");
			square = true;
		} catch (NumberFormatException | NullPointerException ex) {
			equalsClick= true;
			textAns.setText("No Value");
			txtAnswer.setText("Error:");
			newEq();
		}
	}
	
	public void display() {
		String stringResult;
		
			//Calculation Display Field
			//The Square root and squared function have different displays to normal functions
			number = Double.parseDouble(txtField.getText());
			if(root == true) {
				calcString = calcString + " " + operator; 
				calc.setText(calcString);
				root = false;
			} else if (square == true){
				calcString = calcString + " " + operator; 
				calc.setText(calcString);
				square = false;
			}	else {
				calcString = calcString + " " + number + " " + operator; 
				calc.setText(calcString);
			}
			
			
			//Answer Display Field
			if(operatorCount == 1) {
				String numberString = Double.toString(number);
				textAns.setText(numberString);
			} else {
				switch (operatorStorage) {
				case "+":
					result = dbAnswer + number;
					break;
				case "-":
					result = dbAnswer - number;
					break;
				case "/":
					if(operatorCount == 1) {
						dbAnswer = 1;
					}
					result = dbAnswer / number;
					break;
				case "*":
					if(operatorCount == 1) {
						dbAnswer = 1;
					}
					result = dbAnswer * number;
					break;
				case " mod ":
					result = dbAnswer % number;
					break;
				}
				
				stringResult = Double.toString(result);
				textAns.setText(stringResult);
				
			}
			txtAnswer.setText("Answer:");
			dbAnswer = Double.parseDouble(textAns.getText());
		
	}
	
	//This is a check to make sure the last input was not an equals
	//If it was it resets all displays
	public void newEq() {
		if(equalsClick == true) {
			txtField.setText(null);
			calc.setText(null);
			calcString = " ";
			equalsClick = false; 	
		}
	}
	
	//Equal method varies from display in that after calculation
	//all screens and relevant variables are reset
	public void equal() {
		try {
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
				case " mod ":
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
		} catch (NumberFormatException | NullPointerException ex) {
			equalsClick= true;
			newEq();
		}
		
	}
}
