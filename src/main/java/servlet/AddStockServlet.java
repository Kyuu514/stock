package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.categoryDAO;
import model.entity.CategoryBean;

/**
 * Servlet implementation class AddStockServlet
 */
@WebServlet("/add-stock-servlet")
public class AddStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStockServlet() {
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
		categoryDAO catDao = new categoryDAO();
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		List<CategoryBean>catList = catDao.categoryList(user_id);
		session.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("add_stock.jsp");
		rd.forward(request, response);
	}

}
