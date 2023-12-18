
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List arr = new ArrayList();
        arr.add(5);
        arr.add("Hello Lucky this is a collection");
        arr.add(new Date());

        Integer a = (Integer) arr.get(0);
        String Hello= (String) arr.get(1);
        Date today = (Date) arr.get(2);


        System.out.println(a);
        System.out.println(Hello);
        System.out.println(today);
        System.out.println("the size of the list is "+arr.size());
        for (Object o:arr){
            System.out.println(o);
        }
        List<String> students = new ArrayList<String>();
        students.add("JOHN");
        students.add(1,"this is john and very exited");

    }
}