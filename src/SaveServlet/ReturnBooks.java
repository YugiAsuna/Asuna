package SaveServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asuna.bean.Book;
import com.asuna.bean.Reader;

import dao.LendBooksDao;
import dao.ReturnBooksDao;

@WebServlet("/ReturnBooks")//注释

public class ReturnBooks extends HttpServlet {
	
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String barCode = request.getParameter("returnbarCode");
	String rno = (String)request.getSession().getAttribute("RNO");//从Session对象中获得用户学号/工号
	System.out.println(barCode);
	System.out.println(rno);
	ReturnBooksDao returnBooksDao = new ReturnBooksDao();
	try {
		
		
		Reader judgemin = returnBooksDao.judgemin(rno);
		System.out.println(judgemin);
		if(judgemin.getLendNum() >0) {
			Book query_book = returnBooksDao.query_book(barCode);
			if(query_book.getLendNum() == 0) {
				returnBooksDao.change_state(barCode);
			}
			if(query_book.getLendNum() > 0) {
				returnBooksDao.change_state_b(barCode);
			}
		
			String book_Name = query_book.getbName();
			System.out.println(book_Name);
			returnBooksDao.lendNum_desease(barCode);
			

			returnBooksDao.reader_people(rno);
			returnBooksDao.reader_people_1(rno);	
			request.getRequestDispatcher("returnSuccess.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("returnFailure.jsp").forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
