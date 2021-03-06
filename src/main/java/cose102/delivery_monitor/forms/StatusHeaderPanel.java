package cose102.delivery_monitor.forms;

import cose102.delivery_monitor.models.ParcelInformation;
import cose102.delivery_monitor.utils.Shortcuts;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class StatusHeaderPanel extends JPanel {
    private JLabel parcelNameLabel = new JLabel();
    private JLabel createdAtLabel = new JLabel();
    private JLabel invoiceLabel = new JLabel();
    private JLabel senderNameLabel = new JLabel();
    private JLabel receiverNameLabel = new JLabel();
    private JLabel receiverAddressLabel = new JLabel();
    private JLabel completedLabel = new JLabel();

    StatusHeaderPanel() {
        this.setBounds(10, 5, 430, 150);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.setLayout(new GridLayout(7, 1));

        JLabel[] labels = { createdAtLabel, invoiceLabel, senderNameLabel,
                            receiverNameLabel, receiverAddressLabel, completedLabel };

        parcelNameLabel.setFont(Constants.getFont(Font.BOLD, 15));
        for(JLabel label:labels) label.setFont(Constants.getFont());

        this.add(parcelNameLabel);
        for(JLabel label:labels) this.add(label);
    }

    void clear() {
        parcelNameLabel.setText("");
        createdAtLabel.setText("");
        invoiceLabel.setText("");
        senderNameLabel.setText("");
        receiverNameLabel.setText("");
        receiverAddressLabel.setText("");
        completedLabel.setText("");
    }

    void displayParcelInformation(ParcelInformation parcel) {
        parcelNameLabel.setText(parcel.getParcelName());
        createdAtLabel.setText("Registered: " + Shortcuts.dateTimeToString(parcel.getCreatedAt()));
        invoiceLabel.setText("Invoice Number: " +
                String.format("%s | %s", parcel.getCompany().getCompanyName(), parcel.getInvoiceNumber()));
        senderNameLabel.setText("Sender: " + parcel.getSenderName());
        receiverNameLabel.setText("Receiver: " + parcel.getReceiverName());
        receiverAddressLabel.setText("Address: " + parcel.getReceiverAddress());
        completedLabel.setText(parcel.isCompleted() ? "Completed" : "Incomplete");
    }
}
