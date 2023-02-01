package base.class01_sort;

public class Heap {

    //堆排序
    public static void heapSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //变成大根堆
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

        //变成大根堆
        for (int i = arr.length-1; i >=0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //heapInsert操作，某个数出现在index位置，往上继续移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //堆化操作，某个数出现在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左边孩子小标
        while (left < heapSize) {//下方有孩子时
            //获取两个孩子中较大那个的下标
            int largest = (left + 1) < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //获取父和较大孩子之间的那个下标
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            //往下移动
            index = largest;
            left = index * 2 + 1;
        }

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
