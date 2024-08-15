package client;

import service.Calc;
import view.CalcView;

public class Client {
   public static void main(String[] args) {
      
      // 계산기 프로그램을 수행할 예정
      
      CalcView view=new CalcView();
      Calc service = new Calc();
      
      while(true) {
         view.printIntInfo();
         int num1=view.inputInt();
         view.printOpInfo();
         String op=view.inputOp();
         view.printIntInfo();
         int num2=view.inputInt();
         
         service.setNum1(num1);
         service.setNum2(num2);
         service.setOp(op);
         service.calc();
         int result=service.getResult();
         
         view.printResult(num1, op, num2, result);
      }

   }
}