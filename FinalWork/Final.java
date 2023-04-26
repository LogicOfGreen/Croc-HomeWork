import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.nio.file.Paths;
public class Final {
    public static void main(String[] args) throws Exception{
        ObjectMapper mapper1 = new ObjectMapper();
        File js1 = new File("src/Sellers123.json");
        SellerCom SC= mapper1.readValue(js1, SellerCom.class);

        ObjectMapper mapper11 = new ObjectMapper();
        File js11 = new File("src/Sellers.json");
        SellerCom SC1= mapper1.readValue(js1, SellerCom.class);

        ObjectMapper mapper2 = new ObjectMapper();
        File js2 = new File("src/Products.json");
        ProductCom PC= mapper2.readValue(js2, ProductCom.class);

        ObjectMapper mapper3 = new ObjectMapper();
        File js3 = new File("src/SellersHasProducts.json");
        SellerHasProductCom SHP= mapper3.readValue(js3, SellerHasProductCom.class);

        ObjectMapper mapper4 = new ObjectMapper();
        File js4 = new File("src/SelledProducts.json");
        SellsCom SlC= mapper4.readValue(js4, SellsCom.class);

        String[] arPr=new String[PC.getListProduct().size()+1];
        String[] arSN=new String[PC.getListProduct().size()+1];
        int[] arP = new int[PC.getListProduct().size()+1];
        int[] arS = new int[PC.getListProduct().size()+1];

        for(Product p : PC.getListProduct()){
            arPr[p.getIdProduct()]=p.getTitle();
        }

        for(int i=1;i<arP.length;i++){
            arP[i]=999;
        }

        for(SellerHasProduct shp : SHP.getSellerHasProduct()){

            if(arP[shp.getIdProduct()]>shp.getPriceProduct()) {
                arP[shp.getIdProduct()] = shp.getPriceProduct();
                arS[shp.getIdProduct()] = shp.getIdSeller();
            }
        }

        for(Seller s : SC1.getListSeller()){
            System.out.println(s.getFirstName());
            for(int i=0;i<arS.length;i++){
                if(arS[i]==s.getIdSeller()){
                    arSN[i]=String.join(" ",s.getFirstName(), s.getSecondName());
                }
            }
        }

        List<First> answer = new ArrayList<>();
        for(int i=1;i<arP.length;i++){
            First ans = new First(arPr[i],arS[i],arP[i]);
            answer.add(ans);
        }

        ObjectMapper mapperp1 = new ObjectMapper();
        ObjectWriter writer = mapperp1.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("src/ans1.json"),answer);
        List<String> Arr21 = new ArrayList<>();
        List<Integer> Arr22 = new ArrayList<>();
        int sum=0;
        for (Sells s: SlC.getSells()){
            if(Arr21.size()==0){
                Arr21.add(s.getSellData());

                sum+=s.getCountSelledProduct();
            }
            else{
                if(Arr21.get(Arr21.size()-1).equals(s.getSellData())){
                    //System.out.println(Arr21.get(Arr21.size()-1));
                    sum+=s.getCountSelledProduct();
                }
                else{
                    Arr21.add(s.getSellData());
                    //System.out.println(Arr21.get(Arr21.size()-1));
                    Arr22.add(sum);
                    sum=0;
                    sum+=s.getCountSelledProduct();
                }
            }
        }
        Arr22.add(sum);
        List<Second> FinalAns = new ArrayList<>();
        for(int i=0;i<5;i++){
            int max=0,id=0;
            for(int j=0;j<Arr22.size();j++) {
                if (max < Arr22.get(j)) {
                    max = Arr22.get(j);
                    id=j;
                }
            }
            Second fa1= new Second(Arr21.get(id));
            Arr22.set(id,-1);
            FinalAns.add(fa1);
        }
        ObjectMapper mapperp2 = new ObjectMapper();
        ObjectWriter writer2 = mapperp2.writer(new DefaultPrettyPrinter());
        writer2.writeValue(new File("src/ans2.json"),FinalAns);
    }
}
