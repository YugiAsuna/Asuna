package SaveServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InfoDao;

@WebServlet("/UpdateInfo")//注释
public class UpdateInfo extends HttpServlet {
 @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		String rno = (String) session.getAttribute("RNO");//获得用户更改后的信息
		
		String newPassword = request.getParameter("newPassword");
		InfoDao infoDao = new InfoDao();
		try {
			infoDao.changeInfo(rno,newPassword);
			System.out.println("调用完成");
			request.getRequestDispatcher("pwdChangeSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
}
}
