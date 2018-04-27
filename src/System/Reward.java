package System;

public class Reward {
	private String title;
	private double pledgeAmount;
	private String description;
	private String rewardItem;
	private String estimatedDelivery;// ex. "april 2018"
	private String shippingDetails; // perguntar se a entrega é limitada para quantidade de pessoas, para determinadas regioes, livre... 
	
	private Reward(String title, double pledgeAmount, String description,
			String rewardItem, String estimatedDelivery, String shippingDetails) {
		super();
		this.title = title;
		this.pledgeAmount = pledgeAmount;
		this.description = description;
		this.rewardItem = rewardItem;
		this.estimatedDelivery = estimatedDelivery;
		this.shippingDetails = shippingDetails;
	}

	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public double getPledgeAmount() {
		return pledgeAmount;
	}

	
	public void setPledgeAmount(double pledgeAmount) {
		this.pledgeAmount = pledgeAmount;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getRewardItem() {
		return rewardItem;
	}

	
	public void setRewardItem(String rewardItem) {
		this.rewardItem = rewardItem;
	}

	
	public String getEstimatedDelivery() {
		return estimatedDelivery;
	}

	
	public void setEstimatedDelivery(String estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	
	public String getShippingDetails() {
		return shippingDetails;
	}

	
	public void setShippingDetails(String shippingDetails) {
		this.shippingDetails = shippingDetails;
	}
	
	
	
	
}
