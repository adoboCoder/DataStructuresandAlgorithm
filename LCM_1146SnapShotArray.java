import java.util.*;

class SnapshotArray {
    private List<Map<Integer, Integer>> shot;
    private Map<Integer, Integer> diff;

    public snapshotArray(int length) {
        shot = new ArrayList<>(length);
        diff = new HashMap<>(length);
    }

    public void set(int index, int val) {
        diff.put(index, val);
    }

    public int snap() {
        shot.add(diff);
        diff = new HashMap<>();
        return shot.size() - 1;
    }

    public int get(int index, int snap_id) {

        for(int = snap_id; i >= 0; i--) {
            if(shot.get(i).containsKey(index)) {
                return shot.get(i).get(index);
            }
        }
        return 0;
    }
}