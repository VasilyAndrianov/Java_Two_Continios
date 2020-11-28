package Work_2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String s) {
        super(" Не корректные данные - "  + s);
    }
}
