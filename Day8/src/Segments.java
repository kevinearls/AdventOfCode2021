import com.kevinearls.adventofcode2021.common.MyUtils;

import java.util.List;

public class Segments {
    public static void main(String[] args) throws Exception {
        Segments segments=new Segments();
        List<String> input=segments.loadData();
        List<String>
    }

    public List<String> loadData() throws Exception {
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day7/resources/input.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }

    public List<String> getTestData() throws Exception{
        String fileName = "/Users/kearls/sources/kevinearls/AdventOfCode2021/Day7/resources/testInput.txt";
        List<String> contents = MyUtils.loadFromFile(fileName);
        return contents;
    }


}
