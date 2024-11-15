import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private final JSONParser parser = new JSONParser();

    public List<Album> toListObj(String JSON) {
        try {
            Object obj = parser.parse(JSON);
            JSONArray jsonArray = (JSONArray) obj;

            ArrayList<JSONObject> list = new ArrayList<>();
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;
                list.add(jsonObject);
            }

            List<Album> res = new ArrayList<>();

            // Hiển thị kết quả
            for (JSONObject jsonObject : list) {
                res.add(
                        new Album(
                                (long) jsonObject.get("id"),
                                (long) jsonObject.get("userId"),
                                jsonObject.get("title").toString()
                        )
                );
            }

            return res;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeFile(List<String> arr){
        String filePath = "out.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(String str : arr) {
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
