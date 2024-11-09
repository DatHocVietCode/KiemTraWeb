package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

import DAO.MonHocDAO;
import beans.Khoa;
import beans.MonHoc;
import dbutil.dbutils;

/**
 * Servlet implementation class ThemSinhVien_servlet
 */
public class ThemMonHoc_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMonHoc_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MonHoc mh = new MonHoc(
					request.getParameter("maMH"),
					request.getParameter("tenMH"),
					Integer.parseInt(request.getParameter("stc")),
					new Khoa(Integer.parseInt(request.getParameter("khoaQL")), "")
				);
		boolean isValid = MonHocDAO.CheckInput(mh);
		
		String destination = "ThemMonHoc.jsp";
		String message = "default";
		if (isValid) {
			MonHocDAO.ThemMonHoc(mh);
			message = "Thêm môn học thành công!";
			destination = "HienThiMonHoc.jsp";
		}
		else {
			message = "Thêm môn học thất bại!";
		}
		request.getSession().setAttribute("message", message);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
