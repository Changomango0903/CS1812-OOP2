public enum Rank{
  UNIQUE, RARE, UNCOMMON, COMMON;
  public int rankInt(){ //Giving value to each enum value
    switch(this) {
    case UNIQUE:
      return 3;
    case RARE:
      return 2;
    case UNCOMMON:
      return 1;
    case COMMON:
      return 0;
    default:
      return -1;
    }
  } 
}
