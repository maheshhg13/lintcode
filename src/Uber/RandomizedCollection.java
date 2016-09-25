package Uber;

import java.util.*;

public class RandomizedCollection {

    /** Initialize your data structure here. */
    Map<Integer, List<Integer>> map;
    List<Integer> lst;
    public RandomizedCollection() {
        map = new HashMap<Integer, List<Integer>>();
        lst = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = true;
        if(map.containsKey(val)){
            result = false;
        }else{
            map.put(val, new ArrayList<Integer>());
        }
        map.get(val).add(lst.size());
        lst.add(val);
        return result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        if(!map.get(val).contains(lst.size()-1)){
        	int temp = lst.get(lst.size()-1);
        	map.get(temp).remove(new Integer(lst.size()-1));
        	
        	int indx = map.get(val).get(0);
        	lst.set(indx, temp);
        	map.get(temp).add(indx);
        	map.get(val).add(lst.size()-1);
        }
        map.get(val).remove(new Integer(lst.size()-1));
        lst.remove(lst.size()-1);
        if(map.get(val).isEmpty()){
        	map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int indx = new Random().nextInt(lst.size()-1);
        return lst.get(indx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
