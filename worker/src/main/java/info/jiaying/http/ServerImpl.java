package info.jiaying.http;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import info.jiaying.constant.TaskUrl;
import info.jiaying.dto.CommonResponse;
import info.jiaying.dto.FileNameResponse;
import info.jiaying.dto.FileResponse;
import info.jiaying.enums.NetworkStatus;
import info.jiaying.model.Task;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 利用OKhttp发起端口请求
@Slf4j
public class ServerImpl implements ServerInterface {
    OkHttpClient client = new OkHttpClient();

    // get方法
    public String get(String url) {
        Request request = new Request.Builder().url(url)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiY3JlYXRlZCI6IjIwMjQtMDMtMDIgMTA6MDc6MDUifQ.xZk7gJBMO3gvQKPvbK6bIqdYimFEOZqkF6lb5qu-gA2TDZveFVfyDXHYPcKx1RBWql51JMuYgtN7CpgN4co3xg")
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
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
    public String post(String url, String body) {
        Request request = new Request.Builder()
                .addHeader("content-type", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiY3JlYXRlZCI6IjIwMjQtMDMtMDIgMTA6MDc6MDUifQ.xZk7gJBMO3gvQKPvbK6bIqdYimFEOZqkF6lb5qu-gA2TDZveFVfyDXHYPcKx1RBWql51JMuYgtN7CpgN4co3xg")
                .url(TaskUrl.IPORT + url)
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body))
                .build();

        String result;
        try {
            return result = client.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public byte[] loadFileByFilename(String fileName) {
        Map<String, String> params = new HashMap<>();
        params.put("fileName", fileName);
        String resp = get( TaskUrl.IPORT +  TaskUrl.LOAD_FILE + getParamStr(params));
        FileResponse fileResponse = JSONObject.parseObject(resp, FileResponse.class, JSONReader.Feature.Base64StringAsByteArray);
        if (fileResponse.getCode() == 200) {
            return fileResponse.getData();
        } else {
            log.error("Error lading the file from server");
            return null;
        }
    }


    // 获取任务列表url
    @Override
    public List<Task> getTaskList(String taskType, int status, int limit) {
        Map<String, String> params = new HashMap<String, String>() {{
            put("task_type", taskType);
            put("status", status + "");
            put("limit", limit + "");
        }};
        String url = TaskUrl.IPORT + TaskUrl.HOLD_TASK + getParamStr(params);
        CommonResponse resp = JSONObject.parseObject(get(url), CommonResponse.class);
        return resp.getData();
    }

    // 调用更改任务信息接口
    @Override
    public void setTask(Task task) {
        CommonResponse resp = JSONObject.parseObject(post(TaskUrl.SET_TASK, JSONObject.toJSONString(task)), CommonResponse.class);
        if (resp.getCode() == 200) {
            log.info("Set task successfully");
        } else {
            log.error("Error setting task: " + resp.getMsg());
        }
    }

    // 获取任务配置信息
    @Override
    public CommonResponse getTaskTypeCfgList() {
       return JSONObject.parseObject(get(TaskUrl.IPORT + TaskUrl.GET_CFG_LIST), CommonResponse.class);
    }

    @Override
    public String uploadFile(String file) {
        FileNameResponse resp = JSONObject.parseObject(post(TaskUrl.UPLOAD_FILE, file), FileNameResponse.class);
        if (resp.getCode() == NetworkStatus.OK.getCode()) {
            return resp.getData();
        } else {
            return "";
        }
    }

}
