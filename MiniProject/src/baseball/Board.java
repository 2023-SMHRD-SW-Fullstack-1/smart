package baseball;

public class Board {
//  
//  System.out.println("---점수판(볼카운트)---");
//  ArrayList<DTO> List = dao.Infor();
//  for(int i=0; i<List.size(); i++) {
//     int strike = List.get(i).getStrike();
//     int ball = List.get(i).getBall();
//     int outs = List.get(i).getOuts();
//     System.out.println("Strike : "+strike+" Ball : "+ball+" Outs : "+outs);
//  }
//  
  
  //타자 끝나면클린해주기
  
  // 스트라이크 , 볼 , 아웃카운트를 보여줄수있는 메서드 만들기
  //점수판1 -> 스트라이크 / 볼 / 아웃 보여주는 점수판 (스트라이크, 볼, 아웃 3개의 매개변수를 받아서 반영해서 출력할 수있는 void 메서드 만들기)
  int strike; //3번
  int ball;   //4번
  int outs;   //5번
  int score;
  
  //공격/수비 행위를 한 뒤 실행하세요
  public void add(int result) {
     if(result == 3) {
        strike++;
     }else if (result == 4) {
        ball++;
     }else if (result == 5) {
        outs++;
     }else if (result == 1) {
        score++;
     }else if (result == 2) {
        score = score+4;
     }
  }
  
  //타자가 바뀌게 되면 반드시 실행하세요
  public void clean() { //타자가 바뀔때 초기화
     strike = 0;
     ball = 0;
     
  }
  
  
  // 현재 스트라이크, 볼, 아웃 카운트를 보여주는 메서드 (Calculate()를 실행한 뒤에 실행하세요)
  public void ballCount () {
      System.out.println("Strikes: " + strike);
      System.out.println("Balls: " + ball);
      System.out.println("Outs: " + outs);
  }
       // displayScore(2, 1, 0); 
       
  
  //점수판2 -> 현재라운드 / 라운드별 나의 점수와 상대점수(라운드 매개변수 1개 ,상대점수, 우리점수)
  
    private static int round=1;   // 라운드(3)
    static int oScore=0;  // 우리팀 점수 ourScore
    static int eScore;  // 상대팀점수  enemyScore
    
    //공수를 교대할 때 실행하여 점수를 보여주세요 
       public void displayScore () {
          
    	   System.out.println("라운드: " + round);
          System.out.println("우리팀 점수 : " + oScore);
          System.out.println("상대팀 점수 : " + eScore);
      }
       
       // add() 이후에  ballcount() 호출 이전에반드시 실행하세요
       public void Calculate() {
          if(ball==4) {
             score++;
             clean();
             
          }
          if(strike==3) {
             outs++;
             clean();
          }
          if(outs==3) {
             System.out.println("공수 교대 알림");
             
          }
       }
       
       // 공격이 끝났을때 호출하세요
       public void AttackEnd() {
          oScore += score;
          score = 0;
          clean();
          outs=0;
       } 
       
       // 수비가 끝났을 때 호출하세요
       public void DefenceEnd() {
          eScore += score;
          score = 0;
          clean();
          outs=0;
       }
       public int getRound() {
    	   
    	   return this.round;
       }
       public void setRound(int round1) {
    	   this.round=round1;
       }
       
       
       //메서드를 짜서 호출을 함
      // 볼 --> 4개가쌓여야 +1 
       //안타 --> 점수1+카운트
       //홈런 --> 점수4+
      // 스트라이크 - > 아웃
}

