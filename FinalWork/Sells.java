import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sells {
    private int idSell;
    private int idSeller;
    private int idProduct;
    private int countSelledProduct;
    private String sellData;

    public Sells(){
        this.idSell=0;
        this.idSeller=0;
        this.idProduct=0;
        this.countSelledProduct=0;
        this.sellData="";
    }
    public Sells(int idS, int idSer, int idP, int CSP, String Data){
        this.idSell=idS;
        this.idSeller=idSer;
        this.idProduct=idP;
        this.countSelledProduct=CSP;
        this.sellData=Data;
    }

    public int getIdSell() {
        return idSell;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getCountSelledProduct() {
        return countSelledProduct;
    }

    public String getSellData() {
        return sellData;
    }
}
