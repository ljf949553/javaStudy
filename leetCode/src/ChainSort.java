public class ChainSort {

    //节点类
    static class Node {
        int value;
        Node next = null;

        public Node(int value) {
            this.value = value;
        }
    }

    //冒泡排序
    public void bubbleSort(Node start) {
        if (start.next == null) {
            return;
        }
        if (start.next.next == null) {
            if (start.value > start.next.value) {
                int temp = 0;
                temp = start.value;
                start.value = start.next.value;
                start.next.value = temp;
            }
            return;
        }
        Node slow = start;
        Node fast = start;

        while (slow.next != null) {
            while (fast.next != null) {
                Node f = fast.next;
                int temp = 0;
                if (slow.value > f.value) {
                    temp = slow.value;
                    slow.value = f.value;
                    f.value = temp;
                }
                fast = fast.next;
            }
            slow = slow.next;
            fast = slow.next;
        }
    }

    //快排
    public void quickSort(Node head, Node end) {
        Node slow = null;
        Node fast;
        if (head != end) {
            slow = head;
            fast = head.next;
            while (fast != end) {
                if (fast.value < head.value) {
                    slow = slow.next;

                    int temp = slow.value;
                    slow.value = fast.value;
                    fast.value = temp;
                }
                fast = fast.next;
            }
            if (slow != head) {
                int temp = slow.value;
                slow.value = head.value;
                head.value = temp;
            }
            quickSort(head, slow);
            quickSort(slow.next, end);
        }
    }

    //打印链表
    public void print(Node start) {
        while (start.next != null) {
            System.out.print(start.value + ",");
            start = start.next;
        }
        System.out.println(start.value);
    }

    //测试main()
    public static void main(String[] args) {
        ChainSort chainSort = new ChainSort();
        int[] array = {0, 3, 2, 8, 6, 9, 7, 5, 1, 4};
        Node start = new Node(array[0]);
        Node temp = start;

        for (int i = 1; i < array.length; i++) {
            temp.next = new Node(array[i]);
            temp = temp.next;
        }
        chainSort.print(start);
        chainSort.bubbleSort(start);
       // chainSort.quickSort(start, null);
        chainSort.print(start);
    }
}
