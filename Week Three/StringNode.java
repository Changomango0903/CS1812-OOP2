class StringNode {
  StringNode next;
  String payload;

  public StringNode(String payload) {
    this.payload = payload;
    next = null;
  }

  public int size(){
    if (next == null){
      return 1;
    } else {
      return 1 + next.size();
    }
  }
}
