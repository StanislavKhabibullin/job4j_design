package serialization;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoggyClubPOJO {
    private final boolean pedegree;
    private final int numberAwards;
    private final String breed;
    private final String[] dogSize;
    private final NickNamePOJO nickName;

    public DoggyClubPOJO(boolean pedegree, int numberAwards, String breed,
                         NickNamePOJO nickName, String... dogSize) {
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

    public NickNamePOJO getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "DoggyClub{"
                + "pedegree=" + pedegree
                + ", numberAwards=" + numberAwards
                + ", breed='" + breed + '\''
                + ", dogSizes=" + Arrays.toString(dogSize)
                + ", nickName=" + nickName
                + '}';
    }

    public static void main(String[] args) {
        JSONObject jsonNickName = new JSONObject("{\"nickName\":\"Demolution\"}");

        final DoggyClubPOJO doggyClubPojo = new DoggyClubPOJO(true, 2,
                "shepherd",
                new NickNamePOJO("Stava"),
                "small", "medium", "large");

        List<String> dogSizeArray = new ArrayList<>();
        dogSizeArray.add("small");
        dogSizeArray.add("medium");
        JSONArray jsonArray = new JSONArray(dogSizeArray);

        JSONObject jsonDoggy = new JSONObject();
        jsonDoggy.put("pedegreee", doggyClubPojo.isPedegree());
        jsonDoggy.put("numberAwards", doggyClubPojo.getNumberAwards());
        jsonDoggy.put("breed", doggyClubPojo.getBreed());
        jsonDoggy.put("dogSize", jsonArray);
        jsonDoggy.put("NickName", jsonNickName);

        System.out.println(jsonDoggy);

        System.out.println(new  JSONObject(doggyClubPojo).toString());

    }
}
