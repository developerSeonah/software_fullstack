package class01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// [파일 입출력]
public class Test01 {
	public static void main(String[] args) {
		// 파일 입출력 설명
		// 실습경로
		String filePath = "D:\\JJH\\workspace\\day020\\src\\class01\\";
		// 파일을 찾을 때 경러가 필요
		
		String fileName = "test.txt";	
		// 확장자를 반드시 함께 작성
		
		FileReader fileReader;
		String line = "";
		try {
			fileReader = new FileReader(filePath+fileName);
			// fileReader가 올바르게 작동해야지
			BufferedReader reader = new BufferedReader(fileReader);
			// BufferedReader가 작동
			// 버퍼 깜빡이는 커서를 의미
			
			// 한 번만 읽어들임
			line = reader.readLine();
			
			/*
			// 한 줄 씩 읽음
			// 읽은 줄이(해당 라인이) 빈 라인이 나올 때까지 반복 
			while((line = reader.readLine()) != null) {
				System.out.println("line : "+ line);
			}
			*/
			// 코드가 패턴화(템플릿화) 되었다.
		} catch (FileNotFoundException e) {
			// 확장자를 빼거나, 파일명에 오타가 있을 경우
			System.out.println("파일명이 올바르지 않습니다.");
		} catch (IOException e) {
			System.out.println("입출력 과정중에 에러가 발생했습니다.");
		}
		
		// 활용 설명
		// updown 게임
		int ansNum = Integer.parseInt(line);
		int startNum = 1;
		int endNum = 50;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(startNum + "~"+endNum+" 중에서 정수 입력 >> ");
			int num = sc.nextInt();
			
			if(ansNum < num) {
				System.out.println("Down!");
				endNum = num -1;
			}
			else if(num < ansNum) {
				System.out.println("Up!");
				startNum = num +1;
			}
			// 사용자가 정답을 맞추면 종료
			else {
				break;
			}
		}
		System.out.println("정답입니다!");
	}
}
