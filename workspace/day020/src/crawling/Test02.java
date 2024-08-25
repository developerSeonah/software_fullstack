package crawling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 웹 크롤링
public class Test02 {
	public static void main(String[] args) {
		// 크롤링한 데이터를 가져올 웹 페이지 주소 가져오기
		String url = "https://kakamuka.com/product/list.html?cate_no=27";
		 ArrayList<String> productName = new ArrayList<String>();

		// Connection 클래스
		// 해당 url에서 HTML 문서를 가져오기 위한 클래스 생성
		// Jsoup 라이브러리에서 HTTP 또는 HTTPS를 통해 웹 서버와 연결을 설정하고,
		// 웹 페이지의 HTML 문서를 가져오기 위한 기능을 제공
		Connection conn = Jsoup.connect(url);

		try {
			// Document
			// 웹 페이지 화면 문서를 의미함
			Document doc = conn.get();

			// Elements 클래스
			// HTML 문서에서 선택한 요소들을 담는 컬렉션,
			// 배열 형태로 구현되어있다. 
			Elements elems = doc.select("p.name");
			
			// 상품 이름에서 제거할 부분
			String removeName = "상품명 : ";

			for(Element elem : elems) {
				String originalElem = elem.text();
				
				// 요소들의 "상품명 : : 제거
				// String 클래스의 replace 함수를 사용한다.
				String clearName = originalElem.replace(removeName, "");
				
				// 제거된 이름을 넣어줌
				productName.add(clearName);
			}
			
			// 확인용 배열 리스트 출력
			for(String name : productName) {
				System.out.println(name);
			}
		} catch (IOException e) {
			System.out.println("연결중 에러 발생!");
		}
	}
}