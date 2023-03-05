public class PrizeWinnerStore extends ReadingListItemStore{
  //Constructor graveyard
  public PrizeWinnerStore(){ super();}
  public PrizeWinnerStore(String fileName, int num){ super(fileName, num);}

  public boolean containsKey(String key){
    return super.containsKey(key);
  }

  public void put(String key, String item){
    if(containsKey(key)){
      super.put(key, item);
    } else {
      super.put(key, item);
    }
  }
  @Override
  public String getRandomItem(String key){ return super.getRandomItem(key) + " (prize-winner)";}
}
