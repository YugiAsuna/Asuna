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

import com.asuna.bean.JdbcUtil;
import com.asuna.bean.Lendbook;
import com.asuna.bean.Reader;

import dao.AllReaderDao;

@WebServlet("/AllReaderFind")//注释
public class AllReaderFind extends HttpServlet {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	AllReaderDao allReaderDao = new AllReaderDao();
	 List<Reader> list = null;
	 List<Lendbook> list2 = null;
	try {
		list = allReaderDao.getAllReaders();
		list2 = allReaderDao.getAllLendBooks();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("list", list);
	req.setAttribute("list2", list2);
	req.getRequestDispatcher("/R_function/ReaderInfo.jsp").forward(req, resp);
}
}
