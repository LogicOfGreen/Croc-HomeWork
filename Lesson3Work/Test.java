/**
 *Программа проверяет класс написаный для 3 задания, связанного с исключением,
 * при вводе правильных значений программа не выбрасывает исключений,
 * если ввести значения меньше или больше, будет выброшено исключение,
 * которое означает выход за границы допустимых значений
 * @author Dmitriy Sivyy(LogicOfGreen)
 *
 */
public class Test {
    public static void main (String[] args) throws IllegalArgumentException {
        Chess ch= new Chess (0,1);
        System.out.println(ch.toString());
        Chess ch2= new Chess (9,1);
        System.out.println(ch2.toString());
    }
}
