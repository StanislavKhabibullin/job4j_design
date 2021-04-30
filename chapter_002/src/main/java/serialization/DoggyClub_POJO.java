package serialization;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class DoggyClub_POJO {
    private final boolean pedegree;
    private final int numberAwards;
    private final String breed;
    private final String[] dogSize;
    private final NickName_POJO nickName;

    public DoggyClub_POJO(boolean pedegree, int numberAwards, String breed,
                          String[] dogSize, NickName_POJO nickName) {
        this.pedegree = pedegree;
        this.numberAwards = numberAwards;
        this.breed = breed;
        this.dogSize = dogSize;
        this.nickName = nickName;
    }

    public boolean isPedegree() {
        return pedegree;
    }

    public int getNumberAwards() {
        return numberAwards;
    }

    public String getBreed() {
        return breed;
    }

    public String[] getDogSize() {
        return dogSize;
    }

    public NickName_POJO getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "DoggyClub{" +
                "pedegree=" + pedegree +
                ", numberAwards=" + numberAwards +
                ", breed='" + breed + '\'' +
                ", dogSizes=" + Arrays.toString(dogSize) +
                ", nickName=" + nickName +
                '}';
    }

    public static void main(String[] args) {
        JSONObject jsonNickName = new JSONObject("{\"nickName\":\"Demolution\"}");

        final DoggyClub_POJO doggyClubPojo = new DoggyClub_POJO(true, 2,
                "shepherd", new String[]{"small", "medium", "large"},
                new NickName_POJO("Stava"));

        JSONObject jsonDoggy = new JSONObject();
        jsonDoggy.put("pedegreee", doggyClubPojo.isPedegree());
        jsonDoggy.put("numberAwards", doggyClubPojo.getNumberAwards());
        jsonDoggy.put("breed", doggyClubPojo.getBreed());
        jsonDoggy.put("dogSize", doggyClubPojo.getDogSize());
        jsonDoggy.put("NickName", doggyClubPojo.getNickName());

        System.out.println(jsonDoggy);

        System.out.println(new  JSONObject(doggyClubPojo).toString());

    }
}
