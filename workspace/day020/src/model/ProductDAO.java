package model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class ProductDAO {

	//멤버변수 설정
	private ArrayList<ProductDTO> productDatas;//전체 상품 배열리스트
	private Random rand = new Random();


	//기본생성자 생성
	public ProductDAO(){
		this.productDatas = new ArrayList<ProductDTO>();
		// 상품명을 담을 배열 리스트
		ArrayList<String> productName = new ArrayList<String>();
		// 상품 가격을 담을 배열 리스트
		ArrayList<Integer> productPrice = new ArrayList<Integer>();
		// 상품 PK값
		int PK = 1001;

		//샘플데이터 생성
		//상품 번호, 상품명, 가격, 잔여수량, 품정상태변화 변수 초기화

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
				productName.add(elem.text());
			}
			//상품 가격 부분
			for(Element elem : priceElems) {
				String clearPrice = elem.text().replace(",", "");
				clearPrice = clearPrice.replace("원", "");
				int price = Integer.parseInt(clearPrice);
				productPrice.add(price);
			}

		} catch (IOException e) {
			System.out.println("연결중 에러 발생!");
		}

		for(int i = 0; i<productName.size(); i++) {
			ProductDTO productData = new ProductDTO(); //한 상품 객체 선언
			productData.setPK(PK++);		// 상품 번호 자동 설정
			productData.setProductName(productName.get(i)); //상품 이름
			productData.setPrice(productPrice.get(i)); //상품 가격
			productData.setStockCount(rand.nextInt(101)); //잔여 수량
			productDatas.add(productData);
		}
	}

	//C(create)R(read)U(update)D(delete)기능
	//ProductDTO produtDTO: 상품DAO 요소(PK, 이름, 가격, 재고 수량) 배열

	private boolean insert(ProductDTO productDTO) {
		//기능 미구현으로 hiding
		return false;
	}


	//전체 상품 목록-Read.sellectAll, update 
	//input으로 ProductDTO(상품요소), output으로 productDTO를 반환값으로 받는 함수.
	public ArrayList<ProductDTO> selectAll(ProductDTO productDTO){ 
		System.out.println("model.ProductDAO.SellectAll 전체 상품 목록 시작");  
		ArrayList<ProductDTO> productDatas = new ArrayList<ProductDTO>();//힙메모리에 ProductDTO 타입의 데이터공간 만듦. productDatas변수명에 저장 //Datas객체 생성
		for (ProductDTO productData : this.productDatas) {/*0에서 1씩 증가. productDatas의 크기 이내만큼 참되어 실행문 반복.productData에 넣기*/
			productDatas.add(productData);//productData 받아오기. 받아온 데이터 productDatas에 넣기
		}
		System.out.println("model.ProductDAO.SellectAll 전체 상품 목록 반환");
		return productDatas;//Datas 반환
	}   

	// 선택 상품 보내기. 선택 상품을 반환하는 함수.   
	public ProductDTO selectOne(ProductDTO productDTO){//R.sellectOne
		System.out.println("model.ProductDAO.sellectOne 상품 선택 시작");
		for(ProductDTO productData : this.productDatas) {//컨트롤러가 상품 정보 주면, 그 정보와 일치하는 상품 꺼내기
			if(productData.getPK()==productDTO.getPK()){//2. 전체상품 배열에서 인덱스 번호 찾기(선택상품 PK로)
				// 해당 인덱스 번호의 값 반환값으로 내보내기
				System.out.println("model.ProuductDAO.sellectOne 선택 상품 반환");
				return productData; //선택 상품 데이터 반환
			}   
		}return null;
	}
	public boolean update(ProductDTO productDTO) {//상품 구매 재고 수량 업데이트
		System.out.println("model.ProductDAO.update 시작");
		for(ProductDTO productData:productDatas){/*0에서 1씩 증가. productDatas의 크기 이내만큼 참되어 실행문 반복.productData에 넣기*/
			if(productData.getPK()==productDTO.getPK()/*data에 있는 PK와 구매한 PK가 같을 때*/) {
				productData.setStockCount(productDTO.getStockCount());/*c에서 받아온 stockCount를 data의 stockCount에 넣기*/
				System.out.println("model.ProductDAO.update 종료");
				return true;//수량변경완료
			}
		}
		return false;//수량변경 미진행
	}
	/*
     C : 현재재고-장바구니수량
     U : 그냥 받은값으로 변경
	 */

	private boolean delete(ProductDTO productDTO) {  //기능 미구현으로 hiding
		return false;
	}
}


