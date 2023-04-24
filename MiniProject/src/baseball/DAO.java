package baseball;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
   Scanner sc = new Scanner(System.in);
   Connection conn = null;
   PreparedStatement pstm = null;
   ResultSet rs = null;

   private static String team = "TEAM_";
   private static String enemy = "TEAM_";
   // private int[] PlayerNum = new int[5];

   public void teamset(String team) { // 선택한 팀 구단 가져오기
      this.team += team;
   }

//      
//      public void teamadd(int[] PlayerNum) { //선수들 번호 받아오기
//         this.PlayerNum=PlayerNum;
//      }
//      
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

   public ArrayList<DTO> Infor() {
      getConn();
      ArrayList<DTO> TeamList = new ArrayList<DTO>();
      try {

         String sql = "select PLAYER_NAME, BA, TEAM, ROLL from " + team;
         pstm = conn.prepareStatement(sql);
//            
//            pstm.setString(1, team);
//            pstm.setInt(2, PlayerNum[i]);
         rs = pstm.executeQuery();

         while (rs.next()) {
            String name = rs.getString(1);
            int ba = rs.getInt(2);
            String group = rs.getString(3);
            String roll = rs.getString(4);

            DTO dto = new DTO(name, ba, group, roll);
            TeamList.add(dto);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      close();
      return TeamList;
   }
   public ArrayList<DTO> enemyInfor() {
       getConn();
       ArrayList<DTO> TeamList = new ArrayList<DTO>();
       try {

          String sql = "select PLAYER_NAME, BA, TEAM, ROLL from " + enemy;
          pstm = conn.prepareStatement(sql);
//             
//             pstm.setString(1, team);
//             pstm.setInt(2, PlayerNum[i]);
          rs = pstm.executeQuery();

          while (rs.next()) {
             String name = rs.getString(1);
             int ba = rs.getInt(2);
             String group = rs.getString(3);
             String roll = rs.getString(4);

             DTO dto = new DTO(name, ba, group, roll);
             TeamList.add(dto);
          }

       } catch (Exception e) {
          e.printStackTrace();
       }

       close();
       return TeamList;
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
   public void enemyset(String enemy) { // 선택한 팀 구단 가져오기
       this.enemy += enemy;
    }

   /*
    * public int getBA(String ba){ int result=0; return result; }
    */

}