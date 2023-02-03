public class TreeNode{
  private String value;
  private TreeNode leftNode, rightNode;

  public TreeNode(String value){this.value = value;}
  public TreeNode(String value, TreeNode leftNode, TreeNode rightNode){
    this.value = value;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  //Getters
  public String getValue(){return this.value;}
  public TreeNode getLeft(){return this.leftNode;}
  public TreeNode getRight(){return this.rightNode;}
  
  //Setters
  public void setValue(String value){this.value = value;}
  public void setLeft(TreeNode leftNode){this.leftNode = leftNode;}
  public void setRight(TreeNode rightNode){this.rightNode = rightNode;}

  //Function: Check if no left/right nodes
  //Returns: boolean
  public boolean isLeaf(){
    if(leftNode == null && rightNode == null){
      return true;
    }
    return false;
  }


}
