package Work_2;

public class ExceptionMail {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String [][] str = {{"10", "3", "1", "2"} ,{"2", "3", "2", "2"} , {"5", "6", "7", "1"}, {"300", "3", "1", "0"}};
        String [][] str1 = {{"10", "a", "1", "2"} ,{"2", "3", "2", "2"} , {"t", "6", "7", "1"}, {"300", "w", "1", "0"}}; //для проверки на наличие символов
        String [][] str2 = {{"10", "3", "1", "2"} ,{"2", "3", "2", "2"} , {"5", "6", "7", "1"}, {"300", "3", "1", "0"}, {"5", "6", "7", "1"}}; //для проверки размера матрицы

        Exception.strToArr(str);
        System.out.println(" ");
//        Exception.strToArr(str1);
        System.out.println(" ");
        Exception.strToArr(str2);
    }
}
