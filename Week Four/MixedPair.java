public class MixedPair<U, V>{
  U eOne;
  V eTwo;
  public MixedPair(U element1, V element2){
    this.eOne = element1;
    this.eTwo = element2;
  }

  public U getOne(){return this.eOne;}
  public V getTwo(){return this.eTwo;}

  public void setOne(U eOne){this.eOne = eOne;}
  public void setTwo(V eTwo){this.eTwo = eTwo;}

  public String toString(){
    return this.eOne + "\n" + this.eTwo;
  }
}
