public class BookStore extends ReadingListItemStore{
  public BookStore(){ super();}
  public BookStore(String fileName, int num){ super(fileName, num);}

  public boolean containsKey(String key){
    return super.containsKey(key);
  }

  public void put(String key, String item){
    super.put(key, item);
  }

  @Override
  public String getRandomItem(String key){
    if(super.containsKey(key)){
      String title = super.getRandomItem(key);
      int pYear = Integer.parseInt(title.substring(title.length()-4, title.length()));
      if(pYear >= 1990){
        return title + " (contemporary)";
      } else if (pYear >= 1900) {
        return title + " (modern)";
      } else {
        return title + " (classic)";
      }
    } else {
      return null;
    }
  }
}
