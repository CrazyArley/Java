package defalut;

public interface InterfaceA {
    default void foo(){
        System.out.println("InterfaceA foo");
    }
}
