package com.sathyatech.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sathyatech.app.model.PurchaseOrderDetails;

@Component
public class PurchaseOrderDtlValidator implements Validator{

		public boolean supports(Class<?> clazz) {
			return PurchaseOrderDtlValidator.class.equals(clazz);
		}
		
		public void validate(Object target, Errors errors) {
			PurchaseOrderDetails poDtls = (PurchaseOrderDetails)target;
			
			if(poDtls.getItemDetails() == null || poDtls.getItemDetails().getItemId() == null){
				errors.rejectValue("itemDetails", "", "Plz Select Item");
			}
			
			if(poDtls.getItemsQty()==null || poDtls.getItemsQty()<=0){
				errors.rejectValue("itemsQty", "", "Quantity Must be Greater than 0");
			}
		}
}
