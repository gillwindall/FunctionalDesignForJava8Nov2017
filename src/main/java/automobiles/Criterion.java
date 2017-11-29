package automobiles;

@FunctionalInterface
public interface Criterion<E> {
  boolean test(E c);
}
