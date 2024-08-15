package class01;
//강사님이 짜신 코드

import java.util.Random;
import java.util.Scanner;

class Student {
   int num;
   String name;
   int score;
   char grade;
   Student(int num,String name){
      this(num,name,0);
   }
   Student(int num,String name,int score){
      this.num=num;
      this.name=name;
      this.score=score;
      this.setGrade();
   }
   void printInfo() {
      System.out.println(this.num+"번 "+this.name+" "+this.score+"점 "+this.grade+"등급");
   }
   
   // 학생 1명이 재시험을 봄 ==>>> 메서드
   // 60 -> 60~100 랜덤 점수로 변경됨 : 경계값 검사
   void test() {
      Random rand=new Random();
      /*
      10 >> 10~100 -> 91    랜덤정수의 개수=101-현재점수
      20 >> 20~100 -> 81
      90 >> 90~100 -> 11
      
      .nextInt(100) // 0~99
      .nextInt(100)+1 // 1~100
      */
      this.score=rand.nextInt(101-this.score)+this.score;
      
      this.setGrade();
   }
   void setGrade() {
      this.grade='C';
      if(this.score>=80) {
         this.grade='A';
      }
      else if(this.score>=60) {
         this.grade='B';
      }
   }
}

public class Test01 {

   public static boolean isEmpty(int cnt) {
      if(cnt<=0) {
         System.out.println("데이터가 없습니다!");
         return true;
      }
      return false;
   }
   public static boolean isFull(int cnt,Student[] datas) {
      if(cnt>=datas.length) {
         System.out.println("저장가능한 공간이 없습니다!");
         return true;
      }
      return false;
   }

   public static int firstScore(Student[] datas,int cnt) {
      int pivot = datas[0].score;
      for(int i=1;i<cnt;i++) {
         if(pivot < datas[i].score) {
            pivot = datas[i].score;
         }
      }
      return pivot;
   }

   public static boolean isRight(char grade) {
      if(grade=='A' || grade=='B' || grade=='C') {
         return true;
      }
      return false;
   }
   
   public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);

      int PK=1001; // 시스템에서 부여하는 PK값
      int cnt=0; // 현재 배열에 저장된 데이터의 개수
      Student[] datas=new Student[3];
      datas[0]=new Student(PK++,"티모",50);
      cnt++;

      while(true) {

         System.out.println("===== 메 뉴 =====");
         System.out.println("1. 학생추가");
         System.out.println("2. 전체목록출력");
         System.out.println("3. 번호검색");
         System.out.println("4. 이름검색");
         System.out.println("5. 1등출력");
         System.out.println("6. 등급검색");
         System.out.println("7. 재시험");
         System.out.println("0. 프로그램 종료");
         System.out.println("===============");
         System.out.print("메뉴 입력 >> ");
         int menu=sc.nextInt();      

         if(menu==0) {
            break;
         }
         else if(menu==1) { // 학생추가

            if(isFull(cnt,datas)) {
               continue;
            }

            String name;
            int score;
            while(true) {
               System.out.print("이름 입력 >> ");
               name=sc.next();
               System.out.print("정말로? (Y/N) >> ");
               String ans=sc.next();
               if(ans.equals("Y")) {
                  break;
               }
            }
            while(true) {
               System.out.print("성적 입력 >> ");
               score=sc.nextInt();
               if(0<=score && score<=100) {
                  break;
               }
            }
            datas[cnt++]=new Student(PK++,name,score);
         }
         else if(menu==2) { // 전체목록출력

            if(isEmpty(cnt)) {
               continue;
            }

            System.out.println("===============");
            for(int i=0;i<cnt;i++) {
               // datas == 배열 == 학생부
               // datas[i] == 배열의 요소 == 학생
               // datas[i].num == 학생.번호 == 학생의 번호
               datas[i].printInfo();
            }
            System.out.println("===============");

         }
         else if(menu==3) { // 번호검색

            if(isEmpty(cnt)) {
               continue;
            }

            int num;
            while(true) {
               System.out.print("검색할 학생의 번호 입력 >> ");
               num=sc.nextInt();
               if(1001<=num && num<2000) {
                  break;
               }
            }

            boolean flag=false;
            for(int i=0;i<cnt;i++) {
               if(datas[i].num == num) {
                  // 현재 살펴보고있는 학생.번호 == 사용자가 입력한 번호
                  flag=true;
                  datas[i].printInfo();
               }
            }
            if(!flag) {
               System.out.println("검색결과가 없습니다...");
            }

         }
         else if(menu==4) { // 이름검색
            if(isEmpty(cnt)) {
               continue;
            }

            System.out.print("검색어 입력 >> ");
            String searchKeyword=sc.next();
            // 검색어 : searchKeyword,searchContent,sk,sc
            // 유효성 검사 x

            boolean flag=false;
            for(int i=0;i<cnt;i++) {
               if(datas[i].name.contains(searchKeyword)) {
                  // 학생부에 저장되어있는 학생의 이름안에 검색어가 있어?
                  datas[i].printInfo();
                  flag=true;
               }
            }
            if(!flag) {
               System.out.println("검색결과가 없습니다...");
            }
         }
         else if(menu==5) { // 1등출력 -->>> selectAll
            if(isEmpty(cnt)) {
               continue;
            }            

            // 1등의 점수
            //  : 함수
            int score=firstScore(datas,cnt); // 1등의 점수를 함수로 찾아냄

            for(int i=0;i<cnt;i++) {
               if(score==datas[i].score) {
                  datas[i].printInfo();
               }
            }
            // 해당 점수인 학생을 모두 출력
            //  : 1명은 메서드 --->> .printInfo()
            //  : N명은 함수
         }
         else if(menu==6) { // 등급검색
            if(isEmpty(cnt)) {
               continue;
            }

            char grade;
            while(true) {
               System.out.print("등급 입력 >> ");
               grade=sc.next().charAt(0);
               if(isRight(grade)) {
                  break;
               }
            }
            
            boolean flag=false;
            for(int i=0;i<cnt;i++) {
               if(datas[i].grade==grade) {
                  datas[i].printInfo();
                  flag=true;
               }
            }
            if(!flag) {
               System.out.println("검색결과가 없습니다...");
            }
         }
         else if(menu==7) { // 재시험
            if(isEmpty(cnt)) {
               continue;
            }
            
            // 전체 학생들이 재시험을 봅니다.
            for(int i=0;i<cnt;i++) {
               datas[i].test();
            }
         }
         else {
            System.out.println("잘못된 입력입니다!");
         }
      }
   }
}
