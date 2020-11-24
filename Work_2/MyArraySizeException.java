package Work_2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String s) {
        super("Не корректный размер массива");
    }
}
