package part11Files;

import java.io.*;

class AttributeClass {
    String attribute;

    AttributeClass(String attribute) {
        this.attribute = attribute;
    }

    public AttributeClass() {
        this("unknown");
    }

    public String toString() {
        return attribute;
    }
}

class ContainerClass implements Serializable {
    String name;
    transient AttributeClass feature = new AttributeClass("tall");

    ContainerClass(String name, String attribute) {
        this.name = name;
        this.feature = new AttributeClass(attribute);
    }

}

public class TestFiles {
    public static void main(String[] args) throws Exception {
        File file = new File("ralph.ser");
        ContainerClass ralph = new ContainerClass("Ralph", "short");
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(ralph);

        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(new FileInputStream(file))) {
            ralph = (ContainerClass) inputStream.readObject();
        }

        System.out.println(ralph.name + " is " + ralph.feature);
    }
}