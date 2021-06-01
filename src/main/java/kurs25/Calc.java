package kurs25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import kurs25.CreatePDF;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦ Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦Р С—РЎвЂ”Р вЂ¦ Р С—РЎвЂ”Р вЂ¦ URL
public class Calc extends HttpServlet {
	
	public static String creditAmount;
	public static String firstPayPDF;
	public static String paymentPerMonth;
	public static String purposeOfTheLoan;
	public static String currencyPDF;
	public static String strahovkaPDF;
	public static String dataPDF;
	private static double result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		
		File currentClass = new File(URLDecoder.decode(Calc.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath(), "UTF-8"));
	
		String filepath = currentClass.getParent();
		File currentClass2 = new File(URLDecoder.decode(filepath, "UTF-8"));
		filepath = currentClass2.getParent();
		
		InputStream ins = new FileInputStream(filepath + "/Stavka");
		if (ins == null) {
            System.out.println("Failed in reading file");
        } else {
            BufferedReader br = new BufferedReader(new FileReader(filepath + "/Stavka"));
            String word;
            while ((word = br.readLine()) != null) {
            	Calc.stavka.add(word);
            }
        }
		
		Calc.setAsRequestAttributesAndCalculate(request);
		if (result <= 0) {
			request.setAttribute("incorrect", "Данные некорректны");
			if ( Admin.status == 1 ) {

				request.setAttribute("changes", "<label for=\"changes\" class=\"changes__text\"> Настройка ставки :</label>\n"
						+ " <input type=\"submit\" name=\"sign\" value=\"Изменить\" class=\"changes__submit input\">");
				request.setAttribute("display", "none");
				request.setAttribute("admin", "<div class=\"header__form\">\n"
						+ " <label for=\"\" class=\"header__text\"> Здравствуйте администратор</label>\n"
						+ " <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");

			} else if (Admin.status == 0) {

				request.setAttribute("display", "none");
				request.setAttribute("admin", "<div class=\"header__form\">\n"
						+ " <label for=\"\" class=\"header__text\"> Здравствуйте пользователь</label>\n"
						+ " <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");

			}
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

		 if ((Admin.status == 0) || (Admin.status == 1)) {
			 request.getRequestDispatcher("/output.jsp").forward(request, response);
				Calc.stavka.clear();
				
				CreatePDF PDF = new CreatePDF();
				String goals = "Hello";
				PDF.Create(goals);
		 } else {
			 request.getRequestDispatcher("/author.jsp").forward(request, response);
		 }
		
		
	}
	
	public static class RequestCalc {
		public final String sizeMortgage;
		public final String firstPay;
		public final String data;
		public final String target;
		public static String strahovka;
		public static String currency;
		static double first_result;
		static double second_result;
		static double data_result;
		static List<String> stavka = new ArrayList<String>();
						
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
				request.setAttribute("target_result", "Коммерческое");
			}
			if (strahovka.equals("No")) {
				request.setAttribute("strahovka_result", "Нет");
			} else {
				request.setAttribute("strahovka_result", "Есть");
			}
			if (currency.equals("dollar")) {
				request.setAttribute("currency_result", "Доллар");
				request.setAttribute("currency_for_result", "Долларов ежемесячно");
			} else if (currency.equals("rub")) {
				request.setAttribute("currency_result", "Рубль");
				request.setAttribute("currency_for_result", "Рублей ежемесячно");
			} else {
				request.setAttribute("currency_result", "Евро");
				request.setAttribute("currency_for_result", "Евро ежемесячно");
			}
			
			
			try { 
			first_result=Double.parseDouble(sizeMortgage);
			
			}
			catch (NumberFormatException e) {
				first_result=0;
				request.setAttribute("first_result", 0);
			}
			try {
				second_result=Double.parseDouble(firstPay);
			} catch (NumberFormatException e) {
				second_result=0;
				request.setAttribute("second_result", 0);
			}
			try {
				data_result=Double.parseDouble(data);
			} catch (NumberFormatException e) {
				data_result=0;
				request.setAttribute("data_result", 0);
			}
			if (second_result < 0 || first_result <= 0) {
				result = 0;
				request.setAttribute("result", result);
			} else {
				if (target.equals("ready house")) {
					CalculationRH calculation = new CalculationRH();
					request.setAttribute("result", calculation.res);
					result = calculation.res;
				}
				if (target.equals("new house")) {
					CalculationNH calculation = new CalculationNH();
					request.setAttribute("result", calculation.res);
					result = calculation.res;
				}
				if (target.equals("commercial")) {
					CalculationC calculation = new CalculationC();
					request.setAttribute("result", calculation.res);
					result = calculation.res;
				}
			}
			
			creditAmount = Double.toString(first_result);
			firstPayPDF = Double.toString(second_result);
			paymentPerMonth = Double.toString(result);
			purposeOfTheLoan = target;
			if (currency.equals("dollar")) {
				currencyPDF = "Dollar";
			} else if (currency.equals("rub")) {
				currencyPDF = "Rub";
			} else {
				currencyPDF = "Euro";
			}
			dataPDF = Double.toString(data_result);
			if (strahovka.equals("No")) {
				strahovkaPDF = "No";
			} else {
				strahovkaPDF = "Yes";
			} 
		}
	
	}
	
	
}
