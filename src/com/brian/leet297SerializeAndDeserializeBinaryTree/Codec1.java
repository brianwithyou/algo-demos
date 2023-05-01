package com.brian.leet297SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 输入：root = []
 * 输出：[]
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * @author : brian
 * @since 0.1
 */
public class Codec1 {
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
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
