package class05;

import java.util.Random;
import java.util.Scanner;

class Student{
	int num;
	String name;
	int score;
	char grade;

	Student(int num, String name){
		this(num, name, 0);
	}
	Student(int num, String name, int score){
		this.num = num;
		this.name = name;
		this.score = score;
		this.grade = 'C';
		if(this.score >= 80) {
			this.grade = 'A';
		}
		else if(this.score >= 60) {
			this.grade = 'B';
		}
	}

	void printInfo() {
		System.out.println(this.num+"번 "+this.name+" 점수 : "+this.score+", 등급 : "+ this.grade+" 입니다.");
	}
}

public class Test01 {
	
	public static boolean isEmpty(int cnt) {
		if(cnt <= 0) {
			System.out.println("데이터가 비어있습니다.");
			return true;
		}
		return false;
	}
	public static boolean isFull(int cnt, Student[] datas) {
		if(cnt >= datas.length) {
			System.out.println("빈 공간이 없습니다.");
			return true;
		}
		return false;
	}

	public static int selectOne(int cnt, Student[] datas) {
		Scanner sc = new Scanner(System.in);

		//번호 검색
		// 알맞은 범위의 값을 입력했나?(유효성 검사)
		int num;
		// 중간에 전학이나 없는 학생이 있는 경우도 생각
		while(true) {
			System.out.print("학번을 입력하세요 >> ");
			num = sc.nextInt();
			// 학번이 시작하는 곳 부터 여유값 2000 사이값만 통과
			if(1001 <= num && num < 2000) {
				return num;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//샘플 데이터 확보
		int PK = 1001;		// 시스템에서 부여한 PK값
		int cnt = 0;		// 현재 배열에 저장된 데이터의 개수
		Student[] datas = new Student[3];
		datas[0] = new Student(PK++, "티모", 50);
		cnt++;

		while (true) {

			System.out.println("===== 메뉴 =====");
			System.out.println("1. 학생추가");
			System.out.println("2. 전체목록출력");
			System.out.println("3. 번호검색");
			System.out.println("4. 이름검색");
			System.out.println("5. 1등출력");
			System.out.println("6. 등급 검색");
			System.out.println("7. 재시험");
			System.out.println("0. 프로그램종료");
			System.out.println("==============");
			System.out.print("메뉴입력 >> ");
			int menu = sc.nextInt();

			if(menu==0) {
				break;
			}
			else if(menu==1) {	//학생 추가
				// 빈 공간이 없다면
				if(isFull(cnt, datas)) {
					continue;
				}
				
				// 학생입력
				String name;
				int score;
				while(true) {
					System.out.print("이름 입력 >>");
					name = sc.next();
					// 입력값 확인받기
					System.out.print("정말 "+name+"으로 하시겠습니까? (Y/N) >> ");
					String ans = sc.next();
					//만약 "Y"라고 답한다면
					if(ans.equals("Y")) {
						break;	//반복문 나감
					}
				}
				// 성적 입력
				while(true) {
					System.out.print("성적 입력 >>");
					score = sc.nextInt();
					// 0~100 사이값만 입력 가능하도록(유효성 검사)
					if(0 <= score && score <= 100) {
						break;
					}
					System.out.println("0~100 사이값만 입력하세요.");
				}

				// 배열에 입력
				datas[cnt++] = new Student(PK++, name, score);

			}
			else if(menu==2) {	// 전체 출력
				if(isEmpty(cnt)) {
					continue;
				}

				System.out.println("===================");
				for (int i = 0; i < cnt; i++) {
					// datas == 배열 == 학생부
					// datas[i] == 배열의 요소 == 학생
					// datas[i].num == 학생.번호 == 학생의 번호
					datas[i].printInfo();
				}
				System.out.println("===================");
			}
			else if(menu==3) {	// 번호 검색(PK)
				// 학생부가 비어있다면
				if(isEmpty(cnt)) {
					continue;
				}

				// 중간에 전학이나 없는 학생이 있는 경우도 생각
				int num = selectOne(cnt, datas);

				boolean flag = false;

				for(int i = 0; i < cnt; i++) {
					if(datas[i].num == num) {
						//현재 살펴보고 있는 학생.번호 == 사용자가 입력한 번호
						flag = true;
						datas[i].printInfo();
					}
				}
				if(!flag) {
					System.out.println("검색 결과가 없습니다....");
				}
			}
			else if(menu==4) {	//이름 검색
				// 학생부가 비어있다면
				if(isEmpty(cnt)) {
					continue;
				}

				// 검색어를 입력받는다.
				System.out.print("검색어 입력 >> ");
				String name = sc.next();

				//검색어가 있는지 없는지 상태
				boolean flag = false;
				// 전체 목록을 확인하며 해당 검색어가 포함되어있는지 확인
				System.out.println("==================");
				for(int i = 0; i < cnt; i++) { // 목록 전체 동안
					if(datas[i].name.contains(name)) {
						datas[i].printInfo();
						flag = true;
					}
				}

				if(!flag) {
					System.out.println("검색 결과가 없습니다.");
				}
				System.out.println("==================");	
			}
			else if(menu==5) {	// 1등 출력
				// 첫 번째 값을 기준점으로 잡음
				// 1등 위치 넣을 변수, 첫 번째 학생 위치를 기준점으로
				int pivot = datas[0].score;
				int first = 0;

				// 가장 높은 점수 찾기
				// 목록 전체 점수값을 보면서
				for(int i = 0; i < cnt; i++) {
					// 만약 기준점보다 다른 학생의 점수가 더 높다면
					if(pivot < datas[i].score) {
						// 기준점에 더 큰 값과 학생(배열)의 위치 새로 대입
						pivot = datas[i].score;
						first = i;
					}
				}
				System.out.println("1등");
				datas[first].printInfo();

				// 1등 동점자 찾기
				// 가장 높은 점수를 찾을 때 가장 먼저 높은 점수를 얻은 사람이 기준값이 되므로
				// 해당 학생 이후 학생부터 반복 실행
				for(int i = first+1; i < cnt; i++) {
					if(pivot == datas[i].score) {
						datas[i].printInfo();
					}
				}
			}
			else if(menu==6) {	// 등급 검색
				// A, B, C 중 하나를 입력받는다.
				// 그 외의 값을 받는다면 알맞은 값을 받을 때까지 반복(유효성 검사)
				char grade;
				while(true) {
					System.out.print("검색할 등급을 입력 >> ");
					// Scanner은 문자를 입력받는 기능이 없다.
					// 문자열을 문자로 변경 : 
					// 		문자열을 쪼개서 첫번째 문자를 가져옴 
					grade = sc.next().charAt(0);

					// 문자는 아스키코드에 의해 숫자값을 갖고 있다.
					// grade가 'A'와 'C' 사이의 문자라면
					if('A'<= grade && grade <= 'C') {
						break;		// 반복문 나감
					}

					System.out.println("A~C 사이의 등급을 입력하세요.");
				}

				// 목록 전체에서 학생의 등급이 입력한 등급인지 확인
				// 만약 해당 등급이라면 출력
				for(int i = 0; i < cnt; i++) {
					if(grade == datas[i].grade) {
						datas[i].printInfo();
					}
				}

			}
			else if(menu==7) {	// 재시험
				// 학생부가 비어있다면
				if(isEmpty(cnt)) {
					continue;
				}

				// 재시험을 볼 사람을 선택해주세요
				// 등록된 학생 안에서만 선택(유효성 검사)
				// 번호 검색
				int num = selectOne(cnt, datas);

				//일치하는 사람의 점수를 랜덤값으로 변환
				// 0~100 사이값
				Random rand = new Random();
				int newScore = rand.nextInt(101);

				boolean flag = false;

				for(int i = 0; i < cnt; i++) {
					if(datas[i].num == num) {
						//현재 살펴보고 있는 학생.번호 == 사용자가 입력한 번호
						datas[i].score = newScore;
						datas[i].printInfo();

						flag = true;
					}
				}
				if(!flag) {
					System.out.println("검색 결과가 없습니다....");
				}

			}
			else {
				System.out.println("잘못된 입력입니다!");
			}

		}
	}
}
