package automobiles;

import java.util.Arrays;
import java.util.List;

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

  public static Criterion<Car> getOneOfManyBlueCriteria() {
    return c -> c.getColor().equals("Blue");
  }

  private static final Criterion<Car> redCarCriterion = c -> c.getColor().equals("Red");
  public static Criterion<Car> getRedCarCriterion() {
    return redCarCriterion;
  }

  public static Criterion<Car> getFuelLevelCriterion(int threshold) {
    return c -> c.getFuel() < threshold;
  }
}
