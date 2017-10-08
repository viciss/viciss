import java.nio.file.Paths;
import java.util.Optional;

/**
 * Created by huangs22 on 2017/8/28.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional.ofNullable(System.getenv("VIMRUNTIME"))
                .map(path ->{System.out.println("path returned from getenv is: " + path); return path;})
                .map(path -> Paths.get(path))
                .map(path -> {System.out.println("path after map by Paths.get() is: " + path); return path;});
    }
}
