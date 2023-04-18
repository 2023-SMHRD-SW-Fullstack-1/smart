package baseball;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DAO {
	Scanner sc= new Scanner(System.in);
	   Connection conn = null;
	   PreparedStatement pstm = null;
	   ResultSet rs = null;
	   
	   public void getConn() {
		   try {
		         // DB연결할 수 있는 외부 클래스 가져오기
		         Class.forName("oracle.jdbc.driver.OracleDriver");

		         // 연결시 필요한 값 (url, id, pw)
		         String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		         String id = "campus_k_0417_6";
		         String pw = "smhrd6";

		         conn = DriverManager.getConnection(url, id, pw);

		      } catch (ClassNotFoundException | SQLException e) {
		         e.printStackTrace();
		      }
	   }
	   public void close() {
		  try {
	         if (rs != null) {
	            rs.close();
	         }
	         if (pstm != null) {
	            pstm.close();
	         }
	         if (conn != null) {
	            conn.close();
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	   
	   
	   public int getBA(String ba){
		   int result=0;
		   return result;
	   }
	   
	   //public ArrayList<>getList() {
		   
	   //}
	   //public ArrayList<>getList_SM(){
		   
	 //  }
	
	
}
