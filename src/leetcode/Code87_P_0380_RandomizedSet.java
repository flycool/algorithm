package leetcode;

import java.util.HashMap;

//insert remove getRandom
// O(1)
public class Code87_P_0380_RandomizedSet {

    public class RandomizedSet {
        private HashMap<Integer, Integer> keyIndexMap;
        private HashMap<Integer, Integer> indexKeyMap;
        private int size;
        public RandomizedSet() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            size = 0;
        }

        public boolean insert(int val) {
            if (!keyIndexMap.containsKey(val)) {
                keyIndexMap.put(val, size);
                indexKeyMap.put(size++, val);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (keyIndexMap.containsKey(val)) {
                int deleteIndex = keyIndexMap.get(val);
                int lastIndex = --size;
                int lastKey = indexKeyMap.get(lastIndex);
                //把最后的那条数据，填到删除的位置上
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(val);
                indexKeyMap.remove(deleteIndex);
                return true;
            }
            return false;
        }

        public int getRandom() {
            if (size == 0) {
                return -1;
            }
            int randomIndex = (int) (Math.random() * size);
            return indexKeyMap.get(randomIndex);
        }
    }
}
