package interfaces;

import java.util.List;

public interface MyInterfaces {
//    int[][] generateArray(){
//
//    }

    void printRootArray(int[][] matrixArray);

    int[] getMainDiagonal(int[][] matrixArray);

    List<Integer> getMainDiagonalAndBottom(int[][] matrixArray);

    List<Integer> getMainDiagonalAndTop(int[][] matrixArray);

    int[] getSecondaryDiagonal(int[][] matrixArray);

    List<Integer> getSecondaryDiagonalAndBottom(int[][] matrixArray);
    List<Integer> getSecondaryDiagonalAndTop(int[][] matrixArray);
}
