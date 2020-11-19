package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {

  @Test
  public void understandingCollect() throws Exception {
//    List<String> emails = MockData.getPeople()
//        .stream()
//        .map(Person::getEmail)
//        .collect(() -> new ArrayList<String>(),
//            (list, element) -> list.add(element),
//            (list1, list2) -> list1.addAll(list2));

//    List<String> emails = MockData.getPeople()
//        .stream()
//        .map(Person::getEmail)
//        .collect(ArrayList::new,
//            List::add,
//            List::addAll);

    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }
}
