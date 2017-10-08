import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by huangs22 on 2017/9/1.
 */
public class main {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,4).collect(Collectors.toList());
        System.out.println(list);
    }
}
