// ~ declare interface structure
interface MyCommandInterface {
    void execute(String name);
}

// ~ interface example
class CommandExample {
    // ~
    static void myCommand(String greeting, String name) {
        System.out.println(greeting + ", " + name + "!");
    }

    // ~ declare interface class
    static class MyInterface implements MyCommandInterface {
        final String greeting;

        MyInterface(String name) {
            this.greeting = name;
        }

        public void execute(String name) {
            CommandExample.myCommand(this.greeting, name);
        }
    }


    // ~
    static class MyCaller {
        MyCaller(MyCommandInterface manager, String[] name) {
            for (String n : name) {
                manager.execute(n);
            }
        }
    }

    // ~
    public static void main(String... args) {

        MyInterface myManager = new CommandExample.MyInterface("Hello");

        new CommandExample.MyCaller(
                myManager,
                new String[]{"World"}
        );

        new CommandExample.MyCaller(myManager, new String[]{"Foo", "Boo"});
    }
}