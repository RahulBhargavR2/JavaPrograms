package rahul;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class serialization {
    public  void serialize()
    {
        try{
            name a=new name(20,"hi");
            FileOutputStream fo=new FileOutputStream("f.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(fo);
            xmlEncoder.writeObject(a);
            xmlEncoder.close();
            fo.close();
            System.out.println("Success");

        }catch (Exception e){
            System.out.println(e);}


    }

    public  void deSerialize() {
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("f.xml"));
            name s = (name) xmlDecoder.readObject();
            System.out.println(s.id + " " + s.name);
            xmlDecoder.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
class name implements Serializable {
        int id;
        String name;

        name(int id, String name) {
            this.id = id;
            this.name = name;
        }
}class outPut{
    public static void main(String[] args) {
        serialization serialization = new serialization();
        serialization.serialize();
    }
}
