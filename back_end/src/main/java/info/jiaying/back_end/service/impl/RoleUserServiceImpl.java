package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.UserRoleParams;
import info.jiaying.back_end.mapper.UserRoleMapper;
import info.jiaying.back_end.model.Role;
import info.jiaying.back_end.model.UserRole;
import info.jiaying.back_end.model.UserRoleExample;
import info.jiaying.back_end.service.RoleService;
import info.jiaying.back_end.service.RoleUserService;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    public CommonResponse grantRole(UserRoleParams userRoleParams) {
        int userId = userService.getUserIdByName(userRoleParams.getUsername());
        int roleId = (int) roleService.getRoleIdByName(userRoleParams.getRoleName()).getData();
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        userRoleMapper.insertSelective(userRole);
        return CommonResponse.success();
    }

    public CommonResponse revokeRole(UserRoleParams userRoleParams) {
        int userId = userService.getUserIdByName(userRoleParams.getUsername());
        int roleId = (int) roleService.getRoleIdByName(userRoleParams.getRoleName()).getData();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andRoleIdEqualTo(roleId).andUserIdEqualTo(userId);
        userRoleMapper.deleteByExample(userRoleExample);
        return CommonResponse.success();
    }

    public CommonResponse getUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = userService.getUserIdByName(authentication.getName());
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> userRoleList = userRoleMapper.selectByExample(example);
        List<Role> roles = (List<Role>) roleService.getRoles(userRoleList).getData();
        return CommonResponse.success(roles.stream().map(Role::getRoleName).toList());
    }
}
