package kurs25;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="Back", urlPatterns="/Back")
public class Back extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ( Admin.status == 1 ) {
			request.setAttribute("incorrect", "");
			request.setAttribute("changes", "<label for=\"changes\" class=\"changes__text\"> Настройка ставки :</label>\n"
					+ "                <input type=\"submit\" name=\"sign\" value=\"Изменить\" class=\"changes__submit input\">");
			request.setAttribute("display", "none");
			request.setAttribute("admin", "<div class=\"header__form\">\n"
					+ "                <label for=\"\" class=\"header__text\"> Здравсвуйте администратор</label>\n"
					+ "                <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");
			
		} else if (Admin.status == 0) {
			request.setAttribute("incorrect", "");
			request.setAttribute("display", "none");
			request.setAttribute("admin", "<div class=\"header__form\">\n"
					+ "                <label for=\"\" class=\"header__text\"> Здравствуйте пользователь</label>\n"
					+ "                <input type=\"submit\" name=\"sign\" value=\"Выйти\" class=\"header__input input\"></div>");
			
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
