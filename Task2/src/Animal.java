
import java.util.Map;

public class Animal {
    private String title;
    private boolean isAvailaible;
    private boolean isSolid;
    private Map<String, String> photosMap;



    @Override
    public String toString() {
        return "Animal{" +
                "title='" + title + '\'' +
                ", isAAvailaible=" + isAvailaible +
                ", isSolid=" + isSolid +
                ", photosMap=" + photosMap +
                '}';
    }

}
