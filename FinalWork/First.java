public class First {
    private String productName;
    private int sellerName;
    private int productPrise;

    public First(String pN, int sN, int pp){
        this.productName=pN;
        this.productPrise=pp;
        this.sellerName=sN;
    }

    public int getProductPrise() {
        return productPrise;
    }

    public String getProductName() {
        return productName;
    }

    public int getSellerName() {
        return sellerName;
    }
}
