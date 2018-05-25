package chapter11;

import java.math.BigDecimal;
import java.nio.file.Path;

public class Product {
	
	private String name;
	private Path file;
	private BigDecimal price;
	
	public Product(String name, Path file, BigDecimal price) {
		this.name = name;
		this.price = price;
		this.file = file;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the file
	 */
	public Path getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(Path file) {
		this.file = file;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
