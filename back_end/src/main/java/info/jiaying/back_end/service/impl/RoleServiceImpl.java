package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dao.UserDao;
import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.RoleParams;
import info.jiaying.back_end.mapper.RoleMapper;
import info.jiaying.back_end.model.*;
import info.jiaying.back_end.service.RoleService;
import info.jiaying.back_end.service.RoleUserService;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    public CommonResponse addRole(RoleParams params) {
        Role role = new Role();
        BeanUtils.copyProperties(params, role);
        roleMapper.insert(role);
        return CommonResponse.success();
    }

    public CommonResponse deleteRole(RoleParams params) {
        Role role = new Role();
        BeanUtils.copyProperties(params, role);
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleNameEqualTo(role.getRoleName());
        roleMapper.deleteByExample(roleExample);
        return CommonResponse.success();
    }

    public CommonResponse getRoleIdByName(String roleName) {
        int roleId = roleMapper.getRoleIdByRoleName(roleName);
        return CommonResponse.success(roleId);
    }

    public CommonResponse getRoles(List<UserRole> userRoleList) {
        List<Integer> roleIdList = userRoleList.stream().map(UserRole::getRoleId).toList();
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIdIn(roleIdList);
        return CommonResponse.success(roleMapper.selectByExample(roleExample));
    }
}
