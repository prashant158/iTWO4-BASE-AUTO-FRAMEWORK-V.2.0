package Practice_Programs;
import java.util.HashSet;
import java.util.Iterator;

public class HashsetExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //HashSet treeset, LinkedHashset implements Set interface
        //does not accept duplicate values
        // There is no guarantee elements stored in sequential order..Random order

        HashSet <String> hs = new HashSet();
        hs.add("USA");
        hs.add("UK");
        hs.add("INDIA");
        hs.add("INDIA");
        hs.add("TAIWAN");
        hs.add("CHINA");

        System.out.println(hs);
        System.out.println(hs.isEmpty());
        //System.out.println(hs.remove("UK"));
        System.out.println(hs.size());
        //Iterator
        Iterator <String> it = hs.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
    }

