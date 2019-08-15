package com.yang.code.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mu_Yi
 * @Date: 2019/8/15 23:03
 * @Version 1.0
 * @qq: 1411091515
 */
public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer> rs = new ArrayList<>();
        int row_len = matrix.length;
        int cel_len = matrix[0].length;
        int min_len = Math.min(row_len, cel_len);
        if(row_len == 1){
            for(int i = 0;i < cel_len;i++){
                rs.add(matrix[0][i]);
            }
        } else if(cel_len == 1){
            for(int i =0;i < row_len;i++){
                rs.add(matrix[i][0]);
            }
        } else {
            for(int k=0;k < min_len / 2;k++){
                for(int i = k,j =k;j < cel_len - k -1;j++){
                    rs.add(matrix[i][j]);
                }
                for(int i = k,j = cel_len - k -1;i < row_len -k -1;i++){
                    rs.add(matrix[i][j]);
                }
                for(int i = row_len - k -1,j=cel_len - k -1;j > k;j--){
                    rs.add(matrix[i][j]);
                }
                for(int i=row_len - k -1,j =k;i > k;i--){
                    rs.add(matrix[i][j]);
                }
            }

            if(min_len % 2 == 1){
                if(row_len == cel_len){
                    rs.add(matrix[row_len/2][row_len/2]);
                } else {
                    for(int i=row_len/2;i<cel_len-1;i++){
                        rs.add(matrix[row_len/2][i]);
                    }
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int [][] matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        ArrayList<Integer> rs = solution.printMatrix(matrix);
        for(int i=0;i<rs.size();i++){
            System.out.print(rs.get(i)+" ");
        }
    }

}
