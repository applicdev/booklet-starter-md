// ~ declare interface structure
interface MyCommandInterface {
    void execute(Object data);
}

// ~ interface example
class CommandExample {
    // ~
    public static void myCommand(Object data) {
        System.out.println(data.toString());
    }

    // ~
    public static void myCommandCaller(MyCommandInterface command, Object data) {
        // [... do something]

        command.execute(data);

        // [... do something]
    }

    // ~
    public static void main(String... args) {
        // ~ declare interface class
        class myInterface implements MyCommandInterface {
            public void execute(Object data) {
                CommandExample.myCommand(data);
            }
        }

        myCommandCaller(new myInterface(), "hello world");
    }
}