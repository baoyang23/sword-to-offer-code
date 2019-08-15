package com.yang.code.magic;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 *
 * @Author: Mu_Yi
 * @Date: 2019/8/15 22:27
 * @Version 1.0
 * @qq: 1411091515
 */
public class MagicChams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] sc = new int[n];
        for(int i = 0;i < n;i++){
            sc[i] = scanner.nextInt();
        }

        int [] dp = new int[1001];
        for(int i=0;i < 1001;i++){
            dp[i] = 0;
        }

        dp[0] = 1;
        int[] byteArray={1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        // 得出 0 到  999之间得值;存放在数组中
        for(int i = 0;i < 1000;i++){
            for(int j =0;j < 10 && i >= byteArray[j];j++){
                dp[i] += dp[i - byteArray[j]];
                dp[i] %= (1000000000 + 3);
            }
        }

        for(int i = 0;i < dp.length;i++){
            System.out.println(" i " + i + " : " +  dp[i]);
        }

        for(int i=0;i<n;i++){
            System.out.println(dp[sc[i]]);
        }

        scanner.close();
    }

}
