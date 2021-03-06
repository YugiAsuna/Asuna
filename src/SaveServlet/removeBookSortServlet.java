package SaveServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asuna.bean.Util;

@WebServlet(name="removeBookSortServlet", urlPatterns="/removeBookSortServlet")//配置文件
public class removeBookSortServlet extends HttpServlet {
	private Connection conn=null;	
	private static final long serialVersionUID = 1L;	   
	public void init(ServletConfig config) throws ServletException {
		conn=Util.getConn();		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取表单中属性值
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String rmbsort = request.getParameter("bsort2");//获得删除图书类别		
   	 if (conn != null) {
			try {							
				String sql="delete from booksort where bSort=?"; //删除图书类别
				//创建PreparedStatement对象
				PreparedStatement ps = conn.prepareStatement(sql);												   					
				ps.setString(1, rmbsort);
				ps.executeUpdate();
				PrintWriter out = response.getWriter();
				//输出注册结果信息				
				out.println("<script language='javascript'>");
				out.println("var str='图书类别删除成功！';");
				out.println("alert(str);");	
				out.println("window.navigate('booksort.jsp');");
				out.println("</script>");	
				out.flush();
				out.close();										               			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} 
   	    else {
			//发送数据库连接错误提示信息
			response.sendError(500, "数据库连接错误！");
		}
	}

}
