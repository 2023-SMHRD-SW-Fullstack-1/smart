package baseball;

import java.util.ArrayList;
import java.util.Random;

public class Defence {
   DAO dao = new DAO();
   Random rd = new Random();
   final ArrayList<DTO> List = dao.Infor();
   public int throwing(int target) {
      int hitPoint = rd.nextInt(5)+1;
      if(hitPoint == target) {
         if(defencing()) {
            return 5; //1. 안타, 2. 홈런, 3. 스트라이크, 4.볼, 5. 아웃
         }else {
            if(rd.nextInt(10)+1==9) {
               return 2;
            }
            return 1;
         }
      }else {
         int notHit = rd.nextInt(2)+1;
         if(notHit==1) {
            return 3;
         }else {
            return 4;
         }
      }
   }
   
   public boolean defencing() {
      int defencer = rd.nextInt(8);
      int ball = rd.nextInt(100)+1;
      if(List.get(defencer).getBa()>ball) {
         return true; 
      }else{
         return false;
      }
   }
   
   
   
   
}