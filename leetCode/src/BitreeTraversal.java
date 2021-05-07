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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }

        return buildFromPreAndIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 从 前序 与 中序遍历序列构造二叉树
    private TreeNode buildFromPreAndIn(int[] preorder, int preStr, int preEnd, int[] inorder, int inStr, int inEnd) {
        //拿到前序第一个的值  (拿到根节点的值)
        int rootValue = preorder[preStr];
        //使用此值生成根节点
        TreeNode root = new TreeNode(rootValue);
        //如果 开始位置等于结束位置(数组长度为0) 那么结束
        if (preStr == preEnd) {
            return null;
        }
        //从开始位置寻找根节点位置
        int rootInorder = inStr;
        while (inorder[rootInorder] != rootValue && rootInorder <= inEnd) {
            rootInorder++;
        }
        //中序遍历的前半部分为 左子树
        int leftLength = rootInorder - inStr;
        //中序遍历后半部分为 右子树
        int leftPreEnd = preStr + leftLength;
        //如果 左子树的数组长度 大于0 则递归调用
        if (leftLength > 0) {
            //连接树下一个左节点
            root.left = buildFromPreAndIn(preorder, preStr + 1, leftPreEnd, inorder, inStr, inEnd);
        }
        //如果左子树 数组长度 小于 当前数组长度 表示存在右子树
        if (leftLength < preEnd - preStr) {
            //连接树下一个右节点
            root.right = buildFromPreAndIn(preorder, leftPreEnd + 1, preEnd, inorder, rootInorder + 1, inEnd);
        }

        return root;
    }

    //由 中序 和 后序遍历 构造二叉树
    public TreeNode buildFromInAndPost(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        if (postStart == postEnd) {
            return root;
        }
        int index = inStart;
        //令index指向中序序列中根节点所在位置
        while (inOrder[index] != postOrder[postEnd]) {
            index++;
        }
        int leftSubInStart = inStart;
        int leftSubInEnd = index - 1;
        int rightSubInStart = index + 1;
        int rightSubInEnd = inEnd;

        int leftSubPostStart = postStart;
        int leftSubPostEnd = leftSubPostStart + (leftSubInEnd - leftSubInStart);
        int rightSubPostStart = leftSubPostEnd + 1;
        int rightSubPostEnd = postEnd - 1;

        root.left = buildFromInAndPost(inOrder, postOrder, leftSubInStart, leftSubInEnd, leftSubPostStart, leftSubPostEnd);
        root.right = buildFromInAndPost(inOrder, postOrder, rightSubInStart, rightSubInEnd, rightSubPostStart, rightSubPostEnd);
        return root;
    }

    //由 前序 与 后序 构造二叉树
    public TreeNode buildFromPreAndPost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        //越界，说明已经递归构造到树末端
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        //前序序列第一个元素为根
        TreeNode root = new TreeNode(pre[preStart]);
        //仅剩一个节点待构造，是叶节点，直接返回
        if (preStart == preEnd) {
            return root;
        }
        //index为数组中最右一个左子树的元素（划分左右子树边界）
        int index = postStart;
        //前序遍历中左子树的根节点对应的是后序遍历得到的数组序列中左子树元素的最右一个
        while (pre[preStart + 1] != post[index]) {
            index++;
        }
        //左子树的前序、后序序列起止下标
        int leftSubPreStart = preStart + 1;
        int leftSubPreEnd = preStart + 1 + index - postStart;
        int leftSubPostStart = postStart;
        int leftSubPostEnd = index;
        //右子树的前序、后序序列起止下标
        int rightSubPreStart = leftSubPreEnd + 1;
        int rightSubPreEnd = preEnd;
        int rightSubPostStart = index + 1;
        int rightSubPostEnd = postEnd - 1;
        //递归构造左右子树
        root.left = buildFromPreAndPost(pre, post, leftSubPreStart, leftSubPreEnd, leftSubPostStart, leftSubPostEnd);
        root.right = buildFromPreAndPost(pre, post, rightSubPreStart, rightSubPreEnd, rightSubPostStart, rightSubPostEnd);
        return root;
    }

}