package com.vti.testing.config.resourceproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 5, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 5, 2020
 */
@ConfigurationProperties(prefix = "server")
public class ServerProperty {

	private int port;
	private String hostName;
	private String protocol;

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return protocol + "://" + hostName + ":" + getPort();
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

}
