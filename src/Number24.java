import sun.misc.LRUCache;

import java.util.*;

/**
 * Created by byhieg on 2017/9/5.
 * Mail to byhieg@gmail.com
 */
public class Number24 {

    public static class LFUCache {
        List<Item> list;
        int size = 0;
        int capacity = 0;

        // @param capacity, an integer
        public LFUCache(int capacity) {
            // Write your code here
            this.capacity = capacity;
            list = new LinkedList<>();
        }

        // @param key, an integer
        // @param value, an integer
        // @return nothing
        public void set(int key, int value) {
            // Write your code here
            sortList();

            if (size <= capacity - 1) {
               addItem(key,value);
            } else {
                list.remove(0);
                size--;
                addItem(key,value);
            }
        }

        public int get(int key) {
            // Write your code here
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).hashMap.containsKey(key)) {
                    Item item = list.get(i);
                    item.freq++;
                    sortList(item);
                    return item.getValue(key);
                }
            }

            return -1;
        }

        void addItem(int key, int value){
            Item item = new Item();
            item.freq++;
            item.hashMap = new HashMap<>();
            item.hashMap.put(key, value);
            if (!isInList(item)) {
                list.add(0,item);
            }else{
                list.remove(item);
                list.add(0,item);
            }
            sortList();

            size++;
        }

        void sortList() {
            Collections.sort(list, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return o1.freq - o2.freq;
                }
            });
        }

        void sortList(Item item) {
            int index1 = list.indexOf(item);
            int index2 = 0;
            for (int i = list.size() - 1; i >= 0  ; i--) {
                if (list.get(i).freq == item.freq) {
                    index2 = i;
                    break;
                }
            }
            for (int i = index1 + 1; i <= index2 ; i++) {
                list.set(i - 1, list.get(i));
            }
            list.set(index2, item);
        }

        boolean isInList(Item item) {
            for (int i = 0; i < list.size() ; i++) {
                if (list.get(i).equals(item)) {
                    return true;
                }
            }
            return false;
        }

        class Item {
            HashMap<Integer, Integer> hashMap;
            int freq = 0;

            public Item() {
                hashMap = new HashMap<>();
                freq = 0;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof HashMap) {
                    HashMap<Integer, Integer> maps = (HashMap<Integer, Integer>) obj;
                    int key = maps.keySet().iterator().next();
                    int value = maps.get(key);
                    Set<Integer> keys = hashMap.keySet();
                    for (Integer tmpKey : keys) {
                        if (tmpKey == key) {
                            return true;
                        }
                    }

                    return false;
                } else
                    return obj instanceof Item && equals(((Item) obj).hashMap);

            }

            public int getValue(int key) {
                return hashMap.get(key);
            }

            public int getKey(){
                return hashMap.keySet().iterator().next();
            }
        }

    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(3);
        cache.set(1,10);
        cache.set(1,20);
        System.out.println(cache.get(1));

    }

}
