import java.io.IOException;

public interface Connector {

    String httpGet(String resource) throws IOException, InterruptedException;
}
