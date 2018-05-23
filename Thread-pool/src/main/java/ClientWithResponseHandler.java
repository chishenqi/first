import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by BG332387 on 2018/5/22.
 */
public class ClientWithResponseHandler {
    private static final Logger logger = LoggerFactory.getLogger(ClientWithResponseHandler.class);
    private static final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    /**
     * @throws Exception
     */
    public void doPay()throws Exception{
//        // 创建Httpclient对象
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setConnectionManager(cm).build();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/v2/withdraw/pay");

        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        Map map=new HashMap();
        map.put("accountBranch", "中国建设银行股份有限公司西宁曹家寨支行");
        map.put("accountCityId", "1323");
        map.put("accountHolder", "cccccc");
        map.put("creditCardNum", "620000000006111");
        map.put("bankName", "建设银行");
        map.put("records", "[{\"actualReceiveFee\":990.00,\"billDetailIds\":[1127785,1127784],\"cashRate\":0,\"derictCarrierFlag\":false,\"guarantyCash\":0.00,\"line\":\"成都至北京专线\",\"manageRate\":0.2000,\"payApplyTime\":1527050591985,\"payBeginTime\":1525852264000,\"payWithdrawStatus\":\"完结\",\"relyCompanyId\":8,\"serviceFee\":10.00,\"totalFee\":1000.00,\"wayBillId\":1448203860750}]");

        String s = JSON.toJSONString(map);
        // 构造一个form表单式的实体
        StringEntity se = new StringEntity(s, Charset.forName("UTF-8"));
//        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中

        httpPost.setEntity(se);
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
                logger.info(Thread.currentThread().getName()+"    "+content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }
    public void doList()throws Exception{
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm).build();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/v2/withdraw/orderAndWaybillList");

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
                logger.info(Thread.currentThread().getName()+"    "+content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }

    }
    }


