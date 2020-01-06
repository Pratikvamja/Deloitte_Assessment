package Product;



public class Product1 {

	private String id;
	private String name;
	private int price;
	private String category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product1(String id, String name, int price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product1 [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	
}
