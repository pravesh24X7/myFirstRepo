package super_suspicious;

// interface calculate {
//     void cal(int item);
// }

// class display implements calculate {

//     int x;

//     @Override
//     public void cal(int item) {
//         // TODO Auto-generated method stub

//         x = item * item;
        
//     }
    

// }


class equality {
    int x, y;
    boolean isEqual() {
        return x == y;
    }
}

public class Test {

    public static void main(String[] args) {
        equality e = new equality();
        e.x = 5;
        e.y=5;

        System.out.println(e.isEqual());
    }


}
