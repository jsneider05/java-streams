package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture11 {
  
  private static final List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
  private static final String STRING_EXPECTED = "[ANNA|JOHN|MARCOS|HELENA|YASMIN]";

  @Test
  public void joiningStrings() throws Exception {

    StringBuilder join = new StringBuilder();

    for (String name : names) {
      join.append(name.toUpperCase()).append("|");
    }

//    join = new StringBuilder("[" + join.substring(0, join.length() - 1) + "]");
    join = new StringBuilder().append("[").append(join.substring(0, join.length() - 1)).append("]");
    assertThat(join.toString()).hasToString(STRING_EXPECTED);
    System.out.println(join);
  }

  @Test
  public void joiningStringsWithStream() throws Exception {

    String join = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining("|", "[", "]"));

    assertThat(join).hasToString(STRING_EXPECTED);
    System.out.println(join);
  }
}
