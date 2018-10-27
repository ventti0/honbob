package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// DB 연결 정보
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@112.149.190.85:8585:XE";
	private static final String USERNAME = "hon";
	private static final String PASSWORD = "bap";

	// DB 연결 객체
	private static Connection conn = null; //연결객체
	
	// private 생성자
	private DBConn() { }
	
	// Connection 객체 반환 - Singleton Pattern
	public static Connection getConnection() {

		// DB 연결이 안되어있을 때만 동작
		if( conn == null ) {
			try {
				Class.forName(DRIVER); //드라이버로드
				
				// DB 연결객체 생성
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn; // DB 연결객체 반환
	}
	
}













