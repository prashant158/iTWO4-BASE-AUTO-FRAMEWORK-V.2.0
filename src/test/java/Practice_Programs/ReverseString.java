package Practice_Programs;

public class ReverseString {


    public static void main(String[] args) {
        String s ="rahul"; //Palindrome
        String t="";
        for(int i = s.length()-1;i>=0;i--)
        {
            System.out.println(s.charAt(i));
            t=t+s.charAt(i);
        }

        System.out.println(t);
        if (s.equals(t))
        {
            System.out.println("String is Palindrome");
        }
        else {
            System.out.println("Strings are not matching");
        }

    }



}
