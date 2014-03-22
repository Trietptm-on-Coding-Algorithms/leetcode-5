class LRUCache {
    class Node {
        int key, val;
        Node next, pre;
        Node(int k, int v) {
            key = k;
            val = v;
            pre = next = null;
        }
    }
    int capacity = 0;
    int size = 0;
    Node lru = null;    
    Node head = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //System.out.println("get("+key+")");
        Node node = head;
        while(node!=null) {
            if(node.key==key) {
                // node becomes head    
                head.pre = node;
                node.pre.next = node.next;
                node.next = (node==head ? null : head);                
                head = node;
                if(lru==head) lru = lru.pre;
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        //System.out.println("set("+key+","+value+")");
        if(capacity<=0)
            return;
        Node node = head;
        while(node!=null) {
            if(node.key==key) {
                // node becomes head                
                head.pre = node;
                node.pre.next = node.next;
                node.next = (node==head ? null : head);                
                node.val = value;                
                head = node;
                if(lru==head) lru = lru.pre;
                return;
            }
            node = node.next;
        }
        node = new Node(key,value);
        
        if(head==null || capacity==1) {
            // set head with a self-loop            
            node.pre = node;
            head = lru = node;
            size = 1;            
        }else {            
            if(size>=capacity) {
                lru.pre.next = null;
                lru = lru.pre;
            }else
                size++;
            // new node becomes head
            node.next = head;                
            head.pre = node;            
            head = node;
        }
    }
}