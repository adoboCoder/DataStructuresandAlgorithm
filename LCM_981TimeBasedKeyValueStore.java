import java.util.*;

class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treemap = map.get(key);
        if (treemap == null)
            return "";

        Integer floor = treemap.floorKey(timestamp);
        if (floor == null)
            return "";
        return treemap.get(floor);
    }
}