package kurs25;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class CalculationNH extends Calculator {
	double res;
	public CalculationNH() {
		
		res = FlodPoint(Calculator());
	}
	public static double FlodPoint(double value) {
		value = Math.round(value * 100);
		value = value/100;
		return value;
	}
	
	@Override
	public Double Calculator() {
		double sum = Calc.RequestCalc.first_result - Calc.RequestCalc.second_result;
		rate = 8.6;
		if (Strahovka().equals("Exist")) {
			rate = rate - 1;
		}
		rate = rate/12/100/12;
		if (Calc.RequestCalc.data_result == 0 || sum == 0) {
			return (double) 0;
		}else {
		pay = rate * Math.pow(1+rate, Calc.RequestCalc.data_result)/(Math.pow(1+rate, Calc.RequestCalc.data_result)-1)*(Calc.RequestCalc.first_result+Calc.RequestCalc.second_result);
		}
		return pay;
	}
	@Override
	public boolean IsDouble(String d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInteger(String d) {
		// TODO Auto-generated method stub
		return false;
	}

	public String Strahovka() {
		String info = (String) Calc.RequestCalc.strahovka;
		return info;
	};


	

	

}
