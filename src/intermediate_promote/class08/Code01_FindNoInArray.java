package intermediate_promote.class08;

public class Code01_FindNoInArray {

    //整数数组A，长度为n， 有 1 <= A[i] <= n，其中部分整数会重复出现，部分不会。
    //求找到其中未出现的整数。要求时间复杂度O(n)，空间复杂度O(1)
    public static void findNoInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int value : arr) {//要i的位置上放的是i+1
            modify(value, arr);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                System.out.println(i + 1);
            }
        }
    }

    private static void modify(int value, int[] arr) {
        while (arr[value - 1] != value) {
            int tmp = arr[value - 1];
            arr[value - 1] = value;
            value = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 3, 5, 4};
        findNoInArray(arr);
    }

}
