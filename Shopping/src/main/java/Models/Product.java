package Models;

public class Product {
	private int id;
	private String name;
	private String details;
	private float price;
	private String sourceImg;
	private String type;
	private String brand;

	public Product(int id, String name, String details, float price, String sourceImg, String type, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.price = price;
		this.sourceImg = sourceImg;
		this.type = type;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSourceImg() {
		return sourceImg;
	}

	public void setSourceImg(String sourceImg) {
		this.sourceImg = sourceImg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", details=" + details + ", price=" + price + ", sourceImg="
				+ sourceImg + ", type=" + type + ", brand=" + brand + "]";
	}

}
