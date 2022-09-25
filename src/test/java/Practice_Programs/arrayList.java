package Practice_Programs;

import java.util.ArrayList;

public class arrayList {

    public static void main(String[] args){
  //
            arrayList al = new arrayList();
            String [] FruitNames ={"m","Banana","Strawberry","Apple","mango"};
            System.out.println("============Using for loop==============");
            for (int i = 0;i<FruitNames.length;i++)
            {
                System.out.println(FruitNames[i]);
                if(FruitNames[i].contains("M")||FruitNames[i].contains("m"))
                {

                    System.out.println("Name containes M");
                    break;
                                }
                else
                {
                    System.out.println("Name does not contain M");
                                    }

            }
            System.out.println("============Using advance for loop==============");
            for ( String fruit:FruitNames)
            {
                System.out.println(fruit);

            }

            System.out.println(al.getNames());
            System.out.println(al.getNameSize());
            System.out.println(al.getValueatIndex());





         }

    public ArrayList<String> getNames()
    {
        ArrayList <String>  arr = new ArrayList <String>();
        arr.add("Prashant");
        arr.add("Om");
        arr.add("Aavir");
        arr.add("Neel");
        arr.add("Manthan");
        return(arr);
    }

    public int getNameSize()
    {
        ArrayList <String>  arr1 = new ArrayList <String>();
        arr1.add("Prashant");
        arr1.add("Om");
        arr1.add("Aavir");
        arr1.add("Neel");
        arr1.add("Manthan");
        int size = arr1.size();
        return size;
    }

    public int getValueatIndex()
    {
        ArrayList <String>  arr2 = new ArrayList <String>();
        arr2.add("Prashant");
        arr2.add("Om");
        arr2.add("Aavir");
        arr2.add("Neel");
        arr2.add("Manthan");
        int index = arr2.indexOf("Aavir");
        return  index;
    }


}
