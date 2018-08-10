package test;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test2 {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //加载数据库驱动
			System.out.println("数据库驱动加载成功！");	//输出的信息
			String url = "jdbc:oracle:thin:@192.168.0.21:1521:oraclesugo";	//获取连接URL
			String user = "SYSTEM"; //连接用户名
			String password = "Sugo123456"; //连接密码
			conn = DriverManager.getConnection(url, user, password); //获取数据库连接
			if (conn != null) {
				System.out.println("成功的与Oracle数据库建立连接！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; //返回Connection实例
	}

	public static void main(String[] args) {
		Connection connection = getConnection();
	}
}
