import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    //题目描述：某街道两旁分别种植一排树木，编号如下：
    //
    //1  3 5 7 9 11 13 15 17 。。。。 99
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
    //8 47  （8为起始位置 47为连续树木）
    public static void main(String[] args) {
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
            System.out.printf("(%d,%d)",beginA,targetA);
        } else {
            System.out.printf("(%d,%d)",beginB,targetB);

        }
    }

}
