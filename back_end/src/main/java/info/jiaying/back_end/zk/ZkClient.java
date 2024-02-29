package info.jiaying.back_end.zk;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ZkClient {
    private static CuratorFramework curatorFramework = CuratorFrameworkFactory.
            builder().connectString("jiaying.info:2181").
            sessionTimeoutMs(4000).retryPolicy(new
                    ExponentialBackoffRetry(1000,3)).
            namespace("").build();

    static {
        curatorFramework.start();
    }

    public static void setData(String path, Object object) {
        try {
            curatorFramework.setData().forPath(path, JSONObject.toJSONString(object).getBytes());
            log.info("Set the node " + path);
        } catch (Exception e) {
            log.error("Zookeeper: Error setting path " + path);
            throw new RuntimeException(e);
        }
    }

}
