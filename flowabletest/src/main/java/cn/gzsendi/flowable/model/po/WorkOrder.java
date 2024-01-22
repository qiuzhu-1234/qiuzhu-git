package cn.gzsendi.flowable.model.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**   
 * @Description: work_order
 * @author liujh
 * @date 2022-04-03 16:44:42
 * @version V1.0   
 */
public class WorkOrder implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private Integer id;
	
	//"工单号")
	private String orderId;
	
	//"流程定义key")
	private String orderType;
	
	//"工单所属主体的ID")
	private Integer subjectId;
	
	//"工单所属主体的类型")
	private String subjectType;
	
	//"申请人(用户ID)")
	private String applicant;
	
	//"申请时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date applicationTime;
	
	//"工单摘要/审批摘要")
	private String orderSummary;
	
	//"工单状态")
	private String orderStatus;
	
	//"提工单原因")
	private String reason;
	
	//"工单可变字段数据,json文本存储")
	private String formData;
	
	//"当前流程节点名称")
	private String handler;
	
	//"备注")
	private String remark;
	
	//"创建人员")
	private String createUser;
	
	//"创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
	//"更新人员")
	private String updateUser;
	
	//"更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getOrderSummary() {
		return orderSummary;
	}

	public void setOrderSummary(String orderSummary) {
		this.orderSummary = orderSummary;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFormData() {
		return formData;
	}

	public void setFormData(String formData) {
		this.formData = formData;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
