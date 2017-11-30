package automobiles;

import static automobiles.SuperIterable.showAll;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
  public static void main(String[] args) {
    List<String> stringList = Arrays.asList(
      "Fred", "womble", "Jim", "Sheila", "banana");
    
    stringList.stream()
        .forEach(x -> System.out.println(x));
    System.out.println("-------------");
    stringList.stream()
        .filter(x -> x.length() > 4)
        .forEach(x -> System.out.println(x));
    System.out.println("-------------");
    stringList.stream()
        .forEach(x -> System.out.println(x));
    System.out.println("-------------");
    stringList.stream()
        .filter(x -> x.length() > 4)
        .map(x -> x.toUpperCase())
        .forEach(x -> System.out.println(x));;
    System.out.println("-------------");

    
    List<Car> fleet = Arrays.asList(
        new Car("Red", 8, "Fred", "Jim", "Sheila"),
        new Car("Blue", 7, "Alice", "Bob"),
        new Car("Black", 3, "Maverick"),
        new Car("Blue", 9, true, "Sarah", "Tara", "Ellie", "Jane"),
        new Car("Green", 5, "Brian", "Mary"),
        new Car("Red", 6, "William", "Joseph", "Lilly")
    );
    
    fleet.stream().forEach(x -> System.out.println(x));;
    System.out.println("-------------");
    fleet.stream()
        .parallel() // won't improve anything here.
        .filter(c -> c.getColor().equals("Blue"))
        .flatMap(c -> c.getPassengers().stream()
            .map(x -> x + " is in a " + c.getColor() + " car "))
        .forEach(System.out::println);
//        .forEach(x -> System.out.println(x));
  }
}
