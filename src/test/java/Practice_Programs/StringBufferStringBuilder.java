package Practice_Programs;

public class StringBufferStringBuilder {

    public static void main(String[] args) {
        String a = "hello"; // String literals - Immutable
        String b = "hello";

        String s1 = new String("hello"); // Using String class
        String s2 = new String("hello");

        System.out.println("========COMPARISON CODE=======================");

        System.out.println(a.equals(b)); // this is called as content comparison
        System.out.println(a==b); // this is called as reference comparison
        System.out.println(a.equals(s1)); // this is called as content comparison
        System.out.println(a==s1); // this is called as content comparison
        System.out.println("========COMPARISON CODE ENDS HERE=======================");

        System.out.println("==========================================");

        String replace=s1.replace("l","t");
        System.out.println(replace);
        String lower = s1.toLowerCase();
        System.out.println(lower);
        String upper=s1.toUpperCase();
        System.out.println(upper);
        System.out.println("==========================================");

        //String Buffer String Builder - Mutable
        // String buffer is thread safe - synchronized
        // String Builder is not thread safe - Not synchronized, Faster than String buffer
        StringBuffer sb = new StringBuffer("hello");
        sb.append(" World");
        System.out.println(sb);
        sb.insert(2," my ");
        System.out.println(sb);
        sb.replace(2,4,"Your");
        System.out.println(sb);
        sb.deleteCharAt(6);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
       }


}
