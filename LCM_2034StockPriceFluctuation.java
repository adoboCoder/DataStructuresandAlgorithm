import java.util.*;

class StockPrice {
    private TreeMap<Integer, Integer> tm = new TreeMap<>();
    private TreeMap<Integer, Set<Integer>> valueTimeStamp = new TreeMap<>();
    
    public StockPrice() {
        tm = new TreeMap<>();
        valueTimeStamp = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(tm.containsKey(timestamp)) {
            int oldPrice = tm.get(timestamp);
            valueTimeStamp.get(oldPrice).remove(timestamp);
            if(valueTimeStamp.get(oldPrice).size() == 0) {
                valueTimeStamp.remove(oldPrice);
            }
        }
        tm.put(timestamp, price);
        valueTimeStamp.putIfAbsent(price, new HashSet<>());
        valueTimeStamp.get(price).add(timestamp);
    }
    
    public int current() { // get current price
        return tm.get(tm.lastKey());
    }
    
    public int maximum() { // get High
        return valueTimeStamp.lastKey();
    }
    
    public int minimum() { //get Low
        return valueTimeStamp.firstKey();
    }
}
