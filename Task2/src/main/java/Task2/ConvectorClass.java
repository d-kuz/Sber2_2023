package Task2;
import java.util.HashMap;
import java.util.List;

import java.lang.reflect.Field;
import java.util.Map;

import static java.nio.file.Files.size;

public class ConvectorClass {
    public static Animal mapToProductDto(Pet pet) throws NoSuchFieldException, IllegalAccessException {
        Animal animal = new Animal();
        Class p = pet.getClass();
        Class a = animal.getClass();

        Field name = p.getDeclaredField("name");
        Field nameA = a.getDeclaredField("title");
        name.setAccessible(true);
        nameA.setAccessible(true);
        nameA.set(animal, name.get(pet));

        Field status = p.getDeclaredField("status");
        status.setAccessible(true);
        Field availaible = a.getDeclaredField("isAvailaible");
        availaible.setAccessible(true);
        Field sold = a.getDeclaredField("isSolid");
        sold.setAccessible(true);

        if (status.get(pet).equals(Status.AVAILABLE)){
            availaible.set(animal, true);
            sold.set(animal, false);
        }else {
            availaible.set(animal, false);
            sold.set(animal, true);
        }

        Field photosMap = a.getDeclaredField("photosMap");
        photosMap.setAccessible(true);
        Map<String, String> map = new HashMap<>();

        Field photos = Pet.class.getDeclaredField("photoList");
        photos.setAccessible(true);
        List<Photo> photoList = (List<Photo>) photos.get(pet);
        for (Photo photo : photoList){
            map.put(photo.getName(), photo.getURL());
        }
        photosMap.set(animal, map);

        return animal;
    }
}
