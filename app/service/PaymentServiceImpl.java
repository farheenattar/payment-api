package service;

import models.PaymentDto;
import models.PaymentEntity;
import models.core.ApplicationConstants;

public class PaymentServiceImpl implements PaymentService
{

	@Override
	public void create(PaymentDto paymentDto)
	{
		PaymentEntity paymentEntity=new PaymentEntity();
		paymentEntity.setAmount(paymentDto.getAmount());
		paymentEntity.setOrderId(paymentDto.getOrderId());
		paymentEntity.setPaymentMode(paymentDto.getPaymentMode());
		paymentEntity.setStatus(ApplicationConstants.ACTIVE);	
		paymentEntity.save();		
	}

	@Override
	public void refundPayment(String orderId) 
	{
		PaymentEntity paymentEntity=PaymentEntity.find("orderId=?", orderId).first();
		paymentEntity.setStatus(ApplicationConstants.IN_ACTIVE);
		paymentEntity.save();
	}	
}
