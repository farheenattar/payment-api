package service;

import models.PaymentDto;

public interface PaymentService {

	public void create(PaymentDto paymentDto);
	public void refundPayment(String orderId);
}
