package crawling;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// java.xxx.Xxxx
// org.xxx.Xxxx
// 회사명.xxx.Xxx >> 외부 라이브러리

// 스크랩핑		: 데이터를 모으기
// 크롤링			: 모인 데이터를 가공 (분석), 보통 스크랩핑과 같이 감
//							==> 모아서 정제 및 가공
//					웹 크롤링 : 웹 데이터를 모아서 정제 및 가공
// 데이터 시각화	: 시각화한다. (python을 주로 사용함)

// 정적 크롤링 => 웹 페이지에만 접근
//				페이지에 직접 작성된 데이터만 접근
//				"페이지 소스 코드 보기"로 보이는 데이터만 가져오는 것
//				ex) jsoup <<
// 동적 크롤링 => 웹 페이지가 참조하는 데이터까지 접근 가능
//				본 서버으 ㅣ데이터를 암호화했다면 접근 불가능
//				ex) 셀레니움 << 웹 포트폴리오 작업할 때 사용해보세요!

// 오피지지 웹 사이트는
// 페이지 골격 코드만 만듦
// 실시간으로 데이터를 본 서버에서 받아오는 구조
//	=> 동적 크롤링을 사용해야 함

// 웹 크롤링
public class Test01 {
	public static void main(String[] args) {
		String url = "https://www.melon.com/";
		// 웹 페이지에서 "index"란, 표지 페이지(첫 페이지)를 의미

		Connection conn = Jsoup.connect(url);
		// Jsoup으로 연결 시도
		// 연결객체가 반환 됨

		// Jsoup은 JAVA의 기본 패키지가 아니다.
		// 					라이브러리 == 소스코드 모음집
		// Jsoup 라이브러리를 별도로 설치해야 함
		// 		.jar Java아카이브 == JAVA 압축파일 == 소스코드 모음집 == 라이브러리 == 패키지

		try {
			Document doc = conn.get();
			// Document란?
			// 웹 페이지 화면 문서를 의미함
			
			Elements elems = doc.select("a.ellipsis");
			// cssQuery : Css 언어
			// Elements : 요소들
			// 				웹 개발에서는 모든 것을 요소로 봄
			
			for(Element elem : elems) {
				System.out.println(elem.text());
			}

		} catch (IOException e) {
			System.out.println("연결중 에러 발생!");
		}


	}
}