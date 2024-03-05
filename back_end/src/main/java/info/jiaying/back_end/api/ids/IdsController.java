package info.jiaying.back_end.api.ids;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.IdsParams;
import info.jiaying.back_end.dto.UserIdsParams;
import info.jiaying.back_end.model.Ids;
import info.jiaying.back_end.model.UserIds;
import info.jiaying.back_end.service.IdsService;
import info.jiaying.back_end.service.UserIdsService;
import info.jiaying.back_end.service.UserService;
import org.checkerframework.checker.signature.qual.BinaryNameForNonArray;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.RegEx;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/ids")
public class IdsController {
    @Autowired
    UserService userService;
    @Autowired
    IdsService idsService;
    @Autowired
    UserIdsService userIdsService;
    @GetMapping
    public CommonResponse get(@AuthenticationPrincipal UserDetails userDetails) {
        List<UserIds> userIdsList = userIdsService.getIdsIdList(userDetails.getUsername());
        List<Ids> idsList = new ArrayList<>();
        for (UserIds userIds: userIdsList) {
            idsList.add(idsService.get(userIds.getIdsId()));
        }
        return CommonResponse.success(idsList);
    }

   @GetMapping("/all")
    public CommonResponse getAll() {
        return CommonResponse.success(idsService.getAll());
   }

   @PostMapping("grant")
    public CommonResponse grant(@RequestBody UserIdsParams userIdsParams, @AuthenticationPrincipal UserDetails userDetails) {
        userIdsService.grant(userService.getUserIdByName(userDetails.getUsername()), userIdsParams.getIdsId());
        return CommonResponse.success();
   }

   @PostMapping("revoke")
    public CommonResponse revoke(@RequestBody UserIdsParams userIdsParams, @AuthenticationPrincipal UserDetails userDetails) {
       userIdsService.revoke(userService.getUserIdByName(userDetails.getUsername()), userIdsParams.getIdsId());
       return CommonResponse.success();
   }
}
