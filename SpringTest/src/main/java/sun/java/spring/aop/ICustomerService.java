package sun.java.spring.aop;

/**
 * Created by sun on 27/10/15.
 */
public interface ICustomerService
{
    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException();

    void addCustomerAround(String name);
}
