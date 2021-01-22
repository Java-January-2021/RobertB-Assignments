
public class CalculatorController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorPt1 problem = new CalculatorPt1();
		
		problem.setNumber1(10.5);
		problem.setNumber2(5.2);
		problem.setOperator('+');
		problem.doOperation();
		problem.findResults();
	}

}
