package com.stcm.backoffice.utils;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsSTCM {

	public static String getDateTime() {
		String pattern = "yyyy-MM-dd HH:mm:ss";

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		Date time_now = new Date();

		String formattedDate = formatter.format(time_now);

		return formattedDate;
	}

	public static String getDate() {
		String pattern = "yyyy-MM-dd";

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		Date time_now = new Date();

		String formattedDate = formatter.format(time_now);

		return formattedDate;
	}

	public static Timestamp stringToTimestamp(String strDate) {

		// SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date;
		try {
			date = formatDateTime.parse(strDate);

			String dateTime = formatDateTime.format(date);

			return Timestamp.valueOf(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean isHexadecimal(String txt) {

		if (txt == null || txt.isEmpty()) {
			return false;
		}
		// char[] hexaDig = new char[24];
		// caracteres
		char[] hexa = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C',
				'D', 'E', 'F' };

		// tamaño del string
		int sizeTxt = txt.length();
		// tamaño del char
		int sizeH = hexa.length;

		for (int i = 0; i < sizeTxt; i++) {

			boolean found = false;
			// System.out.print(txt.charAt(i) + ",");

			for (int j = 0; j < sizeH; j++) {

				if (txt.charAt(i) == hexa[j]) {
					// System.out.println("true");
					found = true;
					break;
				}
			}

			if (found == false) {
				return false;
			}
		}

		return true;
	}
	
	public static String getRandomHex() {
		SecureRandom random = new SecureRandom();
		String formatted = new String();

		for (int i = 0; i < 4; i++) {
			formatted += String.format("%06x", random.nextInt(0x1000000));
		}
		return formatted;
	}

	public static String getRandomInt() {
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(0x1000000);
		String formatted = String.format("%d", num);
		return formatted;
	}
}
