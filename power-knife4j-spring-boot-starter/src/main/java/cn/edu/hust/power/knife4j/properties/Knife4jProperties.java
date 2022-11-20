package cn.edu.hust.power.knife4j.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author wylu
 * @Date 2022/11/20 下午 9:10
 */
@ConfigurationProperties(prefix = "power.knife4j")
public class Knife4jProperties {
	private String groupName;
	private String description;
	private String termsOfServiceUrl;
	private Contact contact;
	private String version;
	private String basePackage;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
}
