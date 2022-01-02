import java.util.*;

class SnapshotArray {
    private List<Map<Integer, Integer>> snapshot;
    private Map<Integer, Integer> diff;

    public void snapshotArray(int length) {
        snapshot = new ArrayList<>(length);
        diff = new HashMap<>(length);
    }

    public void set(int index, int val) {
        diff.put(index, val);
    }

    public int snap() {
        snapshot.add(diff);
        diff = new HashMap<>();
        return snapshot.size() - 1;
    }

    public int get(int index, int snap_id) {

        for(int i = snap_id; i >= 0; i--) {
            if(snapshot.get(i).containsKey(index)) {
                return snapshot.get(i).get(index);
            }
        }
        return 0;
    }
}