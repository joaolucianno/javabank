package org.academiadecodigo.javabank.view;


import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class BalanceGFXView implements View{
    //Fields
    private BalanceController balanceController;
    private DecimalFormat df = new DecimalFormat("#.##");
    private Text text = new Text(10, 10, "");
    private Text text2 = new Text(10, 30, "");
    private List<Text> textList = new LinkedList<>();


    /**
     * Sets the controller responsible for rendering the view
     *
     * @param balanceController the controller to set
     */
    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

    @Override
    public void show() {
        showBalance();
    }

    public void showBalance(){
        Customer customer = balanceController.getCustomer();

        Rectangle rectangle = new Rectangle(200, 400, 0 ,0);
        rectangle.delete();
        rectangle.draw();

        text.delete();
        text.setText(customer.getName() + Messages.VIEW_BALANCE_MESSAGE);
        text.setColor(Color.BLUE);
        text.draw();

        text2.delete();
        text2.setText(Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(balanceController.getCustomerBalance()));
        text2.draw();

        List<Account> accounts = customer.getAccounts();

        double n = 50;

        if(textList.size() != 0){
            n = textList.get(textList.size() - 1).getY() + 20;
            for (int i = textList.size() - 1; i < accounts.size(); i++) {
                textList.add(new Text(10, n, ""));
                n += 20;
            }

        } else {
            for (int i = 0; i < accounts.size(); i++) {
                textList.add(new Text(10, n, ""));
                n += 20;
            }
        }


        for (int i = 0; i < accounts.size(); i++) {
            textList.get(i).delete();
            textList.get(i).setText(accounts.get(i).getId() +
                    "\t" + accounts.get(i).getAccountType() +
                    "\t" + df.format(accounts.get(i).getBalance()));
            textList.get(i).draw();
        }


    }
}
