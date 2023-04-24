package baseball;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 아스키코드(Alligator2)
		System.out
				.println("\r\n" + "                    :::    :::                 :::::::::   ::::::::  :::::::::  \r\n"
						+ "                    :+:   :+:                  :+:    :+: :+:    :+: :+:    :+: \r\n"
						+ "                    +:+  +:+                   +:+    +:+ +:+    +:+ +:+    +:+ \r\n"
						+ "                    +#++:++     +#++:++#++:++  +#++:++#+  +#+    +:+ +#++:++#+  \r\n"
						+ "                    +#+  +#+                   +#+        +#+    +#+ +#+        \r\n"
						+ "                    #+#   #+#                  #+#        #+#    #+# #+#        \r\n"
						+ "                    ###    ###                 ###         ########  ###        \r\n" + "");

		// 출력 후 1초 대기
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\r\n"
				+ "     :::::::::      :::      ::::::::  :::::::::: :::::::::      :::     :::        :::        \r\n"
				+ "     :+:    :+:   :+: :+:   :+:    :+: :+:        :+:    :+:   :+: :+:   :+:        :+:        \r\n"
				+ "     +:+    +:+  +:+   +:+  +:+        +:+        +:+    +:+  +:+   +:+  +:+        +:+        \r\n"
				+ "     +#++:++#+  +#++:++#++: +#++:++#++ +#++:++#   +#++:++#+  +#++:++#++: +#+        +#+        \r\n"
				+ "     +#+    +#+ +#+     +#+        +#+ +#+        +#+    +#+ +#+     +#+ +#+        +#+        \r\n"
				+ "     #+#    #+# #+#     #+# #+#    #+# #+#        #+#    #+# #+#     #+# #+#        #+#        \r\n"
				+ "     #########  ###     ###  ########  ########## #########  ###     ### ########## ########## \r\n"
				+ "");

		// 출력 후 1초대기
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 스캐너
		Scanner sc = new Scanner(System.in);

		// 객체생성
		DAO dao = new DAO();
		// Attack atk = new Attack();

		// 변수
		int menu; // 게임시작, 게임종료
		int agency; // 에이전시 : SM, YG, HYBE
		int enemy; //상대 구단

		// 반복
		while (true) {
			System.out.println(
					"---------------------------------------------------------------------------------------------------\n");
			System.out.print("                                     [1] 게임시작  [2] 게임종료 >> ");
			menu = sc.nextInt();
			System.out.println();

			// 게임시작
			if (menu == 1) {

				// 게임설명

				// 본인구단선택
				System.out.println(
						"---------------------------------------------------------------------------------------------------\n");
				System.out.println("                                     [1] SM    [2] YG    [3] HYBE   \n");

				System.out.print("                                        구단을 선택해주세요 >> ");
				agency = sc.nextInt();
				System.out.println();

				// 구단 데이터베이스

				if (agency == 1) {
					dao.teamset("SM");
				} else if (agency == 2) {
					dao.teamset("YG");
				} else if (agency == 3) {
					dao.teamset("HYBE");
				} else {
					System.out.println("                                        >> 번호를 다시 선택해 주세요 << \n");
					continue; // 문제점 : 구단선택이 출력되어야하는데 게임시작으로 이동함.
				}

				// 선택한 구단 명단
				System.out.println(
						"---------------------------------------------------------------------------------------------------\n");
				ArrayList<DTO> userList = dao.Infor();

				System.out.println("  [순번]         [선수명]           [소속 그룹]             [포지션]           [타율]\n");

				for (int i = 0; i < userList.size(); i++) {
					String name = userList.get(i).getName();
					String group = userList.get(i).getGroup();
					String roll = userList.get(i).getRoll();
					int ba = userList.get(i).getBa();
					System.out.printf("    %-10d  %-10s\t  %-15s\t %-10s \t  %d\n", i + 1, name, group, roll, ba);
				}
				System.out.println();

				// 상대구단선택 (선수는 랜덤)
				
				

				// 구단 데이터베이스

				while(true) {
					System.out.println(
						"---------------------------------------------------------------------------------------------------\n");
					System.out.println("                                     [1] SM    [2] YG    [3] HYBE   \n");

					System.out.print("                                         상대 구단을 선택해주세요 >> ");
					enemy = sc.nextInt();
					System.out.println();
					if (enemy == 1 && agency ==1 ) {
					System.out.println("이미 선택한 구단입니다.");
					
					//dao.enemyset("SM");
				}
					else if(enemy == 1 && agency!=1) {
					dao.enemyset("SM");
					break;
				}
					else if(enemy ==2 && agency ==2) {
					System.out.println("이미 선택한 구단입니다.");
					
				}
					else if(enemy ==2 && agency !=2) {
						dao.enemyset("YG");
						break;
					}
					else if(enemy ==3 && agency ==3) {
						System.out.println("이미 선택한 구단입니다.");
						
					}
					else if(enemy ==3 && agency !=3) {
						dao.enemyset("HYBE");
						break;
					}
				}
				ArrayList<DTO> enemyList = dao.enemyInfor();
				System.out.println(
						"---------------------------------------------------------------------------------------------------\n");
				System.out.println("  [순번]         [선수명]           [소속 그룹]             [포지션]           [타율]\n");

				for (int i = 0; i < enemyList.size(); i++) {
					String name = enemyList.get(i).getName();
					String group = enemyList.get(i).getGroup();
					String roll = enemyList.get(i).getRoll();
					int ba = enemyList.get(i).getBa();
					System.out.printf("    %-10d  %-10s\t  %-15s\t %-10s \t  %d\n", i + 1, name, group, roll, ba);
				}
				System.out.println();
				

				// 공수선택
				
				int a = 1;
				int round = 1;
				//게임 진행
				Board board= new Board();
				while(round!=2) {
				if(a==1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					getAttack();
					
					getDefence();
					
					board.setRound(round++);
					
				}else {
					getDefence();
					getAttack();
					board.setRound(round++);
				}
				
				
				
				}
				// 점수판

				System.out.println("\r\n"
						+ " ___   ___  ______  _____  _____  _   _  _      _____  ___   ___  \r\n"
						+ "|__ \\ |__ \\ | ___ \\|  ___|/  ___|| | | || |    |_   _||__ \\ |__ \\ \r\n"
						+ "   ) |   ) || |_/ /| |__  \\ `--. | | | || |      | |     ) |   ) |\r\n"
						+ "  / /   / / |    / |  __|  `--. \\| | | || |      | |    / /   / / \r\n"
						+ " |_|   |_|  | |\\ \\ | |___ /\\__/ /| |_| || |____  | |   |_|   |_|  \r\n"
						+ " (_)   (_)  \\_| \\_|\\____/ \\____/  \\___/ \\_____/  \\_/   (_)   (_)  \r\n"
						+ "                                                                  \r\n"
						+ "                                                                  \r\n"
						+ "");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				board.displayScore();
				if(board.oScore > board.eScore) {
					System.out.println("\r\n"
							+ " _  _  _  _ __   __ _____  _   _   _    _  _____  _   _  _  _  _  _ \r\n"
							+ "| || || || |\\ \\ / /|  _  || | | | | |  | ||_   _|| \\ | || || || || |\r\n"
							+ "| || || || | \\ V / | | | || | | | | |  | |  | |  |  \\| || || || || |\r\n"
							+ "| || || || |  \\ /  | | | || | | | | |/\\| |  | |  | . ` || || || || |\r\n"
							+ "|_||_||_||_|  | |  \\ \\_/ /| |_| | \\  /\\  / _| |_ | |\\  ||_||_||_||_|\r\n"
							+ "(_)(_)(_)(_)  \\_/   \\___/  \\___/   \\/  \\/  \\___/ \\_| \\_/(_)(_)(_)(_)\r\n"
							+ "                                                                    \r\n"
							+ "                                                                    \r\n"
							+ "");
					break;
				}
				else {
					System.out.println("\r\n"
							+ " _____  _____  _____  __   __ _____  _   _   _      _____  _____  _____   _____  _____  _____ \r\n"
							+ "|_   _||_   _||_   _| \\ \\ / /|  _  || | | | | |    |  _  |/  ___||  ___| |_   _||_   _||_   _|\r\n"
							+ "  | |    | |    | |    \\ V / | | | || | | | | |    | | | |\\ `--. | |__     | |    | |    | |  \r\n"
							+ "  | |    | |    | |     \\ /  | | | || | | | | |    | | | | `--. \\|  __|    | |    | |    | |  \r\n"
							+ "  | |    | |    | |     | |  \\ \\_/ /| |_| | | |____\\ \\_/ //\\__/ /| |___    | |    | |    | |  \r\n"
							+ "  \\_/    \\_/    \\_/     \\_/   \\___/  \\___/  \\_____/ \\___/ \\____/ \\____/    \\_/    \\_/    \\_/  \r\n"
							+ "                                                                                              \r\n"
							+ "                                                                                              \r\n"
							+ "");
					break;
				}
				
				
				
			} else if (menu == 2) {// 게임종료
				System.out.println(
						"------------------------------------------ 게임을 종료합니다 ------------------------------------------");

				break;
			} else {
				System.out.println("                                        >> 번호를 다시 선택해 주세요 << \n");
				continue;
			}

		}
		//마지막 결과화면
		

	}

	public static void getAttack() {
		Scanner sc = new Scanner(System.in);
		Attack atk = new Attack();
		Board board = new Board();
		DAO dao = new DAO();
		ArrayList<DTO> userList = dao.Infor();
		int outcount = 1;
		
		//선수 선택
		while(true) {
			if(outcount>=4) {
				break;
			}
		System.out.println("공격을 시작합니다.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("우리 선수를 선택하세요 >> ");
		
		//선수 명단 보여주기
		
		int per = sc.nextInt();
		try {
			Scanner scname = new Scanner(new File("이름아스키/" + userList.get(per-1).getName() + ".txt"));

			while (scname.hasNextLine()) {
				String str = scname.nextLine();
				Thread.sleep(100);
				System.out.println("\t\t\t\t" + str);
			}
			// 뽑은 선수 정보 보여주기

		} catch (FileNotFoundException | InterruptedException e) {

			e.printStackTrace();
		}
		
		//-----------------------
		
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("투수 와인드업!");
			int res = atk.Percent(per);
			if (res == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _   _  _____ ___  ___ _____ ______  _   _  _   _ \r\n"
						+ "| | | ||  _  ||  \\/  ||  ___|| ___ \\| | | || \\ | |\r\n"
						+ "| |_| || | | || .  . || |__  | |_/ /| | | ||  \\| |\r\n"
						+ "|  _  || | | || |\\/| ||  __| |    / | | | || . ` |\r\n"
						+ "| | | |\\ \\_/ /| |  | || |___ | |\\ \\ | |_| || |\\  |\r\n"
						+ "\\_| |_/ \\___/ \\_|  |_/\\____/ \\_| \\_| \\___/ \\_| \\_/\r\n"
						+ "                                                  \r\n"
						+ "                                                  \r\n" + "");
				board.add(2);
				board.clean();
				break;
			} else if (res == 1) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _   _  _  _    _ \r\n" + "| | | |(_)| |  | |\r\n"
						+ "| |_| | _ | |_ | |\r\n" + "|  _  || || __|| |\r\n" + "| | | || || |_ |_|\r\n"
						+ "\\_| |_/|_| \\__|(_)\r\n" + "                  \r\n" + "                  \r\n" + "");
				board.add(1);
				board.clean();
				break;
			} else if (res == 3) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _____  _____ ______  _____  _   __ _____  _  _ \r\n"
						+ "/  ___||_   _|| ___ \\|_   _|| | / /|  ___|| || |\r\n"
						+ "\\ `--.   | |  | |_/ /  | |  | |/ / | |__  | || |\r\n"
						+ " `--. \\  | |  |    /   | |  |    \\ |  __| | || |\r\n"
						+ "/\\__/ /  | |  | |\\ \\  _| |_ | |\\  \\| |___ |_||_|\r\n"
						+ "\\____/   \\_/  \\_| \\_| \\___/ \\_| \\_/\\____/ (_)(_)\r\n"
						+ "                                                \r\n"
						+ "                                                \r\n" + "");
				board.add(3);
				
			} else if (res == 4) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + "______   ___   _      _     \r\n" + "| ___ \\ / _ \\ | |    | |    \r\n"
						+ "| |_/ // /_\\ \\| |    | |    \r\n" + "| ___ \\|  _  || |    | |    \r\n"
						+ "| |_/ /| | | || |____| |____\r\n" + "\\____/ \\_| |_/\\_____/\\_____/\r\n"
						+ "                            \r\n" + "                            \r\n" + "");
				board.add(4);
				if(board.ball ==4) {
					break;
				}
			} else if (res == 5) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _____  _   _  _____  _  _ \r\n" + "|  _  || | | ||_   _|| || |\r\n"
						+ "| | | || | | |  | |  | || |\r\n" + "| | | || | | |  | |  | || |\r\n"
						+ "\\ \\_/ /| |_| |  | |  |_||_|\r\n" + " \\___/  \\___/   \\_/  (_)(_)\r\n"
						+ "                           \r\n" + "                           \r\n" + "");
				board.add(5);
				board.clean();
			}

			board.Calculate();
			board.ballCount();
			//while 종료
			
			if(board.outs == outcount) {
				outcount++;
				break;
			}
			
		}
		//-----------------------------------------
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (board.outs == 3) {
				
				board.AttackEnd();
				board.displayScore();
				break;
			}

		}
	}

	public static void getDefence() { //수비 -------------------------
		Scanner sc = new Scanner(System.in);
		Defence df = new Defence();
		Random rd = new Random();
		DAO dao = new DAO();
		Board board = new Board();
		int outcount = 1;
		ArrayList<DTO> enemyList = dao.enemyInfor();
		System.out.println("수비를 시작합니다");

		
		
		while (true) {
			if(outcount>=4) {
				break;
			}

			int enemyPN = rd.nextInt(5)+1;
			System.out.println(" 상대 선수 출전 중 ");

			try {
				Scanner scname = new Scanner(new File("이름아스키/" + enemyList.get(enemyPN).getName() + ".txt"));

				while (scname.hasNextLine()) {
					String str = scname.nextLine();
					Thread.sleep(200);
					System.out.println("\t\t\t\t" + str);
				}

			} catch (FileNotFoundException | InterruptedException e) {

				e.printStackTrace();
			}
//while 시작지점
			while(true) {
				
			System.out.println("원하는 곳을 고르시오");	
			int point = sc.nextInt();
			
			System.out.println("투수 와인드업!");
			int res = df.throwing(point);
			if (res == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _   _  _____ ___  ___ _____ ______  _   _  _   _ \r\n"
						+ "| | | ||  _  ||  \\/  ||  ___|| ___ \\| | | || \\ | |\r\n"
						+ "| |_| || | | || .  . || |__  | |_/ /| | | ||  \\| |\r\n"
						+ "|  _  || | | || |\\/| ||  __| |    / | | | || . ` |\r\n"
						+ "| | | |\\ \\_/ /| |  | || |___ | |\\ \\ | |_| || |\\  |\r\n"
						+ "\\_| |_/ \\___/ \\_|  |_/\\____/ \\_| \\_| \\___/ \\_| \\_/\r\n"
						+ "                                                  \r\n"
						+ "                                                  \r\n" + "");
				board.add(2);
				board.clean();
				break;
			} else if (res == 1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _   _  _  _    _ \r\n" + "| | | |(_)| |  | |\r\n"
						+ "| |_| | _ | |_ | |\r\n" + "|  _  || || __|| |\r\n" + "| | | || || |_ |_|\r\n"
						+ "\\_| |_/|_| \\__|(_)\r\n" + "                  \r\n" + "                  \r\n" + "");
				board.add(1);
				board.clean();
				break;
			} else if (res == 3) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _____  _____ ______  _____  _   __ _____  _  _ \r\n"
						+ "/  ___||_   _|| ___ \\|_   _|| | / /|  ___|| || |\r\n"
						+ "\\ `--.   | |  | |_/ /  | |  | |/ / | |__  | || |\r\n"
						+ " `--. \\  | |  |    /   | |  |    \\ |  __| | || |\r\n"
						+ "/\\__/ /  | |  | |\\ \\  _| |_ | |\\  \\| |___ |_||_|\r\n"
						+ "\\____/   \\_/  \\_| \\_| \\___/ \\_| \\_/\\____/ (_)(_)\r\n"
						+ "                                                \r\n"
						+ "                                                \r\n" + "");
				board.add(3);
			} else if (res == 4) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + "______   ___   _      _     \r\n" + "| ___ \\ / _ \\ | |    | |    \r\n"
						+ "| |_/ // /_\\ \\| |    | |    \r\n" + "| ___ \\|  _  || |    | |    \r\n"
						+ "| |_/ /| | | || |____| |____\r\n" + "\\____/ \\_| |_/\\_____/\\_____/\r\n"
						+ "                            \r\n" + "                            \r\n" + "");
				board.add(4);
				if(board.ball ==4) {
					board.clean();
					break;
				}
			} else if (res == 5) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n" + " _____  _   _  _____  _  _ \r\n" + "|  _  || | | ||_   _|| || |\r\n"
						+ "| | | || | | |  | |  | || |\r\n" + "| | | || | | |  | |  | || |\r\n"
						+ "\\ \\_/ /| |_| |  | |  |_||_|\r\n" + " \\___/  \\___/   \\_/  (_)(_)\r\n"
						+ "                           \r\n" + "                           \r\n" + "");
				board.add(5);  
				board.clean();
			}

			board.Calculate();
			board.ballCount();
			
			if(board.outs == outcount) {
				outcount++;
				break;
			}
		}
			//while 종료
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (board.outs == 3) {
				board.DefenceEnd();
				board.displayScore();
				break;
			}

		}

	}
}
