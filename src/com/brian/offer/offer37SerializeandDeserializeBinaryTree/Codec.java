package com.brian.offer.offer37SerializeandDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author : brian
 * @since 0.1
 */
public class Codec {
    /**
     * Encodes a tree to a single string.
     * 前序遍历 序列化
     */
    public String serialize(TreeNode root) {

        if (root == null)
            return "null";

        String result = "";
        result += (root.val) + ",";
        result += serialize(root.left);
        result += ",";
        result += serialize(root.right);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> split = new LinkedList<>(Arrays.asList(data.split(",")));
        if (Objects.equals(split.get(0), "null")) {
            return null;
        }
        return deserialize(split);
    }

    public TreeNode deserialize(List<String> data) {

        if (Objects.equals(data.get(0), "null")) {
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.remove(0)));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = new Codec().serialize(root);
        TreeNode deserialize = new Codec().deserialize(serialize);

        System.out.println(serialize);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
