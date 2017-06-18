package structural;

/**
 * Created by govind.bhone on 6/18/2017.
 */
class Inventory {
    public String checkInventory(String OrderId) {
        return "Inventory checked";
    }
}

class Payment {
    public String deductPayment(String orderID) {
        return "Payment deducted successfully";

    }
}

class OrderFacade {
    private Payment pymt = new Payment();
    private Inventory inventry = new Inventory();

    public void placeOrder(String orderId) {
        String step1 = inventry.checkInventory(orderId);
        String step2 = pymt.deductPayment(orderId);
        System.out
                .println("Following steps completed:" + step1
                        + " & " + step2);
    }
}

public class FacadeDesignPattern2 {
    public static void main(String args[]) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("OR123456");
        System.out.println("Order processing completed");
    }
}
