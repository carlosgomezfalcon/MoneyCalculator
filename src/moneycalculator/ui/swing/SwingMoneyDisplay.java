package moneycalculator.ui.swing;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.model.Money;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    private Money money;
    
    @Override
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(prefix());
        this.add(amount());
        this.add(currency());
        this.updateUI();
    }

    private Component prefix() {
        return new JLabel("Es equivalente a ");
    }
    
    private Component amount() {
        //Redondeo a dos decimales por cuestión estética.
        return new JLabel(String.valueOf(Math.round(money.getAmount()*100.0)/100.0));
    }

    private Component currency() {
        return new JLabel(String.valueOf(money.getCurrency().getCode()));
    }
    
}
