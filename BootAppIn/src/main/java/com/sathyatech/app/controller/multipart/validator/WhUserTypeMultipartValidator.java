package com.sathyatech.app.controller.multipart.validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.util.WhUserTypeUtil;

@Component
public class WhUserTypeMultipartValidator {

	@Autowired
	private WhUserTypeUtil util;

	public Map<String, List<String>> validateWhUserTypes(List<WhUserType> whUserTypes) {
		Map<String, List<String>> errorsMap = new LinkedHashMap<String, List<String>>();
		int i = 1;

		for (WhUserType whUserType : whUserTypes) {
			List<String> errorList = new ArrayList<String>();

			if (StringUtils.isEmpty(whUserType.getUserType())) {
				errorList.add("WhUserType Can not be empty");
			}
			else if (!util.getUserType().contains(whUserType.getUserType())) {
				errorList.add("WhUserType must be one of: " + util.getUserType().toString());
			}
			if (StringUtils.isEmpty(whUserType.getUserCode())) {
				errorList.add("WhUserType Code Can not be empty");
			}
			else if (!Pattern.compile("[A-Z\\t\\n\\x0B\\f\\r]{4,12}").matcher(whUserType.getUserCode()).matches()) {
				errorList.add("WhUserType Code must be 4-12 Uppercase letters only");
			}
			if (StringUtils.isEmpty(whUserType.getUserEmail())) {
				errorList.add("WhUser Email Can not be empty");
			} 
			else if (!Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}").matcher(whUserType.getUserEmail()).matches()) {
				errorList.add("Please Enter Valid Email Address");
			}
			if(StringUtils.isEmpty(whUserType.getUserContact()))
			{
				errorList.add("WhUser Contact Can not be empty");
			}
			else if(!Pattern.compile("\\w{10}").matcher(whUserType.getUserContact()).matches())
			{
				errorList.add("Please Enter 10 Digits Number");
			}
			if(StringUtils.isEmpty(whUserType.getUserIdType()))
			{
				errorList.add("WhUser Id Type Can not be empty");
			}
			else if(!util.getUserIdType().contains(whUserType.getUserIdType()))
			{
				errorList.add("WhUser ID Type must be one of: "+util.getUserIdType().toString());
			}
			if(StringUtils.isEmpty(whUserType.getIdNumber()))
			{
				errorList.add("WhUserType Id Number Can not be empty");
			}
			else if(!Pattern.compile("\\w{2,20}").matcher(whUserType.getIdNumber()).matches())
			{
				errorList.add("WhUserType ID Number must be 2-20 Char or Digits Only");
			}
			if(!errorList.isEmpty()) {
				errorsMap.put("Errors at Row# "+i,errorList);
			}
			i++;
			
		}

		return errorsMap;
	}
}
