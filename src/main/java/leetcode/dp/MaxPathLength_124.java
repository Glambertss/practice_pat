package leetcode.dp;//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 需要解决的问题：
 *      1. 如何解决单一路径的问题
 *      2. 如何解决
 */
public class MaxPathLength_124 {
    public int solution(TreeNode root){
        /**
         * 思路：
         *  通过后序遍历，先查询
         */


    }

    public void trace(TreeNode node){
        if(node == null) {
            return;
        }
        trace(node.left);
        trace(node.right);
        int temp
        if(node.left != null){
            if(node.left.left != null || node.left.right == null){

            }
        }
    }
    public static void main(String[] args) {

    }
}

/**
 *输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
