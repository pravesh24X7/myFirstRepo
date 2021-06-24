public class input_methods {

    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println("cmd args : ");
            for (var val : args) {
                System.out.print(val);
            }
        } else {
            System.out.println(" no cmd ");
        }

    //     String name = System.console().readLine();

    //     System.out.println("Name :" + name);
    }


}
