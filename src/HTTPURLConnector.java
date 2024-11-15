import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPURLConnector implements Connector {

    private final String baseURL;

    public HTTPURLConnector(String baseURL) {
        this.baseURL = baseURL;
    }

    public String httpGet(String resource) throws IOException {
        URL url = new URL(baseURL + resource);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection
                    .getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            in.close();

            return response.toString();
        } else {
            System.out.println("GET request did not work.");
        }
        return null;
    }
}
