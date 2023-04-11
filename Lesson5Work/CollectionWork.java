/**
 *Программа выполняет нормализацию стркои в которой указан путь в файловой системе
 * .-текущая директория, ..-родительская относительно текущей, /- разделитель директорий
 * @author Dmitriy Sivyy(LogicOfGreen)
 *
 */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CollectionWork {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String S = in.nextLine();
        String words[]=S.split("/");
        //разбили строку на массив строк, что бы было проще работать с каждым элементом
        Deque<String> deque = new ArrayDeque<>();
        //цикл по всем словам
        for (String word: words){
            System.out.println(word);
            //проверяем какое слово попало - файл, .. или .
            if (word.equals("..")){
                //если нет пути то пишем .., иначе выходим из файла
                if(deque.peekLast()==null) {
                    deque.addLast(word);
                }
                else{
                    deque.removeLast();
                }
            }
            //если попалось название файла до переходим в него
            else if(!word.equals("..") && !word.equals(".")){
                deque.addLast(word);
            }
        }
        //вывод нормализированной строки
        for (String word:deque){
            if (!deque.peekLast().equals(word)){
                System.out.printf("%s/",word);
            }
            else{
                System.out.printf("%s",word);
            }
        }
    }
}
