import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class PetSuggester{
  public static Scanner scanner = new Scanner(System.in);
  //Function: Ask question
  //Returns: boolean
  public static boolean askYesNo(String question){
    System.out.println(question + " [y/n]");
    String answer = scanner.nextLine();
    if(answer.toUpperCase().equals("Y")){
      return true;
    }
    return false;
  }

  //Function: Preorder Tree Traversal
  //Returns: String
  public static String preOrderWrite(TreeNode tNode){
    String preOrderTree = "";
    preOrderTree += tNode.getValue();
    if(tNode.isLeaf()){
      return preOrderTree;
    } else {
      preOrderTree += "\n" + preOrderWrite(tNode.getLeft()) + "\n" + preOrderWrite(tNode.getRight());
    }
    return preOrderTree;
  }

  //Function: Construct Tree in preorder
  //Returns: head of Tree
  public static TreeNode preOrderRead(BufferedReader bf){
    try{
      String payload = bf.readLine();
      if(payload.indexOf('?') == -1){
        return new TreeNode(payload);
      } else {
        return new TreeNode(payload, preOrderRead(bf), preOrderRead(bf));
      }
    }catch(IOException e){
      System.out.println("Something went wrong :(");
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    //Default Tree Creation
    TreeNode defaultTree = new TreeNode("Do you like dogs?", new TreeNode("Do you prefer big dogs?", new TreeNode("a golden retriever"), new TreeNode("a chihuahua")), new TreeNode("an iguana"));
    //Current Cursor Initiation
    TreeNode currentTree = defaultTree;
    //Check for Game State
    boolean gameState = true;
    System.out.println("Welcome to this ultra fun questionnaire!");
    //Read from existing files
    try(BufferedReader bf = new BufferedReader(new FileReader("suggestions.txt"))){
      defaultTree = preOrderRead(bf);
      currentTree = defaultTree;
    } catch(IOException e){
      //If file cannot be found, don't do anything
    }
    do{
      //Standard Question Flow
      if(askYesNo(currentTree.getValue())){
        currentTree = currentTree.getLeft();
      } else {
        currentTree = currentTree.getRight();
      }
      if(currentTree.isLeaf()){ //Check for end of tree
        System.out.println(currentTree.getValue());
        if(!askYesNo("Are you satisfied with your answer?")){ //Add question
        //Add Question flow
          System.out.println("Enter name of preferred pet: ");
          String newEntry = scanner.nextLine();
          System.out.println("Enter question that is true for pet: ");
          String newQuestion = scanner.nextLine();
          currentTree.setLeft(new TreeNode(newEntry));
          currentTree.setRight(new TreeNode(currentTree.getValue()));
          currentTree.setValue(newQuestion);
        }
        //Restart Questionaire
        if(askYesNo("Would you like to play again?")){
          gameState = true;
          currentTree = defaultTree;
          continue;
        } else {
        gameState = false; //End Game Flow
        //Tree Saving Flow
          if(askYesNo("Do you want to save the current tree?")){
            try(BufferedWriter bf = new BufferedWriter(new FileWriter("suggestions.txt"))){
              String savedTree = preOrderWrite(defaultTree);
              bf.write(savedTree);
            }catch(IOException e){
              System.out.println("Uh oh, oopsie, you done messed up hah");
              e.printStackTrace();
            }
          }
        }
      }
    } while (gameState);
  }
}
