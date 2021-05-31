package kurs25;

import java.io.FileWriter;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="Exit", urlPatterns="/JavaExit")
public class Exit extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin.status = 2;
		request.getRequestDispatcher("/author.jsp").forward(request, response);
	}
	}
