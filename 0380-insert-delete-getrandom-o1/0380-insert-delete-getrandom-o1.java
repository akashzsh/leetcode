import java.util.Random;

class RandomizedSet {
    ArrayList<Integer> vec;
    HashMap<Integer, Integer> map;
    Random rand;
    
    public RandomizedSet() {
        vec = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean check = map.containsKey(val);
        if (check) return false;
        map.put(val, vec.size());
        vec.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        boolean check = map.containsKey(val);
        if (check == false) return false;
        
        int pos = map.get(val);
        if (pos < vec.size() - 1) {
            int lastEl = vec.get(vec.size() - 1);
            vec.set(pos, lastEl);
            map.put(lastEl, pos);
        }
        vec.remove(vec.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return vec.get(rand.nextInt(vec.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */