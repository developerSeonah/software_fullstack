package class02;

import java.util.Scanner;

public class Test01Repeat {
	
	// 샘플 데이터
	public static int sampleData(String[] datas) {
		// 샘플 데이터를 설정하는 함수
		// 데이터의 값을 넣어주고,
		// 들어있는 데이터의 갯수를 반환
		datas[0] = "티모";
		int cnt = 1;
		
		return cnt;
	}

	// 메뉴 입력
	public static int menuEnter() {
		// 메뉴를 출력하고,
		// 선택한 메뉴 값을 반환
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 학생추가");
		System.out.println("2. 학생부 전체출력");
		System.out.println("3. 이름으로 검색");
		System.out.println("4. 번호로 검색");
		System.out.println("5. 이름변경");
		System.out.println("0. 프로그램종료");
		System.out.println("==============");
		System.out.print("메뉴 입력 >> ");
		int menu = sc.nextInt();
		
		return menu;
	}

	// 데이터가 다 찬 경우
	public static boolean isFull(int cnt, String[] datas) {
		// 학생부가 다 찬 경우 true를 반환하는 함수
		if (cnt >= datas.length) { // 저장할 수 있는 최대로 이미 저장되어 있는 경우라면
			System.out.println("학생부에 빈 공간이 없습니다.");
			return true;
		}
		return false;
	}
	
	// 데이터가 빈 경우
	public static boolean isEmpty(int cnt) {
		// 학생부가 비어있는 경우 true를 반환하는 함수
		if (cnt <= 0) { // 유효성 검사는 넓고 꼼꼼하게
			System.out.println("보여줄 학생 데이터가 없습니다.");
			return true;
		}
		return false;
	}
	
	// 학생 입력
	public static String studentEnter(String option, int cnt, String[] datas) {
		// 학생 이름을 입력하는 함수
		// 학생의 이름을 입력,
		// 중복을 확인
		// 학생 추가와, 이름 변경에서 사용
		Scanner sc = new Scanner(System.in);
		String name;
		
		while (true) {
			System.out.print(option + "하고 싶은 학생의 이름을 입력해주세요. >> ");
			name = sc.next();

			System.out.print("정말" + name + "으로 하시겠습니까? (Y/N)");
			String answer = sc.next();

			if (answer.equals("Y")) {

				boolean flag = false; // 기본적으로 false로 시작, 학생부에 name이 없는 상태

				// 학생부 데이터들을 하나하나 확인하면서
				// 데이터 일치 여부를 판단
				for (int i = 0; i < cnt; i++) {
					if (name.equals(datas[i])) {	// 사용자가 입력한 값이 학생부 데이터와 일치합니까?
						flag = true; // 일치한다면 true
						System.out.println(name + "은(는) 이미 존재하는 이름입니다.");
					}
				}

				if (!flag) { // 학생부에 저장되어있지 않다면
					break;
				}
			}
		}
		return name;
	}
	
	// 학생부 출력
	public static void printStudent(int cnt, String[] datas) {
		// 학생부에 있는 모든 이름을 출력하는 함수
		// 1번부터 저장된 학생의 수만큼 출력
		System.out.println("=== 학생 목록 ===");
		for (int i = 0; i < cnt; i++) {
			System.out.println((i + 1) + "번 학생 : " + datas[i]);
		}
		System.out.println("===============");
	}
	
	// 이름 검색
	public static void searchName(int cnt, String[] datas) {
		// 학생부에 있는 이름 중 사용자가 원하는 문자열이 포함되어있는 이름을 출력하는 함수
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어 입력 >> ");
		String searchContent = sc.next(); // searchKeyword

		boolean flag = false; // 검색결과가 없는 상태
		System.out.println("===============");
		// 학생부를 하나하나 확인하면서
		for (int i = 0; i < cnt; i++) {
			// 학생의 이름 안에 검색어가 있니?
			if (datas[i].contains(searchContent)) {
				System.out.println((i + 1) + "번 학생 : " + datas[i]);
				flag = true; // 검색 결과를 찾은 상태
			}
		}

		if (!flag) { // 검색 결과가 없다면
			System.out.println("검색 결과가 없습니다.");
		}
		
		System.out.println("===============");
	}
	
	// 번호 검색
	public static void selectOne() {
		// 사용자가 입력한 값에 해당하는 번호를 가진 이름을 출력하는 함수

	}

	public static void main(String[] args) {

		String[] datas = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("학생부 프로그램");
		
		int cnt = sampleData(datas);

		while (true) {

			int menu = menuEnter();

			if (menu == 0) {
				break;
			} 
			else if (menu == 1) { // 학생추가
				//데이터가 다 찬 경우
				if (isFull(cnt, datas)) { // 저장할 수 있는 최대로 이미 저장되어 있는 경우라면
					continue;
				}
				//이름 입력
				String name = studentEnter("저장", cnt, datas);

				datas[cnt] = name;
				cnt++;

				System.out.println(name + "이 저장되었습니다.");
			} 
			else if (menu == 2) { // 학생부 전체출력
				// 학생부 안에 값이 없을 때
				if (isEmpty(cnt)) { // 유효성 검사는 넓고 꼼꼼하게
					continue;
				}

				// 학생부 출력
				printStudent(cnt, datas);
				
			} 
			else if (menu == 3) { // 이름으로 검색
				// 이름 검색
					searchName(cnt, datas);
			} 
			else if (menu == 4) { // 번호로 검색 = > PK로 검색 == selectOne(getOne)
				// 학생부 안에 값이 없을 때------------------------------------------------------
				if (cnt == 0) { // 학생이 한 명도 저장되어있지 않다면
					System.out.println("검색할 학생 데이터가 없습니다.");
					continue; // 프로그램 처음으로 돌아가기
				}

				// 번호 검색----------------------------------------------------------------------
				int num;
				while (true) {
					System.out.println("검색할 학생의 번호 입력 >> ");
					num = sc.nextInt();
					// 사용자가 검색하고 싶은 번호를 입력 : 유효성 검사
					if (1 <= num && num <= cnt) { // 제대로 입력했는지, 경계값 검사
						break;
					}
					// 제대로 입력하라고 안내문구 출력
					System.out.println("올바른 번호를 입력해주세요.");
				}
				System.out.println(num + "번 학생의 이름은" + datas[num - 1] + "입니다.");
				// 사용자가 입력한 번호에 해당하는 학생의 이름은
				// datas[num-1] 입니다.
			} else if (menu == 5) { // 이름변경
				// 학생부 안에 값이 없을 때------------------------------------------------------
				if (cnt == 0) { // 학생이 한 명도 저장되어있지 않다면
					System.out.println("변경할 학생 데이터가 없습니다.");
					continue; // 프로그램 처음으로 돌아가기
				}

				//번호 검색-----------------------------------------------------------------------
				int num;
				while (true) {
					System.out.println("변경할 학생의 번호 입력 >> ");
					num = sc.nextInt();
					// 사용자가 검색하고 싶은 번호를 입력 : 유효성 검사
					if (1 <= num && num <= cnt) { // 제대로 입력했는지, 경계값 검사
						break;
					}
					// 제대로 입력하라고 안내문구 출력
					System.out.println("올바른 번호를 입력해주세요.");
				}

				System.out.println(num + "번 학생의 이름은 " + datas[num - 1] + "입니다.");


				//이름 입력----------------------------------------------------------------------
				String name = studentEnter("변경", cnt, datas);

				// A 자리에 데이터 저장
				datas[num - 1] = name;

			} else { // 유효성 검사
				System.out.println("제대로 입력해주세요~~");
			}
		}
	}
}
