
package gnnt.MEBS.activeUser.vo;

import java.util.Date;


/**
 * <P>类说明：用户登录验证，传入 VO 对象
 * <br/>
 * <br/>
 * </p>
 * 修改记录:
 * <br/>
 * <ul>
 * 
 * <li> 创建类                    |2014-4-21下午03:41:20|金网安泰 </li>
 * 
 * </ul>
 * @author liuzx
 */
public class AUCheckUserVO extends AUBaseVO{
	/** 序列编号 */
	private static final long serialVersionUID = 6049725213980514919L;

	/** AU SessionID */
	private long sessionID;

	/** 用户名 */
	private String userID;

	/** 新模块编号 */
	private int toModuleID;

	/**
	 * 登录类型<br/>
	 * web web服务登录<br/>
	 * pc 电脑客户端登录<br/>
	 * mobile 手机客户端登录<br/>
	 */
	private String logonType;
	
	/**
	 * 登录IP
	 */
	private String logonIp;
	/**
	 * 登录时间
	 */
	private Date logonTime = null;
	
	public AUCheckUserVO() {
		logonTime = new Date();
	}
	
	/**
	 * 
	 * AU SessionID
	 * <br/><br/>
	 * @return
	 */
	public long getSessionID() {
		return sessionID;
	}

	/**
	 * 
	 * AU SessionID
	 * <br/><br/>
	 * @param sessionID
	 */
	public void setSessionID(long sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * 
	 * 用户名
	 * <br/><br/>
	 * @return
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * 
	 * 用户名
	 * <br/><br/>
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * 新模块编号
	 * <br/><br/>
	 * @return
	 */
	public int getToModuleID() {
		return toModuleID;
	}

	/**
	 * 
	 * 新模块编号
	 * <br/><br/>
	 * @param toModuleID
	 */
	public void setToModuleID(int toModuleID) {
		this.toModuleID = toModuleID;
	}

	/**
	 * 
	 * 登录类型<br/>
	 * web web服务登录<br/>
	 * pc 电脑客户端登录<br/>
	 * mobile 手机客户端登录<br/>
	 * <br/><br/>
	 * @return
	 */
	public String getLogonType() {
		return logonType;
	}

	/**
	 * 
	 * 登录类型<br/>
	 * web web服务登录<br/>
	 * pc 电脑客户端登录<br/>
	 * mobile 手机客户端登录<br/>
	 * <br/><br/>
	 * @param logonType
	 */
	public void setLogonType(String logonType) {
		this.logonType = logonType;
	}
	/**
	 * 设置用户登录Ip地址
	 * @param ip
	 */
	public void setLogonIp(String logonIp) {
		this.logonIp = logonIp;
	}

	/**
	 * 获取用户登录ip地址
	 * @return
	 */
	
	public String getLogonIp() {
		return logonIp;
	}

	

	/**
	 * 登录时间
	 */
	public Date getLogonTime() {
		return logonTime;
	}
	
	/**
	 * 登录时间
	 */
	public void setLogonTime(Date logonTime) {
		this.logonTime =logonTime;
	}
	
	
}