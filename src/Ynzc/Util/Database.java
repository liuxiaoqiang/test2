package Ynzc.Util;

public class Database {
	private String servername;
	private String serverurl;
	private String username;
	private String password;
	private String driver;
	private String initialSize;
	private String maxActive;
	private String maxIdle;
	private String maxWait;
	private String minIdle;
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	public String getServerurl() {
		return serverurl;
	}
	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	public String getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	public String getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}
	public String getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}
	public String getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}
}
