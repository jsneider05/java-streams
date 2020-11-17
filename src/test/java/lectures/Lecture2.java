package lectures;

import beans.Person;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    System.out.println("for i");
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }

    System.out.println("Exclusive");
    IntStream.range(0, 10).forEach(System.out::println);

    System.out.println("Inclusive");
    IntStream.rangeClosed(0, 10).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    IntStream.range(0, people.size())
        .forEachOrdered(index -> {
          Person person = people.get(index);
          System.out.println(person);
        });
  }

  @Test
  public void intStreamIterate() throws Exception {
    
    /**
     * seed is where you begin.
     * intUnaryOperator is a function and tells you how to increment.
     * operand is the result of what you return.
     */
    IntStream.iterate(1, operand -> operand + 1)
        .filter(number -> number % 2 == 0)
        .limit(20)
        .forEachOrdered(System.out::println);
  }
}
