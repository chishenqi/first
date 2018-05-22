import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BG332387 on 2018/5/22.
 */
public class ClientWithResponseHandler {

    public void doPost()throws Exception{
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://10.45.8.124:10080/v2/withdraw/orderAndWaybillList");

        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("accountBranch", "中国建设银行股份有限公司西宁曹家寨支行"));
        parameters.add(new BasicNameValuePair("accountCityId", "1323"));
        parameters.add(new BasicNameValuePair("accountHolder", "cccccc"));
        parameters.add(new BasicNameValuePair("creditCardNum", "620000000006111"));
        parameters.add(new BasicNameValuePair("bankName", "建设银行"));

        parameters.add(new BasicNameValuePair("records", "[{\"payApplyTime\":1526995098233,\"orderFee\":10000,\"paymentType\":\"MORTGAGE_PAY\",\"serviceFee\":10000,\"orderWaybillId\":1,\"mortgageFee\":10000}]"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        // 伪装浏览器请求
        httpPost.setHeader(
                "useragent",
                "1.0;iPhone 6;iOS/8.4;WIFI;775825877788");
        Header[] headers=new Header[3];
        headers[0]=new BasicHeader("useragent",
                "1.0;iPhone 6;iOS/8.4;WIFI;775825877788");
        headers[1]=new BasicHeader("access-token",
                "AT_C_8229ecf0-5ea8-4392-b84a-37ba0bb74223");
        headers[2]=new BasicHeader("Content-Type",
                "application/json");
        httpPost.setHeaders(headers);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 获取服务端响应的数据
                String content = EntityUtils.toString(response.getEntity(),
                        "UTF-8");
                System.out.println(Thread.currentThread().getName()+"    "+content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }
    }


