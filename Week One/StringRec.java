class StringRec {

  static public void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please provide a command line argument");
      return;
    }
    String s = args[0];
    System.out.println(isLowerCase(s));
    System.out.println(removeUpper(s));
    System.out.println(toLowerCase(s));
    System.out.println(revRec(s));
  }

  static public boolean isLowerCase(String s) {
    if (s.isEmpty()) {
      // all the characters in the empty string are uppercase
      return true;
    } else {
      if (Character.isUpperCase(s.charAt(0))) {
        // first character is uppercase
        // therefore not all characters are lowercase
        return false;
      } else {
        // may still find uppercase characters in the rest of the string
        return isLowerCase(s.substring(1));
      }
    }
  }

  public static String removeUpper(String s){
    if(s.isEmpty()){
      return "";
    } else if(Character.isUpperCase(s.charAt(0))){
      return removeUpper(s.substring(1));
    } else {
      return s.substring(0, 1) + removeUpper(s.substring(1, s.length()));
    }
  }

  public static String toLowerCase(String s){
    if(s.isEmpty()){
      return "";
    } else if(Character.isUpperCase(s.charAt(0))){
      return s.substring(0, 1).toLowerCase() + toLowerCase(s.substring(1, s.length()));
    } else{
      return toLowerCase(s.substring(1));
    }
  }

  public static String revRec(String s){
    if(s.isEmpty()){
      return "";
    } else{
      return s.substring(s.length()-1, s.length()) + revRec(s.substring(0, s.length()-1));
    }
  }
}
