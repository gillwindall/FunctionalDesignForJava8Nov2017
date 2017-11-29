package automobiles;

import java.util.Arrays;
import java.util.List;

public class UseCars {

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
  }
}
