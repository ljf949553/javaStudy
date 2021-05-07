import javafx.scene.control.Cell;
import sun.plugin.dom.core.CoreConstants;

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
    // 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
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
    //如果不存在公共前缀，返回空字符串""。
    //
    //示例1:
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

    //给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
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
    public static class ListNode {
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
    //示例1:
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


    //实现strStr()函数。
    //
    //给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
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

    //给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //示例:
    //
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释:连续子数组[4,-1,2,1] 的和最大，为6。
    public int maxSubArray(int[] nums) {
        //此位置最大值
        int maxToCurr = nums[0];
        //当前最大值
        int sum = nums[0];
        //循环 : 从首位至末位
        for (int i = 1; i < nums.length; i++) {
            // 此位置最大值  = ( 上一次最大值 + 当前值 )  动态地更新此位置最大值 , 总是保留
            maxToCurr = Math.max(maxToCurr + nums[i], nums[i]);
            // 此位置最大值 与 当前最大值中 保留大的
            sum = Math.max(sum, maxToCurr);
        }
        return sum;
    }

    public int[] maxSubArrayWithIndex(int[] nums) {
        //此位置最大值
        int maxToCurr = nums[0];
        //当前最大值
        int sum = nums[0];
        int start = 0;
        int end = 0;
        //循环 : 从首位至末位
        for (int i = 1; i < nums.length; i++) {
            // 此位置最大值  = ( 上一次最大值 + 当前值 )  动态地更新此位置最大值 , 总是保留
            maxToCurr = Math.max(maxToCurr + nums[i], nums[i]);
            // 如果新值更大 , 那么最大值起始点跟进
            if (maxToCurr == nums[i]) {
                start = i;
            }
            // 此位置最大值 与 当前最大值中 保留大的
            sum = Math.max(sum, maxToCurr);
            // 如果当前最大值更大 , 那么结束位置跟进
            if (sum == maxToCurr) {
                end = i;
            }
        }
        System.out.println("start  : " + start);
        System.out.println("end  : " + end);
        return new int[]{sum, start, end};
    }

    //给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。
    //
    //如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
    //如果不存在最后一个单词，请返回 0。
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
    //示例1:
    //输入: [1,2,3]
    //输出: [1,2,4]
    //解释: 输入数组表示数字 123。
    public int[] plusOne(int[] digits) {
        //carry是几应该都没什么影响
        int carry = 1;
        //从后向前遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            //最后一位加carry
            digits[i] += carry;
            //令carry 除以 10 得到进位
            carry = digits[i] / 10;
            //最后一位赋值为 对 10 取余
            digits[i] = digits[i] % 10;
        }
        //如果最后carry大于 0 , 说明第一位需要进位 . 将carry放在第一位, digits全部后移一位 .
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

    //实现int sqrt(int x)函数。
    //
    //计算并返回x的平方根，其中x 是非负整数。
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

    //给定两个有序整数数组nums1 和 nums2，将 nums2 合并到nums1中，使得num1 成为一个有序数组。
    //说明:
    //初始化nums1 和 nums2 的元素数量分别为m 和 n。
    //你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
    //示例:
    //输入:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //输出:[1,2,2,3,5,6]
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
    //示例1:
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
    //例如，二叉树[1,2,2,3,4,4,3] 是对称的。
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
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
    //说明:叶子节点是指没有子节点的节点。
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]，
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度3 。
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
    //本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
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
    //一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
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
    //说明:叶子节点是指没有子节点的节点。
    //示例:
    //给定二叉树[3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最小深度 2
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
    //说明:叶子节点是指没有子节点的节点。
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


    //给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
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

    //给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
    //设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //示例 1:
    //输入: [7,1,5,3,6,4]
    //输出: 7
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    public int maxProfitTwo(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    //注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //示例1:
    //输入: [3,3,5,0,0,3,1,4]
    //输出: 6
    //解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
    //    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3

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

    //相同的数字 异或(^)为0 与0异或最终得出为出现1次的数
    public int bestSingleNumber(int[] nums) {
        int num = 0;
        for (int j : nums) {
            num = num ^ j;
        }
        return num;
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
    //push(x)-- 将元素 x 推入栈中。
    //pop()-- 删除栈顶的元素。
    //top()-- 获取栈顶元素。
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
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;
    }

    //给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
    //函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。
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

    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊ n/2 ⌋的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //示例1:
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
        //每次数 1(m == 1) 那么第1个人一定会到最后 , 如果只有 1(n < 2) 个人, 直接出列
        if (m == 1 || n < 2)
            return n;
        // 创建环形链表
        Node head = createLinkedList(n);
        // 遍历删除
        int count = 1;
        Node cur = head;
        //前驱节点 删除节点时使用
        Node pre = null;
        //循环退出条件为 : 链表内只有一个节点
        while (head.next != head) {
            //遍历至第 m 个  删除此节点
            if (count == m) {
                //重置count
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
    static class Node {
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
            next.next = new Node(i);
            next = next.next;
        }
        // 头尾串联
        next.next = head;
        return head;
    }


    //题目描述：某街道两旁分别种植一排树木，编号如下：
    //
    //1 3 5 7 9 11 13 15 17 。。。。 99
    //
    //2 4 6 8 10 12 .。。100
    //
    //砍了一些树，希望找到最长连续的大树
    //
    //
    //
    //输入：一个整数N
    //
    //第二行：N个被砍的树木编号：
    //
    //5
    //
    //9 15 27 35 6
    //
    //输出
    //
    //8 47 （8为起始位置 47为连续树木）
   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int nums[] = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }

        Map map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }

        int left[] = new int[50];
        int right[] = new int[50];
        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + 2;
        }
        right[0] = 2;
        for (int i = 1; i < right.length; i++) {
            right[i] = right[i - 1] + 2;
        }

        int tempA = 0;
        int tempB = 0;
        int targetA = 0;
        int targetB = 0;
        int beginA = 1;
        int beginB = 2;
        for (int i = 0; i < left.length; i++) {
            if (map.containsKey(left[i])) {
                targetA = Math.max(targetA, tempA);
                tempA = 0;
                continue;
            }
            if (targetA == tempA) {
                beginA = left[i] - tempA * 2;
            }
            tempA++;
            targetA = tempA;
        }
        for (int i = 0; i < right.length; i++) {
            if (map.containsKey(right[i])) {
                targetB = Math.max(targetB, tempB);
                tempB = 0;
                continue;
            }
            if (targetB == tempB) {
                beginB = right[i] - tempB * 2;
            }
            tempB++;
            targetB = tempB;
        }

        if (targetA >= targetB) {
            System.out.printf("(%d,%d)", beginA, targetA);
        } else {
            System.out.printf("(%d,%d)", beginB, targetB);

        }
    }*/

    //复习快排  试着写写
    public void testQuickSort(int[] arrays, int low, int high) {
        //取第一个值用于对比
        int pivod = arrays[low];
        //开始位置
        int i = low + 1;
        //结束位置
        int j = high;

        while (i < j) {
            //前半部分  如果小于基准数 指针后移 如果大于退出循环
            while (i < j && arrays[i] < pivod) {
                i++;
            }
            //后半部分 如果大于基准数 指针前移 如果小于退出循环
            while (i < j && arrays[j] > pivod) {
                j--;
            }
            //以上两个循环退出时, 指针指向不符合的两个数字, 调换位置
            if (i < j) {
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
        }

        //退出以上循环时, 确认基准数与当前指针所在数的大小, 如果不符则替换
        if (arrays[i] < arrays[low]) {
            int temp = arrays[low];
            arrays[low] = arrays[i];
            arrays[i] = temp;
        }
        //拆分数组为两部分 递归调用
        if (i - 1 > low) {
            testQuickSort(arrays, low, i - 1);
        }
        if (i < high) {
            testQuickSort(arrays, i, high);
        }
    }

    //复习二分查找 试着写写    !--数组要有序--
    public int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        //开始位置
        int begin = 0;
        //结束位置
        int end = arr.length - 1;
        while (begin < end) {
            //找到中间位置
            int mid = (end + begin) / 2;
            //使用Comparable比较两个数字大小
            Comparable compiler = arr[mid];
            final int i1 = compiler.compareTo(target);
            if (i1 < 0) {
                //小于零  使开始位置等于中间
                begin = mid + 1;
            } else if (i1 > 0) {
                //大于零 使开结束位置处于中间
                end = mid - 1;
            } else {
                //等于则直接返回
                return mid;
            }
        }
        return -1;
    }

    //      !!!!        前缀和问题       !!!!
    //给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
    //
    //实现 NumArray 类：
    //
    //NumArray(int[] nums) 使用数组 nums 初始化对象
    //int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
    //
    //
    //示例：
    //
    //输入：
    //["NumArray", "sumRange", "sumRange", "sumRange"]
    //[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    //输出：
    //[null, 1, -1, -3]
    //
    //解释：
    //NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    //numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
    //numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
    //numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))

    //可直接for循环暴力解决
    //但是题干说会重复调用 , 每一次都会将数组内元素相加 , 看了下大佬题解 , 使用前缀和的方式
    //前缀和 的方式时通过对暴力方法的一步一步优化得来 :
    // 1)暴力法每次都会重新计算 , 既然会多次调用 , 就用三层循环将每个位置的数据求出来存起来, 这样每次查一下就行了 .
    // 2)多层循环继续优化: 当前项的值 = 当前前缀和 - 上一项的前缀和
    //      nums 数组的每一项都对应有它的前缀和： nums 的第 0 项到 当前项 的和。
    //      用数组 preSum 表示，preSum[i] : 第 0 项到 第 i 项 的和。
    //                preSum[i] = nums[0] + nums[1] +…+nums[i]
    //      易得，nums 的某项 = 两个相邻前缀和的差：
    //                nums[i] = preSum[i] - preSum[i - 1]
    //                nums[i]=preSum[i]−preSum[i−1]
    //      对于 nums 的 i 到 j 的元素和，上式叠加，有：
    //                nums[i] +…+nums[j]=preSum[j] - preSum[i - 1]
    //                nums[i]+…+nums[j]=preSum[j]−preSum[i−1]
    //      当 i 为 0 时，此时 i-1 为 -1，我们故意让preSum[-1]为 0，使得上式在i=0时也成立：
    //                nums[0] +…+nums[j]=preSum[j]
    //                nums[0]+…+nums[j]=preSum[j]
    //      所以：
    //                sumRange(i, j) = preSum[j] - preSum[i - 1]
    //
    //链接：https://leetcode-cn.com/problems/range-sum-query-immutable/solution/jian-dan-wen-ti-xi-zhi-fen-xi-qian-tan-q-t2nz/
    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            int len = nums.length;
            this.preSum = new int[len + 1];
            for (int i = 0; i < len; i++)
                preSum[i + 1] = preSum[i] + nums[i];

        }

        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }


    //给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
    //
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //
    //你可以假设除了数字 0 之外，这两个数都不会以 0开头。
    //
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    //解释：342 + 465 = 807.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //l1是否为null , 为null 则 x = 0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //当前位的值为  x+y+carry(进位)
            int sum = x + y + carry;
            //进位
            carry = sum / 10;
            //去掉进位后的值
            sum = sum % 10;
            //当前位赋值
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //出循环后如果有进位,增加一个新节点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


    //给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
    //
    //示例 :
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public int lengthOfLongestSubstring(String s) {
        // 异常输入排查
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxCount = 0;
        int len = s.length();
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // 右指针不断向前，直到字符串尾部
        while (end < len) {
            maxCount = Math.max(maxCount, end - start);
            // 当遇到重复值，说明左指针需要跳转，跳转的位置是该重复值的下标+1
            // 比如字符串abcdecf，到遇到第二个c，即便从bcde任意一个开始，长度都无法超过a，只有从decf开始计算才是新一轮查找
            // 值得注意的是，如果碰到了重复值的下标比左指针还小的情况，不应该跳转，因为左指针左边的元素不再窗口内，比如abba
            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end), end);        // 无论重不重复都需要更新，该元素最近的下标
            end++;
        }
        maxCount = Math.max(maxCount, end - start);
        return maxCount;
    }


    //删除链表中等于给定值 val 的所有节点。
    //
    // 示例:
    // 输入: 1->2->6->3->4->5->6, val = 6
    // 输出: 1->2->3->4->5
    public ListNode removeElements(ListNode head, int val) {
        //哨兵节点 , 将其置为第一个节点, 避免前几个节点需要删除的情况
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            //如果找到此值跳过此节点
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                //否则两个指针分别向后走
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

    //统计所有小于非负整数n的质数的数量。
    //
    // 示例 1：
    // 输入：n = 10
    // 输出：4
    // 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
    //此题时比较硬得数学题
    //
    //初始化长度 O(n)的标记数组，表示这个数组是否为质数。数组初始化所有的数都是质数.
    //从 2 开始将当前数字的倍数全都标记为合数。标记到 根号n 时停止即可
    //注意每次找当前素数 x 的倍数时，是从 x^2开始的。因为如果 x > 2x>2，那么 2*x2∗x 肯定被素数 2 给过滤了，最小未被过滤的肯定是 x^2.
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    //给定两个字符串 s 和 t，判断它们是否是同构的。
    //如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
    //
    // 示例 1:
    // 输入：s = "egg", t = "add"
    // 输出：true
    //
    //通过s 与 t 字符串的各个位置上的一一映射关系 , 如果不一致则有问题
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            //如果s2t中已经存在第 i 位字符,并且s2t中 x 字符与房前 y 值
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    //翻转链表
    public ListNode reverseList(ListNode head) {
        //pre作用是保留最后的前一个curr 因为最后的curr是null
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //递归方法
    private ListNode reverse(ListNode head) {
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    //
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //
    //例如，给定如下二叉搜索树:
    //                 6
    //                / \
    //               2   8
    //              / \ / \
    //             0  4 7  9
    //               / \
    //              3  5
    //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //输出: 6
    //解释: 节点 2 和节点 8 的最近公共祖先是 6。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) {
            return p;
        }
        if (q.val == root.val) {
            return q;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    //给定两个数组，编写一个函数来计算它们的交集。
    //
    //示例 1：
    //
    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2]
    //示例 2：
    //
    //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出：[9,4]
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            if (!set.add(num)) {
                set1.add(num);
            }
        }

        for (int num : nums2) {
            if (!set.contains(num)) {
                set1.add(num);
            }
        }
        int[] arr = new int[set1.size()];
        int i = 0;
        for (Integer integer : set1) {
            arr[i++] = integer;

        }
        return arr;
    }

    //给定两个数组，编写一个函数来计算它们的交集。
    //
    //示例 1：
    //
    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2,2]
    //示例 2：
    //
    //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出：[9,4]
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }

        for (int num : nums2) {
            if (list.contains(num)) {
                list1.add(num);
                list.remove((Integer) num);
            }
        }
        int[] arr = new int[list1.size()];
        int i = 0;
        for (Integer integer : list1) {
            arr[i++] = integer;

        }
        return arr;
    }

    //给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
    //进阶：不要 使用任何内置的库函数，如  sqrt 。
    //
    //示例 1：
    //输入：num = 16
    //输出：true
    //
    //  !!!  利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
    public boolean isPerfectSquare(int num) {
        int sumnum = 1;
        while (num > 0) {
            num -= sumnum;
            sumnum += 2;
        }
        return num == 0;
    }

    //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
    //
    //(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
    //
    //示例 1：
    //输入：ransomNote = "a", magazine = "b"
    //输出：false
    //
    //示例 2：
    //输入：ransomNote = "aa", magazine = "ab"
    //输出：false
    //   !!! 利用 StringBuilder 的 deleteCharAt() 将检查到的字符删除掉 直至无法找到下一个字符 .
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder stringBuilder = new StringBuilder(magazine);
        int index;
        for (char c : ransomNote.toCharArray()) {
            index = stringBuilder.indexOf(String.valueOf(c));
            if (index >= 0) {
                stringBuilder.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return true;
    }

    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    //
    //示例：
    //s = "leetcode"
    //返回 0
    //
    //s = "loveleetcode"
    //返回 2
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //给定两个字符串 s 和 t，它们只包含小写字母。
    //字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    //请找出在 t 中被添加的字母。
    //
    //示例 1：
    //输入：s = "abcd", t = "abcde"
    //输出："e"
    //解释：'e' 是那个被添加的字母。
    //
    //示例 2：
    //输入：s = "", t = "y"
    //输出："y"
    public char findTheDifference(String s, String t) {

        // 利用 StringBuild 都不如用两层循环  辣鸡如斯.
      /*  StringBuilder stringBuilder = new StringBuilder(s);
        for (char ch : t.toCharArray()) {
            int i = stringBuilder.indexOf(Character.toString(ch));
            if (i == -1) {
                return ch;
            }
            stringBuilder.deleteCharAt(i);
        }
        return ' ';*/

        // 利用 char 固定值得特点 , 多出来的就是新增的 .
        //  !!!! 遇到 char 题 , 多想 !!! 位操作
        int sumS = 0;
        int sumT = 0;
        for (char ch : s.toCharArray()) {
            sumS += ch;
        }
        for (char ch : t.toCharArray()) {
            sumT += ch;
        }
        return (char) (sumT - sumS);
    }

    //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    //字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    //
    //示例 1：
    //输入：s = "abc", t = "ahbgdc"
    //输出：true
    //
    //示例 2：
    //输入：s = "axc", t = "ahbgdc"
    //输出：false

    // !!!!  自己写的  内存耗费较多
   /* public boolean isSubsequence(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        if (null == s || null == t || "".equals(t)) {
            return false;
        }
        int j = t.indexOf(s.charAt(0));
        if (j < 0) {
            return false;
        }
        int k = 1;
        int pre = 0;
        String index = t;
        for (int i = 1; i < s.length(); i++) {
            int l = index.indexOf(s.charAt(i)) ;
            index = index.substring(l + 1);
            int temp = pre;
            pre += l + 1;
            l = l + temp;
            if (l > j) {
                k++;
                j = l;
            }
        }
        return k == s.length();
    }*/

    // !!! 题解 双指针还是优秀啊
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

}
