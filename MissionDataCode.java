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

		// Amount to be shared
		double shareAmount = totalAmount / numberOfUsers;
		
		// Formatting sytle as per requirement
		DecimalFormat formattingStyle = new DecimalFormat("0.00");
		double roundingSharedAmount = Double.parseDouble(formattingStyle.format(shareAmount));
		// Logic if the roundoff amount is decimal
		if (shareAmount - (int) shareAmount != 0) { // decimal value present
			double valueAfterRounding = Double.parseDouble(formattingStyle.format(roundingSharedAmount * numberOfUsers));
			String valueAfterRounded = formattingStyle.format(valueAfterRounding);
			// After rounding to 2 decimal places there is a chance of missing
			// or gaining few extra cents
			// I wrote the logic to make sure there is no loss or gain in cents
			if (totalAmount > valueAfterRounding) {
				lostCents = 10 - Integer.parseInt(valueAfterRounded.substring(valueAfterRounded.length() - 1));
			} else {
				extraCents = Integer.parseInt(valueAfterRounded.substring(valueAfterRounded.length() - 1));
			}
			boolean flag = false;
			int i = 0;
			for (String users : object.keySet()) {
				if (extraCents > 0) {
					if (i == extraCents) {
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
					i++;
				} else if (lostCents > 0) {
					if (i == lostCents) {
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
					i++;
				}
			}
		}

		// Logic if formating amount is not decimal
		else {
			for (String users : object.keySet()) {
				double amount = object.get(users) - shareAmount;
				String str = "$" + formattingStyle.format(amount);
				outputString.put(users, str);
			}
		}

		return outputString;
	}
}
