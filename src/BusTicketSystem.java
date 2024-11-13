import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class BusTicketSystem extends JFrame
{
    JCheckBox cbChild, cbAdult, cbSenior;
    JButton buttonCalculate,buttonClear,buttonPrint;
    JTextField txname, txnumchild,txnumadult,txnumsenior,txprice ;
    JLabel ltitle,lname,lnumchild,lnumadult, lnumsenior,lprice,ldepart,ldestination;
    JPanel panelTitle, panelCategories, panelAtas, panelC;
    JComboBox depart, destination;

    public BusTicketSystem()
    {
        super("Bus Ticket Reservation");

        cbChild = new JCheckBox("Child");
        cbAdult = new JCheckBox("Adult");
        cbSenior = new JCheckBox("Senior ");
        buttonCalculate= new JButton("CALCULATE");
        buttonClear= new JButton("Clear");
        buttonPrint= new JButton("Print");
        txname = new JTextField ("",10);
        txnumchild= new JTextField ("",10);
        txnumadult= new JTextField ("",10);
        txnumsenior= new JTextField ("",10);
        txprice = new JTextField ("",10);
        ltitle = new JLabel("BUS TICKETING SYSTEM");
        lname = new JLabel("Name:");
        lnumchild = new JLabel("Number of child:");
        lnumadult = new JLabel("Number of adult:");
        lnumsenior = new JLabel("Number os senior:");
        lprice = new JLabel(" TOTAL PRICE : RM");
        depart = new JComboBox<>();
        depart.addItem("Melaka");
        depart.addItem("Johor");
        depart.addItem("Perak");
        depart.addItem("Selangor");
        depart.addItem("Kelantan");
        destination = new JComboBox<>();
        destination.addItem("Melaka");
        destination.addItem("Johor");
        destination.addItem("Perak");
        destination.addItem("Selangor");
        destination.addItem("Kelantan");
        ldepart = new JLabel("Departure");
        ldestination = new JLabel("Destination");


        //panel title
        panelTitle= new JPanel();
        panelTitle.add(ltitle);

        //panel 1 :storage type
        //GridLayout layout1 = new GridLayout(4,1);
        panelCategories = new JPanel(new GridLayout(1,4));
        //panelStoType.setLayout(layout1);
        panelCategories.add(cbChild);
        panelCategories.add(cbAdult);
        panelCategories.add(cbSenior);

        //panel label & textField
        JPanel panelLabel = new JPanel (new GridLayout(9,2));
        //panelLabel.setBorder(new TitledBorder("Information and charges:"));
        panelLabel.add(lname);
        panelLabel.add(txname);
        panelLabel.add(new JLabel("Categories:"));
        panelLabel.add(panelCategories);
        panelLabel.add(ldepart);
        panelLabel.add(depart);
        panelLabel.add(ldestination);
        panelLabel.add(destination);
        panelLabel.add(lnumchild);
        panelLabel.add(txnumchild);
        panelLabel.add(lnumadult);
        panelLabel.add(txnumadult);
        panelLabel.add(lnumsenior);
        panelLabel.add(txnumsenior);
        panelLabel.add(lprice);
        panelLabel.add(txprice);

        //panel button

        JPanel panelC = new JPanel(new FlowLayout());
        panelC.add(buttonCalculate);
        panelC.add(buttonClear);
        panelC.add(buttonPrint);


        JPanel panelB = new JPanel(new GridLayout(2,1));
        panelB.add(panelLabel);
        panelB.add(panelC);

        this.getContentPane().add(panelTitle, BorderLayout.NORTH);
        this.getContentPane().add(panelLabel, BorderLayout.CENTER);
        this.getContentPane().add(panelB, BorderLayout.SOUTH);

        PcHandler shop = new PcHandler();
        buttonCalculate.addActionListener(shop);
        buttonClear.addActionListener(shop);
        buttonPrint.addActionListener(shop);
        this.setSize(400,400);
        this.show();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
    }

    double totalPrice = 0.0 ;

    private class PcHandler implements ActionListener
    {		public void actionPerformed(ActionEvent event)
    {
        String name = txname.getText();
        String departure = depart.getSelectedItem().toString();
        String desti = destination.getSelectedItem().toString();

        int child = Integer.parseInt(txnumchild.getText());
        int adult= Integer.parseInt(txnumadult.getText());
        int senior = Integer.parseInt(txnumsenior.getText());


        DecimalFormat dc = new DecimalFormat(".##");
        //double totalPrice = 0.0 ;

        if(event.getSource()==buttonClear)
        {		txname.setText("");
            txnumchild.setText("");
            txnumadult.setText("");
            txnumsenior.setText("");
            txprice.setText("");
            cbChild.setSelected(false);
            cbAdult.setSelected(false);
            cbSenior.setSelected(false);
        }

        else if (event.getSource()==buttonCalculate)
        {	double pchild, padult, psenior;

            //departureMelaka
            if (departure == "Melaka" & desti == "Johor"){
                if (cbChild.isSelected())
                    pchild = child * 11.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 15.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 12.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM"  + totalPrice);
            }

            else if (departure == "Melaka" & desti == "Selangor"){
                if (cbChild.isSelected())
                    pchild = child * 20.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 25.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 22.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice );
            }

            else if (departure == "Melaka" & desti == "Perak"){
                if (cbChild.isSelected())
                    pchild = child * 40.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 50.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 45.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM"  + totalPrice);
            }

            else if (departure == "Melaka" & desti == "Kelantan"){
                if (cbChild.isSelected())
                    pchild = child * 56.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 60.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 50.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Melaka" & desti == "Melaka"){
                txprice.setText("invalid");
            }


            //departureJohor
            if (departure == "Johor" & desti == "Melaka"){
                if (cbChild.isSelected())
                    pchild = child * 11.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 15.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 12.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM"  + totalPrice);
            }

            else if (departure == "Johor" & desti == "Selangor"){
                if (cbChild.isSelected())
                    pchild = child * 25.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 27.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 23.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice );
            }

            else if (departure == "Johor" & desti == "Perak"){
                if (cbChild.isSelected())
                    pchild = child * 45.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 55.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 50.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM"  + totalPrice);
            }

            else if (departure == "Johor" & desti == "Kelantan"){
                if (cbChild.isSelected())
                    pchild = child * 66.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 70.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 60.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Johor" & desti == "Johor"){
                txprice.setText("invalid");
            }


            //departurePerak
            if (departure == "Perak" & desti == "Johor"){
                if (cbChild.isSelected())
                    pchild = child * 45.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 55.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 50.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM"  + totalPrice);
            }

            else if (departure == "Perak" & desti == "Selangor"){
                if (cbChild.isSelected())
                    pchild = child * 25.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 30.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 23.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice );
            }

            else if (departure == "Perak" & desti == "Melaka"){
                if (cbChild.isSelected())
                    pchild = child * 40.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 50.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 45.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM"  + totalPrice);
            }

            else if (departure == "Perak" & desti == "Kelantan"){
                if (cbChild.isSelected())
                    pchild = child * 46.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 50.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 50.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Perak" & desti == "Perak"){
                txprice.setText("invalid");
            }



            //departureSelangor
            if (departure == "Selangor" & desti == "Johor"){
                if (cbChild.isSelected())
                    pchild = child * 25.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 27.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 23.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice );
            }

            else if (departure == "Selangor" & desti == "Melaka"){
                if (cbChild.isSelected())
                    pchild = child * 20.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 25.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 22.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice );
            }

            else if (departure == "Selangor" & desti == "Perak"){
                if (cbChild.isSelected())
                    pchild = child * 25.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 30.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 23.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice );
            }

            else if (departure == "Selangor" & desti == "Kelantan"){
                if (cbChild.isSelected())
                    pchild = child * 56.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 65.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 53.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Selangor" & desti == "Selangor"){
                txprice.setText("invalid");
            }


            //departureKelantan
            if (departure == "Kelantan" & desti == "Johor"){
                if (cbChild.isSelected())
                    pchild = child * 66.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 70.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 60.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Kelantan" & desti == "Selangor"){
                if (cbChild.isSelected())
                    pchild = child * 56.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 65.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 53.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Kelantan" & desti == "Perak"){
                if (cbChild.isSelected())
                    pchild = child * 46.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 50.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 50.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Kelantan" & desti == "Melaka"){
                if (cbChild.isSelected())
                    pchild = child * 56.2;
                else
                    pchild = 0.0;

                if (cbAdult.isSelected())
                    padult = adult * 60.0;
                else
                    padult = 0.0;

                if (cbSenior.isSelected())
                    psenior = senior * 50.0;
                else
                    psenior = 0.0;


                totalPrice = pchild + padult + psenior;


                txprice.setText("RM" + totalPrice);
            }

            else if (departure == "Kelantan" & desti == "Kelantan"){
                txprice.setText("invalid");
            }


        }

        //receipt
        else if (event.getSource() == buttonPrint){
            Receipt r = new Receipt(name, departure, desti, (child + adult + senior),totalPrice );
        }
    }// end actionPerformed
    }//end pcHandler

    public static  void main(String[] args)
    {
        BusTicketSystem eg = new BusTicketSystem();

    }
}