package view;
/*
1. 로그아웃 
2. 장바구니에 상품 담기 
3. 장바구니에 담긴 상품 목록 출력
4. 장바구니에 담긴 상품 목록 구매
5. 장바구니에서 상품 빼기 
 */

import java.util.ArrayList;

import model.ProductDTO;

// void로 우선 사용 model 완성 후 변경 / 인자값도 넣지 않음
public class LoginView extends View { // 메인에서 abstract class View 선언

   public void menuList () { // 메뉴 출력
      System.out.println("2. 장바구니에 상품 담기");
      System.out.println("3. 장바구니에 담긴 상품 보기");
      System.out.println("4. 장바구니에 있는 상품 구매");
      System.out.println("5. 장바구니에 담긴 상품 삭제");
      System.out.println("6. 로그아웃");
   }
   public int productNum(ArrayList<ProductDTO> datas) { // 상품 번호 입력
      int num; // 스코프 맞추기
      while(true){ // 사용자가 몇번만에 입력할지 몰라 while
         try{ // 사용자의 입력 값이 잘못 될 수 있기 때문에 try로 감쌈
            System.out.println("장바구니에 담을 상품의 번호를 입력해주세요 >> ");
            num=sc.nextInt(); // 입력 받은 값을 저장
         }
         catch(Exception e){ // 오류 코드 이름을 몰라 최상위 클래스인 Exception을 사용
            System.out.println("올바른 상품 번호를 다시 입력해주세요!");
            continue; // 올바른 값을 입력 할 때 까지
         }

         for(ProductDTO data : datas) { // 배열을 비교해서
            if(num==data.getPK()) { // 사용자가 입력한 값이 배열안에 있다면
               if(data.getStockCount() == 0) {// data에 재고가 0이라면 false기 때문에 break를 만나서
                  break; // for문을 종료하고 while문으로 다시 돌아감
               }
               return num;
            }
         }
      }
   }
   // 가독성생각해서 메서드명 정의해보면어떨까?
   public void basketListEmpty() { // 장바구니가 비어있을때 비어있다고 출력해주는 메서드
      System.out.println("장바구니가 비어있습니다..");
   }
   public void basketList(ArrayList<ProductDTO> datas, int sum) { // 담아놓은 장바구니 목록 출력
      if(datas.size()<=0) { // 만약 배열의 크기가 0과 같거나 작다면
         System.out.println("장바구니가 비어있습니다..");
         return;
      }
      // 장바구니에 상품이 있다면 장바구니 목록을 출력
      System.out.println("=== 장바구니 목록 ===");
      for(ProductDTO data:datas) { // 장바구니 배열을 확인하면서
         System.out.println("상품 번호 : "+data.getPK()+" | "+"상품 이름 : "+data.getProductName()+" | "+"상품 가격 : "+data.getPrice()+"원"+" | "+"장바구니에 있는 상품 수량 : "+data.getBasketCount()+"개"); // 상품 정보 출력
      }
      System.out.println("장바구니에 담긴 상품의 총합 : "+sum); // sum은 장바구니 상품의 총합 가격
      // 상품 PK, 상품 이름, 상품 가격, 상품 수량 출력
   }
   // 인자 타입 한글로 정의해두기
   public int productAmount(int stockCount) { // 구매를 원하는 제품 수량 입력 받는 메서드
      int num; // 스코프 맞추기
      if(stockCount==0) {
         System.out.println("상품의 최대 수량을 담았습니다.");
         return 0;
      }
      while(true) {
         try { // 입력 값이 잘 못 될 수 있기 때문에 try
            System.out.println("구매를 원하는 상품의 수량을 입력해주세요 >> ");
            num=sc.nextInt(); // 구매를 원하는 상품의 수량을 저장
         }
         catch(Exception e){ // 오류 코드 이름을 몰라 최상위 클래스인 Exception을 사용
            System.out.println("올바른 상품의 수량을 다시 입력해주세요!");
            continue; // 올바른 값을 입력 할 때 까지
         }
         if(num>stockCount) { // 만약 사용자가 입력한 값이 재고 수량보다 많으면
            System.out.println("선택하신 제품의 재고 수량보다 작은 값을 입력해주세요!");
            continue;
         }
         else if(num<=stockCount && num>0) { // 재고 수량보다 작거나 같은 경우 / 0보다 커야할때
            System.out.println(num+"개의 상품이 장바구니에 담겼습니다!");
            break; // 반복문 종료
         }
         System.out.println("1개 이상의 값을 입력해주세요.."); // 사용자가 -를 입력 할수도 있음
      }
      return num; // 사용자가 입력한 값 반환
   } 
   // 인자 타입 한글로 정의해두기 & 메서드명 가독성 & 메서드 역할 체크
   public void basketAmountCnt(String productName, int basketCount) { // 바구니에 담겨있는 상품의 이름과 수량을 출력해주는 메서드
      System.out.println(productName+"이(가) "+basketCount+"개 담겨있습니다!");
   }
   public int deleteProductList(ArrayList<ProductDTO> datas) { // 담아놓은 상품 삭제 / PK값으로 c한테 전달
      int num; // 스코프 맞추기

      while(true){
         try { // 입력 값이 잘 못 될 수 있기 때문에 try
            System.out.println("삭제를 원하는 상품의 번호를 입력해주세요 >> ");
            num=sc.nextInt(); // 삭제를 원하는 상품의 수량을 저장
         }
         catch(Exception e){ // 오류 코드 이름을 몰라 최상위 클래스인 Exception을 사용
            System.out.println("올바른 상품의 번호를 다시 입력해주세요!");
            continue; // 올바른 값을 입력 할 때 까지
         }
         boolean flag=false; // flag는 false로 시작

         for(ProductDTO data:datas) { // 배열을 확인하면서
            // 배열과 정확한 입력을 할 횟수는 1:1
            // 배열을 확인 할때 잘못 된 값을 입력했다고 출력하는 횟수는 == 배열 전체 값 - 1
            if(num == data.getPK()) { // 사용자가 입력한 값이 있다면 배열안에 있다면
               flag=true; // flag가 true가 되고
               return num;
            }
         }
         if(flag != true) { // flag가 true가 아닐 경우
            System.out.println("장바구니에 없는 상품 번호 입니다.. 다시 입력해주세요!");

         }
      }
   } 


