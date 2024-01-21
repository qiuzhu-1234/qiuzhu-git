package some.qiuzhu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import some.qiuzhu.common.CustomException;
import some.qiuzhu.common.GlobalResult;
import some.qiuzhu.service.FormServiceImpl;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/form")
public class ApiController {
    private final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private FormServiceImpl iuser;

    @GetMapping("/indexlist")
    public String indexList
            (Model model) {
        log.info("ThymeleafUserController form info log start");
        return "form/indexlist";
    }

    @GetMapping("/testlist")
    public String testList(Model model) {
        log.info("ThymeleafUserController form info log start");
        return "form/testlist";
    }

    @GetMapping("/api/indexlist")
    @ResponseBody
    public ResponseEntity<?> indexlistBody(String lc_engname, String username) {
        Map result = new HashMap<>();
        result.put("rows", iuser.getAllInfo(lc_engname, username));
        log.info("select:" + result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/delete/{list_id:\\d+}")  //正则表达式
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("list_id") int list_id) {
        Integer count = iuser.deleteById(list_id);
        log.info("**************删除数据的个数：" + count);
        if (0 == count) {
            throw new CustomException("要删除的数据不存在");
        }
        return ResponseEntity.ok(GlobalResult.SUCCESS("删除成功", null));
    }

    @PostMapping("/change/update")
    @ResponseBody
    public ResponseEntity<?> change(@RequestBody HashMap<String, Object> data) throws Exception {
        try {
            iuser.changeById(data);
        } catch (Exception e) {
            throw e;
        }
        return ResponseEntity.ok(GlobalResult.SUCCESS("修改成功", null));
    }

    @PostMapping("/change/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody HashMap<String, Object> data) throws Exception {
        try {
            iuser.addById(data);
        } catch (Exception e) {
            throw e;
        }
        return ResponseEntity.ok(GlobalResult.SUCCESS("新增成功", null));
    }


}
