package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class DoggyClub {
    private final boolean pedegree;
    private final int numberAwards;
    private final String breed;
    private final String[] dogSize;
    private final NickName nickName;

    public DoggyClub(boolean pedegree, int numberAwards, String breed,
                     String[] dogSize, NickName nickName) {
        this.pedegree = pedegree;
        this.numberAwards = numberAwards;
        this.breed = breed;
        this.dogSize = dogSize;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoggyClub{" +
                "pedegree=" + pedegree +
                ", numberAwards=" + numberAwards +
                ", breed='" + breed + '\'' +
                ", dogNames=" + Arrays.toString(dogSize) +
                ", nickName=" + nickName +
                '}';
    }

    public static void main(String[] args) {
        NickName nickName1 = new NickName("Star", 5);
        final DoggyClub doggyClub = new DoggyClub(true, 3, "giant schnauzer",
                new String[]{"small", "medium", "large"}, nickName1);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(doggyClub));

        final String doggyJson =
                "{"
                        + "\"pedegree\":false,"
                        + "\"numberAwards\":0,"
                        + "\"dogSize\" :"
                        + "[\"dont\", \"metter\"],"
                        + "\"nickName\":"
                        + "{"
                        + "\"nick\":\"subZero\","
                        + "\"age\":\"3\""
                        + "},"
                        + "\"breed\":none"
                        + "}";


        final DoggyClub unknownDogs = gson.fromJson(doggyJson, DoggyClub.class);
        System.out.println(unknownDogs);
    }
}
