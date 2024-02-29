package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.UserRoleParams;

public interface RoleUserService {
    CommonResponse grantRole(UserRoleParams userRoleParams);
    CommonResponse revokeRole(UserRoleParams userRoleParams);
    CommonResponse getUserRoles();
}
