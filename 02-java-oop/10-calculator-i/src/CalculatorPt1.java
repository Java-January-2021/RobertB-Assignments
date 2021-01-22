
public class CalculatorPt1 {
	private double number1;
	private double number2;
	private double results;
	private char operator;
	
	public double getNumber1(){
		return this.number1;
	}
	public void setNumber1(double number1) {
		this.number1 = number1;
	}
	
	public double getNumber2() {
		return this.number2;
	}
	public void setNumber2(double number2) {
		this.number2 = number2;
	}
	
	public double getResults() {
		return this.results;
	}
	public void getResults(double results) {
		this.results = results;
	}
	
	public char getOperator() {
		return this.operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public void doOperation() {
		if(this.operator == '+') {
			results = (number1 + number2);
			System.out.println(number1 + " + " + number2 + " equals " + results);
		}
		else if(this.operator == '-') {
			results = (number1 - number2);
			System.out.println(number1 + operator + number2 + "equals" + results);
		}
	}
	public void findResults() {
		System.out.println(results);
	}
}