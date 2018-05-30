package controllers;

import com.google.gson.Gson;

import models.PaymentDto;
import models.PaymentEntity;
import play.mvc.Controller;
import service.PaymentService;
import service.PaymentServiceImpl;

public class PaymentController extends Controller{

	public static void createPayment()
	{
		String body=params.get("body");
		PaymentDto paymentDto=new Gson().fromJson(body,PaymentDto.class);
		PaymentService paymentService=new PaymentServiceImpl();
		paymentService.create(paymentDto);
		renderJSON("{\"success\":\"true\"}");
	}
	public static void refund()
	{
		String orderId=params.get("order_id");
		PaymentService paymentService=new PaymentServiceImpl();
		paymentService.refundPayment(orderId);
		renderJSON("{\"success\":\"true\"}");
	}

	
}
