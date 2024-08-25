package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// JAVA <---> DBMS(Oracle)

public class Test01 {
	public static void main(String[] args) {
		
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userName = "JJH";
		final String password = "1234";
		final String sql = "SELECT * FROM PRODUCT";
		final String insert = "INSERT INTO PRODUCT VALUES (?,?,1000,1)";
		
		// [1] JDBC 드라이버를 메모리에 로드(load, 적재)
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.err.println("해당 드라이버 클래스를 찾을 수 없습니다!");
			// 사람이 오타를 냈거나
			// 클래스 파일 추가하지 않았거나
		}
		finally {
			System.out.println("[1] JDBC 드라이버를 메모리에 로드(load, 적재)");
		}
		
		// [2] DB와의 연결을 확보한다.
		// driverName : 접속 주소
		// 계정 이름
		// 비밀번호
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!");
		}finally {
			System.out.println("[2] DB와의 연결을 확보한다.");
		}
		
		// [3] DB에 데이터를 read, write
		PreparedStatement pstmt = null;
		try {
			/*
			// DB(sql)에서 데이터 불러오기 
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			// 결과가 안 남을 때까지
			while(rs.next()) {
				System.out.println("NUM : "+rs.getInt("Num"));
				System.out.println("NAME : "+rs.getString("NAME"));
				System.out.println("PRICE : "+rs.getInt("PRICE"));
				System.out.println("CNT : "+ rs.getInt("CNT"));
			}
			*/
			
			// DB(sql)에 데이터 입력하기
			Scanner sc = new Scanner(System.in);
			System.out.print("PK 값 입력 >> ");
			int num = sc.nextInt();
			System.out.print("제품명 입력 >> ");
			String name = sc.next();
			
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL문이 올바르지 않습니다.");
		}finally {
			System.out.println("[3] DB에 데이터를 read, write 성공");
		}
		
		// [4] 닫아줌
		
		// 종류를 해줘야 안정적
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("[4] DB 연결 해제(안정성 때문)");
		}
		
		// jdbc 코드는 패턴화(템플릿화) 되어있음
	}

}
