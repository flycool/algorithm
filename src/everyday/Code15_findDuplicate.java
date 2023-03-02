package everyday;

/**
 * 15 阿里
 * 1，2，3...n-1，n，n，n+1，n+2...
 * 在这个序列中，只有一个数字有重复（n）
 * 这个序列是有序的，找到重复数字n （二分）
 * 这个序列是无序的，找到重复数字n
 * （数组下标来回跳，单链表入环，双指针）
 */
public class Code15_findDuplicate {

    //arr无序时
    public int findDuplicate(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int slow = arr[0];//跳1步
        int fast = arr[arr[0]];//跳2步
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
