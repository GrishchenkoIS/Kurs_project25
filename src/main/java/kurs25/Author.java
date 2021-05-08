package kurs25;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletContext;

import kurs25sub.Calc.RequestCalc;


@WebServlet(name="Author", urlPatterns="/JavaPass")
public class Author extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		servletContext.getRequestDispatcher("/author.jsp").forward(request, response);
	}
	}
