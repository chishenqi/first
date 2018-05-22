






import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by BG332387 on 2018/5/22.
 */
public class ThreadPools {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Test
    public void testPostThread() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            Post post=new Post();
            Thread t1=new Thread(post);
            Thread.sleep(1000);
        }
    }
    @Test
    public void testPost() throws Exception {
        ClientWithResponseHandler client=new ClientWithResponseHandler();
        client.doPost();

    }
}
