package some.qiuzhu.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import some.qiuzhu.entity.Form;

import java.util.List;
import java.util.Map;

@Repository
public interface FormDao {

    /**
     * 查询所有人员信息
     */

    @SelectProvider(type = PlatformProvider.class, method = "getAllInfo")
    List<Form> getAllInfo(String lc_engname, String username);

    /**
     * 删除一行记录
     */
    @Delete("delete  from hb_sysex_relation where list_id = #{list_id}")
    Integer deleteById(@Param("list_id") int list_id);

    /**
     * 修改一行记录
     */
    @UpdateProvider(type = PlatformProvider.class, method = "changeById")
    Integer changeById(Map data);

    /**
     * 新增一条记录
     */
    @InsertProvider(type = PlatformProvider.class, method = "addById")
    Integer addById(Map data);

    class PlatformProvider {
        public String getAllInfo(String lc_engname, String username) {
            return new SQL() {{
                SELECT("*");
                FROM("Form h");
                if (StringUtils.hasText(lc_engname)) {
                    WHERE("h.lc_engname like " + "'%" + lc_engname + "%'");
                }
                if (StringUtils.hasText(username)) {
                    WHERE("h.username like " + "'%" + username + "%'");
                }
                ORDER_BY("list_id desc");
            }}.toString();
        }

        public String changeById(Map data) {
            return new SQL() {{
                UPDATE("Form h");
                SET("h.welding_type=#{welding_type}", "h.welding_describe=#{welding_describe}");
                WHERE("h.list_id=#{list_id}");
            }}.toString();
        }

        public String addById(Map data) {
            return new SQL() {
                {
                    INSERT_INTO("Form h");
                    VALUES("list_id,lc_cname,lc_engname,activity,c_activity,welding_type," +
                                    "sysname,typename,backup_field,username,userid,welding_describe",
                            "form_seq.nextval,#{lc_cname},#{lc_engname},#{activity},#{c_activity},#{welding_type}," +
                                    "#{sysname},#{typename},#{backup_field},#{username},#{userid},#{welding_describe}");
                }
            }.toString();
        }

    }

}
