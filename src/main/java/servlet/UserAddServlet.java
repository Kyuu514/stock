package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.userDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/user-add-servlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
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
		String checkpass = request.getParameter("checkpass");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");
		RequestDispatcher rd;
		if(checkpass != password) {
			String mes = "パスワードが一致していません";
			request.setAttribute("mes", mes);
			rd = request.getRequestDispatcher("add_check.jsp");
			rd.forward(request, response);
		}
		String role = "1";
		Random random = new Random();
		String user_id;
		userDAO userDao = new userDAO();
		
		while(true) {
			char alphabet = (char)('A' + random.nextInt(26));
			String number = String.format("%04d", random.nextInt(10000));
			user_id = alphabet + number;
			
			try {
				boolean result = userDao.select(user_id);
				if(result == false) {
					break;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		UserBean userBean = new UserBean();
		userBean.setUser_id(user_id);
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setRole(role);
		
		try {
			int count = userDao.userEntry(userBean);
			if(count == 1) {
				request.setAttribute("user_id", user_id);
				rd = request.getRequestDispatcher("add_result.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
