package leasure;

import java.util.*;

/**
 * Created by chenteng on 2017/3/9.
 */

public class Test {
    public static void main(String[] args){
        Collection s = Arrays.asList("1","2");
        String s1 ="1";
        System.out.println(s1.hashCode());
        int h;
        System.out.println(Integer.MAX_VALUE);
        System.out.println((h=s1.hashCode())^h>>>16);
        List linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add(0,"3");
        System.out.println(linkedList.toString());
        List list = new ArrayList();
        list.iterator();
        list.add("1");
        list.get(0);
        list.clear();
        System.out.println(list.size());
        Map map = new HashMap();
        map.put("1","1");

        Map map2 = new IdentityHashMap();
        map2.put("1",23);
    }
}
