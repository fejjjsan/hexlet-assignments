package exercise;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
class App {
    public static void save(Path path, Car obj)  {
        try {
            String objAsString = obj.serialize();
            Files.write(path, objAsString.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) throws IOException {
        return Car.unserialize(path.toString());
    }
}

// END
