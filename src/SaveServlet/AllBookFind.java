package SaveServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.asuna.bean.Book;
import com.asuna.bean.JdbcUtil;

import dao.AllBookDao;

@WebServlet("/AllBookFind")//注释
public class AllBookFind extends HttpServlet {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	AllBookDao allBookDao = new AllBookDao();
	 List<Book> list = null;
	try {
		list = allBookDao.getAllBooks();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("list", list);
	req.getRequestDispatcher("/R_function/AllBookInfo.jsp").forward(req, resp);
}
}
