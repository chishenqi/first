
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
            Pay post=new Pay();
            executorService.execute(post);
        }
        Thread.sleep(1000);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        for (int i = 0; i < 1000; i++) {
//            Pay pay = new Pay();
//            executorService.execute(pay);
//
//        }
        ClientWithResponseHandler client=new ClientWithResponseHandler();
        try {
            client.doPay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }



