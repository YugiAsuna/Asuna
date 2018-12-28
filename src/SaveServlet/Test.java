package SaveServlet;

import java.sql.Connection;

import com.asuna.bean.Util;

public class Test {

	public static void main(String[] args) {
	Connection conn = Util.getConn();
System.out.println(conn);
	}

}
