package client;

import controller.BoardController;

public class Client {
	public static void main(String[] args) {
		// 어플 설치후,
		BoardController app=new BoardController();
		// 어플 실행
		app.start();
	}
}
