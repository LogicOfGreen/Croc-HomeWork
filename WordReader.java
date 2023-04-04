/**
 *Это работа для 4 лабораторной по потокам ввода и вывода,
 * Для начала проверяется количество аргументов внутри args, если их нет
 * то исключение что нет названия, потом идёт открытие файла через try-with-resources
 * если не открывается перехватываем, дальше сканируем по слову через сканнер и выводим
 * @author Dmitriy Sivyy(LogicOfGreen)
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
public class WordReader {
    public static void main(String args[]) throws Exception{
        int count=0;
        //проверка количества аргументов (есть название файла или нет)
        if(args.length<=0){
            throw new IllegalArgumentException(" File name not exist in argument");
        }
        //открываем файл , через try-with-resources
        try(FileReader f = new FileReader(args[0])){
            Scanner in = new Scanner(f);
            //циклом перебираем все слова которые попадутся
            while (in.hasNext()){
                String s= in.next();
                count++;
            }
            System.out.println(count);
        }
        //если не открывается ловим исключение
        catch(FileNotFoundException e){
            System.out.println("This file cannot be processed");
        }

    }
}
