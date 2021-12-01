public class Variables {

    // int x = 7;                       // -> instance variable on a Variables object
    public static int x = 7;            // -> static scoped variable on Variables constructor

    public static void machmal(int y) { // -> method parameter
        x = 9;                          // -> static scoped variable
        System.out.println(y);
    }

    public static void main(String[] args) {
        // int x = 3;                   // -> lokale variable / local variable
        machmal(x);
        System.out.println(x);

//        Variables node = new Variables();
//        System.out.println(node.x);
    }

}
