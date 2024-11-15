import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClientConnector implements Connector {
    private final HttpClient client = HttpClient.newHttpClient();

    private final String baseURL;

    public HTTPClientConnector(String baseURL){
        this.baseURL = baseURL;
    }

    @Override
    public String httpGet(String resource) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseURL+resource))
                .build();
        HttpResponse<String> res = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return res.body();
    }
}
