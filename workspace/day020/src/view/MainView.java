package view;


import model.ProductDTO;
import java.util.ArrayList;
import java.util.Scanner;

abstract class View {
    public static Scanner sc = new Scanner(System.in);
}

public class MainView extends View {// 추상클래스 View를 상속받은 MainView
    // 로그인/ 아웃 상태 상관없이 출력받을 수 있는
    // 공통 메뉴
    public void printMenuList() { //전체 메뉴 출력문 메서드
        // =======메뉴=======
        System.out.println("======== 메뉴 ========");
        System.out.println("0. 창 닫기");
        System.out.println("1. 상품 목록 출력");
    }

    public void printProductMenu(ArrayList<ProductDTO> datas) { // 상품 품절 여부 검사 및 상태 출력
        System.out.println("================ 상품 목록 출력 ================");
        for (ProductDTO data : datas) {
            if (data.getStockCount()==0){ // import된 Product.dto로부터 상품 고유번호, 이름, 가격, 재고량까지 받아서 출력.
                System.out.println("[상품 번호=" + data.getPK() + ", 상품명=" + data.getProductName() + ", 가격=" + data.getPrice() + " 품절" + "]");
            }
            else{
                System.out.println("[상품 번호=" + data.getPK() + ", 상품명=" + data.getProductName() + ", 가격=" + data.getPrice() + ", 재고 보유량="
                        + data.getStockCount() + "]");
            }
        }
    }

    public int inputMenuNum(int menuSize) { // 메뉴를 입력받을때 사용될 메서드
        int menuInput; //scope 맞춰주기 위해 while문에서 밖으로.
        while (true) {
            // 메뉴 입력 안내문구
            System.out.println("메뉴 입력: ");
            // 메뉴 입력 받고
            menuInput = sc.nextInt();
            // 유효성 검사 후,
            if ((menuInput >= 0) && (menuInput <= menuSize)) { //메뉴 입력 번호가 0과 같거나 크고, 총 길이보다 작거나 같은 떄
                break;// 정수값 반환 및 반복 종료
            }
            else {// 아닐 경우
                continue; // 반복문으로 복귀
            }
        }
        return menuInput;
    }

    public void exit() {// 프로그램 종료 안내문구
        System.out.println("사이트 이용을 종료합니다!");
    }

    public void printTrue() { //일반 성공 문구 출력 메서드
        System.out.println("성공!");
    }

    public void printFalse() {// 일반 실패 문구 출력 메서드
        System.out.println("실패!");
    }
}