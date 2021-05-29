package kurs25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="Change", urlPatterns="/JavaToChange")
public class Changes extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File currentClass = new File(URLDecoder.decode(Changes.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath(), "UTF-8"));
	
		String filepath = currentClass.getParent();
		File currentClass2 = new File(URLDecoder.decode(filepath, "UTF-8"));
		filepath = currentClass2.getParent();
		
		List<String> stavka = new ArrayList<String>();
		
		InputStream ins = new FileInputStream(filepath + "/Stavka");
		if (ins == null) {
            System.out.println("Failed in reading file");
        } else {
            BufferedReader br = new BufferedReader(new FileReader(filepath + "/Stavka"));
            String word;
            while ((word = br.readLine()) != null) {
            	stavka.add(word);
            }
        }
		request.setAttribute("stavkaRH", stavka.get(0));
		request.setAttribute("stavkaNH", stavka.get(1));
		request.setAttribute("stavkaC", stavka.get(2));
		request.getRequestDispatcher("/changes.jsp").forward(request, response);
	}
	

}
