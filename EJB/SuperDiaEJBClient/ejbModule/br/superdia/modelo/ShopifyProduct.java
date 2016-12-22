package br.superdia.modelo;

import java.util.ArrayList;
import java.util.List;

public class ShopifyProduct {
	private String title;
	private String vendor;
	private String tags;
	private List<Variants> variants = new ArrayList<>();
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<Variants> getVariants() {
		return variants;
	}

	public void setVariants(List<Variants> variants) {
		this.variants = variants;
	}
}