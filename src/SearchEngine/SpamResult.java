package SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class SpamResult {
	private boolean isSpam;
	private double confidenceScore;
	private String ruleViolated;
	private List<String> detectedKeywords;
	
	public SpamResult(boolean isSpam, double confidenceScore, String ruleViolated) {
		this.isSpam = isSpam;
		this.confidenceScore = confidenceScore;
		this.ruleViolated = ruleViolated;
		this.detectedKeywords = new ArrayList<>();
	}

	public void addKeyword(String keyword) {
		this.detectedKeywords.add(keyword);
	}

	public boolean isSpam() {
		return isSpam;
	}

	public double getConfidenceScore() {
		return confidenceScore;
	}

	public String getRuleViolated() {
		return ruleViolated;
	}

	public List<String> getDetectedKeywords() {
		return detectedKeywords;
	}
}