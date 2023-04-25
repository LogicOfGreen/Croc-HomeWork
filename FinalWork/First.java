public class First {
    private String productName;
    private String sellerName;
    private int productPrise;

    public First(String pN, String sN, int pp){
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

    public String getSellerName() {
        return sellerName;
    }
}
