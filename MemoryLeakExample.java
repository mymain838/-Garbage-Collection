import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            Object object = new Object(); // 객체 생성
            list.add(object);
            list.remove(object); // 객체를 추가한 후 즉시 제거하지 않음
        }
    }
}
