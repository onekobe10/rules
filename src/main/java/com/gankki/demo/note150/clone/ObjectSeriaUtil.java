package com.gankki.demo.note150.clone;

import java.io.*;

public class ObjectSeriaUtil {

    private ObjectSeriaUtil() {
        throw new AssertionError();
    }

    public static <T extends Serializable> T clone(T t) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(t);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (T) ois.readObject();
    }

}
