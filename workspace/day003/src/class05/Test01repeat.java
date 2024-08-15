package class05;

import java.util.Scanner;

public class Test01repeat {

	public static void main(String[] args) {
		
		// 사용할 변수
		String[] stu = new String[5];	// 학생 이름을 받을 배열(크기 5의 문자열 배열)
		int cnt = 0;					// '총 입력된 이름 수' 정수
		int num;						// '사용하려는 메뉴 번호' 정수
		int select;						// 검색에 사용하려는 정수
		String name;					// 학생 추가시 사용하는 문자열 변수
		boolean flag = false;			// 검색 등에서 찾을 때 있는지 없는지 확인 할 때 사용
		
		//학생부 프로그램은 계속 작동
		while(true){// 반복 횟수가 정해져 있지 않으므로
			// 메뉴 출력
			System.out.println("=== 메뉴 ===");
			System.out.println("1. 학생추가");
			System.out.println("2. 학생부 전체출력");
			System.out.println("3. 이름으로 검색");
			System.out.println("4. 번호로 검색");
			System.out.println("5. 이름변경");
			System.out.println("0. 프로그램종료");
			System.out.println("==============");
			Scanner sc = new Scanner(System.in);
			
			while(true){			// 유효성 검사, 알맞은 메뉴를 골랐는지 확인
				// 메뉴를보고 사용하려는 기능 선택
				// 정수로 입력받음
				System.out.print("사용하려는 기능의 번호를 입력해주세요. >> ");
				num = sc.nextInt();
				
				if(0<=num&&num<=5) {			// num이 0~5 사이라면
					break;
				}
				System.out.println("메뉴에 있는 번호를 입력해주세요.");
			}
		
			//입력받은 정수에 따른 선택지
			//프로그램 종료
			if(num == 0) {		//num이 0이라면
				System.out.println("프로그램이 종료됩니다.");
				break;								//학생부 프로그램 종료
			}
			//학생 추가
			else if(num == 1)	{	// num이 1이라면
				if(cnt >= stu.length) {		// cnt가 배열의 크기이상이라면
					System.out.println("더 이상 학생을 받을 수 없습니다.");
					continue;
				}
				
				while(true) { 		// 유효성 검사, 이름 재확인
					// 추가할 학생의 이름을 입력받음(String)
					System.out.print("추가할 학생의 이름을 입력해주세요. >> ");
					name = sc.next();
				
					// 정말로 입력할 이름이 알맞는지 확인('Y/N')
					System.out.print("정말로 "+ name+"을 입력하시겠습니까? (Y/N)");
					String answer = sc.next();
					
					if(answer.equals("Y")) {		//'Y'라면
						flag = false;	// 기본적으로 학생부에 name이 없는 상태로 만듬
						
						// 중복된 이름이 있는 지 확인
						for(int i = 0; i < cnt; i++) {		//사용자가 입력해 놓은 학생 수만큼 반복
							if(name.equals(stu[i])) {	//만약 name값과 배열에 중복된 값이 있다면
								flag = true;
								System.out.println(name + "은(는) 이미 존재하는 이름입니다.");
							}
						}
						if(!flag) {	// 만약 중복값이 없다면
							break;	//이름을 확인하는 while문 나감
						}
					}
				}
						
				// 학생부 배열의 입력된 인덱스 다음 칸에 이름을 넣음
				stu[cnt] = name; 
				// '입력된 이름 수' 1 증가
				cnt++;
			}
			// 학생부 전체 출력 
			else if(num == 2) {		// num이 2이라면
				if(cnt <= 0) {		//cnt가 0이라면, 이하라면
					System.out.println("입력된 학생이 없습니다.");
					continue;		// 프로그램 넘김
				}
		
				System.out.println("=== 학생 목록 ===");
				for(int i = 0; i <cnt; i++) {		//cnt만큼 반복
					//학생부 배열에서 이름을 하나씩 가져옴
					System.out.println((i+1)+"번 : "+ stu[i]);
				}
				System.out.println("===============");
			}
			// 학생 이름으로 검색
			else if(num == 3) {			// num이 3이라면
				while(true){			//검색을 완료할 때까지 반복
					//검색하려는 이름을 입력받음
					System.out.print("검색하려는 이름을 입력하세요. >> ");
					String name2 = sc.next();
					
					flag = false;
					// 검색할 이름이 학생부에 없다는 상태에서 시작
					int number = 0;		// 검색한 것이 있을 경우 번호값을 넣는 변수
					
					for(int i = 0; i < cnt; i++) {		// cnt만큼 반복
						if(name2.equals(stu[i])) {		// 만약 이름이 일치한다면
							flag = true;				// flag값을 true로 바꿔 결과를 말함
							number = i;
						}	
					}
					
					if(flag) {				// flag가 true라면
						System.out.println((number+1) + "번 : "+ stu[number]);
						break;
					}
					
					System.out.println("일치하는 이름이 없습니다.");
					System.out.println("다시 검색하시겠습니까? (Y/N)");
					String answer = sc.next();
					if(answer.equals("N")) {		//'N'라면
						break;	//검색하는 while문 나감
					}
				}
			}
			// 학생 번호로 검색
			else if(num == 4) {			//num이 4이라면
				if(cnt == 0) {		//학생부에 아무 이름도 없을 경우
					System.out.println("검색할 이름이 없습니다.");
					continue;		//프로그램 처음으로
				}
				
				flag = false;	//검색하기 전 초기화
				
				while(true) {				//유효성 검사
					System.out.print("검색할 학생의 번호를 입력하세요 >> ");
					select = sc.nextInt();
					
					if(1 <= select && select <= cnt) {		//search 값이 1에서부터 cnt 사이의 값이라면
						flag = true;
						break;
					}
					System.out.println("해당번호의 학생은 없습니다.");
					
					// 재검색을 물음
					System.out.println("다시 검색하시겠습니까? (Y/N)");
					String answer = sc.next();
					if(answer.equals("N")) {		//'N'라면
						break;	//검색하는 while문 나감
					}
				}
				
				if(flag) {		//flag가 true면
					//해당 학생을 출력
					System.out.println(select + "번 : "+ stu[select-1]);
				}
			}
			//학생 이름 수정
			else if(num == 5) {	//num이 5이라면			
				//수정하려고 하는 학생의 번호, 이름 둘 중에 무엇을 검색할 것인지 정하기
				System.out.println("번호와 이름 중 어느 것을 입력하겠습니까?");
				System.out.println("1. 번호");
				System.out.println("2. 이름");
				while(true) { //유효성 검사, 1과2 둘 중 하나만 입력하도록
					System.out.print(">> ");
					select = sc.nextInt();
					
					if(select == 1 || select == 2) {	//select가 1과 2 둘중 하나면
						break;
					}
					System.out.println("1과 2 둘 중 하나를 입력하세요.");
				}
				
				flag = false;	//검색하기 전 초기화
				int number = 0;	
				
				while(true) {		// 번호/이름을 입력받고 배열 위치 찾기
					//번호를 선택했다면
					if(select == 1) {		//select가 1이면
						System.out.print("검색할 학생의 번호를 입력하세요 >> ");
						number = sc.nextInt();

						//알맞게 입력했다면
						if(1 <= number && number <= cnt) {		//number 값이 1에서부터 cnt 사이의 값이라면
							flag = true;
							number = number-1;			//이름을 입력받을 때와 값을 일치시킴
							break;
						}
					}
					else {	//select가 2면
						System.out.print("검색하려는 이름을 입력하세요. >> ");
						String name2 = sc.next();
						
						for(int i = 0; i < cnt; i++) {		// cnt만큼 반복
							if(name2.equals(stu[i])) {		// 만약 이름이 일치한다면
								flag = true;				// flag값을 true로 바꿔 결과를 말함
								number = i;
							}	
						}
						
						//알맞게 입력했다면
						if(flag) {				// flag가 true라면
							break;
						}
					}
					
					//재검색 물음
					System.out.println("일치하는 학생이 없습니다.");
					System.out.println("다시 검색하시겠습니까? (Y/N)");
					String answer = sc.next();
					if(answer.equals("N")) {		//'N'라면
						break;	//검색하는 while문 나감
					}
				}				
				
				//변경할 이름이 확실한지 확인 작업
				System.out.println((number+1) + "번 : "+ stu[number]+"의 이름을 변경하시겠습니까? (Y/N)");
				String answer = sc.next();
				
				// 변경한다고 대답한다면
				if(answer.equals("Y")) {	//"Y"라고 대답한다면
					// 변경할 이름을 입력하고, 그 이름으로 할 것인지 확인작업
					while(true) {
						//이름 입력
						System.out.println("변경하실 이름을 입력해주세요. >> ");
						name = sc.next();
					
						System.out.print("정말로 "+ name+"으로 변경하시겠습니까? (Y/N)");
						answer = sc.next();
						if(answer.equals("Y")) {		//'Y'라면
							break;	//이름을 확인하는 while문 나감
						}
						System.out.println("아니라면 다시 입력해주세요.");
					}
					
					//배열의 해당 인덱스에 이름을 수정함
					stu[number] = name;
					System.out.println((number+1) + "번 : "+ stu[number]+"으로 변경되었습니다.");
				}
				System.out.println("메뉴로 돌아갑니다.");
			}
					
			else{		//그 외의 정수를 입력받으면
					System.out.println("제대로 입력해주세요.");
			}
		}
	}
}