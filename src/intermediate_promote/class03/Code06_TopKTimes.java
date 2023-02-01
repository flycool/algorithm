package intermediate_promote.class03;

import java.util.HashMap;

/**
 * 1)给定一个字符串类型的数组arr，求其中出现次数最多的前k个
 * 2)动态的增加字符串，求其中出现次数最多的前k个
 */
public class Code06_TopKTimes {

    private static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public static class TopKRecord {
        private Node[] heap;
        private int heapSize;
        private HashMap<String, Node> strNodeMap;
        private HashMap<Node, Integer> nodeIndexMap;

        public TopKRecord(int k) {
            this.heap = new Node[k];
            this.heapSize = 0;
            this.strNodeMap = new HashMap<>();
            this.nodeIndexMap = new HashMap<>();
        }

        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if (preIndex == -1) {
                if (heapSize == heap.length) {
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, heapSize);
                    }
                } else {
                    nodeIndexMap.put(curNode, heapSize);
                    heap[heapSize] = curNode;
                    heapInsert(heapSize++);
                }
            } else {
                heapify(preIndex, heapSize);
            }
        }

        private void heapify(int index, int heapSize) {
            int l = index * 2 + 1;
            int r = index * 2 + 2;
            int smallest = index;
            while (l < heapSize) {
                if (heap[l].times < heap[index].times) {
                    smallest = l;
                }
                if (r < heapSize && heap[r].times < heap[index].times) {
                    smallest = r;
                }
                if (smallest != index) {
                    swap(smallest, index);
                } else {
                    break;
                }
                index = smallest;
                l = index * 2 + 1;
                r = index * 2 + 2;
            }
        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parentIndex = (index - 1) / 2;
                if (heap[index].times < heap[parentIndex].times) {
                    swap(parentIndex, index);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        private void swap(int index1, int index2) {
            nodeIndexMap.put(heap[index1], index2);
            nodeIndexMap.put(heap[index2], index1);
            Node temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }

        public void printTopK() {
            System.out.println("Top: ");
            for (int i = 0; i < heapSize; i++) {
                if (heap[i] != null) {
                    System.out.print("Str: " + heap[i].str);
                    System.out.println(" Times: " + heap[i].times);
                }
            }
        }
    }

    public static void main(String[] args) {
        TopKRecord topKRecord = new TopKRecord(3);
        topKRecord.add("abc");
        topKRecord.add("abc");
        topKRecord.add("abc");
        topKRecord.add("d");
        topKRecord.add("d");
        topKRecord.add("d");
        topKRecord.add("b");
        topKRecord.add("b");
        topKRecord.add("a");
        topKRecord.printTopK();
    }

}
