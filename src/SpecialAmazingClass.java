import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract class AmazingClass{
    void amazingMethod(Collection c){
        System.out.println("Got collection");
    }
}

public class SpecialAmazingClass extends AmazingClass {
    void amazingMethod(List l) {
        System.out.println("Got list");     }
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        Collection<String> c = al;
        AmazingClass ac = new SpecialAmazingClass();
        ac.amazingMethod(c);
    }
}