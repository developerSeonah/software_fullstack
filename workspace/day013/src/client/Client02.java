package client;

import service.controller.StudentController;

public class Client02 {
	public static void main(String[] args) {
		
		// 학생부 프로그램
		StudentController app = new StudentController();
		app.start();
	}

}
