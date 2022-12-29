package FCAI.FawrySystemApi.Payment;

public interface IPayment {
	public void pay(double amount);
	public void refund(double amount);
}
