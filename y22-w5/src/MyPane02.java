public class MyPane02 {
    MyActionManager action;

    MyPane02(MyActionManager actionManager) {
        this.action = actionManager;

    }

    public void show() {
        this.action.requestCommand(0);
        this.action.requestCommand(0);
        this.action.requestCommand(2);

        // [...]
    }

    public void hide() {
        // [...]
    }
}
