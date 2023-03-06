public class PrizeWinnerStore extends ReadingListItemStore{
  //Constructor graveyard
  public PrizeWinnerStore(){ super();}
  public PrizeWinnerStore(String fileName, int num){ super(fileName, num);}

  //Inherited from ReaedingListItemStore
  public boolean containsKey(String key){ return super.containsKey(key);}
  public void put(String key, String item){ super.put(key, item);}

  @Override
  //Adds "(prize-winner)" segment to end of return
  public String getRandomItem(String key){ return super.getRandomItem(key) + " (prize-winner)";}
}
