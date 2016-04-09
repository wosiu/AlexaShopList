package db;


import java.io.Serializable;

public class Offer implements Serializable {
	private static final long serialVersionUID = 231L;

	private Long id;
	private String shopProductName;
	private String price;
	private String shopName;
	private String shopUrl;
	private Long searchId;

	public Offer() {
	}

	public Offer(String shopProductName, String price, String shopName, String shopUrl, Long searchId) {
		this.shopProductName = shopProductName;
		this.price = price;
		this.shopName = shopName;
		this.shopUrl = shopUrl;
		this.searchId = searchId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopProductName() {
		return shopProductName;
	}

	public void setShopProductName(String shopProductName) {
		this.shopProductName = shopProductName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public Long getSearchId() {
		return searchId;
	}

	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}
}
