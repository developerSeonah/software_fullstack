package client;

import controller.ShoppingController;

public class Client {
	public static void main(String[] args) {
		ShoppingController ctrl = new ShoppingController();
		
		ctrl.start();
	}
}
