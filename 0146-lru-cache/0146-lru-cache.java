class LRUCache {

  class Node {
    Node next;
    Node prev;
    int key;
    int value;

    Node() {
    }

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  int capacity;
  Node head;
  Node tail;

  Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node();
    tail = new Node();
    map = new HashMap<>();

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    Node node = map.get(key);
    removeNode(node);
    addToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      removeNode(node);
      addToHead(node);
      return;
    }

    if (capacity == map.size()) {
      Node node = tail.prev;
      map.remove(node.key);
      removeNode(node);
    }

    Node node = new Node(key, value);
    map.put(key, node);
    addToHead(node);
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void addToHead(Node node) {
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
    head.next = node;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */