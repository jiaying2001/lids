package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.HarvesterParams;
import info.jiaying.back_end.model.HarvesterConf;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface HarvesterService {
    public CommonResponse create(HarvesterParams params) throws InvocationTargetException, IllegalAccessException;

    public CommonResponse updateOffsetByUserIdAndPath(HarvesterParams params);

    CommonResponse deleteByUserIdAndPath(HarvesterParams params) throws InvocationTargetException, IllegalAccessException;

    public List<HarvesterConf> get();

    void deleteByPath(HarvesterParams params) throws InvocationTargetException, IllegalAccessException;
}
