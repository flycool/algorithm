package jadvance.class02;

import java.util.*;

public class Code03_BuildingOutline {

    //描述高度变化的对象
    public static class Node {
        public int x;//x轴上的值
        public boolean isAdd;//true为加入，false为删除
        public int h;

        public Node(int x, boolean isAdd, int h) {
            this.x = x;
            this.isAdd = isAdd;
            this.h = h;
        }
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            if (o1.isAdd != o2.isAdd) {//加在删除的前面
                return o1.isAdd ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] matrix) {
        Node[] nodes = new Node[matrix.length * 2];
        for (int i = 0; i < matrix.length; i++) {
            nodes[i * 2] = new Node(matrix[i][0], true, matrix[i][2]);
            nodes[i * 2 + 1] = new Node(matrix[i][1], false, matrix[i][2]);
        }
        Arrays.sort(nodes, new NodeComparator());
        //有序表，TreeMap 在java中是红黑树实现
        TreeMap<Integer, Integer> mapHeightTimes = new TreeMap<>();
        TreeMap<Integer, Integer> mapXHeight = new TreeMap<>();

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isAdd) {
                if (!mapHeightTimes.containsKey(nodes[i].h)) {
                    mapHeightTimes.put(nodes[i].h, 1);
                } else {
                    mapHeightTimes.put(nodes[i].h, mapHeightTimes.get(nodes[i].h) + 1);
                }
            } else {
                if (mapHeightTimes.get(nodes[i].h) == 1) {
                    mapHeightTimes.remove(nodes[i].h);
                } else {
                    mapHeightTimes.put(nodes[i].h, mapHeightTimes.get(nodes[i].h) - 1);
                }
            }
            if (mapHeightTimes.isEmpty()) {
                mapXHeight.put(nodes[i].x, 0);//没有，高度为0
            } else {
                //最大高度给x
                mapXHeight.put(nodes[i].x, mapHeightTimes.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int preHeight = 0;
        for (Map.Entry<Integer, Integer> entry : mapXHeight.entrySet()) {
            int curx = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (preHeight != curMaxHeight) {
                if (preHeight != 0) {
                    res.add(new ArrayList<>(Arrays.asList(start, curx, curMaxHeight)));
                }
                start = curx;
                preHeight = curMaxHeight;
            }
        }
        return res;
    }
}
