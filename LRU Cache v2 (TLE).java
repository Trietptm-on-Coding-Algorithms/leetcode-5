class LRUCache {
    int capacity = 0;
    LinkedList<Integer> list;
    HashMap<Integer,Integer> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Integer val = map.get(key);
        if(val!=null) {
            list.remove(list.indexOf(key));
            list.addFirst(key);
            return val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(capacity<=0) return;
        Integer val = get(key);
        if(val>=0) {
            map.put(key, value);
        }else{
            if(map.size()>=capacity)
            {
                Integer lru_key = list.removeLast();
                map.remove(lru_key);
            }
            map.put(key, value);
            list.addFirst(key);
        }
    }
}