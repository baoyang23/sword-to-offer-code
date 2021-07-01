package com.iyang.learntreecode.binary.tree;

/**
 * ( •_•)                          (•_• )
 * ( ง )ง                          ୧( ୧ )
 * /︶\                              /︶\
 *
 * @author : luohong
 * @desc :
 * @since : 2021/7/1 / 上午10:24
 */
public class SortedArrayToBST {


    public static void main(String[] args) {

        int [] nums = { 0 , 1 , 2 , 3 , 4  };
        SortedArrayToBST s = new SortedArrayToBST();
        s.helper(nums,0,nums.length -1);

    }


    public MidTreeNode helper(int [] nums,int left,int right){

        // 利用 right 和 left 的数值进行比较.
        if(left > right){
            return null;
        }

        int mid = (left + right) / 2;
        MidTreeNode midTree = new MidTreeNode();
        midTree.val = nums[mid];

        // 获取出中间点节的左边节点.
        midTree.left = helper(nums,left,mid-1);
        // 获取出中间节点的右边节点.
        midTree.right = helper(nums,mid+1,right);

        return midTree;
    }



//    public void sortedArrayToBST(int [] nums){
//
//        // 求出中间节点.
//
//        if(nums.length == 1 || nums.length == 2){
//
//            System.out.println("满足条件的");
//            return;
//        }
//
//        int midVal =  nums.length / 2;
//        MidTreeNode midNode = new MidTreeNode();
//        midNode.val = nums[2];
//
//        MidTreeNode md = new MidTreeNode();
//        for(int i=midVal-1;i>=0;i--){
//
//            md.val = nums[i];
//            midNode.right = md;
//        }
//    }

}
