package class03;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
	private int num;
	private String name;
	private int score;

	Student(int num, String name, int score){
		this.name = name;
		this.num = num;
		this.score = score;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", score=" + score + "]";
	}	
}

public class Test03 {
	public static String enterName() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			// 검색할 이름을 입력받음
			System.out.print("이름 입력 >>");
			String name = sc.next();

			// 정말 그걸로 하시겠습니까?
			System.out.print("정말 "+name+"으로 검색하시겠습니까? (Y/N) ");
			String answer = sc.next();
			// 만약 Y or Yes면
			if(answer.equals("Y")||answer.equals("Yes")) {
				return name;
			}
		}
	}

	public static int selectNumber(int start, int end) {
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			// 학생 번호 범위를 출력
			System.out.println(start + " ~ "+ end +"까지의 번호를 검색하세요.");
			// 학생 번호를 입력받음
			System.out.print("번호 입력 >> ");
			num = sc.nextInt();

			if(start <= num && num <= end) {
				// 반복문을 나감
				return num;
			}
			//존재하지 않는 번호입니다. 출력
			System.out.println("존재하지 않는 번호입니다.");
		}
	}

	public static int searchNumber(ArrayList<Student> datas) {
		int num = selectNumber(1001, 1000+datas.size());

		// 번호에 맞는 값을 찾았다면 true
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i).getNum() == num)	{	// 만약 번호가 일치한다면
				num = i;
				// 위치를 반환;
				return num;
			}
		}

		// 만약 존재하지 않는다면
		// 배열에 존재하지 않는 위치인 -1을 반환
		System.out.println("검색 결과 없음");
		return -1;		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Student> datas = new ArrayList<Student>();
		// 배열 역할을 하는 컬렉션 배열 리스트
		// 학생부 역할

		// [샘플 데이터]
		int PK = 1001;	// 시스템에서 부여
		datas.add(new Student(PK++, "홍길동", 50));
		datas.add(new Student(PK++, "아무무", 0));
		datas.add(new Student(PK++, "티모", 100));
		// [전체 출력]
		// [학생 추가]

		while(true) {

			System.out.println("=== 메 뉴 ===");
			System.out.println("1. 학생추가");
			System.out.println("2. 전체출력");
			System.out.println("3. 번호검색");
			System.out.println("4. 이름검색");
			System.out.println("5. 평균출력");
			System.out.println("6. 점수변경");
			System.out.println("7. 학생삭제");
			System.out.println("0. 프로그램 종료");
			System.out.println("==========");

			int action=selectNumber(0, 7);

			if(action==0) {
				break;
			}
			else if(action==1) {		// 학생 추가
				// 학생 이름을 입력받음
				String name = enterName();

				System.out.println("성적 입력 >> ");
				int score = selectNumber(0, 100);

				datas.add(new Student(PK++, name, score));
				System.out.println("학생 데이터 추가 완료!");
			}
			else if(action==2) {		// 전체 출력
				if(datas.isEmpty()) {		// 비어있다면
					System.out.println("출력 데이터가 없습니다.");
					continue;
				}

				for(Student data : datas) {
					System.out.println(data);
				}

			}
			else if(action==3) {		// 번호 검색
				if(datas.isEmpty()) {		// 비어있다면
					System.out.println("출력 데이터가 없습니다.");
					continue;
				}
				// 학생 번호를 찾음
				int num = searchNumber(datas);

				// 만약 학생을 찾았다면 
				if(num >= 0) {
					//num 위치의 해당 학생 출력
					System.out.println(datas.get(num));
				}
			}
			else if(action==4) {		// 이름 검색
				if(datas.isEmpty()) {		// 비어있다면
					System.out.println("출력 데이터가 없습니다.");
					continue;
				}

				// 학생 이름을 입력받음
				String name = enterName();

				// 학생 이름이 없는 경우를 판단할 flag
				boolean flag = false;

				// 포함되어있는지 판단
				// 배열만큼
				System.out.println("==== 검색 결과 ====");	        	 
				for(Student data : datas) {
					//만약 입력한 문자열이 학생의 이름에 포함되어있다면
					if(data.getName().contains(name)) {
						// 출력
						System.out.println(data);
						// flag를 true로
						flag = true;
					}
				}

				// 만약 flag가 false라면
				if(!flag) {
					// 검색 결과가 없습니다. 출력
					System.out.println("검색 결과가 없습니다.");
				}
				System.out.println("=================");

			}
			else if(action==5) {		// 평균 출력
				if(datas.isEmpty()) {		// 비어있다면
					System.out.println("출력 데이터가 없습니다.");
					continue;
				}

				// 합을 담을 정수형 변수 sum
				int sum = 0;

				// 배열 크기만큼 반복
				for(Student data : datas) {
					// 배열의 점수만 가져와서 sum에 저장
					sum += data.getScore();
				}

				// 실수형 변수 avg = sum / 배열의 크기
				double avg = 1.0 * sum / datas.size();

				// 평균 출력
				System.out.println("평균 : "+ avg);

			}
			else if(action==6) {		// 점수 변경
				if(datas.isEmpty()) {		// 비어있다면
					System.out.println("출력 데이터가 없습니다.");
					continue;
				}

				// 학생 번호로 검색(함수), PK값으로 위치 값 받음
				// 정수 변수 num
				int num = searchNumber(datas);

				// 변경할 값을 입력 받음 (함수)
				// 0 ~ 100 사이 값
				// 정수 변수 score
				System.out.println(datas.get(num));
				int score = selectNumber(0, 100);

				// num 인덱스 위치의 학생에게 score 값을 입력
				// 바뀐 값 출력
				datas.get(num).setScore(score);
				System.out.println(datas.get(num));
			}
			else if(action==7) {		// 학생 삭제
				if(datas.isEmpty()) {		// 비어있다면
					System.out.println("출력 데이터가 없습니다.");
					continue;
				}

				// 학생 번호로 검색(함수), PK값으로 위치 값 받음
				// 정수 변수 num
				int num = searchNumber(datas);
				
				// 만약 없다면
				if(num <= 0) {
					continue;
				}

				// num 인덱스 위치의 학생 삭제(remove)
				datas.remove(num);

			}
			else {
				System.out.println("잘못된 입력입니다!");
			}
		}
	}
}