package info.jiaying.http;

import com.alibaba.fastjson2.JSONObject;
import info.jiaying.constant.TaskUrl;
import info.jiaying.dto.CommonResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 利用OKhttp发起端口请求
public class ServerImpl implements ServerInterface {
    OkHttpClient client = new OkHttpClient();

    // get方法
    public CommonResponse get(String url) {

        Request request = new Request.Builder().url(url)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            String result = response.body().string();
            return JSONObject.parseObject(result, CommonResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 拼接url参数
    private String getParamStr(Map<String, String> params) {
        StringBuffer sb = new StringBuffer();
        sb.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // post请求
    public <E> CommonResponse post(String url, E body) {
        Request request = new Request.Builder()
                .addHeader("content-type", "application/json")
                .url(TaskUrl.IPORT + url)
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSONObject.toJSONString(body)))
                .build();

        String result;
        try {
            result = client.newCall(request).execute().body().string();
            return JSONObject.parseObject(result, CommonResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    // 获取任务列表url
    @Override
    public CommonResponse getTaskList(String taskType, int status, int limit) {
        Map<String, String> params = new HashMap<String, String>() {{
            put("task_type", taskType);
            put("status", status + "");
            put("limit", limit + "");
        }};
        String url = TaskUrl.IPORT + TaskUrl.HOLD_TASK + getParamStr(params);
        return get(url);
    }

    // 调用更改任务信息接口
    @Override
    public CommonResponse setTask( ) {
        return post(TaskUrl.SET_TASK, null);
    }

    // 获取任务配置信息
    @Override
    public CommonResponse getTaskTypeCfgList() {
       return get(TaskUrl.IPORT + TaskUrl.GET_CFG_LIST);
    }

}
