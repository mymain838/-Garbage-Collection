public class GarbageCollectorExample {
    private static class MyClass {
        private String data;

        public MyClass(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass(Object 1);
        MyClass obj2 = new MyClass(Object 2);

        obj1 = null;  obj1에 대한 참조 해제

        obj2 = null;  obj2에 대한 참조 해제
        
        System.gc();  GC가 동작하도록 System.gc() 메소드 호출 합니다.
    }
}