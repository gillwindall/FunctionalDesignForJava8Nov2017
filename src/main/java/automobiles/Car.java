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
  // lambda version 2
  private static final Criterion<Car> redCarCriterion = c -> c.getColor().equals("Red");
//  private static final Criterion redCarCriterion = (Car c) -> c.getColor().equals("Red");

//  // lambda version 2
//  private static final Criterion redCarCriterion = c -> /*{
//      return */ c.getColor().equals("Red")/*;*/
//    /*}*/;
//
//  // lambda version 1 cleaned up
//  private static final Criterion redCarCriterion = (c) -> {
//      return c.getColor().equals("Red");
//    };
//
// Lambda version 1  
//  private static final Criterion redCarCriterion = /*new Criterion() {*/
//    /*@Override
//    public boolean test*/(/*Car*/ c) -> {
//      return c.getColor().equals("Red");
//    }
//  /*}*/;
//
// anonymous inner implementation  
//  private static final Criterion redCarCriterion = new Criterion() {
//    @Override
//    public boolean test(Car c) {
//      return c.getColor().equals("Red");
//    }
//  };
//  
//  private static final Criterion redCarCriterion = new /*RedCarCriterion();
//  private static class RedCarCriterion implements */Criterion() {
//    @Override
//    public boolean test(Car c) {
//      return c.getColor().equals("Red");
//    }
//  };
//  
  public static Criterion<Car> getRedCarCriterion() {
    return redCarCriterion;
  }
  
  static class LowGasCriterion implements Criterion<Car> {

    private int threshold;

    public LowGasCriterion(int threshold) {
      this.threshold = threshold;
    }

    @Override
    public boolean test(Car c) {
      return c.getFuel() < threshold;
    }
  }

}
