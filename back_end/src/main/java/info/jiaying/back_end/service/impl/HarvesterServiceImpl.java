package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dao.HarvesterDao;
import info.jiaying.back_end.dao.UserDao;
import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.HarvesterParams;
import info.jiaying.back_end.event.EventType;
import info.jiaying.back_end.event.manager.ObserverManager;
import info.jiaying.back_end.model.HarvesterConf;
import info.jiaying.back_end.service.HarvesterService;

import info.jiaying.back_end.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class HarvesterServiceImpl implements HarvesterService {
    @Autowired
    HarvesterDao harvesterDao;
    @Autowired
    UserService userService;
    @Autowired
    ObserverManager observerManager;
    @Override
    public CommonResponse create(HarvesterParams params) throws InvocationTargetException, IllegalAccessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HarvesterConf conf = new HarvesterConf();
        params.setUser_id(userService.getUserIdByName(authentication.getName()));
        BeanUtils.copyProperties(params, conf);
        harvesterDao.create(conf);
        observerManager.dispatch(EventType.ONCHANGE, get());
        return CommonResponse.success();
    }

    @Override
    public CommonResponse updateOffsetByUserIdAndPath(HarvesterParams params) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HarvesterConf conf = new HarvesterConf();
        conf.setUser_id(userService.getUserIdByName(authentication.getName()));
        BeanUtils.copyProperties(params, conf);
        harvesterDao.updateOffsetByUserIdAbdPAth(conf);
        return CommonResponse.success();
    }

    @Override
    public CommonResponse deleteByUserIdAndPath(HarvesterParams params) throws InvocationTargetException, IllegalAccessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HarvesterConf conf = new HarvesterConf();
        conf.setUser_id(userService.getUserIdByName(authentication.getName()));
        BeanUtils.copyProperties(params, conf);
        harvesterDao.deleteByUserIdAndPath(conf);
        observerManager.dispatch(EventType.ONCHANGE, get());
        return CommonResponse.success();
    }

    @Override
    public List<HarvesterConf> get() {
        int userId = getUserId();
        return harvesterDao.get(userId);
    }

    @Override
    public void deleteByPath(HarvesterParams params) throws InvocationTargetException, IllegalAccessException {
        int userId = getUserId();
        HarvesterConf conf = new HarvesterConf();
        BeanUtils.copyProperties(params, conf);
        conf.setUser_id(userId);
        harvesterDao.deleteByUserIdAndPath(conf);
        observerManager.dispatch(EventType.ONCHANGE, get());
    }

    private int getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return userService.getUserIdByName(authentication.getName());
    }
}
