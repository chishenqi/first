import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/**
 * Created by BG332387 on 2018/5/22.
 */
public class Post implements Runnable {
    @Override
    public void run() {
        while (true){
            ClientWithResponseHandler clientWithResponseHandler=new ClientWithResponseHandler();
            try {
                clientWithResponseHandler.doPost();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
