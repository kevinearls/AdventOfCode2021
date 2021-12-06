import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SonarTest {

    @Test
    void TestDataTest() throws Exception {
        List<Integer> contents = new ArrayList<>();
        contents.add(199);
        contents.add(200);
        contents.add(208);
        contents.add(210);
        contents.add(200);
        contents.add(207);
        contents.add(240);
        contents.add(269);
        contents.add(260);
        contents.add(263);

        Sonar sonar = new Sonar();
        System.out.println("Increases: " + sonar.countIncreases(contents));

        contents = contents.stream()
                .filter(c -> c.intValue() >200)
                .collect(Collectors.toList());

        System.out.printf("After filter number of entries: " + contents.size());

    }
}
