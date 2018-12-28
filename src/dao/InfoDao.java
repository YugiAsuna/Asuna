package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.asuna.bean.JdbcUtil;

public class InfoDao {
	private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

	public void changeInfo(String rno, String newPassword) throws SQLException {
		String sqlString = "update reader set password = ? where rno = ?";
		queryRunner.update(sqlString,newPassword,rno);	
		System.out.println("更新成功");
	}
	
	
	
	
	
}
