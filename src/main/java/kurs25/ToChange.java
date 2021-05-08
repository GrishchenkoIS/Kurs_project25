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
		
		write(getServletContext().getResourceAsStream("/WEB-INF/resource/Stavka").toString(), request.getParameter("StReadyHouse") + "\n" + request.getParameter("StNewHouse") + "\n" +request.getParameter("StComercial"));
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	public static void write(String fileName, String text) {
	    //Определяем файл
	    File file = new File(fileName);

	    try {
	        //проверяем, что если файл не существует то создаем его
	        if(!file.exists()){
	            file.createNewFile();
	        }

	        //PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());

	        try {
	            //Записываем текст у файл
	            out.print(text);
	        } finally {
	            //После чего мы должны закрыть файл
	            //�?наче файл не запишется
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	

}
