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
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kurs25.Admin;
@WebServlet(name="ToChange", urlPatterns="/JavaChange")
public class ToChange extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File currentClass = new File(URLDecoder.decode(ToChange.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath(), "UTF-8"));
	
		String filepath = currentClass.getParent();
		File currentClass2 = new File(URLDecoder.decode(filepath, "UTF-8"));
		filepath = currentClass2.getParent();
		
		if ((IsDouble(request.getParameter("StReadyHouse"))) && (IsDouble(request.getParameter("StComercial")) && (IsDouble(request.getParameter("StNewHouse"))))) {
			write(filepath + "/Stavka", request.getParameter("StReadyHouse") + "\n" + request.getParameter("StNewHouse") + "\n" +request.getParameter("StComercial"));
		} else {
			request.setAttribute("incChanges", "�� ����� ������� ������");
		}
		
		if ( Admin.status == 1 ) {
			request.setAttribute("incorrect", "");
        	request.setAttribute("changes", "<label for=\"changes\" class=\"changes__text\"> �������� ������ :</label>\n"
        			+ "                <input type=\"submit\" name=\"sign\" value=\"��������\" class=\"changes__submit input\">");
        	request.setAttribute("display", "none");
        	request.setAttribute("admin", "<div class=\"header__form\">\n"
        			+ "                <label for=\"\" class=\"header__text\"> ������������ �������������</label>\n"
        			+ "                <input type=\"submit\" name=\"sign\" value=\"�����\" class=\"header__input input\"></div>");
        	
		} else if (Admin.status == 0) {
			request.setAttribute("incorrect", "");
        	request.setAttribute("display", "none");
        	request.setAttribute("admin", "<div class=\"header__form\">\n"
        			+ "                <label for=\"\" class=\"header__text\"> ������������ �������������</label>\n"
        			+ "                <input type=\"submit\" name=\"sign\" value=\"�����\" class=\"header__input input\"></div>");
        	
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	public static void write(String fileName, String text) {
	    //Р С›Р С—РЎР‚Р ВµР Т�Р ВµР В»РЎРЏР ВµР С� РЎвЂћР В°Р в„–Р В»
	    File file = new File(fileName);

	    try {
	        //Р С—РЎР‚Р С•Р Р†Р ВµРЎР‚РЎРЏР ВµР С�, РЎвЂЎРЎвЂљР С• Р ВµРЎРѓР В»Р С� РЎвЂћР В°Р в„–Р В» Р Р…Р Вµ РЎРѓРЎС“РЎвЂ°Р ВµРЎРѓРЎвЂљР Р†РЎС“Р ВµРЎвЂљ РЎвЂљР С• РЎРѓР С•Р В·Р Т�Р В°Р ВµР С� Р ВµР С–Р С•
	        if(!file.exists()){
	            file.createNewFile();
	        }

	        //PrintWriter Р С•Р В±Р ВµРЎРѓР С—Р ВµРЎвЂЎР С�РЎвЂљ Р Р†Р С•Р В·Р С�Р С•Р В¶Р Р…Р С•РЎРѓРЎвЂљР С� Р В·Р В°Р С—Р С�РЎРѓР С� Р Р† РЎвЂћР В°Р в„–Р В»
	        FileWriter out = new FileWriter(file.getAbsoluteFile(), false);

	        try {
	            //Р вЂ”Р В°Р С—Р С�РЎРѓРЎвЂ№Р Р†Р В°Р ВµР С� РЎвЂљР ВµР С”РЎРѓРЎвЂљ РЎС“ РЎвЂћР В°Р в„–Р В»
	            out.write(text);
	        } finally {
	            //Р СџР С•РЎРѓР В»Р Вµ РЎвЂЎР ВµР С–Р С• Р С�РЎвЂ№ Р Т�Р С•Р В»Р В¶Р Р…РЎвЂ№ Р В·Р В°Р С”РЎР‚РЎвЂ№РЎвЂљРЎРЉ РЎвЂћР В°Р в„–Р В»
	            //Р пїЅР Р…Р В°РЎвЂЎР Вµ РЎвЂћР В°Р в„–Р В» Р Р…Р Вµ Р В·Р В°Р С—Р С�РЎв‚¬Р ВµРЎвЂљРЎРѓРЎРЏ
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	public boolean IsDouble(String d) {
		try {
			Double.parseDouble(d);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	

}
