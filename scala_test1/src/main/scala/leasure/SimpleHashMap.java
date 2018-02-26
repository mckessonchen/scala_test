package leasure;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by chenteng on 2017/3/10.
 * 只是一个简单的hashMap 实现
 */

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    LinkedList<SimpleEntry<K,V>>[] buckets = new LinkedList[DEFAULT_SIZE];

    static int DEFAULT_SIZE = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static int size;

    static int threshold;

    SimpleHashMap(){
        this.threshold = Math.round(DEFAULT_SIZE*DEFAULT_LOAD_FACTOR);
    }
    SimpleHashMap(int size){
        this.DEFAULT_SIZE = size;
        this.threshold = Math.round(DEFAULT_SIZE*DEFAULT_LOAD_FACTOR);
    }

    @Override
    public V get(Object key) {
        int index = h(key);
        if (buckets[index]==null) return null;
        LinkedList<SimpleEntry<K, V>> bucket = buckets[index];
        for (SimpleEntry<K,V> pair:bucket){
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = h(key);
        boolean found = false;
        if (buckets[index]==null)
            buckets[index] = new LinkedList<>();
        LinkedList<SimpleEntry<K,V>> bucket = buckets[index];
        for (Entry<K,V> pair:bucket){
            if (pair.getKey().equals(key)) {
                oldValue = pair.getValue();
                found = true;
                pair.setValue(value);
                break;
            }
        }
        if (!found)
            buckets[index].add(0,new SimpleEntry<K, V>(key,value));
        if (++size>threshold)
            resize();
        return oldValue;
    }

    private int h(Object key) {
        return Math.abs(key.hashCode()) % DEFAULT_SIZE;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>>set =new HashSet<>();
        for (LinkedList<SimpleEntry<K,V>> bucket :buckets){
            if (bucket==null) continue;
            for (SimpleEntry<K,V> pair:bucket)
                set.add(new SimpleEntry<K, V>(pair.getKey(),pair.getValue()));
        }
        return set;
    }

    private void resize(){
        Set<Entry<K,V>> oldSet = this.entrySet();
        boolean flag = true;
        int begin = oldSet.size()*2;
        int newSize = begin;
        while (flag){
            ++begin;
            for (int i = 2;i<begin;i++){
                if (begin%i!=0){
                    flag = false;
                    newSize = begin;
                    break;
                }
            }
        }
        SimpleHashMap<K,V> newMap = new SimpleHashMap<K, V>(newSize);
        for (Entry<K,V> pair:oldSet){
            newMap.put(pair.getKey(),pair.getValue());
        }

    }
}
