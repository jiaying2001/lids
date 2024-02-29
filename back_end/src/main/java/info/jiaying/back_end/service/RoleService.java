package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.RoleParams;
import info.jiaying.back_end.model.UserRole;

import java.util.List;

public interface RoleService {
    CommonResponse getRoleIdByName(String roleName);
    CommonResponse addRole(RoleParams params);
    CommonResponse deleteRole(RoleParams params);
    CommonResponse getRoles(List<UserRole> userRoleList);
}
