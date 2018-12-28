package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.asuna.bean.Book;
import com.asuna.bean.JdbcUtil;

public class AllBookDao {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
	public List<Book> getAllBooks() throws SQLException{
		String sql = "select * from books";
		List<Book> allbooks = null;
		allbooks = queryRunner.query(sql, new BeanListHandler<Book>(Book.class));
		return allbooks;
	}

}
