/**
 *Это класс , в котором имеется 2 поля отвечающие за коордианты клетки,
 * имеется 2 конструктора нулевой и обычный, 2 геттера , 2 сеттера и метод перевода в строку
 * методы написаны в соответствии с заданием по исключениям.
 * @author Dmitriy Sivyy(LogicOfGreen)
 *
 */
public class Chess {
    private int x;
    private int y;

    // Нулевой конструктор
    public Chess(){
        this.x=0;
        this.y=0;
    }
    // Обычный конструктор
    public Chess(int x1,int y1) throws IllegalArgumentException{
        if (x1<=7 && x1>=0 && y1<=7 && y1>=0){
            this.x=x1;
            this.y=y1;
        }
        else{
            throw new IllegalArgumentException("Введёные значения не подходят!");
        }

    }
    // Геттер координаты по горизонтали, горизонтали хранятся начиная с 0
    public int getX(){
        return this.x;
    }
    // Геттер координаты по вертикали, вертикали хранятся начиная с 0
    public int getY(){
        return this.y;
    }
    // Сеттеры координаты по горизонтали, горизонтали хранятся начиная с 0
    public void setX(int x1) throws IllegalArgumentException{
        if (x1<=7 && x1>=0){
            this.x=x1;
        }
        else{
            throw new IllegalArgumentException("Введёное значение не подходит!");
        }
    }
    // Сеттеры координаты по вертикали, вертикали хранятся начиная с 0
    public void setY(int y1) throws IllegalArgumentException
    {
        if (y1<=7 && y1>=0){
            this.y=y1;
        }
        else{
            throw new IllegalArgumentException("Введёное значение не подходит!");
        }
    }
    // Метод перевода к строке , переводит координаты в строку: Пример коориданты (1,1) перейдут в коориданты b2
    public String toString(){
        String s="";
        char c=(char)('a'+ this.y);
        s+=c;
        s+=(char)this.x+1;
        return s;
    }

}
