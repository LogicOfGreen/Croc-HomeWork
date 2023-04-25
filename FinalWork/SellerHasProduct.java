
public class SellerHasProduct {
    private int idSeller;
    private int idProduct;
    private int countProduct;
    private int priceProduct;

    public SellerHasProduct(){
        this.idSeller=0;
        this.idProduct=0;
        this.countProduct=0;
        this.priceProduct=0;
    }
    public SellerHasProduct(int idS, int idP, int CP, int PP){
        this.idSeller=idS;
        this.idProduct=idP;
        this.countProduct=CP;
        this.priceProduct=PP;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }
}
