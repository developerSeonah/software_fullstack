package class01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		// 실습경로
		String filePath = "D:\\JJH\\workspace\\day020\\src\\class01\\";
		// 파일을 찾을 때 경러가 필요

		String fileName = "test.txt";	
		// 확장자를 반드시 함께 작성

		// 사용자 이름을 받음
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자의 이름을 작성해 주세요. >> ");
		String name = sc.next();


		// 파일 리더 선언
		FileReader fileReader;
		// 파일에서 읽은 라인을 넣을 변수, 초기화
		String line = "";

		try {
			// 파일 리더 생성
			fileReader = new FileReader(filePath + fileName);

			// 버퍼 리더 생성
			BufferedReader reader = new BufferedReader(fileReader);

			// 파일 안의 내용을 한 줄만 읽음
			// 정답 내용 가져옴
			line = reader.readLine();
		} 
		// 파일을 찾지 못했을 때 catch문
		catch (FileNotFoundException e) {
			System.out.println("파일 이름이나 주소가 잘못되었습니다.");
		} 
		// 입출력 과정에서 에러 발생 catch문
		catch (IOException e) {
			System.out.println("입출력 과정 중에 에러가 발생했습니다.");
		}

		// 활용 설명
		// updown 게임
		// String으로 받은 정답을 정수로 변환
		int ansNum = Integer.parseInt(line);
		// 최소, 최대 범위
		int startNum = 1;
		int endNum = 50;
		// 시도 횟수
		int cnt = 0;

		// 게임 시작
		while(true) {
			// 사용자에게 받을 값
			int num;
			// 값 입력 유효성 검사
			while(true) {
				System.out.println(startNum + "~"+endNum+" 중에서 정수 입력 >> ");
				num = sc.nextInt();

				// 해당 범위 내 값만 통과
				if(startNum <= num && num <= endNum) {
					break;
				}
				System.out.println("다시 입력해주세요.");
			}

			// 시도 횟수 증가
			cnt++;

			// 만약 정답보다 크다면
			if(ansNum < num) {
				System.out.println("Down!");
				// 최대 범위 변경
				endNum = num -1;
			}
			// 만약 정답보다 작다면
			else if(num < ansNum) {
				System.out.println("Up!");
				// 최소 범위 변경
				startNum = num +1;
			}
			// 사용자가 정답을 맞추면 종료
			else {
				break;
			}
		}
		System.out.println("정답입니다!");

		// 파일 라이더 생성
		FileWriter fileWriter;
		try {
			// 파일 리더 선언
			fileWriter = new FileWriter(filePath + fileName);

			// 파일 writer은 파일을 덮어쓰는 방식
			BufferedWriter writer = new BufferedWriter(fileWriter);

			// 파일 내부에 작성될 내용
			writer.write(name+"님이 "+cnt+"번만에 정답을 맞추셨습니다!");
			
			// 닫아줘야 작성이 완료됨
			writer.close();
		} 
		// 입출력 과정에서 에러 발생 catch문
		catch (IOException e) {
			System.out.println("파일 입출력 에러가 발생했습니다!");
		}
	}
}