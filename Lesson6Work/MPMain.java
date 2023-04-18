import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MPMain {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     *Программа, которая благодаря многопоточности проверяет строку быстрее чем чем одним потоком
     * @author Dmitriy Sivyy(LogicOfGreen)
     */
    public static void main(String[] args) throws Exception {

        long current = System.currentTimeMillis();
        //создаём потоки и массив из элементов Future где будем хранить будущий результат, в размере количества символов
        Future<Boolean> [] resr = new Future [INPUT_STRING.length()] ;
        ExecutorService executor = Executors.newFixedThreadPool(INPUT_STRING.length());
        int sum = 0;
        //циклом вызываем потоки, и записываем будущие результаты в массив
        for (int i = 0; i < INPUT_STRING.length(); i++) {

            Callable worker = new Matcher(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE);
            Future<Boolean> res = executor.submit(worker);
            resr[i]=res;
        }
        //закрываем потоки
        executor.shutdown();
        //проверяем каждое значение, если пробел то +1
        for (int i = 0; i < INPUT_STRING.length(); i++) {

            if(resr[i].get()){
                sum++;
            }
        }
        System.out.println("Count of space: " + sum);
        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}
