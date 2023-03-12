/**
 * Программа выводит числа от 1 до 100, при этом вместо чисел,
 * которые делятся на три пишет Fizz, которые делятся на 5 пишет Buzz,
 * которые делятся на три и на пять пишет FizzBuzz.
 * @author Dmitriy Sivyy(LogicOfGreen)
 *
 */
public class Main {
    public static void main(String[] args) {
        /*
        ЗАпускаем цикл перебора чисел от 1 до 100
         */
        for (int i=1;i<101;i++){
            // Если число делится и на три и на пять выводим FizzBuzz
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            // Если число делится только на три выводим Fizz
            else if(i%3==0){
                System.out.println("Fizz");
            }
            // Если число делится только на пять выводим Buzz
            else if(i%5==0){
                System.out.println("Buzz");
            }
            // В иных случаях выводим само число
            else{
                System.out.println(i);
            }
        }

    }
}