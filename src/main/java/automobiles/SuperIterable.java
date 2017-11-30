package automobiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;
  
  public SuperIterable(Iterable<E> self) {
    this.self = self;
  }

  public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
    List<F> out = new ArrayList<>();
    for (E e : self) {
      for (F f :op.apply(e)) {
        out.add(f);
      }
    }
    return new SuperIterable<>(out);
  }
  
  public SuperIterable<E> filter(Predicate<E> predicate) {
    List<E> out = new ArrayList<>();
    for (E e : self) {
      if (predicate.test(e)) {
        out.add(e);
      }
    }
    return new SuperIterable<>(out);
  }

  public <F> SuperIterable<F> map(Function<E,F> op) {
    List<F> out = new ArrayList<>();
    for (E e : self) {
      out.add(op.apply(e));
    }
    return new SuperIterable<>(out);
  }

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }

  public static void showAll(Iterable<?> i) {
    for (Object x : i) {
      System.out.println(x);
    }
    System.out.println("----------------------------------");
  }
  public static void main(String[] args) {
    SuperIterable<String> stringIter = new SuperIterable<>(Arrays.asList(
      "Fred", "womble", "Jim", "Sheila", "banana"));
    
    showAll(stringIter);
    showAll(stringIter.filter(x -> x.length() > 4));
    showAll(stringIter);
    showAll(stringIter.filter(x -> x.length() > 4).map(x -> x.toUpperCase()));
    showAll(stringIter);
    
    SuperIterable<Car> fleet = new SuperIterable<>(Arrays.asList(
        new Car("Red", 8, "Fred", "Jim", "Sheila"),
        new Car("Blue", 7, "Alice", "Bob"),
        new Car("Black", 3, "Maverick"),
        new Car("Blue", 9, true, "Sarah", "Tara", "Ellie", "Jane"),
        new Car("Green", 5, "Brian", "Mary"),
        new Car("Red", 6, "William", "Joseph", "Lilly")
    ));
    
    showAll(fleet);
    showAll(
        fleet
        .filter(c -> c.getColor().equals("Blue"))
        .flatMap(c -> new SuperIterable<>(c.getPassengers())
            .map(x -> x + " is in a " + c.getColor() + " car "))
//        .flatMap((Car c) -> {
//          return new SuperIterable<>(c.getPassengers())
//            .map(x -> x + " is in a " + c.getColor() + " car ");
//        })
    );
  }
}
