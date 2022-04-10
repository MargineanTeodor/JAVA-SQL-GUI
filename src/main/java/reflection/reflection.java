package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class reflection {
    public List<String> retrieveheader(Object object) {
        List<String> lista=new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.getName();
                lista.add((String) value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
