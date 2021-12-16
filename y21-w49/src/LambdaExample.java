// ~ declare interface structure
interface MyLambdaCommandInterface {
    void execute(String greeting);
}

// ~ lambda example
public class LambdaExample {
    // ~
    public static void myCommand(String greeting) {
        // ...
        System.out.println(greeting);
        // ...
    }

    // ~
    public static void myCommandCaller(MyLambdaCommandInterface command, String name) {
        // ...
        command.execute("Hello, " + name + "!");
        // ...
    }

    public static void main(String[] args) {
        // ~ call a code block
        myCommandCaller((String greeting) -> {
            // ...
            System.out.println(greeting);
            // ...
        }, "world");

        // ~ myCommand in LambdaExample
        myCommandCaller(LambdaExample::myCommand, "world");
    }
}
