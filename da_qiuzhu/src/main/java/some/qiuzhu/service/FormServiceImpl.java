package some.qiuzhu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import some.qiuzhu.dao.FormDao;
import some.qiuzhu.entity.Form;

import java.util.HashMap;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    private final Logger log = LoggerFactory.getLogger(FormServiceImpl.class);
    @Autowired
    FormDao ud;

    @Override
    public List<Form> getAllInfo(String lc_engname, String username) {
        log.info("PlatformService getAllInfo info log start");
        return ud.getAllInfo(lc_engname, username);
    }

    @Override
    public Integer deleteById(int list_id) {
        log.info("PlatformService deleteById info log start");
        return ud.deleteById(list_id);
    }

    public Integer changeById(HashMap data) {
        log.info("PlatformService changeById info log start");
        return ud.changeById(data);
    }

    public Integer addById(HashMap data) {
        log.info("PlatformService addById info log start");
        return ud.addById(data);
    }

}
