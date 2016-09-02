package framework.util;

public class ResultVO {

	private int successCount = 0;
	private int failureCount = 0;
	private double successPercentage = 0.0;
	private double failurePercentage = 0.0;

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public double getSuccessPercentage() {
		return successPercentage;
	}

	public void setSuccessPercentage(double successPercentage) {
		this.successPercentage = successPercentage;
	}

	public double getFailurePercentage() {
		return failurePercentage;
	}

	public void setFailurePercentage(double failurePercentage) {
		this.failurePercentage = failurePercentage;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

}
