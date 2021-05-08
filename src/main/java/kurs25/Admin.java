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
import java.util.Properties;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Admin", urlPatterns="/JavaAdmin")
public class Admin extends HttpServlet {

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				InputStream ins = getServletContext().getResourceAsStream("/WEB-INF/resource/password");
				if (ins == null) {
		            System.out.println("Failed in reading file");
		        } else {
		            BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
		            String word = br.readLine();
		            if (word.equals(request.getParameter("password"))) {
		            	request.setAttribute("incorrect", "");
		            	request.setAttribute("changes", "<label for=\"changes\" class=\"changes__text\"> Настройка ставки :</label>\n"
		            			+ "                <input type=\"submit\" name=\"sign\" value=\"�?зменить\" class=\"changes__submit input\">");
		            	request.setAttribute("display", "none");
		            	request.setAttribute("admin", "<div class=\"header__form\">\n"
		            			+ "                <label for=\"\" class=\"header__text\">Режим администратора</label>\n"
		            			+ "                <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");
		            	
						}else {
						request.setAttribute("incorrect", "Не правильный пароль");
						request.setAttribute("changes", "");
						
					}
		        }
				
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		}
			
		}


