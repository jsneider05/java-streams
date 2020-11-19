package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  private static final ArrayList<String> namesExpected = Lists.newArrayList(
      "Mariam",
      "Alex",
      "Ismail",
      "John",
      "Alesha",
      "Andre",
      "Susy",
      "Ali"
  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() throws Exception {
//    [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

    List<String> names = new ArrayList<>();

//    for (List<String> listOfNames : arrayListOfNames) {
//      for (String name : listOfNames) {
//        names.add(name);
//      }
//    }

//    for (List<String> listOfNames : arrayListOfNames) {
//      names.addAll(listOfNames);
//    }

//    arrayListOfNames.forEach(list -> {
//      list.forEach(name -> listOfNames.add(name));
//    });

//    arrayListOfNames.forEach(list -> {
//      list.forEach(listOfNames::add);
//    });

//    arrayListOfNames.forEach(list -> {
//      listOfNames.addAll(list);
//    });

    arrayListOfNames.forEach(names::addAll);

    assertThat(names).isEqualTo(namesExpected);
    System.out.println(names);
  }

  @Test
  public void withFlatMap() throws Exception {
//   [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

    List<String> names = arrayListOfNames.stream()
        .flatMap(List::stream)
        .collect(Collectors.toList());

    assertThat(names).isEqualTo(namesExpected);
    System.out.println(names);
  }

}

