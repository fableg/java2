package hw2;

public class HomeWork2 {
    private static final int REQUIRED_ARRAY_SIZE = 4;

    private static final String [][] CORRECT_DATA = new String[][]{
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "1", "1"},
    };

    private static final String [][] INCORRECT_SIZE_DATA = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11"},
            {"13", "14", "15", "16"},
    };

    private static final String [][] INCORRECT_VALUE_DATA = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "1O", "11", "12"},
            {"13", "14", "15", "16"},
    };

    public static void main(String[] args) {
        try {
            int result = sumArrayValue(CORRECT_DATA);
//            int result = sumArrayValue(INCORRECT_SIZE_DATA);
//            int result = sumArrayValue(INCORRECT_VALUE_DATA);
            System.out.println("Array sum: " + result);
        }catch (MyArraySizeException e) {
            System.err.println("incorrect array size");
            e.printStackTrace();
        }catch (MyArrayDataException e) {
            System.err.println("incorrect data in array");
            e.printStackTrace();
        }
    }

    private static int sumArrayValue(String[][] data) throws MyArrayDataException, MyArraySizeException {
        checkArraySize(data);

        int sumResult = 0;

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String value = row[colIndex];
                try {
                    sumResult += Integer.parseInt(value);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(value,rowIndex,colIndex);
                }
            }
        }
     return sumResult;
    }

    private static void checkArraySize(String[][] data) {
        if (data.length != REQUIRED_ARRAY_SIZE) {
            throw new MyArraySizeException();
        }
        for (String[] row : data) {
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
    }
}
