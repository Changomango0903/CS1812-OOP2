public class LinkedListMap<K, V>{
  private Node<K, V> first;
  public LinkedListMap(){
  }

  public void put(K key, V value){
    Node<K, V> cursor = first;
    if(first == null){
      this.first = new Node<K,V>(key, value);
    }else if(containsKey(key)){

      while(cursor != null){
        if(cursor.getKey() == key) {
          cursor.setValue(value);
          break;
        } else {
          cursor = cursor.getNext();
        }
      }
    } else {
      while(cursor.getNext() != null){
        cursor = cursor.getNext();
      }
      cursor.setNext(new Node<K, V>(key, value));
    }
  }

  public V get(K key){
    if(containsKey(key)){
      Node<K, V> cursor = first;
      while(cursor != null){
        if(cursor.getKey() == key) {
          return cursor.getValue();
        } else {
          cursor = cursor.getNext();
        }
      }
      return null;
    }
    return null;
  }

  public boolean containsKey(K key){
    return first.containsKey(key, this.first);
  }
  
  public boolean containsValue(V value){
    return first.containsValue(value, this.first); 
  }

  public String toString(){
    if(first == null){
      return null;
    } else {
      String result = "";
      Node<K, V> cursor = this.first;
      while(cursor != null){
        result += "<" + cursor.getKey() + ", " + cursor.getValue() + "> ";
        cursor = cursor.getNext();
      }
      return result;
    }
  }

}
