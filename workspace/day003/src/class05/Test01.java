package class05;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		String[] datas = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("학생부 프로그램");

		datas[0] = "티모";
		int cnt = 1;

		while (true) {
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

			if (menu == 0) {
				break;
			} 
			else if (menu == 1) { // 학생추가

				if (cnt >= datas.length) { // 저장할 수 있는 최대로 이미 저장되어 있는 경우라면
					System.out.println("데이터를 더 이상 저장할 수 없습니다.");
					continue;
				}

				String name;
				// 정말 __로 하시겠습니까?
				while (true) {
					System.out.print("저장하고 싶은 학생의 이름을 입력해주세요. >> ");
					name = sc.next();

					System.out.println("정말" + name + "으로 하시겠습니까? (Y/N)");
					String answer = sc.next();

					if (answer.equals("Y")) {

						boolean flag = false; //기본적으로 false로 시작, 학생부에 name이 없는 상태
						//기본적으로, 사용자가 입력한 name이 학생부에 없겠지?

						//학생부 데이터들을 하나하나 확인하면서
						//데이터 일치 여부를 판다
						for(int i = 0; i<cnt; i++) {
							if(name.equals(datas[i])) {
								//사용자가 입력한 값이 학생부 데이터와 일치합니까?

								flag = true; //일치한다면 true
								System.out.println(name + "은(는) 이미 존재하는 이름입니다.");
							}
						}

						if(!flag) {	//학생부에 저장되어있지 않다면
							break;
						}
					}
				}
				datas[cnt] = name;
				cnt++;

				System.out.println(name + "이 저장되었습니다.");
			} 
			else if (menu == 2) { // 학생부 전체출력
				if (cnt <= 0) { // 유효성 검사는 넓고 꼼꼼하게
					System.out.println("보여줄 학생 데니터가 없습니다.");
					continue;
				}

				// 1번부터 저장된 학생의 수만큼 출력
				System.out.println("=== 학생 목록 ===");
				for (int i = 0; i < cnt; i++) {
					System.out.println((i + 1) + "번 학생 : " + datas[i]);
				}
				System.out.println("===============");
			} 
			else if (menu == 3) { // 이름으로 검색

				//검색어를 입력 >>
				//이 검색어가 맞습니까? XXX : 사용자가 하는 입력이 데이터에 변화를 주지 않기 때문

				System.out.println("검색어 입력 >> ");
				String searchContent = sc.next();		//searchKeyword

				boolean flag = false;	//검색결과가 없는 상태
				System.out.println("===============");
				// 학생부를 하나하나 확인하면서
				for(int i = 0; i < cnt; i++) {
					//학생의 이름 안에 검색어가 있니?
					if(datas[i].contains(searchContent)) {
						System.out.println((i + 1) + "번 학생 : " + datas[i]);
						flag = true;	//검색 결과를 찾은 상태
					}
					//있다면, 출력
					//없다면, 출력x
				}

				if(!flag) {		// 검색 결과가 없다면
					System.out.println("검색 결과가 없습니다.");
				}
				// 검색결과가 없다면, 없다고 알려주기
				// 1. 검색결과가 없다는 출력은 한번만 수행하기 때문에 반복문 바깥에 있어야함
				// 2. 검색결과가 없다는 사실은 검색을 다~ 해봐야 알 수 있음.
				// ==> flag로직의 대표적인 케이스
				System.out.println("===============");
			} 
			else if (menu == 4) { // 번호로 검색 = > PK로 검색 == selectOne(getOne)
				// Primary Key : "데이터를 '식별'" 할 수 있게 해주는 값
				// ex) 주민번호, 학번, ...
				// 사용자가 지정하는 것이 아니라, 프로그램에서 부여하는 값
				// 현재 학생부 프로그램에서는 '번호' == PK

				if(cnt == 0) {			//학생이 한 명도 저장되어있지 않다면
					System.out.println("검색할 학생 데이터가 없습니다.");
					continue;		//프로그램 처음으로 돌아가기
				}

				int num;
				while(true) {
					System.out.println("검색할 학생의 번호 입력 >> ");
					num = sc.nextInt();
					// 사용자가 검색하고 싶은 번호를 입력 : 유효성 검사
					if(1<=num && num <= cnt) {	//제대로 입력했는지, 경계값 검사
						break;
					}
					//제대로 입력하라고 안내문구 출력
					System.out.println("올바른 번호를 입력해주세요.");
				}
				System.out.println(num + "번 학생의 이름은" + datas[num-1]+"입니다.");
				//사용자가 입력한 번호에 해당하는 학생의 이름은
				// datas[num-1] 입니다.
			} 
			else if (menu == 5) { // 이름변경
				//UPDATE : 업데이트 처리할 대상 데이터가 특정되어있어야 함
				//ex) 프로필 사진 변경, 닉네임 변경

				// 이름을 변경할 학생의 번호 입력 >>
				// PK로 데이터를 특정한 후에 UPDATE를 진행해야함

				if(cnt == 0) {			//학생이 한 명도 저장되어있지 않다면
					System.out.println("변경할 학생 데이터가 없습니다.");
					continue;		//프로그램 처음으로 돌아가기
				}

				int num;
				while(true) {
					System.out.println("변경할 학생의 번호 입력 >> ");
					num = sc.nextInt();
					// 사용자가 검색하고 싶은 번호를 입력 : 유효성 검사
					if(1<=num && num <= cnt) {	//제대로 입력했는지, 경계값 검사
						break;
					}
					//제대로 입력하라고 안내문구 출력
					System.out.println("올바른 번호를 입력해주세요.");
				}
				// PK로 대상을 특정짓는다는 부분이 selectOne과 닮을 수밖에 없다

				//사용자가 A를 변경하고 싶어한다.
				System.out.println(num + "번 학생의 이름은 "+datas[num-1]+"입니다.");

				//B로 이름을 변경
				//정말 변경할지 확인
				String name;
				// 정말 __로 하시겠습니까?
				while (true) {
					System.out.print("변경하려는 이름을 입력해주세요. >> ");
					name = sc.next();

					System.out.println("정말" + name + "으로 하시겠습니까? (Y/N)");
					String answer = sc.next();

					if (answer.equals("Y")) {

						boolean flag = false; //기본적으로 false로 시작, 학생부에 name이 없는 상태
						//기본적으로, 사용자가 입력한 name이 학생부에 없겠지?

						//학생부 데이터들을 하나하나 확인하면서
						//데이터 일치 여부를 판다
						for(int i = 0; i<cnt; i++) {
							if(name.equals(datas[i])) {
								//사용자가 입력한 값이 학생부 데이터와 일치합니까?

								flag = true; //일치한다면 true
								if(datas[num-1].equals(name)) {		//내 이전 이름이면
									System.out.println("이전 이름입니다.");//이전 이름이라 안 됨
								}
								else {
									System.out.println(name + "은(는) 이미 존재하는 이름입니다.");
								}
							}
						}

						if(!flag) {	//학생부에 저장되어있지 않다면
							break;
						}
					}
				}

				//A 자리에 데이터 저장
				datas[num-1] = name;

			} 
			else { // 유효성 검사
				System.out.println("제대로 입력해주세요~~");
			}
		}
	}
}