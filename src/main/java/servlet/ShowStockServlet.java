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
import model.dao.stockDAO;
import model.entity.CategoryBean;
import model.entity.StockCategoryBean;

/**
 * Servlet implementation class ShowStockServlet
 */
@WebServlet("/show-stock-servlet")
public class ShowStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStockServlet() {
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
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		
		stockDAO stDAO = new stockDAO();
		List<StockCategoryBean>stockList = stDAO.stockList(user_id);
		session.setAttribute("stockList", stockList);
		
		categoryDAO catDao = new categoryDAO();
		List<CategoryBean>catList = catDao.categoryList(user_id);
		session.setAttribute("catList", catList);
		
		RequestDispatcher rd = request.getRequestDispatcher("show_stock.jsp");
		rd.forward(request, response);
	}

}
