import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeBoth(String inpt){ //implements both a stack and queue
        
        //initiate the data struc
        MyStack<Character> a = new MyStack<>(); 
        MyQueue<Character> b = new MyQueue<>();
        String noCaps = inpt.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        //convert all capital letters to non caps
        for (char c : noCaps.toCharArray()) {
            a.push(c);
            b.enqueue(c);
        }
        System.out.println("Checking if this is a palindrome....");
        System.out.print("\n  From the front ");
        System.out.print("   ");
        System.out.println("From the back  ");
        System.out.println("====================================");

        boolean checker = true;
        while (!a.isEmpty() && !b.isEmpty()) { //pops the back letters and deques the front letters to select them and check if they are the same
            char frontChar = b.dequeue();
            char backChar = a.pop();
            System.out.print("\t");
            System.out.print(frontChar);
            System.out.print("\t  |\t   ");
            System.out.println(backChar);
            try {
                Thread.sleep(500); //animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (frontChar != backChar) {
                checker = false;
            }
        }
        return checker;
    }

    public static boolean isPalindromeQueue(String inpt){ //implements a queue only

        
        MyQueue<Character> b = new MyQueue<>();
        String noCaps = inpt.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (char c : noCaps.toCharArray()) {
            b.enqueue(c);
        }
        System.out.println("Checking if this is a palindrome....");
        System.out.print("\n  From the front ");
        System.out.print("   ");
        System.out.println("From the back  ");
        System.out.println("====================================");
        
            // dequeue and compare the characters
        boolean checker = true;
        for (int i = 0; i < noCaps.length(); i++) {
            char back = noCaps.charAt(b.size()-1); //from the back
            char front = b.dequeue();
            System.out.print("\t");
            System.out.print(front);
            System.out.print("\t  |\t   ");
            System.out.println(back);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (front != back) {
                checker = false;
            }
        }
        return checker;
    }

    public static boolean isPalindromeStack(String inpt) { //implementsa stack only

        MyStack<Character> a = new MyStack<>();
        String noCaps = inpt.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (char c : noCaps.toCharArray()) {
            a.push(c);
        }
        System.out.println("Checking if this is a palindrome....");
        System.out.print("\n  From the front ");
        System.out.print("   ");
        System.out.println("From the back  ");
        System.out.println("====================================");

        // pop and compare the characters
        boolean checker = true;
        for (int i = 0; i < noCaps.length(); i++) {
            char front = noCaps.charAt(i); //from the front
            char back = a.pop();
            System.out.print("\t");
            System.out.print(front);
            System.out.print("\t  |\t   ");
            System.out.println(back);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (front != back) {
                checker = false;
            }
        }
        return checker;
    
    }
    
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        System.out.println("(Q)euque");
        System.out.println("(S)tack");
        System.out.println("(B)oth");

        System.out.print("Select your method: ");
        String input = scn.nextLine();

        System.out.println("Enter a string:");
        String input2 = scn.nextLine();

        System.out.println("String inputted: "+ input2);

        //initialize the string that will be printed
        String yes =  "\nYESSIRRR this is a palindrome!"; 
        String no = "\nThis aint no palindrome brotha smh";

        
        if(input.equals("Q")){
            long startingTime = System.currentTimeMillis();
            
            if(isPalindromeQueue(input2)){
                System.out.println(yes);
               
            }
            else{
                System.out.println(no);
            } 
            long endTime = System.currentTimeMillis();
            long timeTook = endTime - startingTime; //measures the time it took
            System.out.println("Using the queue data structure, it took "+timeTook+ " milliseconds to check the palindrome");
            
        }
        else if(input.equals("S")){
            long startingTime = System.currentTimeMillis();
            if(isPalindromeStack(input2)){
                System.out.println(yes);
               
            }
            else{
                System.out.println(no);
            } 
            long endTime = System.currentTimeMillis();
            long timeTook = endTime - startingTime;

            System.out.println("Using the stack data structure, it took "+timeTook+ " milliseconds to check the palindrome");
        }
        else if(input.equals("B")){
            long startingTime = System.currentTimeMillis();
            if(isPalindromeBoth(input2)){
                System.out.println(yes);
               
            }
            else{
                System.out.println(no);
            } 
            long endTime = System.currentTimeMillis();
            long timeTook = endTime - startingTime;

            System.out.println("Using the both the data structures, it took "+timeTook+ " milliseconds to check the palindrome");
        }
        else{
            System.out.println("invalid input");
        }

        System.out.println("Which data structure would you like to compare this data structure you used with?");
        System.out.println("(Q)euque");
        System.out.println("(S)tack");
        System.out.println("(B)oth");
        String input3 = scn.nextLine();

        if(input3.equals("S")){
            long startingTime2 = System.currentTimeMillis();
            isPalindromeStack(input2);
            long endTime2 = System.currentTimeMillis();
            long timeTook2 = endTime2 - startingTime2;
            System.out.println("While Using the stack data structure, it took "+timeTook2+ " milliseconds to check the palindrome");
           
        }

        else if(input3.equals("Q")){
            long startingTime2 = System.currentTimeMillis();
            isPalindromeQueue(input2);
            long endTime2 = System.currentTimeMillis();
            long timeTook2 = endTime2 - startingTime2;
            System.out.println("Using the queue data structure, it took "+timeTook2+ " milliseconds to check the palindrome");
        }

        else if(input3.equals("B")){
            long startingTime2 = System.currentTimeMillis();
            isPalindromeBoth(input2);
            long endTime2 = System.currentTimeMillis();
            long timeTook2 = endTime2 - startingTime2;
            System.out.println("Using both the data structure, it took "+timeTook2+ " milliseconds to check the palindrome");
        }
        else{
            System.out.println("invalid input");
        }
    
       
    }
}

