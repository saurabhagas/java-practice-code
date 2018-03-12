package recursion;

/**
 * Class that solves the classic Towers of Hanoi problem.
 * <p>
 * The problem consists of three towers and a number of disks of different sizes which can slide onto any rod.
 * The puzzle starts with the disks on one rod in decreasing order of size, with the smallest disk at the top.
 * The objective of the puzzle is to move the entire stack to another rod using the auxilary tower,
 * while satisfying the following rules:
 * <ul>
 * <li>Only one disk may be moved at a time</li>
 * <li>Each move consists of taking the upper disk from one of the rods and sliding it onto another rod,
 * on top of the other disks that may already be present on that rod</li>
 * <li>No disk may be placed on top of a smaller disk</li>
 * </ul>
 */
class TowersOfHanoi {
  public static void main(String[] args) {
    TowersOfHanoi towers = new TowersOfHanoi();
    towers.solve(3, 'A', 'C', 'B');
//    towers.solve(4, 'A', 'C', 'B');
//    towers.solve(5, 'A', 'C', 'B');
  }

  /**
   * Recursive function which solves the Towers of Hanoi problem
   *
   * @param disks       number of disks
   * @param source      source tower
   * @param destination destination tower
   * @param auxiliary   auxiliary tower
   */
  public void solve(int disks, char source, char destination, char auxiliary) {
    /*Parameter checks*/
    if (disks < 1) {
      throw new IllegalArgumentException("Disk count should be greater than or equal to 1");
    }

    /*Base case*/
    if (disks == 1) {
      System.out.printf("Move disk %d from %c to %c\n", disks, source, destination);
      return;
    }

    /*Recursive case*/
    //Move top n-1 disks from source to auxiliary
    solve(disks - 1, source, auxiliary, destination);

    //Move the nth disk from source to destination
    System.out.printf("Move disk %d from %c to %c\n", disks, source, destination);

    //Move n-1 disks from auxiliary to destination. Tada!
    solve(disks - 1, auxiliary, destination, source);
  }
}