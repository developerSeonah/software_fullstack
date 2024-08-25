package model;
public class ProductDTO {
   private int PK; // 상품 번호
   private String productName; // 상품 이름
   private int price; // 가격
   private int stockCount; // 잔여수량
   private int basketCount; // C에서 사용할 장바구니수량
   public int getPK() {
      return PK;
   }
   public void setPK(int pK) {
      PK = pK;
   }
   public String getProductName() {
      return productName;
   }
   public void setProductName(String productName) {
      this.productName = productName;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public int getStockCount() {
      return stockCount;
   }
   public void setStockCount(int stockCount) {
      this.stockCount = stockCount;
   }
   public int getBasketCount() {
      return basketCount;
   }
   public void setBasketCount(int basketCount) {
      this.basketCount = basketCount;
   }
   @Override
   public String toString() {
      return "ProductDTO [PK=" + this.PK + ", productName=" + this.productName + 
    		  ", price=" + this.price + ", stockCount=" + this.stockCount + 
    		  ", basketCount="+ this.basketCount + ",]";
   }
}