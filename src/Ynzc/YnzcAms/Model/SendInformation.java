package Ynzc.YnzcAms.Model;
/**
 * 信息发布
 * @author dhm
 * @date 2011-05-05
 * class SendInformation.java
 */



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_sendinformation")
public class SendInformation {
	private int id;//编号
	private String type;//信息类别
	private int sendUserId;//发布者编号
	private String sendUserName;//发布者
	private String title;//信息标题
	private String sendContent;//信息内容
	private Date sendDate;//发布日期
	private int replyId ;//回复编号
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	
}
