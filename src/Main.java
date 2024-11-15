import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connector connector =
                new HTTPClientConnector("https://jsonplaceholder.typicode.com");
        Util util = new Util();
        String JSON = connector.httpGet("/albums");

        List<Album> res = util.toListObj(JSON);
        List<String> arr = new ArrayList<>();

        for(Album item : res){
            System.out.println(item.toString());
            arr.add(item.toString());
        }
        util.writeFile(arr);
    }
}