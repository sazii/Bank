package LCProblems;

import java.util.ArrayList;
import java.util.List;

/*****************************QUESTION**********************************
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 123
 * 456   => spiralOrder = {1,2,3,6,9,8,7,4,5}
 * 789
 ***************************************************************************/
public class SpiralOrder {

    /***********************SOLUTION***********************
     * (x) right -> (x-1) down -> (x-1)left -> (x-2) up
     * (x-2) right ...
     * horizontalRange  VerticalRange
     * rowDelta: +1 -> down -1 -> up
     * colDelta: +1 -> right -1 -> left
     * Delta: +1 => right+down -1: left + up
     */

    public static List<Integer> findSpiralOrder(int[][] matrix){
        List<Integer> spiralOrder = new ArrayList<>();
        int delta =1, row=0, col =-1;
        int horizontalRange = matrix[0].length, verticalRange = matrix.length;
        while(horizontalRange>0 && verticalRange >0){
            for(int i=0; i<horizontalRange; i++){
                col += delta;
                spiralOrder.add(matrix[row][col]);
            }
            verticalRange--; // last col value already visited
            for(int i=0; i<verticalRange; i++){
                row += delta;
                spiralOrder.add(matrix[row][col]);
            }
            horizontalRange--; // last row value already visited
            delta *= -1;

        }
        return spiralOrder;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
        System.out.println(findSpiralOrder(matrix));
    }
}
