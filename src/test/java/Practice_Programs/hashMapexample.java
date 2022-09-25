package Practice_Programs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashMapexample {
    public static void main(String[] args) {
// TODO Auto-generated method stub

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(0, "hello");
        hm.put(1, "Gudbye");
        hm.put(2, "morning");
        hm.put(3, "evening");
        System.out.println(hm.get(42));
        //hm.remove(42);
        //System.out.println(hm.get(42));
        Set sn = hm.entrySet();
        Iterator it = sn.iterator();
        //hashtable -pass table set collections
        while (it.hasNext()) {
            System.out.println(it.next());
            Map.Entry mpp= (Map.Entry)it.next(); // Cast to Map. Entry

            //Map.Entry mp = (Map.Entry)it.next();//
            System.out.println(mpp.getKey());
            System.out.println(mpp.getValue());
        }
    }
}

