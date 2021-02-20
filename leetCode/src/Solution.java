import javafx.scene.control.Cell;

import java.util.*;

public class Solution {

    //反转整数
    //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    //
    //示例 1:
    //
    //输入: 123
    //输出: 321
    public static int fanzhuanInt(int x) {
        int term;
        long b = 0;
        while (x != 0) {
            term = x % 10;
            x = x / 10;
            b = b * 10 + term;
        }
        if (b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) b;

    }

    //回文数
    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //示例 1:
    //
    //输入: 121
    //输出: true
    public static boolean method(int i) {
        if (i > 0) {
            int temp = 0;
            long b = 0;
            int j = i;
            while (j != 0) {
                temp = j % 10;
                j = j / 10;
                b = b * 10 + temp;
            }
            if (b == i) {
                return true;
            }
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    //回文数
    public static boolean method2(int x) {
        if (x < 10 && x > -1) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        String xStr = String.valueOf(x);
        char[] xChar = xStr.toCharArray();
        int i = 0, j = xChar.length - 1;
        while (i < j) {
            if (xChar[i] == xChar[j]) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    //超过Integer长度不行   回文数
    public static boolean method3(int x) {
        if (x >= 0) {
            String str = new StringBuffer(String.valueOf(x)).reverse().toString();
            if (Integer.parseInt(str) == x) {
                return true;
            }
        }
        return false;
    }

    //两数相加
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //罗马数字转整数
    // 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    // 示例 2:
    //输入: "IV"
    //输出: 4
    public int romanToInt(String s) {
        //判断后面数值是否大于前面
        Map<Character, Integer> romaNumber = new HashMap<>();
        romaNumber.put('I', 1);
        romaNumber.put('V', 5);
        romaNumber.put('X', 10);
        romaNumber.put('L', 50);
        romaNumber.put('C', 100);
        romaNumber.put('D', 500);
        romaNumber.put('M', 1000);

        int firstValue = 0;
        int nextValue = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            firstValue = romaNumber.get(s.charAt(i));
            if (i == s.length() - 1) {
                sum += firstValue;
            } else {
                nextValue = romaNumber.get(s.charAt(i + 1));
                if (firstValue >= nextValue) {
                    sum += firstValue;
                } else {
                    sum -= firstValue;
                }
            }
        }
        return sum;
    }

    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    //
    //示例 1:
    //
    //输入: ["flower","flow","flight"]
    //输出: "fl"
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.equals("") || res.equals("")) {
                return "";
            }
            int start = 0;
            while (start < res.length() && start < str.length() && str.charAt(start) == res.charAt(start)) {
                start++;
            }
            //res在某一次循环得出最小的公共子串。  根据start < res.length() 得知的.
            res = res.substring(0, start);
        }
        return res;
    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //注意空字符串可被认为是有效字符串。
    //
    //示例 1:
    //
    //输入: "()"
    //输出: true
    public boolean isValid(String s) {
        Stack<Character> mark = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                mark.push(s.charAt(i));
            } else {
                if (mark.isEmpty()) {
                    return false;
                }
                char cur = mark.pop();
                if (cur == '(' && s.charAt(i) != ')') {
                    return false;
                }
                if (cur == '[' && s.charAt(i) != ']') {
                    return false;
                }
                if (cur == '{' && s.charAt(i) != '}') {
                    return false;
                }
            }
        }
        if (mark.isEmpty()) {
            return true;
        }
        return false;
    }

    //单向链表节点类
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
    //
    //示例：
    //
    //输入：1->2->4, 1->3->4
    //输出：1->1->2->3->4->4
    //
    //时间限制未通过   非递归方法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            boolean chk = (l1.val < l2.val);
            cur.next = chk ? l1 : l2;
            cur = cur.next;
            l1 = chk ? l1 : l1.next;
            l2 = chk ? l2 : l2.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return head.next;
    }

    //与上个方法相同 实现方式有差别   通过
    public ListNode mergeTwoListsOK(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;

        }

        if (l2 != null) {
            tmp.next = l2;

        }

        return res.next;
    }

    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    //示例 1:
    // 给定 nums = [0,0,1,1,1,2,2,3,3,4],
    //函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
    //你不需要考虑数组中超出新长度后面的元素。
    //满指针控制下一个前移得数得位置,最后慢指针值为元素个数
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    //示例 1:
    //给定 nums = [3,2,2,3], val = 3,
    //函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
    //你不需要考虑数组中超出新长度后面的元素。
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    //实现 strStr() 函数。
    //
    //给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    //
    //示例 1:
    //
    //输入: haystack = "hello", needle = "ll"
    //输出: 2
    //遇事不决双指针
    public int strStr(String haystack, String needle) {
        char[] hayArr = haystack.toCharArray();
        char[] needArr = needle.toCharArray();
        int i = 0; //主串(haystack)的位置
        int j = 0; //模式串(needle)的位置
        while (i < hayArr.length && j < needArr.length) {
            if (hayArr[i] == needArr[j]) { // 当两个字符相等则比较下一个
                i++;
                j++;
            } else {
                i = i - j + 1; // 一旦不匹配，i后退
                j = 0; // j归零
            }
        }
        if (j == needArr.length) { //说明完全匹配
            return i - j;
        } else {
            return -1;
        }
        //一行解决 , 看indexOf源码 , 源码整好解决
        //  return haystack.indexOf(needle);
    }

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //你可以假设数组中无重复元素。
    //
    //示例 1:
    //
    //输入: [1,3,5,6], 5
    //输出: 2
    public int searchInsert(int[] nums, int target) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                j++;
            }
            if (nums[i] >= target) {
                return j;
            }
        }
        return j;
    }

    //「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
    //
    //1.     1
    //2.     11
    //3.     21
    //4.     1211
    //5.     111221
    //示例:
    //
    //输入: 4
    //输出: "1211"
    //解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
    public String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            s += "#";
            String tmp = "";
            int count = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                } else {
                    tmp = tmp + count + s.charAt(i);
                    count = 1;
                }
            }
            s = tmp;
            n--;
        }


        return s;
    }

    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //示例:
    //
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    public int maxSubArray(int[] nums) {
        int maxToCurr = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToCurr = Math.max(maxToCurr + nums[i], nums[i]);
            sum = Math.max(sum, maxToCurr);
        }
        return sum;
    }

    //给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
    //
    //如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
    //如果不存在最后一个单词，请返回 0 。
    //说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
    //示例:
    //输入: "Hello World"
    //输出: 5

    /**
     * 自己写的有点太麻烦  .
     *
     * @param s
     * @return
     */
    public int myLengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty() || " ".equals(s)) {
            return 0;
        }
        s = s.replace('.', ' ');
        s = s.replace(',', ' ');
        s = s.replace('\'', ' ');
        s = s.replace('\"', ' ');
        String[] strings = s.split("\\s+");
        return strings[strings.length].length();
    }

    /**
     * 同一个想法大佬的做法
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        return s.substring(start).length();
    }

    //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    //你可以假设除了整数 0 之外，这个整数不会以零开头。
    //示例 1:
    //输入: [1,2,3]
    //输出: [1,2,4]
    //解释: 输入数组表示数字 123。
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (carry > 0) {
            int res[] = new int[digits.length + 1];
            res[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }

    //实现 int sqrt(int x) 函数。
    //
    //计算并返回 x 的平方根，其中 x 是非负整数。
    //由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    //示例 1:
    //输入: 4
    //输出: 2

    public int mySqrt(int x) {
        int curr = 0;
        int res = 0;
        int add = 1;
        while (curr <= x) {
            if (Integer.MAX_VALUE - curr < add) {
                return res;
            }
            curr += add;
            res++;
            add += 2;
        }
        return res - 1;
    }

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //注意：给定 n 是一个正整

    /**
     * 通过数组
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 直接使用斐波那契数列
     *
     * @param n
     * @return
     */
    public int climbStairsByfb(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    //示例 1:
    //输入: 1->1->2
    //输出: 1->2
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = new ListNode(0);
        curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    //说明:
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    //你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    //示例:
    //输入:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //输出: [1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int i = m + n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[i] = nums1[i1];
                i1--;
            } else {
                nums1[i] = nums2[i2];
                i2--;
            }
            i--;
        }
        while (i2 >= 0) {
            nums1[i] = nums2[i2];
            i--;
            i2--;
        }
    }

    /**
     * Definition for a binary tree node.
     * TreeNode  二叉树节点类
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //给定两个二叉树，编写一个函数来检验它们是否相同。
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    //示例 1:
    //输入:       1         1
    //          / \       / \
    //         2   3     2   3
    //
    //        [1,2,3],   [1,2,3]
    //输出: true
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    //给定一个二叉树，检查它是否是镜像对称的。
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    //TODO: 2020/2/13  非递归太长没看 需要看
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    //判断是否镜像 ： 1.当前结点是否相等  2.当前节点的左子树 与 镜像节点的右子树是否相等  3. 有子树 与 左子树
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    //给定一个二叉树，找出其最大深度。
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //说明: 叶子节点是指没有子节点的节点。
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]，
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。
    //递归方法
    // TODO: 2020/2/13  非递归太长没看 需要看
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    //给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    //例如：
    //给定二叉树 [3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回其自底向上的层次遍历为：
    //[
    //  [15,7],
    //  [9,20],
    //  [3]
    //]
    // TODO: 2020/2/13 广度优先遍历 和 深度优先遍历需要看    题解暂不理解待消化 博客地址：https://www.jianshu.com/p/76abc4ff072f
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderBottom(root, 0, result);
        return result;
    }

    private void levelOrderBottom(TreeNode root, int len, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() <= len) result.add(0, new ArrayList<>());
        result.get(result.size() - len - 1).add(root.val);
        levelOrderBottom(root.left, len + 1, result);
        levelOrderBottom(root.right, len + 1, result);
    }

    //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    //本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    //示例:
    //给定有序数组: [-10,-3,0,5,9],
    //一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
    //      0
    //     / \
    //   -3   9
    //   /   /
    // -10  5
    // TODO: 2020/2/13 数据结构 ： 链表 、二叉树 基础操作的实现统一学习 。
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    //示例 1:
    //给定二叉树 [3,9,20,null,null,15,7]
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回 true 。
    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null) {
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    //给定一个二叉树，找出其最小深度。
    //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    //说明: 叶子节点是指没有子节点的节点。
    //示例:
    //给定二叉树 [3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最小深度  2
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    //说明: 叶子节点是指没有子节点的节点。
    //示例: 
    //给定如下二叉树，以及目标和 sum = 22，
    //
    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \      \
    //        7    2      1
    //返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    //在杨辉三角中，每个数是它左上方和右上方的数的和。
    //示例:
    //输入: 5
    //输出:
    //[
    //     [1],
    //    [1,1],
    //   [1,2,1],
    //  [1,3,3,1],
    // [1,4,6,4,1]
    //]
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }

    //给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    //在杨辉三角中，每个数是它左上方和右上方的数的和。
    //示例:
    //输入: 3
    //输出: [1,3,3,1]
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }


    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    //注意你不能在买入股票前卖出股票。
    //示例 1:
    //输入: [7,1,5,3,6,4]
    //输出: 5
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        // 表示在当前位置之前的最小值，假设修正法（打擂台法）
        int minVal = prices[0];
        // 注意：这里从 1 开始
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return res;
    }

    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //示例 1:
    //输入: [7,1,5,3,6,4]
    //输出: 7
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    public int maxProfitTwo(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    //注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //示例 1:
    //输入: [3,3,5,0,0,3,1,4]
    //输出: 6
    //解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
    //     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3

    // TODO: 2020/2/14   没看懂可还行  看样子不太容易的感觉  mmp这是简单题  ？？？
    //  点错了 这TM是困难  ！
    //  打扰了 ！！！
    public int maxProfitThree(int[] prices) {
        /**
         //fst的两个变量的意义与121题相同，就是简单的动态规划更新

         fstMineprice : 到该天为止第一次买入股票的最小价格（即所有股票价格的最小值）
         fstMaxprofit: 到该天为止第一次卖出股票的最大收益（即只交易一次的最大收益）

         //sec的两个变量的意义要注意，特别是secMinprice，不单纯是股票原价格，而是在此基础上减去第一次收益

         secMinprice: 到该天为止第二次买入股票的最小价格（第二次买入股票的价格是原股票价格减去第一次买卖收益）
         secMaxprofit: 到该天为止第二次卖出股票可获得的最大收益

         分别对四个变量进行相应的更新, 最后secMaxprofit就是最大
         **/
        int fstMineprice = Integer.MAX_VALUE, fstMaxprofit = 0;
        int secMinprice = Integer.MAX_VALUE, secMaxprofit = 0;
        for (int p : prices) {
            //更新fstMineprice与fstMaxprofit，这里应该没有问题，与121题一样
            fstMineprice = Math.min(fstMineprice, p);
            fstMaxprofit = Math.max(fstMaxprofit, p - fstMineprice);

            //更新secMineprice与secMaxprofit
            secMinprice = Math.min(secMinprice, p - fstMaxprofit);//加入的p产生的最小价格就是p减去第一次买卖的最大收益，以此更新secMinprice
            secMaxprofit = Math.max(secMaxprofit, p - secMinprice);//p产生的最大收益就是p减去第二次买入的最小价格secMinprice，以此更新secMaxprofit
        }
        return secMaxprofit;
    }

    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //说明：本题中，我们将空字符串定义为有效的回文串。
    //示例 1:
    //输入: "A man, a plan, a canal: Panama"
    //输出: true
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        int a = 0, b = s.length() - 1;

        while (a < b) {
            if (!Character.isLetterOrDigit(s.charAt(a))) {
                a++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(b))) {
                b--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(a)) != Character.toLowerCase(s.charAt(b))) {
                return false;
            }

            a++;
            b--;
        }
        return true;
    }

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //说明：
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //示例 1:
    //输入: [2,2,1]
    //输出: 1
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }

    //给定一个链表，判断链表中是否有环。
    //为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    //示例 1：
    //输入：head = [3,2,0,-4], pos = 1
    //输出：true

    /**
     * 双指针 一快一慢重合的点就是交点
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 通过HashSet将每个节点遍历一遍   如表中存在相同值返回True  遍历至Null返回false
     *
     * @param head
     * @return
     */
    public boolean hasCycleByHash(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    //push(x) -- 将元素 x 推入栈中。
    //pop() -- 删除栈顶的元素。
    //top() -- 获取栈顶元素。
    //getMin() -- 检索栈中的最小元素。
    //示例:
    //MinStack minStack = new MinStack();
    //minStack.push(-2);
    //minStack.push(0);
    //minStack.push(-3);
    //minStack.getMin();   --> 返回 -3.
    //minStack.pop();
    //minStack.top();      --> 返回 0.
    //minStack.getMin();   --> 返回 -2.
    class MinStack {

        // 数据栈
        private Stack<Integer> data;
        // 辅助栈
        private Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        // 思路 1：数据栈和辅助栈在任何时候都同步

        public void push(int x) {
            // 数据栈和辅助栈一定会增加元素
            data.add(x);
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            } else {
                helper.add(helper.peek());
            }
        }

        public void pop() {
            // 两个栈都得 pop
            if (!data.isEmpty()) {
                helper.pop();
                data.pop();
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {
            if (!helper.isEmpty()) {
                return helper.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

    }

    //编写一个程序，找到两个单链表相交的起始节点。

    /**
     * 叹为观止啊   将AB相连  最后走到的相同的点就是相交节点。
     * 例如 ： A ： 3 4 1 6 8
     * B :      3 6 8
     * A节点遍历走过路程 ：    3 4 1 6 8 3 6 8
     * B节点遍历走过的路程 ：  3 6 8 3 4 1 6 8
     * 当运行至第一个相同节点 6 时 ， 跳出while循环 ，此节点为相交节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    //给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    //函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    //说明 :
    //返回的下标值（index1 和 index2）不是从零开始的。
    //你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
    //示例:
    //输入: numbers = [2, 7, 11, 15], target = 9
    //输出: [1,2]
    //解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
    public int[] twoSumTwo(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            while (numbers[start] + numbers[end] > target) {
                end--;
            }
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else {
                start++;
            }
        }
        return null;
    }

    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //示例 1:
    //输入: [3,2,3]
    //输出: 3
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length <= 2) {
            return nums[0];
        }
        for (int i : nums) {
            if (map.containsKey(i)) {
                if (map.get(i) + 1 > nums.length / 2) {
                    return i;
                }
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return -1;
    }

    //给定一个整数 n，返回 n! 结果尾数中零的数量。
    //示例 2:
    //输入: 5
    //输出: 1
    //解释: 5! = 120, 尾数中有 1 个零.

    /**
     * 我们把每个乘数再稍微分解下，看一个例子。
     * 11! = 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 = 11 * (2 * 5) * 9 * (4 * 2) * 7 * (3 * 2) * (1 * 5) * (2 * 2) * 3 * (1 * 2) * 1
     * 对于含有 2 的因子的话是 1 * 2, 2 * 2, 3 * 2, 4 * 2 ...
     * 对于含有 5 的因子的话是 1 * 5, 2 * 5...
     * 含有 2 的因子每两个出现一次，含有 5 的因子每 5 个出现一次，所有 2 出现的个数远远多于 5，换言之找到一个 5，一定能找到一个 2 与之配对。所以我们只需要找有多少个 5。
     * 直接的，我们只需要判断每个累乘的数有多少个 5 的因子即可。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    //约瑟夫环
    //已知 n 个人（以编号1，2，3 … n 分别表示）围成一圈。从编号为 1 的人开始报数，
    //数到 m 的那个人出列；他的下一个人又从 1 开始报数，
    //数到 m 的那个人又出列；依此规律重复下去，直到最后剩下一个人。要求找出最后出列的人的编号
    //  todo ！！  此题 M 为固定值  若为非固定的值具体分析  ！！
    public int solve(int n, int m) {
        if (m == 1 || n < 2)
            return n;
        // 创建环形链表
        Node head = createLinkedList(n);
        // 遍历删除
        int count = 1;
        Node cur = head;
        Node pre = null;//前驱节点
        while (head.next != head) {
            // 删除节点
            if (count == m) {
                count = 1;
                pre.next = cur.next;
                cur = pre.next;
            } else {
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        return head.date;
    }

    // 定义链表节点  此类只为此题服务
    class Node {
        int date;
        Node next;

        public Node(int date) {
            this.date = date;
        }
    }

    /**
     * 生成长度为 n 的环形链表
     *
     * @param n
     * @return
     */
    Node createLinkedList(int n) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= n; i++) {
            Node tmp = new Node(i);
            next.next = tmp;
            next = next.next;
        }
        // 头尾串联
        next.next = head;
        return head;
    }

    //复习快排  试着写写
    public void testQuickSort(int[] arrays, int low, int high) {
        int pivod = arrays[low];
        int i = low + 1;
        int j = high;

        while (i < j) {
            while (i < j && arrays[i] < pivod) {
                i++;
            }
            while (i < j && arrays[j] > pivod) {
                j--;
            }
            if (i < j) {
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
        }
        if (arrays[i] < arrays[low]) {
            int temp = arrays[low];
            arrays[low] = arrays[i];
            arrays[i] = temp;
        }
        if (i - 1 > low) {
            testQuickSort(arrays, low, i - 1);
        }
        if (i + 1 < high) {
            testQuickSort(arrays, i, high);
        }
    }
}
