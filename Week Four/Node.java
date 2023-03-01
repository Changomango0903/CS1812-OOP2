public class Node<K, V>{
  K key;
  V value;
  Node<K, V> next;
  public Node(K key, V value){
    this.key = key;
    this.value = value;
  }
  public Node(K key, V value, Node<K, V> next){
    this.key = key;
    this.value= value;
    this.next = next;
  }

  public K getKey(){return this.key;}
  public V getValue(){return this.value;}
  public Node<K, V> getNext(){return this.next;}

  public void setKey(K key){this.key = key;}
  public void setValue(V value){this.value = value;}
  public void setNext(Node<K, V> next){this.next = next;}

  public boolean containsKey(K key, Node<K, V> node){
    if(key == node.getKey()){
      return true;
    } else if(node.getNext() == null){
      return false;
    } else {
      return containsKey(key, node.getNext());
    }
  }

  public boolean containsValue(V value, Node<K, V> node){
      if(value == node.getValue()){
        return true;
      } else if(node.getNext() == null){
        return false;
      } else {
        return containsValue(value, node.getNext());
      }
    }


}
