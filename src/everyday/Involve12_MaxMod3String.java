package everyday;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 12. 去哪儿网
 * 给定一个arr，里面的数字都是0~9
 * 你可以随意使用arr中的数字，哪怕打乱顺序也行
 * 请拼出一个能被3整除的，最大的数字，用str形式返回
 * <p>
 * 贪心 解：
 * 1. sum % 3 ==0 从大到小排序 连起来
 * 2. sum % 3 ==1
 * 2.1 arr[i]%3==1 从中去掉最小的，从大到小排序
 * 2.2 arr[i]%3==2 从中去掉两个最小的，从大到小排序
 * <p>
 * 3. sum % 3 == 2
 * 3.1 arr[i]%3==2 从中去掉最小的，从大到小排序
 * 3.2 arr[i]%3==1 从中去掉两个最小的，从大到小排序
 */
public class Involve12_MaxMod3String {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 0, 3, 6, 8, 6, 9};
        String s = maxMod3String(arr);
        System.out.println(s);
    }

    public static String maxMod3String(int[] A) {
        if (A == null || A.length == 0) {
            return "";
        }
        int mod = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : A) {
            arr.add(num);
            mod += num;
            mod %= 3;
        }
        System.out.println("mod: " + mod);
        if ((mod == 1 || mod == 2) && !remove(arr, mod, 3 - mod)) {
            return "";
        }
        if (arr.isEmpty()) {
            return "";
        }
        arr.sort((a, b) -> b - a);//大到小排序
        if (arr.get(0) == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static boolean remove(ArrayList<Integer> arr, int mod, int i) {
        arr.sort((a, b) -> a - b);
        ArrayList<Integer> mod3Array1 = new ArrayList<>();
        ArrayList<Integer> mod3Array2 = new ArrayList<>();
        for (int num : arr) {
            if (num % 3 == 1) {
                mod3Array1.add(num);
            } else if (num % 3 == 2) {
                mod3Array2.add(num);
            }
        }
        if (mod == 1) {
            if (!mod3Array1.isEmpty()) {
                int delNum = mod3Array1.get(0);
                arr.remove((Integer) delNum);
                return true;
            }
            if (!mod3Array2.isEmpty()) {
                int delNum1 = mod3Array2.get(0);
                int delNum2 = mod3Array2.get(1);
                arr.remove((Integer) delNum1);
                arr.remove((Integer) delNum2);
                return true;
            }
        }
        if (mod == 2) {
            if (!mod3Array2.isEmpty()) {
                int delNum = mod3Array2.get(0);
                arr.remove((Integer) delNum);
                return true;
            }
            if (!mod3Array1.isEmpty()) {
                int delNum1 = mod3Array1.get(0);
                int delNum2 = mod3Array1.get(1);
                arr.remove((Integer) delNum1);
                arr.remove((Integer) delNum2);
                return true;
            }
        }
        return false;
    }
}
