package gnnt.MEBS.logonService.client.front;

import java.io.Serializable;

/**
 * 交易员登录信息
 * 
 * @author xuejt
 * 
 */
public class TraderLogonInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9162037318317990566L;
	/**
	 * 交易员类型：管理员
	 */
	public final static String TRADER_TYPE_ADMIN = "A";
	/**
	 * 交易员类型：普通交易员
	 */
	public final static String TRADER_TYPE_NORMAL = "N";

	/**
	 * 交易员ID
	 */
	private String traderId;
	/**
	 * 交易员名称
	 */
	private String traderName;
	/**
	 * 交易商ID
	 */
	private String firmId;
	
	/**
	 * 交易商名称
	 */
	private String firmName;

	/**
	 * 交易员类型
	 */
	private String type;

	private String trustKey;

	/**
	 * 成功返回sessionID；-1：交易员代码不存在；-2：口令不正确；-3：禁止登录；-4：Key盘验证错误；-5：其他异常 -6交易板块被禁止
	 */
	private long sessionId;
	/**
	 * 是否强制修改密码 0不强制 1强制
	 */
	private int forceChangePwd;
	/**
	 * 上次登陆时间
	 */
	private String lastTime;
	/**
	 * 上次登陆ip
	 */
	private String lastIP;

	/**
	 * @return 交易员代码
	 */
	public String getTraderId() {
		return traderId;
	}

	/**
	 * @param 设置交易员代码
	 */
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}

	/**
	 * @return 交易员名称
	 */
	public String getTraderName() {
		return traderName;
	}

	/**
	 * @param 交易员名称
	 */
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	/**
	 * @return 交易商代码
	 */
	public String getFirmId() {
		return firmId;
	}

	/**
	 * @param 交易商代码
	 */
	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}
	
	/**
	 * @return 交易商名称
	 */
	public String getFirmName() {
		return firmName;
	}

	/**
	 * @param 交易商名称
	 */
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}


	/**
	 * @return 交易员类型：A 管理员 N 普通交易员
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param 交易员类型
	 *            ：A 管理员 N 普通交易员
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return 信任key；如果客户端传入的key与服务端一致则不进行登录错误次数验证
	 */
	public String getTrustKey() {
		return trustKey;
	}

	/**
	 * @param trustKey
	 *            信任key；如果客户端传入的key与服务端一致则不进行登录错误次数验证
	 */
	public void setTrustKey(String trustKey) {
		this.trustKey = trustKey;
	}

	/**
	 * @return 
	 *         成功返回sessionID；-1：交易员代码不存在；-2：口令不正确；-3：禁止登录；-4：Key盘验证错误；-5：没有此模块交易权限
	 *         -6：其他异常
	 */
	public long getSessionId() {
		return sessionId;
	}

	/**
	 * @param 成功sessionID
	 *            ；-1：交易员代码不存在；-2：口令不正确；-3：禁止登录；-4：Key盘验证错误；-5：没有此模块交易权限 -6：其他异常
	 */
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return 是否强制修改密码 0不强制 1强制
	 */
	public int getForceChangePwd() {
		return forceChangePwd;
	}

	/**
	 * @param 是否强制修改密码
	 *            0不强制 1强制
	 */
	public void setForceChangePwd(int forceChangePwd) {
		this.forceChangePwd = forceChangePwd;
	}

	/**
	 * @return 上次登陆时间
	 */
	public String getLastTime() {
		return lastTime;
	}

	/**
	 * @param 上次登陆时间
	 */
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * @return 上次登陆IP
	 */
	public String getLastIP() {
		return lastIP;
	}

	/**
	 * @param 上次登陆IP
	 */
	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}

}
