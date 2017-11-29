package automobiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//interface Boring {
////  void doStuff();
//}

//@FunctionalInterface
//interface Criterion<E> {
////  void doStuff();
//  boolean test(E c);
//}

//interface Silly {
//  boolean daft(Car c);
//}

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

// type variables declared on class / interface are instace specific
// CANNOT use them in statics...
//UseCars<Banana> ucb = new UseCars<>();
//UseCars<Apple> uca = new UseCars<>();
//public class UseCars<X> {

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

//  interface CriterionOfString {
//    boolean test(String s);
//  }
// find anything by criterion-like behavior  
//               v *declaration* of type variable for the getByCriterion method
//                       v                      v                v *uses* of that variable
  public static <X> List<X> getByCriterion(List<X> in, Criterion<X> crit) {
    List<X> out = new ArrayList<>();
    for (X c : in) {
      if (crit.test(c)) {
        out.add(c);
      }
    }
    return out;
  }
  
//// find strings by criterion-like behavior  
//  public static List<String> getStringByCriterion(List<String> in, Criterion<String> crit) {
//    List<String> out = new ArrayList<>();
//    for (String c : in) {
//      if (crit.test(c)) {
//        out.add(c);
//      }
//    }
//    return out;
//  }
  
//  public static List<Car> getCarsByCriterion(List<Car> in, Criterion<Car> crit) {
//    List<Car> out = new ArrayList<>();
//    for (Car c : in) {
//      if (crit.test(c)) {
//        out.add(c);
//      }
//    }
//    return out;
//  }
  
  public static void showAll(List<?> lc) {
    for (Object c : lc) {
      System.out.println("> " + c);
    }
    System.out.println("--------------------------------------------------");
  }

//  public static <E> void showAll(List<E> lc) {
//    for (E c : lc) {
//      System.out.println("> " + c);
//    }
//    System.out.println("--------------------------------------------------");
//  }
//
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

      showAll(getByCriterion(fleet, Car.getRedCarCriterion()));
//      showAll(getByCriterion(fleet, new Car.LowGasCriterion(7)));
      showAll(getByCriterion(fleet, Car.getFuelLevelCriterion(5)));
      
      System.exit(0);
      // sometimes, assignemmt to intermediate variable helps
      // both you and the compiler know what's happening!
      Criterion<Car> carCrit = c -> c.getColor().equals("Green");
      showAll(getByCriterion(fleet, carCrit));
      showAll(getByCriterion(fleet, Car.getOneOfManyBlueCriteria()));
      
//      Silly crit = (c -> c.getColor().equals("Black"));
//      boolean b = ((Criterion)(c -> c.getColor().equals("Black"))).test(new Car("Black", 0));
//      boolean b = ((Silly)(c -> c.getColor().equals("Black"))).daft(new Car("Black", 0));

      List<String> ls = Arrays.asList("Fred", "Jim", "Sheila", "womble", "banana");
        
      showAll(getByCriterion(ls, s -> s.length() > 4));
      showAll(getByCriterion(ls, s -> Character.isUpperCase(s.charAt(0))));

  }
}
