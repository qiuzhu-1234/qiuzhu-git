package some.qiuzhu.service;

import some.qiuzhu.entity.Form;

import java.util.List;

public interface FormService {
    public List<Form> getAllInfo(String lc_engname, String username);

    public Integer deleteById(int list_id);
}
