package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;
import model.ProductDAO;
import model.ProductDTO;
import view.LoginView;
import view.LogoutView;
import view.MainView;

public class ShoppingController {

	// controller에서 사용하기 위해
	// Model과 View를 멤버변수로 가지고 온다. 
	private MemberDAO memberDAO;
	private ProductDAO productDAO;
	private MainView mainView;
	private LoginView loginView;
	private LogoutView logoutView;
	private MemberDTO user; //현재 상태 로그인,로그아웃 판단하는 변수

	// 장바구니 관리를 위한 ArrayList
	private ArrayList<ProductDTO> basket; // 장바구니 AL

	// 생성자, 멤버변수 초기화
	public ShoppingController(){
		this.memberDAO=new MemberDAO();
		this.productDAO=new ProductDAO();
		this.mainView=new MainView();
		this.loginView=new LoginView();
		this.logoutView=new LogoutView();
		this.user=null;
		this.basket= null;
	}

	// 장바구니 합을 계산하는 함수
	private int basketSum(ArrayList<ProductDTO> datas) {
		// 합(정수 sum)을 담을 변수를 0으로 생성;
		int sum = 0;

		// 합 계산
		for(ProductDTO data : datas) {  // 장바구니만큼 반복
			// sum += 장바구니에서 가격을 뽑음(this.basket.가격) * 갯수를 뽑음(this.basket.구매갯수);
			sum += data.getPrice() * data.getBasketCount();
		}

		return sum;
	}

