import javax.swing.*;
import java.awt.*;

public class Receipt extends JFrame {
    JLabel lblName, lblDepart, lblDestination, lblQuantity, lblTotal;
    public Receipt(String name, String departure, String destination, int quantity, double total){
        super("Receipt");

        JLabel lblTitle = new JLabel("RECEIPT");
        JPanel panelTitle = new JPanel();
        panelTitle.add(lblTitle);

        JPanel panelCenter = new JPanel(new GridLayout(6, 2));
        JLabel lbName = new JLabel("Name: ");
        JLabel lbDepart = new JLabel("Departure: ");
        JLabel lbDestination = new JLabel("Destination: ");
        JLabel lbQuantity = new JLabel("Quantity: ");
        JLabel lbTotal = new JLabel("Total: RM");
        lblName = new JLabel(name);
        lblDepart = new JLabel(departure);
        lblDestination = new JLabel(destination);
        lblQuantity = new JLabel(String.valueOf(quantity));
        lblTotal = new JLabel(String.valueOf(total));

        panelCenter.add(lbName);
        panelCenter.add(lblName);
        panelCenter.add(lbDepart);
        panelCenter.add(lblDepart);
        panelCenter.add(lbDestination);
        panelCenter.add(lblDestination);
        panelCenter.add(lbQuantity);
        panelCenter.add(lblQuantity);
        panelCenter.add(lbTotal);
        panelCenter.add(lblTotal);

        this.getContentPane().add(panelTitle, BorderLayout.NORTH);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);

        this.setSize(400,400);
        //this.show();
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
    }
}
