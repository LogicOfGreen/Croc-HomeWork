public class Product {
    private int idProduct;
    private String title;

    public Product(){
        this.idProduct=0;
        this.title="";
    }
    public Product(int id, String First){
        this.idProduct=id;
        this.title=First;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getTitle() {
        return title;
    }
}
