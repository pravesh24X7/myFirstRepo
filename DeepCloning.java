class cat {
    int i;
    cat(int i) {
        this.i =i;
    }
}

class dog {
    cat c;
    int j;
    dog(cat c, int j) {
        this.c = c;
        this.j = j;
    }

    public Object clone() throws 
        CloneNotSupportedException
    {
        cat c1 = new cat(c.i);
        dog d1 = new dog(c1, j);

        return d1;
    }

}

public class DeepCloning {
    public static void main(String[] args) throws 
            CloneNotSupportedException 
    {
        cat c = new cat(19);
        dog d1 = new dog(c, 20);
        
        System.out.println(d1.j + " " + d1.c.i);

        dog d2 = (dog) d1.clone();

        d2.j = 999;
        d2.c.i = 888;

        System.out.println(d1.j + " " + d1.c.i);
        System.out.println(d2.j + " " + d2.c.i);
    }

}
