package some.qiuzhu.entity;

public class Form {
    //表名   hb_sysex_relation
    private int list_id;  //序列
    private String lc_cname;  //流程中文名字
    private String lc_engname;  //流程英文名字
    private String activity;    //英文环节指向
    private String c_activity;   //中文环节指向说明
    private String welding_type;  //固化类型
    private String sysname;    //属性
    private String typename;   //类型
    private String backup_field;   //固化备用字段
    private String username;    //所要固化的用户中文名
    private String userid;    //所要固化的用户id
    private String welding_describe;    //固化描述

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getLc_cname() {
        return lc_cname;
    }

    public void setLc_cname(String lc_cname) {
        this.lc_cname = lc_cname;
    }

    public String getLc_engname() {
        return lc_engname;
    }

    public void setLc_engname(String lc_engname) {
        this.lc_engname = lc_engname;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getC_activity() {
        return c_activity;
    }

    public void setC_activity(String c_activity) {
        this.c_activity = c_activity;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getBackup_field() {
        return backup_field;
    }

    public void setBackup_field(String backup_field) {
        this.backup_field = backup_field;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWelding_type() {
        return welding_type;
    }

    public void setWelding_type(String welding_type) {
        this.welding_type = welding_type;
    }

    public String getWelding_describe() {
        return welding_describe;
    }

    public void setWelding_describe(String welding_describe) {
        this.welding_describe = welding_describe;
    }
}
