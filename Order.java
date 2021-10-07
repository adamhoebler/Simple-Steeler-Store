package hoebler;


import javax.swing.*;
import java.text.DecimalFormat;

public class Order {

    int orderNumber;
    String[] itemPurchased = new String[100];
    double[] itemPrice = new double[100];
    int[] numberItems= new int[100];
    String customerName ;
    String customerAddress;
    double[] itemAmount = new double [100];
    double subTotal;
    double orderTax;
    double finalTotal;

    int orderCounter=0;
    int itemCounter=0;

    int storeMenu() {

        int selectionValue;
        String storeMenuOutput = "Welcome to the Official Steeler's Store" + "\n" +
                "1. Add an order" + "\n" +
                "2. Calculate Bill and Print Invoice" + "\n" +
                "3. Exit" + "\n" +
                "Enter your selection : ";

        selectionValue = Integer.parseInt(JOptionPane.showInputDialog(null,
                storeMenuOutput, "Input Data", JOptionPane.QUESTION_MESSAGE));

        return selectionValue;
    }

    void ReadInData(){


            orderNumber= Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Please enter the order number: ", "Input Data", JOptionPane.QUESTION_MESSAGE));
            customerName = JOptionPane.showInputDialog(null,
                    "Please enter the customer name: ", "Input Data", JOptionPane.QUESTION_MESSAGE);
            customerAddress = JOptionPane.showInputDialog(null,
                    "Please enter the customer address: ", "Input Data", JOptionPane.QUESTION_MESSAGE);
            String addMore = "Y";

            while(addMore.equals("Y")) {
                itemPurchased[itemCounter] = JOptionPane.showInputDialog(null,
                        "Please enter the item purchased: ", "Input Data", JOptionPane.QUESTION_MESSAGE);
                itemPrice[itemCounter] = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Please enter the item price: ", "Input Data", JOptionPane.QUESTION_MESSAGE));
                numberItems[itemCounter] = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Please enter the number of items: ", "Input Data", JOptionPane.QUESTION_MESSAGE));
                addMore=JOptionPane.showInputDialog(null,
                        "Would you like to add more?(Y/N) : ", "Input Data", JOptionPane.QUESTION_MESSAGE);

                if (addMore.equals("Y")) itemCounter++;
            }
            orderCounter++;
    }

    void OrderCalculations(){
        for(int a=0; a<=itemCounter;a++){
            itemAmount[a] = itemPrice[a]*numberItems[a];
        }
        for(int b=0;b<=itemCounter;b++){
            subTotal+=itemAmount[b];
        }
        orderTax=subTotal*.07;
        finalTotal=orderTax+subTotal;
    }
    void PrintData(){
        DecimalFormat decimalFactor =new DecimalFormat("$##,###.00");

        String printOutput =
                "\nOrder Number: "+orderNumber+
                "\nCustomer Name: "+customerName+
                "\nCustomer Address: "+customerAddress+
                "\nPurchased:"+
                "\n"+numberItems[0]+" "+itemPurchased[0]+" "+decimalFactor.format(itemPrice[0])+" "+decimalFactor.format(itemAmount[0])+
                "\n"+numberItems[1]+" "+itemPurchased[1]+" "+decimalFactor.format(itemPrice[1])+" "+decimalFactor.format(itemAmount[1])+
                "\n"+numberItems[2]+" "+itemPurchased[2]+" "+decimalFactor.format(itemPrice[2])+" "+decimalFactor.format(itemAmount[2])+
                "\n"+numberItems[3]+" "+itemPurchased[3]+" "+decimalFactor.format(itemPrice[3])+" "+decimalFactor.format(itemAmount[3])+
                "\nSubtotal: "+decimalFactor.format(subTotal)+
                "\nFinal Total: "+decimalFactor.format(finalTotal);

        JOptionPane.showMessageDialog(null,
                printOutput,"Steeler's Store Invoice",JOptionPane.INFORMATION_MESSAGE);

    }


}
