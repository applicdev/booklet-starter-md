public class MyPane01 {
    MyActionManager action;

    MyPane01(MyActionManager actionManager) {
        this.action = actionManager;

    }

    public void show() {
        this.action.requestCommand(1);

        // [...]
    }

    public void hide() {
        // [...]
    }
}
