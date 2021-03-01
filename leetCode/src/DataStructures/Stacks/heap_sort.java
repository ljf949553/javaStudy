package DataStructures.Stacks;


//基本思路总结  : 
//
//　　a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
//
//　　b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
//
//　　c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
//
//代码实现


public class heap_sort {
    public void sort(int[] arr) {
        int length = arr.length;

        // Build heap (rearrange array)
        // a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
        // (数组长度 / 2) - 1 最后一个非叶子节点
        // 从最后一个非叶子节点向前遍历
        for (int curRoot = length / 2 - 1; curRoot >= 0; curRoot--) {
            // 每走过一个非叶子节点 将3个节点中最大值换至根节点
            // 此方法内存在递归 , 因为当发生替换时 , 子树的根节点无法保证最大 , 重新替换 .
            heapify(arr, length, curRoot);
        }

        // One by one extract an element from heap
        for (int i = length - 1; i >= 0; i--) {
            // Move current root to end
            // b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            // c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node index which is
    // an index in arr[]. operateLength is size of heap
    // arr : 需要排序的数组   operateLength : 数组长度  index : 非叶子节点的下标
    void heapify(int[] arr, int operateLength, int index) {
        int largest = index;  // Initialize largest as root
        int l = 2 * index + 1;  // left = 2*index + 1
        int r = 2 * index + 2;  // right = 2*index + 2

        // If left child is larger than root
        if (l < operateLength && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < operateLength && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != index) {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, operateLength, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7, 14, 2, 8};
        int n = arr.length;

        heap_sort ob = new heap_sort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
