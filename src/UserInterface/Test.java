/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Virajee
 */
public class Test {
    public static void main(String[] args){
//      String name="Virajee Hiranthika Kumaree";
//      System.out.println(name.split(" ")[1]);
        
        int num1=15;
        int num2=1548;
        double d=((double)num1/(double)num2)*100;
        DecimalFormat format=new DecimalFormat("#.00");
        double e=Double.parseDouble(format.format(d));
        System.out.println(e);
        
        Map grades=new HashMap();
        grades.put(1,12);
        grades.put(2,50);
        grades.put(5,32);
        grades.put(4,95);
        grades.put(3,49);
        grades.put(6,50);
        
        Map<Integer, String> map = sortByValues((HashMap) grades); 
      System.out.println("After Sorting:");
      Set set2 = map.entrySet();
      Iterator iterator2 = set2.iterator();
      int i=0;
      while(iterator2.hasNext()) {
           Map.Entry me2 = (Map.Entry)iterator2.next();
           i++;
           if(i==map.size()){
               System.out.println(me2.getKey()+":"+me2.getValue());
           }
           //System.out.print(me2.getKey() + ": ");
           //System.out.println(me2.getValue());
      }
      System.out.println();
      System.out.println("Size of the Map:"+grades.size());
    }
    
   private static HashMap sortByValues(HashMap map) { 
       List list = new LinkedList(map.entrySet());
       // Defined Custom Comparator here
       Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o1)).getValue())
                  .compareTo(((Map.Entry) (o2)).getValue());
            }
       });

       // Here I am copying the sorted list in HashMap
       // using LinkedHashMap to preserve the insertion order
       HashMap sortedHashMap = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
       } 
       return sortedHashMap;
  }
}
