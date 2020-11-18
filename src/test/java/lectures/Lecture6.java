package lectures;


import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() throws Exception {
    //Nondeterministic
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int any = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findAny()
        .orElse(0);

    System.out.println(any);

  }

  @Test
  public void findFirst() throws Exception {
    // Deterministic
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int first = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .orElse(0);

    System.out.println(first);

  }
}

