package Task2;
import java.util.List;

public class Pet {
    private String name;
    private Status status;
    private List<Photo> photoList;

    public Pet(String name, Status status, List<Photo> photoList) {
        this.name = name;
        this.status = status;
        this.photoList = photoList;
    }
}

enum Status {
    AVAILABLE,
    SOLD,
}

class Photo {
    private  String name;
    private String URL;

    public Photo(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }
}
