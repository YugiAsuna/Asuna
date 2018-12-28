package SaveServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.asuna.bean.Book;
import com.asuna.bean.JdbcUtil;
import com.asuna.bean.Lendbook;
import com.asuna.bean.Reader;

import dao.AllBookDao;
import dao.LendBooksDao;

@WebServlet("/LendBooksFind")//注释
public class LendBooksFind extends HttpServlet {

	
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	String barCode = request.getParameter("barCode");
	String rno = (String)request.getSession().getAttribute("RNO");//从Session对象中获得用户学号/工号
	System.out.println(barCode);
	System.out.println(rno);
	LendBooksDao lendBooksDao = new LendBooksDao();
	try {
		
		
		Reader judgemin = lendBooksDao.judgemin(rno);
		if(judgemin.getCanLendNum() >0) {
			Book query_book = lendBooksDao.query_book(barCode);
			if(query_book.getLendNum() == 0) {
				lendBooksDao.change_state(barCode);
			}
			if(query_book.getLendNum() > 0) {
				lendBooksDao.change_state_b(barCode);
			}
		
			String book_Name = query_book.getbName();
			System.out.println(book_Name);
			lendBooksDao.lend_incream(barCode);
			int insert_add = lendBooksDao.insert_add(rno,book_Name);
			
			lendBooksDao.reader_people(rno);
			lendBooksDao.reader_people_1(rno);	
			request.getRequestDispatcher("lendSuccess.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("lendFailure.jsp").forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
