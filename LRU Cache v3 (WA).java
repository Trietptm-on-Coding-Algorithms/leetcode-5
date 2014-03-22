 public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoublyLinkedList();
        map = new HashMap<>(capacity);
    }
    
    Node _get(int key) {
        Node node = map.get(key);
        if(node!=null) {
            list.remove(node);
            list.addFirst(node);
            return node;
        }
        return null;
    }
    public int get(int key) {
        Node node = _get(key);
        if(node!=null)
            return node.val;       
        return -1;
    }
    
    public void set(int key, int value) {
        if (capacity<=0) return;
        Node node = _get(key);
        if (node!=null) {
            node.val = value;
            //map.put(key, value);
        }else{
           if (map.size()>=capacity)  {
                Node lru_node = list.removeLast();
                map.remove(lru_node.key);
           }            
           node = new Node(key, value);
           map.put(key, node);
           list.addFirst(node);
        }
    }
}

class Node {
    Node pre = null, next = null;
    int key, val;
    Node(int k, int v) { key = k; val = v; }
}

/**
 *  A linked list with constant-time operations
 * 
 * */
class DoublyLinkedList {
    Node head = null;
    Node tail = null;
    void addFirst(Node node) {
        if(head==null) {
            head = tail = node;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
    Node removeLast() {
        if(tail==null)
            return null;
        Node node = tail;
        tail = tail.pre;
        if(tail==null)
            head = null;
        else
            tail.next = null;
        return node;
    }
    void remove(Node node) {
        if(node.pre!=null)
            node.pre.next = node.next;
        if(node.next!=null)
            node.next.pre = node.pre;
        if(node==tail)
            tail = node.pre;
        if(node==head)
            head = node.next;
    }
}