	//기능 구현 시작, client에서 시작_start
	public void start() {

		// 메뉴 사이즈를 선언하는 변수
		// 현재 로그아웃 상태임(2)
		int menuLoginSize = 6;
		int menuLogoutSize = 3;
		int menuSize = menuLogoutSize;


		while(true){


			// 로그아웃, 로그인 여부과 관계없이 실행시키는 메뉴

			// 먼저 메인뷰 메뉴를 실행시키고(0. 종료 / 1. 상품목록 출력)
			mainView.printMenuList();

			// 로그인/로그아웃 상태에 따라 출력되는 메뉴가 다름
			if(user != null){ // 만약 user가 null이 아니라면 == 로그인 상태라면
				loginView.menuList();
			}
			else{ // user가 null 상태라면 == 로그아웃 상태라면
				logoutView.printMenuList();
			}

			// 메뉴 선택 받기
			//(유효성 검사 : 메뉴사이즈)
			int menu=mainView.inputMenuNum(menuSize);

			if(menu==0) {
				//0. 종료하기 (프로그램 종료)
				mainView.exit();
				break;
			} // 0끝
			else if(menu==1) {//1. 상품 목록 출력
				// 1. 상품 목록 출력_재고 없는 상품에 대해 품절표시

				// DB에서 상품 전체 목록 받아오기 위해 객체 생성
				ProductDTO productDTO = new ProductDTO();
				
				// V에 출력 요청 + Model에서 selectAll로 상품 전체 자료 받가오기
				mainView.printProductMenu(productDAO.selectAll(productDTO));
				
				// 상품 목록을 test.txt 파일로 만드는 부분
				// 파일을 생성할 주소 변수
				String filePath = "D:\\JJH\\resource\\";
				// 파일 이름 변수
				String fileName = "test.txt";
				
				try{
				// 파일 라이더 생성 및 초기화
				FileWriter fileWriter = new FileWriter(filePath + fileName);
				// 파일 버퍼 생성 및 초기화
				BufferedWriter writer = new BufferedWriter(fileWriter);
					
				// 텍스트 파일로 만들 String 타입의 배열 리스트 만들기
				// 배열에 들어가는 값은 상품 목록(selectAll)
				ArrayList<String> datas = new ArrayList<String>();
				 for (ProductDTO data : productDAO.selectAll(productDTO)) {
		                String productData;
		                if (data.getStockCount()==0){ // import된 Product.dto로부터 상품 고유번호, 이름, 가격, 재고량까지 받아서 출력.
		                    productData = "[상품 번호=" + data.getPK() + ", 상품명=" + data.getProductName() + ", 가격=" + data.getPrice() + " 품절" + "]";
		                }
		                else{
		                	productData = "[상품 번호=" + data.getPK() + ", 상품명=" + data.getProductName() + ", 가격=" + data.getPrice() + ", 재고 보유량="
		                            + data.getStockCount() + "]";
		                }
		                datas.add(productData);
		            }
				// 파일 내부에 작성될 내용 상품 목록(selectAll)
				// 배열 리스트에서 한줄한줄 뽑아서 작성하기
				 for (String line : datas) {
		                writer.write(line);
		                writer.newLine(); // 개행 문자 추가, 새로운 줄에 쓰이게 함
		            }
				// 라이더 닫기
					writer.close();
				}
				// 입출력 과정에서 에러 발생 catch문
				catch (IOException e) {
					System.out.println("파일 입출력 에러가 발생했습니다!");
				}
				
				System.out.println("txt 파일이 생성되었습니다.");

			} // 1끝

			if(user==null) { // 만약 로그아웃 상태라면
				//로그아웃뷰에서 메뉴 실행(2. 회원가입 / 3. 로그인)

				if(menu==2) { // 2. 회원가입

					//회원 DB를 가져오기 위해 new DTO 생성
					MemberDTO memberDTO = new MemberDTO(); 


					while(true) { // 아이디 중복검사하고, 중복이면 다시 반복하기 위한 while문

						// V에게서 회원가입을 할 ID를 받아와 저장시킨다
						// id 사용할게 맞는지 유효성 검사
						String id = logoutView.inputNewId();
						memberDTO.setMid(id);
						MemberDTO data= memberDAO.selectOne(memberDTO);

						// M에게서 입력한 아이디가 중복값인지 확인한다. 
						// null 혹은 data 
						// 반환값은 CUD는 boolean, selectOne==DTO All==AL      
						if(data == null) { // 만약 가입하려는 id가 없다면
							// while문을 탈출
							break;
						}
						else{ // 일치하는 ID가 있다면 회원DTO가 null이 아니라면
							// 다시 입력 요청, while문 반복
							logoutView.nameInUse();
						}
					}

					// 비밀번호 V에게 입력 요청 및 입력받기
					// 1차 2차 입력받고 유효성 검사까지 끝나서 가입 완료가 된 자료를 저장
					String pw = logoutView.inputNewPw();
					// ID가 저장된 DTO에 PW DTO 값을 저장해준다
					memberDTO.setPassword(pw);      

					// 합쳐진 ID와 PW를 M에게 보내준다. (insert)
					memberDAO.insert(memberDTO);
					mainView.printTrue();


				}  // 2. 회원가입 끝

				else if(menu==3) { // 3. 로그인

					MemberDTO memberDTO = new MemberDTO(); 

					// V에 아이디와 비밀번호 입력받아오기
					// 받아서 저장할 DTO 생성해서 받아온 ID, PW 저장
					MemberDTO data= logoutView.inputLoginInfo();

					// 회원DTO에 ID, PW 정보를 저장한다.
					// 이는 selectOne에서 검색을 위한 정보이다.
					memberDTO.setMid(data.getMid());

					MemberDTO checkData = new MemberDTO();
					// model의 selectOne에 ID 자료를 넘겨서 저장된 자료가 있는지 확인하고
					// 확인 후 자료가 있으면 ID와 PW 자료가 반환, 없다면 null 값이 반환
					checkData=memberDAO.selectOne(memberDTO);

					if(checkData !=null ) { // 회원정보가 있다면

						if(data.getPassword().equals(checkData.getPassword())) { // 입력받은 비밀번호와 checkData의 비밀번호가 같다면
							// v에 전달해줄 회원 id 저장
							String id = data.getMid();
							// 로그인 상태로 전환한다
							user=data;
							// 로그인 후 상품을 담을 수 있는 장바구니 ArrayList 생성
							basket = new ArrayList<ProductDTO>();
							// 로그인 되었다는 문구 출력
							logoutView.printLoginSuccess(id);
							// 메뉴사이즈 변경
							// 공통 메뉴 + 로그인 or 로그아웃시 메뉴 출력이 다르기 때문에
							// 메뉴 사이즈 변수 설정하여, 최대 메뉴 갯수를 설정해준다.
							// 이 사이즈는 V에 넘어가서 유효성 검사로 사용하게 됨                  
							menuSize = menuLoginSize;
						}
						else {//입력 받은 비밀번호와 checkData의 비밀번호가 다르다면
							logoutView.printLoginFail();
						}
					}
					else { //회원 정보가 없다면, 데이터==null
						logoutView.printLoginFail();
					}

				} // 3. 로그인 끝 

			} // 로그아웃 상태 메뉴 끝


			// 로그인 상태라면
			else if(user!=null) {

				if(menu == 2) {  // 장바구니에 상품 담기
					// 장바구니에 담을 객체 생성
					// new 상품DTO 객체 생성(data);
					ProductDTO data = new ProductDTO();

					// 상품 전체 목록 가져옴
					// new 배열 리스트(datas) 생성;
					// M에게 selectAll()로 모든 데이터를 받아서 datas에 담음;
					ArrayList<ProductDTO> datas = new ArrayList<ProductDTO>();
					datas = productDAO.selectAll(data);

					// V에게 datas 전달, 상품 목록 출력 요청;
					// V에게 품번(정수 oNum)을 반환 받기; (유효성 검사 : datas)
					mainView.printProductMenu(datas);
					int oNum = loginView.productNum(datas);

					// 생성한 객체(data)에 품번 입력(set);
					data.setPK(oNum);

					// M의 selectOne에 data를 주고 값을 반환받음
					// 반환받은 값을 data에 넣어줌;
					data = productDAO.selectOne(data);

					// 장바구니에 담긴 수량이 재고수를 넘지 않게 제한하는 작업
					int indexNum = 0;
					// 동일한 장바구니가 있을 때 재고수 값을 유지하기 위한 변수
					int stockCount = data.getStockCount();
					//장바구니와 같은 것이 있는지 확인하는 변수 false로 생성(boolean flag);
					boolean flag = false;

					// 일치하는 장바구니 위치 찾기
					for(int i = 0; i < this.basket.size(); i++) {	// 장바구니만큼 반복
						if(this.basket.get(i).getPK() == oNum) {	//장바구니 품목이 입력한 품목과 같다면
							indexNum = i;
							// 장바구니 안에 넣을 수 있는 수량 줄이기
							data.setStockCount(data.getStockCount() - this.basket.get(i).getBasketCount());
							//flag를 true로 변경;
							flag = true;
							break;
						}
					}

					// flag가 true일 때
					// 사용자가 입력한 물품이 장바구니에 몇 개 담겼는지 출력
					if(flag) {
						loginView.basketAmountCnt(this.basket.get(indexNum).getProductName(), this.basket.get(indexNum).getBasketCount());
					}

					// V에게 장바구니에 담을 수량을 입력 요청;
					// V에게 재고수를 주고 수량(정수 bNum)을 반환받기;  (유효성 검사: data)
					int bNum = loginView.productAmount(data.getStockCount());

					// 만약 flag가 true라면
					//  == 장바구니에 데이터가 있다면
					if(flag) {
						// 구매갯수(this.basket.구매갯수)에 bNum을 추가로 넣어줌
						this.basket.get(indexNum).setBasketCount(this.basket.get(indexNum).getBasketCount() + bNum);
						this.basket.get(indexNum).setStockCount(stockCount);
						// 밑 내용 스킵
						continue;
					}

					// data에 구매 갯수(this.basket.구매갯수) bNum 추가;
					data.setBasketCount(bNum);
					//장바구니(this.basket) 안에 data 추가;
					this.basket.add(data);

					// 장바구니에 추가 완료했다는 말을 할까?
				} // 2. 장바구니 상품 담기 끝

				else if(menu == 3) {  // 장바구니 상품 목록 출력
					// 합(정수 sum)을 담을 변수를 생성;
					// 함수로 값 가져오기
					int sum = basketSum(this.basket);
					loginView.basketList(this.basket, sum);
				} // 3. 장바구니 상품 목록 출력 끝

				else if(menu == 4) {  // 장바구니 상품 목록 구매
					// 장바구니가 비어있는지 아닌지 확인
					if(this.basket.isEmpty()) {
						// 비어있음 출력
						loginView.basketListEmpty();
						continue;
					}

					// 합(정수 sum)을 담을 변수를 생성;
					// 함수로 값 가져오기
					int sum = basketSum(this.basket);

					// V에게 장바구니(this.basket), 합(sum)을 보냄; (장바구니(물품, 구매갯수), 합)
					// V에게 구매 의사(boolean flag)을 반환받음;
					loginView.basketList(this.basket, sum);
					boolean flag = loginView.buyProduct();

					if(!flag) {
						// 밑의 프로그램 스킵;
						continue;
					}

					// 업데이트 성공에서 한 번 더 사용하기 위해 flag를 true로
					flag = true;
					
					// 상품 구매 성공, 실패를 담는 배열 리스트
					ArrayList<Boolean> buyResult = new ArrayList<Boolean>();

					// 재고 수량 변경
					for(int i = 0; i < this.basket.size(); i++) {	// 장바구니만큼 반복
						// new 상품DTO 객체(data) 생성;
						ProductDTO data = new ProductDTO();
						// M에게 장바구니의 객체를 전달하고 품번과 일치하는 객체를 받아옴(selectOne)
						// data에 M에서 받아온 객체 저장;
						data = productDAO.selectOne(this.basket.get(i));

						// data의 재고 수량을 (this.basket.재고수량 - 구매 갯수(this.basket.구매갯수))을 넣어줌(set);
						int stockNum = this.basket.get(i).getStockCount() - this.basket.get(i).getBasketCount();
						data.setStockCount(stockNum);

						// M에게 이 객체data를 update_상품재고 하도록 전달;
						// update의 boolean값 받아오기
						flag = productDAO.update(data);
						
						buyResult.add(flag);

						// 상품명, 구매갯수를 뽑아서
						String productName = this.basket.get(i).getProductName();
						int buyNum = this.basket.get(i).getBasketCount();

						if(!flag) {	// flag가 false라면
							// V에게 업데이트 실패 출력;
							loginView.buyFail(productName, buyNum);
							// allFlag를 false로;
							continue;
						}

						// V에게 성공 출력
						loginView.buySuccess(productName, buyNum);
					}
					for(int i = 0; i < buyResult.size(); i++) {
						if(buyResult.get(i)) {
							// this.basket에 해당 객체 (remove)
							this.basket.remove(i);
						}
					}
				} // 4. 구매 끝

				else if (menu == 5){ // 장바구니에서 제외(삭제)	
					// 장바구니가 비어있는지 아닌지 확인
					if(this.basket.isEmpty()) {
						// 비어있음 출력
						loginView.basketListEmpty();
						continue;
					}

					// 합(정수 sum)을 담을 변수를 생성;
					// 함수로 값 가져오기
					int sum = basketSum(this.basket);
					loginView.basketList(this.basket, sum);

					// V에게 장바구니를 보냄;
					// V에게 뺄 품번(정수 oNum)을 반환 받음; (유효성 검사 : this.장바구니)
					int oNum = loginView.deleteProductList(this.basket);

					// new 상품DTO 객체 생성(data);
					// 생성한 객체(data)에 품번 입력(set);
					ProductDTO data = new ProductDTO();

					int indexNum = 0;

					// 일치하는 장바구니 위치 찾기
					for(int i = 0; i < this.basket.size(); i++) {	// 장바구니만큼 반복
						if(this.basket.get(i).getPK() == oNum) {	//장바구니 품목이 입력한 품목과 같다면
							indexNum = i;
							break;
						}
					}
					// 반환받은 값을 data에 넣어줌;
					data = this.basket.get(indexNum);

					// V에게 장바구니 안의 구매갯수(this.basket.구매갯수)를 보내고 제외 수량(정수 bNum)을 반환 받음; (유효성 검사: this.장바구니) 
					int bNum = loginView.deleteProductAmount(this.basket.get(indexNum).getBasketCount());

					// 구매갯수(this.basket.구매갯수)의 갯수를 -bNum 한다;
					this.basket.get(indexNum).setBasketCount(this.basket.get(indexNum).getBasketCount() - bNum);

					if(this.basket.get(indexNum).getBasketCount() <= 0) {	// 구매갯수(this.basket.구매갯수)가 0이하라면
						// 해당 상품을 장바구니에서 삭제한다.(remove);
						this.basket.remove(indexNum);
					}
				} // 5. 장바구니에서 제외 끝

				else if(menu==6) { // 6. 로그아웃

					// 로그아웃시 장바구니 초기화!
					this.basket=null;
					// 회원정보 로그아웃으로 변경
					user=null;
					// 메뉴사이즈 변경
					// 공통 메뉴 + 로그인 or 로그아웃시 메뉴 출력이 다르기 때문에
					// 메뉴 사이즈 변수 설정하여, 최대 메뉴 갯수를 설정해준다.
					// 이 사이즈는 V에 넘어가서 유효성 검사로 사용하게 됨   
					menuSize = menuLogoutSize;
				} // 6. 로그아웃 끝
			} // 로그인 상태 끝
		} // 전체 while 끝
	} // start 끝
} // class 끝
