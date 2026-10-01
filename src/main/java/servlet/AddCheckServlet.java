package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCheckServlet
 */
@WebServlet("/add-check-servlet")
public class AddCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mes = null;
		RequestDispatcher rd;
		
		if(name.length() > 40 || name.length() < 2) {
			mes = "名前は2～40字で入力してください。";
			request.setAttribute("mes", mes);
			rd = request.getRequestDispatcher("user_add.jsp");
			rd.forward(request, response);
		}
		if(password.length() > 18 || password.length() < 5) {
			mes = "パスワードは5～18字で入力してください。";
			request.setAttribute("mes", mes);
			rd = request.getRequestDispatcher("user_add.jsp");
			rd.forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("password", password);
		
		rd = request.getRequestDispatcher("add_check.jsp");
		rd.forward(request, response);
	}

}
