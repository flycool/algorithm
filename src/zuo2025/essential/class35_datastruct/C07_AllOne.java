package zuo2025.essential.class35_datastruct;

import java.util.HashMap;
import java.util.HashSet;

public class C07_AllOne {

    // 7. 全O(1)的数据结构
    // 利用双向链表
    // https://leetcode.com/problems/all-oone-data-structure/
    static class AllOne {

        private static class Bucket {
            private HashSet<String> set;
            private int cnt;
            private Bucket last;
            private Bucket next;

            public Bucket(String s, int c) {
                set = new HashSet<>();
                set.add(s);
                cnt = c;
            }
        }

        private void insert(Bucket cur, Bucket pos) {
            cur.next.last = pos;
            pos.next = cur.next;
            cur.next = pos;
            pos.last = cur;
        }

        private void remove(Bucket cur) {
            cur.last.next = cur.next;
            cur.next.last = cur.last;
        }

        private Bucket head;
        private Bucket tail;
        private HashMap<String, Bucket> map;

        public AllOne() {
            head = new Bucket("", 0);
            tail = new Bucket("", Integer.MAX_VALUE);
            head.next = tail;
            tail.last = head;
            map = new HashMap<>();
        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                if (head.next.cnt == 1) { // has bucket
                    map.put(key, head.next);
                    head.next.set.add(key);
                } else {
                    Bucket bucket = new Bucket(key, 1);
                    map.put(key, bucket);
                    insert(head, bucket);
                }
            } else {
                Bucket bucket = map.get(key);
                if (bucket.next.cnt == bucket.cnt + 1) {
                    map.put(key, bucket.next);
                    bucket.next.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt + 1);
                    map.put(key, newBucket);
                    insert(bucket, newBucket);
                }
                bucket.set.remove(key);
                if (bucket.set.isEmpty()) {
                    remove(bucket);
                }
            }
        }

        public void dec(String key) {
            Bucket bucket = map.get(key);
            if (bucket.cnt == 1) {
                map.remove(key);
            } else {
                if (bucket.last.cnt == bucket.cnt - 1) {
                    map.put(key, bucket.last);
                    bucket.last.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt - 1);
                    map.put(key, newBucket);
                    insert(bucket.last, newBucket);
                }
            }
            bucket.set.remove(key);
            if (bucket.set.isEmpty()) {
                remove(bucket);
            }
        }

        public String getMaxKey() {
            return tail.last.set.iterator().next();
        }

        public String getMinKey() {
            return head.next.set.iterator().next();
        }

    }
}























