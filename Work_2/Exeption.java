package Work_2;


class Exception{
    public static void strToArr(String[][] s) throws MyArraySizeException, MyArrayDataException {
        if (s.length != 4) throw new MyArraySizeException ("Не корректный размер массива");

        int[][] intArr = new int[4][4];
        for(int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                try {
                    intArr[i][j] = Integer.parseInt(s[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(s[i][j]);
                }
            }
        }

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("==========");


        int summ = 0;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                summ += intArr[i][j];
            }
        }System.out.print("Результат расчета равен " + summ);
    }
}


