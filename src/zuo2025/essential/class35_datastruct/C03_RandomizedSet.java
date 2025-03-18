package zuo2025.essential.class35_datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class C03_RandomizedSet {

    // 3. 常数时间插入、删除和获取随机元素
    // https://leetcode.com/problems/insert-delete-getrandom-o1/
    static class RandomizedSet {
        private HashMap<Integer, Integer> map = new HashMap<>();
        private ArrayList<Integer> arr = new ArrayList<>();

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int valIndex = map.get(val);
            int endValue = arr.get(arr.size() - 1);
            map.put(endValue, valIndex);
            arr.set(valIndex, endValue);
            map.remove(val);
            arr.remove(arr.size() - 1);
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

    // 4. 插入，删除和获取随机元素O(1)时间且允许有重复数字的结构
    // https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
    static class RandomizedCollection {
        private HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        private ArrayList<Integer> arr = new ArrayList<>();

        public boolean insert(int val) {
            arr.add(val);
            HashSet<Integer> set = map.getOrDefault(val, new HashSet<>());
            set.add(arr.size() - 1);
            map.put(val, set);
            return set.size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            HashSet<Integer> valSet = map.get(val);
            int valAnyIndex = valSet.iterator().next();
            int endValue = arr.get(arr.size() - 1);
            if (val == endValue) {
                valSet.remove(arr.size() - 1);
            } else {
                HashSet<Integer> endValueSet = map.get(endValue);
                endValueSet.add(valAnyIndex);
                arr.set(valAnyIndex, endValue);
                endValueSet.remove(arr.size() - 1);
                valSet.remove(valAnyIndex);
            }
            arr.remove(arr.size() - 1);
            if (valSet.isEmpty()) {
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }
}
