package crawling;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 웹 크롤링
public class Test03 {
	public static void main(String[] args) {
		// 크롤링한 데이터를 가져올 웹 페이지 주소 가져오기
		String url = "http://camelmart.godomall.com/goods/goods_list.php?cateCd=026";

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
			Elements elems = doc.select("strong.item_name");
			Elements priceElems = doc.select("strong.item_price");

			// 상품명 부분
			for(Element elem : elems) {
				System.out.println(elem.text());
			}
			//상품 가격 부분
			for(Element elem : priceElems) {
				String clearPrice = elem.text().replace(",", "");
				clearPrice = clearPrice.replace("원", "");
				int price = Integer.parseInt(clearPrice);
				System.out.println(price);
			}

		} catch (IOException e) {
			System.out.println("연결중 에러 발생!");
		}
//		String won = "2,100";
//		won = won.replace(",", "");
//		System.out.println(Integer.parseInt(won));
	}
}