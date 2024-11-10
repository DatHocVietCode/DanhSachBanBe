package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import database.dbutils;

/**
 * Servlet implementation class ThemBanBe_servlet
 */
public class ThemBanBe_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemBanBe_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phoneNum = request.getParameter("phone");
		String university = request.getParameter("university");
		String address = request.getParameter("address");
		
		Object[] paObjects = {name, age, phoneNum, university, address};
		String query = "insert into BanBe (name, age, phoneNum, university, address) values (? ,? , ?, ?, ?)";
		int rowaffected = (int)dbutils.ExecPreparedStatement(query, paObjects, false);
		String message = "";
		if (rowaffected == 0) {
			message = "Error occured when adding new friend";
		}
		else {
			message = "You got new friend!";
		}
		request.getSession().setAttribute("message", message);
		response.sendRedirect("DanhSachBanBe.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
