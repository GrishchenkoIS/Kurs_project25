package kurs25;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Admin", urlPatterns="/JavaAdmin")
public class Admin extends HttpServlet {

		public static int status = 2 ;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				InputStream ins = getServletContext().getResourceAsStream("password");
				if (ins == null) {
		            System.out.println("Failed in reading file");
		        } else {
		            BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
		            String word;
		            
		            while ((word = br.readLine()) != null) {
		            	word = br.readLine();
		            	String[] check = word.split(" ");
		            	if (check[0].equals(request.getParameter("login"))) {
		            		String[] words = word.split(" ");
		           
		            		if (words[0].equals(request.getParameter("login")) && words[1].equals(request.getParameter("password")) && words[2].equals("1")) {
				            	request.setAttribute("incorrect", "");
				            	request.setAttribute("changes", "<label for=\"changes\" class=\"changes__text\"> Изменить ставку :</label>\n"
				            			+ "                <input type=\"submit\" name=\"sign\" value=\"Изменить\" class=\"changes__submit input\">");
				            	request.setAttribute("display", "none");
				            	request.setAttribute("admin", "<div class=\"header__form\">\n"
				            			+ "                <label for=\"\" class=\"header__text\"> Здравствуйте администратор</label>\n"
				            			+ "                <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");
				            	status = 1;
				            	request.getRequestDispatcher("/index.jsp").forward(request, response);
								}else if (words[0].equals(request.getParameter("login")) && words[1].equals(request.getParameter("password")) && words[2].equals("0")) {
									request.setAttribute("incorrect", "");
					            	request.setAttribute("display", "none");
					            	request.setAttribute("admin", "<div class=\"header__form\">\n"
					            			+ "                <label for=\"\" class=\"header__text\"> Здравствуйте пользователь</label>\n"
					            			+ "                <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");
					            	status = 0;
					            	request.getRequestDispatcher("/index.jsp").forward(request, response);
								    break;
								 } else {
									request.setAttribute("incorrect", "Не верный логин или пароль");
									request.setAttribute("changes", "");
								
							}
		          
		            	} else {
		            		request.setAttribute("incorrect", "Не верный логин или пароль");
							request.setAttribute("changes", "");
							request.getRequestDispatcher("/author.jsp").forward(request, response);
							break;
		            	}
		        }
		        }	
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
			
			
			
		
			
		}
}


