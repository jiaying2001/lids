package info.jiaying.back_end.event.listener;

import info.jiaying.back_end.model.HarvesterConf;

import java.util.List;

public interface Listener {
    void ONCHANGE(List<HarvesterConf> configs);
}
