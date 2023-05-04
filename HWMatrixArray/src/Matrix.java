import interfaces.MyInterfaces;

import java.util.ArrayList;
import java.util.List;

public class Matrix implements MyInterfaces {

    public static void main(String[] args) {
        int[][] matrixArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrixArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13, 14, 15, 16}};

        Matrix matrix = new Matrix();
        matrix.printRootArray(matrixArray);

        int[] mainDiagonalArray = matrix.getMainDiagonal(matrixArray);
        List<Integer> mainDiagonalAndBottom = matrix.getMainDiagonalAndBottom(matrixArray);
        List<Integer> mainDiagonalAndTop = matrix.getMainDiagonalAndTop(matrixArray);

        int[] secondaryDiagonalArray = matrix.getSecondaryDiagonal(matrixArray);
        List<Integer> secondaryDiagonalAndBottom = matrix.getSecondaryDiagonalAndBottom(matrixArray);
        List<Integer> secondaryDiagonalAndTop = matrix.getSecondaryDiagonalAndTop(matrixArray);
    }

    @Override
    public void printRootArray(int[][] matrixArray) {
        System.out.println("Root Array:");
        for (int i = 0; i < matrixArray.length; i++) {
            int[] elements = matrixArray[i];

            for (int j = 0; j < elements.length; j++) {
                int element = elements[j];
                System.out.print(element + " ");
            }

            System.out.println();
        }
    }

    @Override
    public int[] getMainDiagonal(int[][] matrixArray) {
        System.out.println("\n" + "Main Diagonal Array:");
        int[] array = new int[matrixArray.length];

        for (int i = 0; i < matrixArray.length; i++) {
            int[] elements = matrixArray[i];

            array[i] = matrixArray[i][i];
            System.out.print(elements[i] + " ");
        }

        return array;
    }

    @Override
    public List<Integer> getMainDiagonalAndBottom(int[][] matrixArray) {
        System.out.println("\n\n" + "Main Diagonal And Bottom Array:");
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < matrixArray.length; i++) {
            int[] elements = matrixArray[i];

            for (int j = 0; j < elements.length; j++) {

                if (j <= i) {
                    array.add(elements[j]);
                    System.out.print(elements[j] + " ");
                } else
                    break;
            }

            System.out.println();
        }

        return array;
    }

    @Override
    public List<Integer> getMainDiagonalAndTop(int[][] matrixArray) {
        System.out.println("\n" + "Main Diagonal And Top Array:");
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < matrixArray.length; i++) {
            int[] elements = matrixArray[i];

            for (int j = 0; j < elements.length; j++) {

                if (j >= i) {
                    array.add(elements[j]);
                    System.out.print(elements[j] + " ");
                } else
                    System.out.print("  ");
            }

            System.out.println();
        }

        return array;
    }

    @Override
    public int[] getSecondaryDiagonal(int[][] matrixArray) {
        System.out.println("\n" + "Secondary Diagonal Array:");

        int[] array = new int[matrixArray.length];

        for (int i = 0; i < matrixArray.length; i++) {
            array[i] = matrixArray[matrixArray.length - 1 - i][i];
            System.out.print(matrixArray[matrixArray.length - 1 - i][i] + " ");
        }

        System.out.println();
        return array;
    }

    @Override
    public List<Integer> getSecondaryDiagonalAndBottom(int[][] matrixArray) {
        System.out.println("\n" + "Secondary Diagonal And Bottom Array:");
        List<Integer> array = new ArrayList<>();

        int index = matrixArray.length - 1;
        for (int i = 0; i < matrixArray.length; i++) {
            int[] elements = matrixArray[i];

            for (int j = 0; j < elements.length; j++) {
                if (j >= index) {
                    System.out.print(elements[j] + " ");
                } else
                    System.out.print("  ");
            }

            index--;
            System.out.println();
        }

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray.length; j++) {
                if (j >= i) {
                    array.add(matrixArray[matrixArray.length - 1 - i][j]);
                }
            }
        }

        return array;
    }

    public List<Integer> getSecondaryDiagonalAndTop(int[][] matrixArray) {
        System.out.println("\n" + "Secondary Diagonal And Top Array:");
        List<Integer> array = new ArrayList<>();

        int index = matrixArray.length - 1;
        for (int i = 0; i < matrixArray.length; i++) {
            int[] elements = matrixArray[i];

            for (int j = 0; j < elements.length; j++) {
                if (j <= index) {
                    System.out.print(elements[j] + " ");
                } else
                    System.out.print("  ");
            }

            index--;
            System.out.println();
        }

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray.length; j++) {
                if (j <= i) {
                    array.add(matrixArray[matrixArray.length - 1 - i][j]);
                }
            }
        }

        return array;
    }
}