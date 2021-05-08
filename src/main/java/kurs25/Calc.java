package kurs25;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //���������� �������� � URL
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/output.jsp").forward(request, response);
		
	}
	
	public static class RequestCalc {
		public final String sizeMortgage;
		public final String firstPay;
		public final String data;
		public final String target;
		public static String strahovka;
		public static String currency;
		private double result;
		static double first_result;
		static double second_result;
		static double data_result;
						
		private RequestCalc (String sizeMortgage, String firstPay, String data, String target, String strahovka, String currency) {
			this.sizeMortgage = sizeMortgage;
			this.firstPay = firstPay;
			this.data = data;
			this.target = target;
			RequestCalc.strahovka = strahovka;
			RequestCalc.currency = currency;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("sizeMortgage"),
			request.getParameter("firstPay"),
			request.getParameter("data"),
			request.getParameter("target"),
			request.getParameter("strahovka"),
			request.getParameter("currency")
			);
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", sizeMortgage);
			request.setAttribute("second_result", firstPay);
			request.setAttribute("data_result", data);
			if (target.equals("ready house")) {
				request.setAttribute("target_result", "Готовое жилье");
			} else if (target.equals("new house")) {
				request.setAttribute("target_result", "Новостройка");
			} else {
				request.setAttribute("target_result", "Коммерческая");
			}
			if (strahovka.equals("No")) {
				request.setAttribute("strahovka_result", "Нет");
			} else {
				request.setAttribute("strahovka_result", "Есть");
			}
			if (currency.equals("Dollar")) {
				request.setAttribute("currency_result", "Доллар");
				request.setAttribute("currency_for_result", "Долларов ежемесячно");
			} else if (strahovka.equals("Rub")) {
				request.setAttribute("currency_result", "Рубль");
				request.setAttribute("currency_for_result", "Рублей ежемесячно");
			} else {
				request.setAttribute("currency_result", "Евро");
				request.setAttribute("currency_for_result", "Евро ежемесячно");
			}
			
			
			try { 
			first_result=Double.parseDouble(sizeMortgage);
			second_result=Double.parseDouble(firstPay);
			data_result=Double.parseDouble(data);
			}
			catch (NumberFormatException e) {
				first_result=0;
				second_result=0;
				data_result=0;
			}
			
			
			if (second_result < 0 || first_result <= 0) {
				result = 0;
			}
			if (target.equals("ready house")) {
				CalculationRH calculation = new CalculationRH();
				request.setAttribute("result", calculation.res);
			}
			if (target.equals("new house")) {
				CalculationNH calculation = new CalculationNH();
				request.setAttribute("result", calculation.res);
			}
			if (target.equals("commercial")) {
				CalculationC calculation = new CalculationC();
				request.setAttribute("result", calculation.res);
			}
		}
		
	}
	
	
}
