package interview2022;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 63 超级水王问题和摩尔投票及其扩张
 * 数组中的某个数出现的次数，大于长度的一半，叫水王数（贴子里灌水）
 *
 * 一次删除两个不同的数，有水王的话，会剩下来
 * 没有的话，就没有
 */
public class Code63_FindKMajority {

    public int findMajority(int[] arr) {
        int cand = 0;
        int hp = 0;
        //删除两个不同的数
        for (int i = 0; i < arr.length; i++) {
            if (hp == 0) {
                cand = arr[i];
                hp = 1;
            } else if (cand == arr[i]) {
                hp++;
            } else {
                hp--;
            }
        }
        if (hp == 0) {
            return -1;
        }
        hp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand) {
                hp++;
            }
        }
        if (hp > arr.length / 2) {
            return cand;
        } else {
            return -1;
        }
    }

    //扩张
    public void printKMajor(int[] arr, int k) {
        if (k < 2) {
            return;
        }
        // >n/k 次的数字，最多有k-1个
        HashMap<Integer, Integer> candMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (candMap.containsKey(arr[i])) {
                candMap.put(arr[i], candMap.get(arr[i]) + 1);
            } else {
                if (candMap.size() == k - 1) {//当前数不要，且每个候选付出1点血量，血量为0时，删除
                    allCandsMinusOne(candMap);
                } else {
                    candMap.put(arr[i], 1);
                }
            }
        }
        // 统计candMap里的数出现的真实次数， 当 > n/k 时，打印结果
    }

    private void allCandsMinusOne(HashMap<Integer, Integer> map) {
        LinkedList<Integer> removeList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            Integer key = set.getKey();
            Integer value = set.getValue();
            if (value == 1) {
                removeList.add(key);
            }
            map.put(key, value - 1);
        }
        for (Integer k : removeList) {
            map.remove(k);
        }
    }
}
