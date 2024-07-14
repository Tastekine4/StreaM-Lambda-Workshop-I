package Lambda;

@FunctionalInterface
interface A  {
    void show();
}
//class B implements A {
//
//    public void show() {
//        System.out.println("hi");
//    }
//}

public class lambdaWork {
    public static void main(String[] args) {

        // one way to do this but if you have many interface with one method
        // this will make lots of code and documentation
//        A obj = new B();
//        obj.show();

        // Second Way is Anonymous inner class
//        A obj = new A() {
//            public void show() {
//                System.out.println("hi");
//            }
//        };
//        obj.show();

        // lets make it with lambda expression it is same with Javascript's arrow fucn '=>'
//        A obj = () -> {
//            System.out.println("hi"); // while this is a single statements make it easer like:
//        };
//        obj.show();

        A obj = () -> System.out.println("hi");
        obj.show();
    }
}
