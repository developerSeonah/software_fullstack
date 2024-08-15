package class05;

class Phone implements PhoneAction {
   private Watch watch;
   
   Phone(){
      this(null);
   }
   Phone(Watch watch){
      this.watch=watch;
   }
   
   public Watch getWatch() {
      return watch;
   }

   public void setWatch(Watch watch) {
      this.watch = watch;
   }

   @Override
   public void powerOn() {
      //Watch watch=new Watch();
      this.watch.powerOn();
   }

   @Override
   public void soundUp() {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void soundDown() {
      // TODO Auto-generated method stub
      
   }
}
class Watch implements PhoneAction {

   @Override
   public void powerOn() {
      System.out.println("워치를 활용한 전원ON");
   }

   @Override
   public void soundUp() {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void soundDown() {
      // TODO Auto-generated method stub
      
   }
   
   
   
}
public class Test02 {
	public static void main(String[] args) {
		Watch w = new Watch();
		Phone p = new Phone(w);
		p.powerOn();
		w.powerOn();
	}

}
