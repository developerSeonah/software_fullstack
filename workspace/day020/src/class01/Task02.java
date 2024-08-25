package class01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task02 {
	public static void main(String[] args) {
		//파일 주소, 파일 이름 변수 생성
		String filePath = "D:\\JJH\\resource\\";
		String fileName = "이미지.jpg";
		// 저장할 파일 이름
		String outputFileName = "이미지2.jpg";

		// FileInputStream 선언
		// FileReader은 텍스트를 읽기 위한 목적으로 설계되어서 사진 파일같은 이진 데이터를 읽을 때에는 적합하지 않다.
		// 파일을 읽기위한 클래스타입 선언
		FileInputStream fis;

		// FileOutStream 선언
		// 파일을 쓰기(저장)하기 위한 클래스타입 선언
		FileOutputStream fos;

		// 파일 읽어들이기
		try {
			// 파일을 읽기 위한 객체 공간 생성(초기화)
			fis = new FileInputStream(filePath + fileName);

			// 파일을 쓰기 위한 객체 공간 생성(초기화)
			fos = new FileOutputStream(filePath+outputFileName);

			// 파일 크기만큼의 버퍼를 생성하여 한 번에 읽고 쓰기
			// 파일에서 한 번에 읽어올 크기(1024)를 설정
			byte[] buffer = new byte[1024];
			int byteRead;

			// 파일을 다 읽으면 종료
			// 파일을 읽었을 때 데이터가 아무것도 없을 경우 -1이 반환됨
			while((byteRead = fis.read(buffer)) != -1) {
				// 읽은 내용 새 파일에 쓰기
				// (데이터를 쓸 바이트 배열, 시작 위치, 쓸 데이터의 길이)
				//
				fos.write(buffer, 0, byteRead);
			}

			System.out.println("이미지 파일을 성공적으로 복사했습니다.");


		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}