   public int deleteProductAmount(int stockCount) { // 장바구니에 있는 상품을 삭제 할때 수량을 입력 받는 메서드
      int num; // 스코프 맞추기
      while(true) {
         try { // 입력 값이 잘 못 될 수 있기 때문에 try
            System.out.println("삭제를 원하는 상품의 수량을 입력해주세요 >> ");
            num=sc.nextInt(); // 구매를 원하는 상품의 수량을 저장
         }
         catch(Exception e){ // 오류 코드 이름을 몰라 최상위 클래스인 Exception을 사용
            System.out.println("올바른 상품의 수량을 다시 입력해주세요!");
            continue; // 올바른 값을 입력 할 때 까지
         }
         if(num>stockCount || num<=0) { // 장바구니에 있는 수량보다 큰 값 혹은 0과 같거나 작은 값을 입력했을 때
            System.out.println("올바른 상품의 수량을 다시 입력해주세요!");
            continue;
         }
         else { // 입력한 값이 장바구니 수량과 같거나 작다면
            System.out.println(num+"개의 상품이 삭제 되었습니다!");
         }
         break; // 반복문 종료
      }
      return num; // 사용자가 입력한 삭제를 원하는 값을 반환
   }
   public boolean buyProduct() { // 장바구니에 있는 상품 구매
      String ans; // 스코프 맞추기
      while(true) {
         System.out.println("장바구니에 있는 상품을 구매하시겠습니까? (Y / N) >> ");
         ans=sc.next(); // Y / N을 입력 받고 저장

         if(ans.equals("Y") || ans.equals("N")) { // Y 또는 N이 입력되어야
            break; // while문 종료
         }
         System.out.println("[Y / N]으로만 입력해주세요!"); // Y 또는 N이 아니라면 다시 입력하라는 문구 출력
      }
      // 사용자가 입력하는 건 1번이기 때문에 while문 밖으로 보내야함..
      if(ans.equals("Y")) { // 입력한 값이 Y라면
         return true; // true 반환
      }
      return false; // false 반환

   }
   public void buySuccess(String productName, int buyNum) { // 구매에 성공한 상품의 이름과 수량을 사용자에게 보여줌
      System.out.println(productName+"상품을 "+buyNum+"개 구매에 성공했습니다!");
   }
   public void buyFail(String productName, int buyNum) { // 구매에 실패한 상품의 이름을 출력
      System.out.println(productName+"상품을 "+buyNum+"개 구매에 실패했습니다!");
      System.out.println("관리자에게 문의 해주세요");
   }
}
