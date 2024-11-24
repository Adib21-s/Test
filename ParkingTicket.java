import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class ParkingTicket extends JFrame{
    JButton buttonCalculate, buttonClear;
    JRadioButton radioVIP, radioCommon, radioVisa, radioMaster;
    JTextField textHour, textMinute, textTotalPrice;
    JLabel labelParkingArea, labelHour, labelMinute, labelPayment, labelTotalPrice;
    
    public ParkingTicket(){
        super("Parking Ticket Fee Calculator");
        Container contentPane = getContentPane();

        buttonCalculate = new JButton("Calculate");
        buttonClear = new JButton("Clear");
        
        radioVIP = new JRadioButton("VIP Area");
        radioCommon = new JRadioButton("Common Area");
        radioVisa = new JRadioButton("Visa");
        radioMaster = new JRadioButton("Master");
        
        textHour = new JTextField("0", 10);
        textMinute = new JTextField("0", 10);
        textTotalPrice = new JTextField(10);
        textTotalPrice.setEditable(false);
        
        labelParkingArea = new JLabel("Parking Area:");
        labelHour = new JLabel("Hours:");
        labelMinute = new JLabel("Minutes:");
        labelPayment = new JLabel("Payment Method:");
        labelTotalPrice = new JLabel("PARKING FEE: RM");

        JPanel panelParkingArea = new JPanel();
        GridLayout layout1 = new GridLayout(1,3);
        panelParkingArea.setLayout(layout1);
        TitledBorder tb1 = new TitledBorder("Parking Area");
        panelParkingArea.setBorder(tb1);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioVIP);
        radioGroup.add(radioCommon);
        panelParkingArea.add(labelParkingArea);
        panelParkingArea.add(radioVIP);
        panelParkingArea.add(radioCommon);

        JPanel panelDuration = new JPanel();
        GridLayout layout2 = new GridLayout(2,2);
        panelDuration.setLayout(layout2);
        TitledBorder tb2 = new TitledBorder("Duration");
        panelDuration.setBorder(tb2);
        panelDuration.add(labelHour);
        panelDuration.add(textHour);
        panelDuration.add(labelMinute);
        panelDuration.add(textMinute);

        ButtonGroup radioGroup2 = new ButtonGroup();
	    radioGroup2.add(radioVisa);
	    radioGroup2.add(radioMaster);
        JPanel panelPayment = new JPanel();
	    GridLayout layout4 = new GridLayout(1,3);
	    panelPayment.setLayout(layout4);
	    panelPayment.setBorder(new TitledBorder("Payment Methods"));
	    panelPayment.add(labelPayment);
	    panelPayment.add(radioVisa);
	    panelPayment.add(radioMaster);

        GridLayout layout5 = new GridLayout(1,2);
	    JPanel panelPrice = new JPanel();
	    panelPrice.setLayout(layout5);	
	    panelPrice.setBorder(new TitledBorder("Fee"));
	    panelPrice.add(labelTotalPrice);
	    panelPrice.add(textTotalPrice);

        JPanel panelCombine = new JPanel();
	    GridLayout layout3 = new GridLayout(4,1);
	    panelCombine.setLayout(layout3);
        panelCombine.add(panelParkingArea);
	    panelCombine.add(panelDuration);
	    panelCombine.add(panelPayment);
        panelCombine.add(panelPrice);

        contentPane.add(panelCombine, BorderLayout.CENTER);

        FlowLayout layout6 = new FlowLayout();
        JPanel panelButton = new JPanel();
        panelButton.setLayout(layout6);
        panelButton.add(buttonCalculate);
        panelButton.add(buttonClear);

        this.getContentPane().add(panelButton, BorderLayout.SOUTH);

        FeeHandler shop = new FeeHandler();
        buttonCalculate.addActionListener(shop);
        buttonClear.addActionListener(shop);

        this.setSize(400,400);
        this.setVisible(true);
    }

    private class FeeHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            double hour = Double.parseDouble(textHour.getText());
            double mins1 = Double.parseDouble(textMinute.getText());
            double mins2 = mins1/60;

            DecimalFormat dc= new DecimalFormat("0.00");

            if(event.getSource()==buttonClear){
                radioVIP.setSelected(false);
                radioCommon.setSelected(false);
                textHour.setText("0");
                textMinute.setText("0");
                radioVisa.setSelected(false);
                radioMaster.setSelected(false);
                textTotalPrice.setText(null);
            }
            else if(event.getSource()==buttonCalculate){
                double feeVIP, feeCommon, fee1, fee2=0;
                
                if(radioVIP.isSelected())
                    feeVIP = 2.0;
                else
                    feeVIP = 0.0;

                if(radioCommon.isSelected())
                    feeCommon = 0.5;
                else
                    feeCommon = 0.0;

                fee1 = ((hour+mins2)*1.2)+feeVIP+feeCommon;

                if(radioVisa.isSelected())
                    fee2 = fee1*1.02;
                else if(radioMaster.isSelected())
                    fee2 = fee1*1.05;

                textTotalPrice.setText("RM" + dc.format(fee2));
            }
        }
    }

    public static void main(String[] args) {
        ParkingTicket test1 = new ParkingTicket();
        test1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
