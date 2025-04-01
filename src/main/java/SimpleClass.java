import java.io.Serializable;

/**
 * Created by rhaveson on 7/11/2017.
 */
public class SimpleClass implements Serializable {


        // This is the object serialization version
    private static final long serialVersionUID = 4009916627077293542L;

    int myInt;
    String myString;

        // This is how to mark a field such tat it won't be serialized
    transient int internalDontSerialize;

    public SimpleClass(int myInt, String myString) {
        this.myInt = myInt;
        this.myString = myString;
        internalDontSerialize = myInt * myInt;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
        this.internalDontSerialize = myInt * myInt;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "myInt=" + myInt +
                ", myString='" + myString + '\'' +
                ", internalDontSerialize=" + internalDontSerialize +
                '}';
    }
}
