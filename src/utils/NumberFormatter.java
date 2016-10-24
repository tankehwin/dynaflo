package utils;

import java.math.BigDecimal;

public class NumberFormatter {

	public static BigDecimal getRoundedDiscount(BigDecimal value){
		BigDecimal result = new BigDecimal(0);
		
		// multiply value by 100 because the original value was stored in db as fraction
		result = value.multiply(new BigDecimal(100));
		
		int decimalPlaces = 0;
		BigDecimal bd = new BigDecimal(result.doubleValue());

		// setScale is immutable
		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		result = bd;
	
		return result;
	}
	
}
