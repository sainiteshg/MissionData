package org.nithish.practice;

import java.text.DecimalFormat;
import java.util.HashMap;

public class MissionDataCode {

	public HashMap<String, String> methodName(HashMap<String, Double> object) {

		// Input variables
		int numberOfUsers = 0;
		double totalAmount = 0;
		int extraCents = 0;
		int lostCents = 0;

		// Output returning map object
		HashMap<String, String> outputString = new HashMap<String, String>();

		// I am pulling total Amount and number of users

		for (String users : object.keySet()) {
			totalAmount += object.get(users);
			numberOfUsers++;
		}

		DecimalFormat formattingStyle = new DecimalFormat("0.00");
		double totalAmountInCents = Double.parseDouble(formattingStyle.format(totalAmount)) * 100;

		if (totalAmountInCents < numberOfUsers) {
			totalInCentsLessThanUsers(object, outputString, formattingStyle, totalAmountInCents);
		} else {
			// Amount to be shared
			double shareAmount = totalAmount / numberOfUsers;

			// Formatting sytle as per requirement

			double roundingSharedAmount = Double.parseDouble(formattingStyle.format(shareAmount));
			// Logic if the roundoff amount is decimal
			if (shareAmount - (int) shareAmount != 0) { // decimal value present
				double valueAfterRounding = Double.parseDouble(formattingStyle.format(roundingSharedAmount
						* numberOfUsers));
				String valueAfterRounded = Double.toString(valueAfterRounding);
				// After rounding to 2 decimal places there is a chance of
				// missing
				// or gaining few extra cents
				// I wrote the logic to make sure there is no loss or gain in
				// cents
				if (totalAmount > valueAfterRounding) {
					lostCents = 10 - Integer.parseInt(valueAfterRounded.substring(valueAfterRounded.length() - 1));
				} else if (totalAmount < valueAfterRounding) {
					extraCents = Integer.parseInt(valueAfterRounded.substring(valueAfterRounded.length() - 1));
				} else {
					NoChangeInAmounts(object, outputString, formattingStyle, shareAmount);
				}
				boolean flag = false;
				int count = 0;
				for (String users : object.keySet()) {
					if (extraCents > 0) {
						if (count == extraCents) {
							flag = true;
						}
						if (flag) {
							double amount = object.get(users) - roundingSharedAmount;
							String str = "$" + formattingStyle.format(amount);
							outputString.put(users, str);
						} else {
							double amount = object.get(users) - (roundingSharedAmount - 0.01);
							String str = "$" + formattingStyle.format(amount);
							outputString.put(users, str);
						}
						count++;
					} else if (lostCents > 0) {
						if (count == lostCents) {
							flag = true;
						}
						if (flag) {
							double amount = object.get(users) - roundingSharedAmount;
							String str = "$" + formattingStyle.format(amount);
							outputString.put(users, str);
						} else {
							double amount = object.get(users) - (roundingSharedAmount + 0.01);
							String str = "$" + formattingStyle.format(amount);
							outputString.put(users, str);
						}
						count++;
					}
				}
			}

			// Logic if formated amount is not decimal
			else {
				NoChangeInAmounts(object, outputString, formattingStyle, shareAmount);
			}
		}

		return outputString;
	}

	private void totalInCentsLessThanUsers(HashMap<String, Double> object, HashMap<String, String> outputString,
			DecimalFormat formattingStyle, double totalAmountInCents) {
		int count = 0;
		for (String users : object.keySet()) {
			if (count != (int) totalAmountInCents) {
				double amount = object.get(users) - 0.01;
				String str = "$" + formattingStyle.format(amount);
				outputString.put(users, str);
				count++;
			} else {
				double amount = object.get(users);
				String str = "$" + formattingStyle.format(amount);
				outputString.put(users, str);
			}
		}
	}

	private HashMap<String, String> NoChangeInAmounts(HashMap<String, Double> object,
			HashMap<String, String> outputString, DecimalFormat formattingStyle, double shareAmount) {
		for (String users : object.keySet()) {
			double amount = object.get(users) - shareAmount;
			String str = "$" + formattingStyle.format(amount);
			outputString.put(users, str);
		}
		return outputString;
	}
}
