package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.asuna.bean.Book;
import com.asuna.bean.JdbcUtil;
import com.asuna.bean.Lendbook;
import com.asuna.bean.Reader;

import SaveServlet.LendBookServlet;

public class AllReaderDao {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
	public List<Reader> getAllReaders() throws SQLException{
		String sql = "select * from reader";
		List<Reader> allreaders = null;
		allreaders = queryRunner.query(sql, new BeanListHandler<Reader>(Reader.class));
		return allreaders;
	}
	public List<Lendbook> getAllLendBooks() throws SQLException{
		String sql = "select * from reader";
		List<Lendbook> allLendBooks = null;
		allLendBooks = queryRunner.query(sql, new BeanListHandler<Lendbook>(Lendbook.class));
		return allLendBooks;
	}

}
