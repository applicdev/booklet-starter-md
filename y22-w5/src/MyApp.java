class MyApp {
    public static void main(String... args) {
        new MyApp();
    }

    public MyPane01 pane01;
    public MyPane02 pane02;

    MyApp() {
        MyActionManager actionManager = new MyActionManager(this);

        this.pane01 = new MyPane01(actionManager);
        this.pane02 = new MyPane02(actionManager);

        this.pane01.show();
    }
 
    String greeting = "Hello";

    public void whenCommand(String result) {
        System.out.println(this.greeting + result);
    }
}