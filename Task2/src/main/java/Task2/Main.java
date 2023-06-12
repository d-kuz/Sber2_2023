package Task2;

import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Pet cat = new Pet("Барсик", Status.AVAILABLE,
                List.of(new Photo("Барсик с цветами", "https://catphoto.ru/200/300"),
                        new Photo("Барсик по руках", "https://catphoto.ru/500/600")));

        Animal animalCat = ConvectorClass.mapToProductDto(cat);
        System.out.println(animalCat.toString());
    }


}
