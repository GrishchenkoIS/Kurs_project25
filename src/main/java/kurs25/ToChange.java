package kurs25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="ToChange", urlPatterns="/JavaChange")
public class ToChange extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		write("Stavka", request.getParameter("StReadyHouse") + "\n" + request.getParameter("StNewHouse") + "\n" +request.getParameter("StComercial"));
		if ( Admin.status == 1 ) {
			request.setAttribute("incorrect", "");
			request.setAttribute("changes", "<label for=\"changes\" class=\"changes__text\"> ��������� ������ :</label>\n"
					+ "                <input type=\"submit\" name=\"sign\" value=\"��������\" class=\"changes__submit input\">");
			request.setAttribute("display", "none");
			request.setAttribute("admin", "<div class=\"header__form\">\n"
					+ "                <label for=\"\" class=\"header__text\"> ����������� �������������</label>\n"
					+ "                <input type=\"submit\" name=\"sign\" value=\"�����\" class=\"header__input input\"></div>");
			
		} else if (Admin.status == 0) {
			request.setAttribute("incorrect", "");
			request.setAttribute("display", "none");
			request.setAttribute("admin", "<div class=\"header__form\">\n"
					+ "                <label for=\"\" class=\"header__text\"> ����������� ������������</label>\n"
					+ "                <input type=\"submit\" name=\"sign\" value=\"�����\" class=\"header__input input\"></div>");
			
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	public static void write(String fileName, String text) {
	    //���������� ����
	    File file = new File(fileName);

	    try {
	        //���������, ��� ���� ���� �� ���������� �� ������� ���
	        if(!file.exists()){
	            file.createNewFile();
	        }

	        //PrintWriter ��������� ������������ ������ � ����
	        FileWriter out = new FileWriter(file.getAbsoluteFile(), false);

	        try {
	            //���������� ����� � ����
	            out.write(text);
	        } finally {
	            //����� ���� �� ������ ������� ����
	            //����� ���� �� ��������� 
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	

}