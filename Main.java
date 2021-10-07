package hoebler;

public class Main {

    public static void main(String[] args) {
        int menuSelection;
	    Order order= new Order();

        menuSelection = order.storeMenu();
        while (menuSelection != 3) {
            if (menuSelection == 1)
                order.ReadInData();
            else if (menuSelection == 2)
                order.OrderCalculations();
                order.PrintData();
            menuSelection = order.storeMenu();
        }//end of while loop
    }
}
