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
/** Итоговая работа
*@author Dmitiy Sivyy - LogicOfGreen
*
*
*input - json and output - json
*Final-класс где самое решение, First и Second - классы для создания листов ответов,
*Producr,Seller,SellerHasProduct,Sells- классы в которые мы переносим объекты из json(POJO) , имеют стандартные конструкторы и геттеры
*Эти же классы с припиской Com - классы обёртки для массивов объектов JSON- имеют геттеры и сеттеры
*
*/
public class Final {
    public static void main(String[] args) throws Exception{
        //читаем все 4 json файла
        ObjectMapper mapper1 = new ObjectMapper();
        File js1 = new File("src/Sellers.json");
        SellerCom SC= mapper1.readValue(js1, SellerCom.class);

        ObjectMapper mapper2 = new ObjectMapper();
        File js2 = new File("src/Products.json");
        ProductCom PC= mapper2.readValue(js2, ProductCom.class);

        ObjectMapper mapper3 = new ObjectMapper();
        File js3 = new File("src/SellersHasProducts.json");
        SellerHasProductCom SHP= mapper3.readValue(js3, SellerHasProductCom.class);

        ObjectMapper mapper4 = new ObjectMapper();
        File js4 = new File("src/SelledProducts.json");
        SellsCom SlC= mapper4.readValue(js4, SellsCom.class);
        //Создаем массивы для название продуктов, id продавцов, минимальной цены у продавца
        String[] arPr=new String[PC.getListProduct().size()+1];
        int[] arP = new int[PC.getListProduct().size()+1];
        int[] arS = new int[PC.getListProduct().size()+1];
        //читаем названия продуктов
        for(Product p : PC.getListProduct()){
            arPr[p.getIdProduct()]=p.getTitle();
        }
        //заполняем массив большими значениями , что бы потом искать минимальные
        for(int i=1;i<arP.length;i++){
            arP[i]=999;
        }
        //перебираем все имеющиеся цены продавцов, находим меньше чем есть в массиве, заменяем 
        for(SellerHasProduct shp : SHP.getSellerHasProduct()){

            if(arP[shp.getIdProduct()]>shp.getPriceProduct()) {
                arP[shp.getIdProduct()] = shp.getPriceProduct();
                arS[shp.getIdProduct()] = shp.getIdSeller();
            }
        }
        //создаём лист ответов
        List<First> answer = new ArrayList<>();
        for(int i=1;i<arP.length;i++){
            First ans = new First(arPr[i],arS[i],arP[i]);
            answer.add(ans);
        }
        //выводим ответы
        ObjectMapper mapperp1 = new ObjectMapper();
        ObjectWriter writer = mapperp1.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("src/ans1.json"),answer);
        //задание 2-создаём массив дат и сумм в эти даты
        List<String> Arr21 = new ArrayList<>();
        List<Integer> Arr22 = new ArrayList<>();
        int sum=0;
        //считаем наборы данных, если новый день то добавляем итоговую сумму в массив и дату
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
        //на выходе получаем массив из сумм и дат
        //а дальше выводим 5 наибольших дат в тех местах где самые большие значения числе в массив сумм
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
        //вывод ответа
        ObjectMapper mapperp2 = new ObjectMapper();
        ObjectWriter writer2 = mapperp2.writer(new DefaultPrettyPrinter());
        writer2.writeValue(new File("src/ans2.json"),FinalAns);
    }
}
