import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class BitreeTraversal {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode leftTree, TreeNode rightTree) {
            this.value = val;
            this.left = leftTree;
            this.right = rightTree;
        }

        public TreeNode(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];//以数组形式生成一棵完全二叉树
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i * 2 + 1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i * 2 + 2];
        }

        preOrderRe(node[0]);
        System.out.println();
        postOrder(node[0]);

    }

    //先序遍历 递归实现
    public static void preOrderRe(TreeNode biTree) {//递归实现
        //输出根节点值
        System.out.println(biTree.value);
        //判断 左节点非空则输出 ，并递归调用
        TreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree);
        }
        //判断 右节点非空则输出 ，并递归调用
        TreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    //先序遍历 非递归实现
    public static void preOrder(TreeNode biTree) {//非递归实现
        //创建一个栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //循环条件为  根节点不为空或者栈不为空
        while (biTree != null || !stack.isEmpty()) {
            //循环条件为  根节点不为空
            while (biTree != null) {
                System.out.println(biTree.value);
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }


    public static void midOrderRe(TreeNode biTree) {//中序遍历递归实现
        if (biTree == null)
            return;
        else {
            midOrderRe(biTree.left);
            System.out.println(biTree.value);
            midOrderRe(biTree.right);
        }
    }


    public static void midOrder(TreeNode biTree) {//中序遍历非递归实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.println(biTree.value);
                biTree = biTree.right;
            }
        }
    }

    public static void postOrderRe(TreeNode biTree) {//后序遍历递归实现
        if (biTree == null)
            return;
        else {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.println(biTree.value);
        }
    }

    public static void postOrder(TreeNode biTree) {//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while (biTree != null || !stack.empty()) {
            while (biTree != null) {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }

            while (!stack.empty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().value);
            }

            if (!stack.empty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }

        }
    }

    public static void levelOrder(TreeNode biTree) {//层次遍历
        //根节点为空 返回
        if (biTree == null)
            return;
        //初始化队列
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        //将根节点加入到队列结尾 （链表结尾）
        list.add(biTree);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            //队列头结点 赋值给 当前节点 并输出
            currentNode = list.poll();
            System.out.println(currentNode.value);
            //若当前结点的左子结点非空，将其加入队列尾
            if (currentNode.left != null)
                list.add(currentNode.left);
            //若当前结点的右子结点非空，将其加入队列尾
            if (currentNode.right != null)
                list.add(currentNode.right);
        }
    }
}