package exercise;


import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

// BEGIN
class Validator {

    public static List<String> validate(Address ob) {
        Field[] fields = ob.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();
        try {
            for(Field fld : fields) {
                fld.setAccessible(true);
                if (fld.getAnnotation(NotNull.class) != null) {
                    if (fld.get(ob) == null) {
                        result.add(fld.getName());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }
}
// END
