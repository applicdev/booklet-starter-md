public class MyActionManager {
    MyApp host;

    MyActionManager(MyApp host) {
        this.host = host;
    }

    public void requestCommand(int actionId) {
        if (actionId == 0) {
            System.out.println("~ Action 0 called -> call external function in 'myApp'");

            this.host.whenCommand(", World!");
            return;
        }

        if (actionId == 1) {
            System.out.println("~ Action 1 called -> switch to 'pane02'");

            this.host.pane01.hide();
            this.host.pane02.show();
            return;
        }

        System.out.println("~ Missing action '" + actionId + "' called: void");
    }
}
