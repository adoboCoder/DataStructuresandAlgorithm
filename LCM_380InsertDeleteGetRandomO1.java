import java.util.*;

class RandomizedSet {
    private List<Integer> list;
    private HashMap<Integer, Integer> map;
    Random rand = new Random();
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    public boolean remove (int val) {
        if(!map.containsKey(val)){
            return false;
        }
        if(map.get(val) < list.size() - 1){
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;

    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}