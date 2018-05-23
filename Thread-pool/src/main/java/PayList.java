/**
 * Created by BG332387 on 2018/5/23.
 */
public class PayList implements Runnable {
    @Override
    public void run() {
        while (true){
            ClientWithResponseHandler clientWithResponseHandler=new ClientWithResponseHandler();
            try {
                clientWithResponseHandler.doList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
