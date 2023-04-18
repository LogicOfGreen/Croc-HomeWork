import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Супер посковик + метод который запускается в многопоточности.
 *
 * @author Sergey Verkhushin + Dmitriy Sivyy(LogicOfGreen)
 */
public class Matcher implements Callable<Boolean> {

    private final String Str;
    private final String Character;

    Matcher(String Str,String Character){
        this.Str=Str;
        this.Character=Character;
    }

    /**
     * Осуществляет поиск в строке заданного символа
     *
     * @param str
     *        анализируемая строка
     * @param character
     *        символ, который требуется найти
     * @return {@code true} символ найден, иначе {@code false}
     * @throws IllegalArgumentException
     *         в случае, если в {@code character} пуст или более одного символа.
     * @throws NullPointerException
     *         в случае {@code character} равного {@code null}
     */
    public static boolean match(String str, String character) {
        Objects.requireNonNull(character);
        if (character.length() != 1) {
            throw new IllegalArgumentException("Template must have one character");
        }

        long delay = 100;
        // корректная обработка InterruptedException для метода, который не предполагает проброс этого исключения
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return str.contains(character);
    }
    @Override
    /**
     * метод который запускается для многопоточности, внутри переходим в метод по проверке
     */
    public Boolean call() throws Exception{
        return match(Str,Character);
    }
}
