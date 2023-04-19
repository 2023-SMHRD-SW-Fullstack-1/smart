package baseball;

import java.util.ArrayList;

/*
본인의 팀 중에서 타자를 순서대로 출전시킨다.
- 출전한 선수는 자신의 타율에 따른 확률로 안타/볼/스트라이크/
홈런 중 한가지 행위를 한다. (만약 타율이 45라면 1~100까지의
랜덤 값과 비교해서 타율이 높다면 확률 안에 든다라고 표현한
다.)
- 확률 안에 드는 경우에는 안타 행위를 한다.
- 확률의 1/10에 드는 경우에는 홈런 행위를 한다.
- 안타 행위는 count를 하나 올린다
*/
public class Attack {
	DAO dao = new DAO();
	ArrayList<DTO> List = dao.Infor();
	public void Percent() {
		
		List.get(1);
		System.out.println(List.get(1));
	}
	
}
