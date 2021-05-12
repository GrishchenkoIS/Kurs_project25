package kurs25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") // URL
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		try {
			File file = new File("Stavka");
	        //���������, ��� ���� ���� �� ���������� �� ������� ���
	        if(!file.exists()){
	            file.createNewFile();
	          //PrintWriter ��������� ����������� ������ � ����
		        FileWriter out = new FileWriter(file.getAbsoluteFile(), false);
		        try {
		            //���������� ����� � ����
		            out.write("8.3" + "\n" + "8.6" + "\n" + "7.3" + "\n");
		        } finally {
		            //����� ���� �� ������ ������� ����
		            //����� ���� �� ���������
		            out.close();
		        }
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
		InputStream ins = getServletContext().getResourceAsStream("Stavka");
		if (ins == null) {
            System.out.println("Failed in reading file");
        } else {
            BufferedReader br = new BufferedReader(new FileReader("Stavka"));
            String word;
            while ((word = br.readLine()) != null) {
            	Calc.stavka.add(word);
            }
        }
		
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/output.jsp").forward(request, response);
		Calc.stavka.clear();
		
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
				request.setAttribute("target_result", "������� �����");
			} else if (target.equals("new house")) {
				request.setAttribute("target_result", "�����������");
			} else {
				request.setAttribute("target_result", "�������������");
			}
			if (strahovka.equals("No")) {
				request.setAttribute("strahovka_result", "���");
			} else {
				request.setAttribute("strahovka_result", "����");
			}
			if (currency.equals("dollar")) {
				request.setAttribute("currency_result", "�������");
				request.setAttribute("currency_for_result", "��������� ����������");
			} else if (currency.equals("rub")) {
				request.setAttribute("currency_result", "�����");
				request.setAttribute("currency_for_result", "������ ����������");
			} else {
				request.setAttribute("currency_result", "����");
				request.setAttribute("currency_for_result", "���� ����������");
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
	
	
}
