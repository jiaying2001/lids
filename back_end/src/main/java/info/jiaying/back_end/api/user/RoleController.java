package info.jiaying.back_end.api.user;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.RoleParams;
import info.jiaying.back_end.dto.UserRoleParams;
import info.jiaying.back_end.service.RoleService;
import info.jiaying.back_end.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    RoleUserService roleUserService;

    @PostMapping()
    public CommonResponse create(@RequestBody RoleParams roleParams) {
        return roleService.addRole(roleParams);
    }

    @DeleteMapping()
    public CommonResponse delete(@RequestBody RoleParams roleParams) {
        return roleService.deleteRole(roleParams);
    }

    @PostMapping("grant")
    public CommonResponse grant(@RequestBody UserRoleParams userRoleParams) {
        return roleUserService.grantRole(userRoleParams);
    }
    @PostMapping("revoke")
    public CommonResponse revoke(@RequestBody UserRoleParams userRoleParams) {
        return roleUserService.revokeRole(userRoleParams);
    }
    @GetMapping()
    public CommonResponse getRoles() {
        return roleUserService.getUserRoles();
    }
}
