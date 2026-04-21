import java.io.*;

public class ExceptionTesterApp {

    public static void main(String[] args) {
        System.err.println("In main: calling method1.");
        try {
            method1();
        } catch (IOException e) {
            System.err.println("In main: caught exception.");
            System.err.println("  Message   : " + e.getMessage());
            System.err.println("  toString  : " + e.toString());
            System.err.println("  Stack trace:");
            e.printStackTrace(System.err);
        }
        System.err.println("In main: returned from method1.");
    }

    // Declares that it throws IOException so the exception propagates up
    public static void method1() throws IOException {
        System.err.println("\tIn method1: calling method2.");
        method2();
        System.err.println("\tIn method1: returned from method2.");
    }

    // Declares that it throws IOException so the exception propagates up
    public static void method2() throws IOException {
        System.err.println("\t\tIn method2: calling method3.");
        method3();
        System.err.println("\t\tIn method2: returned from method3.");
    }

    // Throws an IOException to demonstrate exception propagation
    public static void method3() throws IOException {
        System.err.println("\t\t\tIn method3: Entering.");

        // Throw an IOException to test the exception handler in main()
        // The if(true) wrapper allows the code after it to compile
        // (without it, the compiler treats subsequent lines as unreachable)
        if (true) {
            throw new IOException("Test IOException thrown from method3.");
        }

        System.err.println("\t\t\tIn method3: Exiting.");
    }
}
