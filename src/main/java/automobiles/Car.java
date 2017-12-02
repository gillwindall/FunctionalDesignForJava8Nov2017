package automobiles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Car {

  private String color;
  private int fuel;
  private List<String> passengers;
  private List<String> trunk;

  public String getColor() {
    return color;
  }

  public int getFuel() {
    return fuel;
  }

  public List<String> getPassengers() {
    return passengers;
  }

  public List<String> getTrunk() {
    return trunk;
  }

  public Car(String color, int fuel, String... passengers) {
    this.color = color;
    this.fuel = fuel;
    this.passengers = Arrays.asList(passengers);
  }

  public Car(String color, int fuel, boolean hasTrunk, String... passengers) {
    this(color, fuel, passengers);
    if (hasTrunk) {
      this.trunk = Arrays.asList("Jack", "Wrench", "Wheel");
    }
  }

  @Override
  public String toString() {
    return "Car{" + "color=" + color + ", fuel=" + fuel
        + ", passengers=" + passengers + ", trunk=" + trunk + '}';
  }

  public static Predicate<Car> getOneOfManyBlueCriteria() {
    return c -> c.getColor().equals("Blue");
  }
  
  public static Comparator<Car> getFuelComparator() {
     return (c1, c2) -> c1.getFuel() > c2.getFuel() ? 1 : (c1.getFuel() < c2.getFuel() ? -1 : 0);
  }
  
  public static <X> Predicate<X> getlessThanPredicate(Comparator<X> comp, X other) {
     return c -> comp.compare(c, other) < 0;
  }

  private static final Predicate<Car> redCarCriterion = c -> c.getColor().equals("Red");
  public static Predicate<Car> getRedCarCriterion() {
    return redCarCriterion;
  }

  // prior to Java 8, have to say final..
  // Now, only must not change it!
  public static Predicate<Car> getFuelLevelCriterion(final int threshold) {
//    threshold ++;
    return c -> c.getFuel() < threshold;
  }
}
