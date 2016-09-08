package nju.financecity_android.dao;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/9/8.
 */
public class TypeDao {
//    private static String url="http://172.19.105.116:8888/Citi/api/institution";//TODO 使用服务器URL
    private static String url="http://192.168.1.111:8888/Citi/api/institution";
    public static String readData(String type) {
        JSONObject param=new JSONObject();
        try {
            param.put("type",type);
            HttpPost request = new HttpPost(url);
            // 绑定到请求 Entry
            StringEntity se = new StringEntity(param.toString());

            Log.i("test","sendPost: StringEntity="+param.toString());

            se.setContentType("application/json");
            request.setEntity(se);
            // 发送请求
            HttpResponse httpResponse = null;
            httpResponse = new DefaultHttpClient().execute(request);
            // 得到应答的字符串，这也是一个 JSON 格式保存的数据
            String retSrc = EntityUtils.toString(httpResponse.getEntity());
            Log.i("test","sendPost: retSrc="+retSrc);
            return retSrc;
        } catch (Exception e)
        {
            Log.e("test", "sendPost: Exception");
            e.printStackTrace();
        }
        return null;
    }
}
