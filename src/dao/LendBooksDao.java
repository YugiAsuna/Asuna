package dao;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.asuna.bean.Book;
import com.asuna.bean.BookSort;
import com.asuna.bean.JdbcUtil;
import com.asuna.bean.Lendbook;
import com.asuna.bean.Reader;

import SaveServlet.returnBookServlet;

public class LendBooksDao {

	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	
	public List<Lendbook> getLendBooks() throws SQLException{
		
		
		
		
		String sql = "select * from lendbooks";
		List<Lendbook> lendbooks = null;
		lendbooks = queryRunner.query(sql, new BeanListHandler<Lendbook>(Lendbook.class));
		return lendbooks;
	}
	

	public Book query_book(String barCode) throws SQLException {
	String sql ="select * from books where barCode = ?"; 
		Book query = queryRunner.query(sql, new BeanHandler<Book>(Book.class),barCode);
		System.out.println("执行了代码--------query  --条形码");
		System.out.println(query);
		return query;
	
		
	}


	public void change_state(String barCode) throws SQLException {
	String sql  = "update books set state = '未借' where barCode =? ";
	queryRunner.update(sql,barCode);
	System.out.println("执行了代码   ------设置了状态1");
		
	}


	public void change_state_b(String barCode) throws SQLException {
		String sql  = "update books set state = '已借' where barCode =? ";
		queryRunner.update(sql,barCode);
		System.out.println("执行了代码------设置了状态2---");
		
	}


	public void lend_incream(String barCode) throws SQLException {
	
		String sql  = "update books set LendNum = lendNum+1  where barCode =? ";
		queryRunner.update(sql,barCode);
		System.out.println("执行了代码--------自增");
		
	}


	public int insert_add(String rno, String book_Name) throws SQLException {
		String sql = "insert into lendbooks (rNo,lendbook) values(?,?)";
		
		int update = queryRunner.update(sql,rno,book_Name);
		System.out.println("执行了代码--------插入");
		return update;
		
	}


	public void reader_people(String rno) throws SQLException {
			String sql = "update reader set lendNum = lendNum+1 where rno=?";
			queryRunner.update(sql,rno);
		
		
	}


	public void reader_people_1(String rno) throws SQLException {
		String sql = "update reader set canLendNum =canLendNum-1  where rno=?";
		queryRunner.update(sql,rno);
		
	}


	public Reader judgemin(String rno) throws SQLException {
	
		String sql = "select canLendNum from reader where rno=?";
		Reader query = queryRunner.query(sql,new BeanHandler<Reader>(Reader.class),rno);
		return query;
		
	}	
	
	
	
	
	

}
