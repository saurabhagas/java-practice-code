package code.basics;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers {
  public static void main(String[] args) {
    System.out.println("Random numbers using Math.random()");
    System.out.println(Math.random()); //Calls Random::nextDouble()
    System.out.println(Math.random());
    System.out.println(Math.random());

    System.out.println("Random numbers using Random().nextInt()");
    Random randomObj = new Random();
    System.out.println(randomObj.nextInt());
    System.out.println(randomObj.nextInt());
    System.out.println(randomObj.nextInt());

    System.out.println("Random numbers using ThreadLocalRandom");
    // Random number generator local to the current thread. Is more performant than jvm-wide Random
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    System.out.println(threadLocalRandom.nextInt());
    System.out.println(threadLocalRandom.nextInt());
    System.out.println(threadLocalRandom.nextInt());

    System.out.println("Random numbers using SecureRandom");
    //Sub class of Random. Does a few things better like a cryptographically-secure seed
    SecureRandom secureRandom = new SecureRandom();
    System.out.println(secureRandom.nextInt());
    System.out.println(secureRandom.nextInt());
    System.out.println(secureRandom.nextInt());
  }
}
