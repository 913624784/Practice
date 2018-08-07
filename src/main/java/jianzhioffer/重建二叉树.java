package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {
    private Map<Integer, Integer> inOrderNumsIndexs = new HashMap();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            inOrderNumsIndexs.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL, int inR) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = inOrderNumsIndexs.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL, inL + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1, inR);
        return root;
    }
}
