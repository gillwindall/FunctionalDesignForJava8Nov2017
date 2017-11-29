package automobiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Criterion {
  boolean test(Car c);
}

//class RedCarCriterion implements Criterion {
//  @Override
//  public boolean test(Car c) {
//    return c.getColor().equals("Red");
//  }
//}
//
//class LowGasCriterion implements Criterion {
//  private int threshold;
//  public LowGasCriterion(int threshold) {
//    this.threshold = threshold;
//  }
//  
//  @Override
//  public boolean test(Car c) {
//    return c.getFuel() < threshold;
//  }
//}

public class UseCars {

//  public static List<Car> getColoredCars(List<Car> in, String color) {
//    List<Car> out = new ArrayList<>();
//    for (Car c : in) {
//      if (c.getColor().equals(color)) {
//        out.add(c);
//      }
//    }
//    return out;
//  }
//  
//  public static List<Car> getGasLevelCars(List<Car> in, int threshold) {
//    List<Car> out = new ArrayList<>();
//    for (Car c : in) {
//      if (c.getFuel() >= threshold) {
//        out.add(c);
//      }
//    }
//    return out;
//  }
  
  public static List<Car> getCarsByCriterion(List<Car> in, Criterion crit) {
    List<Car> out = new ArrayList<>();
    for (Car c : in) {
      if (crit.test(c)) {
        out.add(c);
      }
    }
    return out;
  }
  
  public static void showAll(List<Car> lc) {
    for (Car c : lc) {
      System.out.println("> " + c);
    }
    System.out.println("--------------------------------------------------");
  }

  public static void main(String[] args) {
    List<Car> fleet = Arrays.asList(
        new Car("Red", 8, "Fred", "Jim", "Sheila"),
        new Car("Blue", 7, "Alice", "Bob"),
        new Car("Black", 3, "Maverick"),
        new Car("Blue", 9, true, "Sarah", "Tara", "Ellie", "Jane"),
        new Car("Green", 5, "Brian", "Mary"),
        new Car("Red", 6, "William", "Joseph", "Lilly")
    );

    showAll(fleet);
    
//    showAll(getColoredCars(fleet, "Red"));
//    
//    showAll(fleet);
//    showAll(getGasLevelCars(fleet, 5));

      showAll(getCarsByCriterion(fleet, Car.getRedCarCriterion()));
      showAll(getCarsByCriterion(fleet, new Car.LowGasCriterion(7)));
  }
}
