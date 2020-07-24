package utill;

import java.util.regex.Pattern;

public class MyUtill {
	
	public static String makePhoneNumber(String phoneNoStr) {
		 //전화 번호를 하이픈으로 짜르는 기능
	      String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
	      if(!Pattern.matches(regEx, phoneNoStr)) return null;
	      return phoneNoStr.replaceAll(regEx, "$1-$2-$3");
	 //
	   }

}
