package cn.gzsendi.flowable.model.po;


import java.io.Serializable;

/**   
 * @Description: work_flow_from_field
 * @author liujh
 * @date 2022-04-06 13:54:03
 * @version V1.0   
 */
public class WorkFlowFormField implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private Integer id;
	
	//"流程定义key")
	private String orderType;
	
	//"字段名称")
	private String fieldName;
	
	//"字段中文")
	private String fieldCname;
	
	//"字段类型")
	private String fieldType;
	
	//默认值
	private String defaultValue;
	
	//其他信息内容
	private String otherInfo;
	
	//"序号")
	private Integer fieldOrder;

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setFlowKey(String orderType) {
		this.orderType = orderType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldCname() {
		return fieldCname;
	}

	public void setFieldCname(String fieldCname) {
		this.fieldCname = fieldCname;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getFieldOrder() {
		return fieldOrder;
	}

	public void setFieldOrder(Integer fieldOrder) {
		this.fieldOrder = fieldOrder;
	}
	
	
}
