/*
 * this is my first java program, hello world.
 * */

public class HelloWorld {
    public static voice main(String[] args) {
        if (args != null) {
	    System.out.println("there is no args input by user");
	} else {
	    System.out.println("user input something: ");
	    int length = args.length();
	    for (int i=0; i<length; i++) {
	        System.out.println("args[" + i + "]= " + args[i]);
	    }
	}
    }
}

