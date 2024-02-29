package info.jiaying.back_end.event.listener;

import info.jiaying.back_end.model.HarvesterConf;
import info.jiaying.back_end.zk.ZkClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HarvesterListener implements Listener{
    @Override
    public void ONCHANGE(List<HarvesterConf> configs) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ZkClient.setData("/" + authentication.getName(), configs);
    }

}
