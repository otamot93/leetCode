import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/16 15:40
 * @description：
 * @version: 1.0.0
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            array.add(i);
        }

        array.size();
    }
}
