package com.iyang.learnpointcode.arr;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-13
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class FindNumberIn2DArrayCase {

    public static void main(String[] args) {


    }


    public void findNumberIn2DArray(){

        int[][] matrix = new int[][] {{123}};
        int target = 0;

        int rows = matrix.length , columns = matrix[0].length;

        int row = 0, column = columns - 1;
        while (row < rows && columns > 0){
            int num = matrix[row][column];
            if(num == target){
                System.out.println("true");
            } else if (num > target){
                column --;
            } else {
                row ++;
            }
        }

        System.out.println(false);
    }

}
