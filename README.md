# -Garbage-Collection
## 가비지 컬렉션 (Garbage Collection) 이란?
메모리 관리 기업중 하나로 프로그램이 동적으로 할당했던 메모리 영역 중에서 더 이상 사용되지 않는 객체  또는 데이터를 식별하고, 해당 메모리를 자동으로 회수하여 재사용 할 수있게 만듭니다.
가비지 컬렉션은 객체의 할당과 해제를 자동으로 처리하여 메모리 누수 와 무효한 참조 와 같은 메모리 관련 문제를 방지하며 그러한 이유로 개발자는 메모리 할당 및 해제에 대한 복잡한 로직을 작성할 필요가 없어 편리하고 생산성이 향상됩니다.

그렇다면 이 가비지 컬렉션이 객체 및 데이터를 식별하고 어떤 방식으로 회수하는지 궁금 할 것입니다. 대표적으로 Mark And Sweep 알고리즘이 있습니다.
## Mark And Sweep
먼저 Mark-sweep 은 다양한 GC에서 사용되는 객체를 솎아내는 내부 알고리즘 입니다. 가비지 컬렉션이 동작하는 기초적인 청소 과정입니다.
### Mark 과정 : 
#### 먼저 Root Space로부터 그래프 순회를 통해 연결된 객체들을 찾아내어 가각 어떤 객체를 참조하고 있는지 마킹합니다. Root ㅇSpace는 메모리 영역을 참조하는 전역 변수, 스택, 레지스터 등이있다.
### Sweep 과정 : 
#### 참조하고 있지 않은 객체를 Heap에서 제거합니다.
### Compact 과정 : 
#### Sweep 후에 분산된 객체들을 heap의 시작 주소로 모아 메모리가 할당된 부분과 아닌 부분으로 압축합니다.

#### 가비지 컬렉션이 제대로 동작되도록 코드를 작성하려면 객체가 더 이상 필요 하지 않을 때 혹은 메모리 누수가 발생할 것 같은 객체의 잠조를 명시적으로 해제 해야 합니다 ex) obj1 = null;
#### 아래는 예시 예시 코드입니다.
```
public class GarbageCollectorExample {
    private static class MyClass {
        private String data;

        public MyClass(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass("Object 1");
        MyClass obj2 = new MyClass("Object 2");

        obj1 = null; // obj1에 대한 참조 해제

        obj2 = null; // obj2에 대한 참조 해제
        
        System.gc(); // GC가 동작하도록 System.gc() 메소드 호출 합니다.
    }
}
```
#### 가비지 컬렉션으로도 메모리 leack 은 발생할 수 있습니다. 만약 가비지 컬렉션이 객체를 식별하고 회수 하는 과정보다 더 빠르게 객체를 추가한 후 즉시 제거를 하지않는다면 메모리 leak이 발생 할 것입니다.
```
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

```









