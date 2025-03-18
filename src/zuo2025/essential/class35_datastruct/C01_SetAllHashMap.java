package zuo2025.essential.class35_datastruct;

import java.util.HashMap;

//1. setAll 功能的哈希表
public class C01_SetAllHashMap {

    private final HashMap<Integer, int[]> map = new HashMap<>();
    private int setAllTime = -1;
    private int setAllValue;
    private int cnt;

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            int[] v = map.get(key);
            v[0] = value;
            v[1] = cnt++;
        } else {
            map.put(key, new int[]{value, cnt++});
        }
    }

    public void setAll(int allValue) {
        setAllTime = cnt++;
        setAllValue = allValue;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int[] value = map.get(key);
        if (value[1] > setAllTime) {
            return value[0];
        } else {
            return setAllValue;
        }
    }
}
