package code.oop;

/**
 * See also {@link java.Lion}
 * @see java.Lion
 */
public class BigCat {
  public String name = "cat";
  protected boolean hasFur = true;
  boolean hasPaws = true;
  private int id;
}

class CatAdmirer {
  public static void main(String[] args) {
    BigCat bigCat = new BigCat();
    System.out.println(bigCat.name);
    System.out.println(bigCat.hasFur);
    System.out.println(bigCat.hasPaws);
  }
}
