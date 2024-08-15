package class01;

public class Homework01 {

	public static void main(String[] args) {
		for(int a = 0; a < 5; a++) {
			for(int i = 0; i < 5; i++) {
				//공백과 별이 있어야 하므로
				if(i > 4-a) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			//한줄이 완성되면 줄바꿈
			System.out.println();
		}
	}
}
