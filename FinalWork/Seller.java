
public class Seller {
    private int idSeller;
    private String secondName;
    private String firstName;


    public Seller(){
        this.idSeller=0;
        this.secondName="";
        this.firstName="";

    }
    public Seller(int id,String Second, String First){
        this.idSeller=id;
        this.secondName=Second;
        this.firstName=First;

    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public void setSecondName(String secondName) {
        secondName = secondName;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
