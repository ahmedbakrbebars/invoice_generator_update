package view;

import cotroller.Controller;
import cotroller.FileOperations;
import model.InoviceHeader;
import model.InoviceLine;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainFrame  extends JFrame {
    private JPanel Leftpanel;
    private JPanel Rightpanel;
    private JButton CreateInv;
    private JButton DeleteInv;
    private JButton DeleteBtn;
    private JButton CreateLineBtn;

    private JLabel InvTable;
    private JLabel InvNum;
    private JLabel InvCount;
    private JLabel InvDate;
    private JLabel CustomerName;
    private JLabel InvTOT;
    private JLabel InvAmnt;
    private JLabel InvItems;

    private JTextField InvDateTxt;
    private JTextField CustomerNameTxt;

    private JTable InvoiceTable;
    private JTable InvItemsTable;

    private JMenuBar MainMenu;
    private JMenu MenuFile;
    private JMenuItem LoadFile;
    private JMenuItem SaveFile;

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
    public MainFrame() {
        super();
        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        //setLayout(new FlowLayout());

        CreateInv = new JButton();
        DeleteInv = new JButton();
        DeleteBtn = new JButton();
        CreateLineBtn = new JButton();

        InvTable = new JLabel();
        InvNum = new JLabel();
        InvCount = new JLabel();
        InvDate = new JLabel();
        CustomerName = new JLabel();
        InvTOT = new JLabel();
        InvAmnt = new JLabel();
        InvItems = new JLabel();


        InvDateTxt = new JTextField();
        CustomerNameTxt = new JTextField();

        InvoiceTable = new JTable();
        InvItemsTable = new JTable();
        MainMenu = new JMenuBar();
        MenuFile = new JMenu("File");
        LoadFile = new JMenuItem("Load File");
        SaveFile = new JMenuItem("Save File");


        MenuFile.add(LoadFile);
        MenuFile.add(SaveFile);
        MainMenu.add(MenuFile);
        setJMenuBar(MainMenu);
        Rightpanel =new JPanel();
        Leftpanel = new JPanel();



        CreateInv.setText("Create New Invoice");
        DeleteInv.setText("Delete Invoice");
        DeleteBtn.setText("Delete Item");
        CreateLineBtn.setText("Create New Item");

        InvTable.setText("Invoices Table");
        InvNum.setText("Invoice Number");
        InvCount.setText("0");
        InvDate.setText("Invoices Date");
        CustomerName.setText("Customer Name");
        InvTOT.setText("Invoices Total");
        InvAmnt.setText("0 EGP");
        InvItems.setText("Invoices Items");


        InvoiceTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "No.", "Date", "Customer", "Total"
                }
        ));

        InvItemsTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "No.", "Item Name", "Item Price", "Count","Item Total"
                }
        ));
        JScrollPane scroll1 =  new JScrollPane(InvoiceTable);
        JScrollPane scroll2 =  new JScrollPane(InvItemsTable);

        Dimension size = InvoiceTable.getPreferredSize();
        CreateInv.setBounds(30,600,200,30);
        DeleteInv.setBounds(250,600,200,30);
        InvTable.setBounds(30,0,200,30);
        scroll1.setBounds(30,65,600,500);
        Leftpanel.setLayout(null);

        InvTable.setSize(1000,100);
        Leftpanel.add(InvTable);
        Leftpanel.add(scroll1);
        Leftpanel.add(CreateInv);
        Leftpanel.add(DeleteInv);

        Rightpanel.setLayout(null);

        CreateLineBtn.setBounds(30,600,150,30);
        DeleteBtn.setBounds(190,600,150,30);

        InvNum.setBounds(30,40,100,30);
        InvCount.setBounds(150,40,100,30);
        InvDate.setBounds(30,70,100,30);
        InvDateTxt.setBounds(150,70,100,30);
        CustomerName.setBounds(30,100,100,30);
        CustomerNameTxt.setBounds(150,100,100,30);

        InvTOT.setBounds(30,130,100,30);
        InvAmnt.setBounds(150,130,100,30);
        InvItems.setBounds(30,170,100,30);
        scroll2.setBounds(30,200,600,370);


        Rightpanel.add(InvDate);
        Rightpanel.add(InvDateTxt);

        Rightpanel.add(InvNum);
        Rightpanel.add(InvCount);
        Rightpanel.add(CustomerName);
        Rightpanel.add(InvTOT);
        Rightpanel.add(InvAmnt);
        Rightpanel.add(InvItems);
        Rightpanel.add(CustomerNameTxt);
        Rightpanel.add(scroll2);
        Rightpanel.add(DeleteBtn);
        Rightpanel.add(CreateLineBtn);


        add(Leftpanel);
        add(Rightpanel);
        InvoiceTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        InvItemsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        //Load Last inital status
        DefaultTableModel InvoiceTablemodel = (DefaultTableModel) InvoiceTable.getModel();
        DefaultTableModel InvItemModel1 = (DefaultTableModel) InvItemsTable.getModel();
        ArrayList<InoviceHeader> InVlist = new ArrayList<InoviceHeader>();
        ArrayList<InoviceLine> InvItemList = new ArrayList<InoviceLine>();

//        InvoiceTablemodel.setRowCount(0);
//
//
//        ArrayList<InvoiceHeader> InVlist = FileOperations.readFile("DataFiles/InvoiceHeader.csv");
//        for (int i = 0; i < InVlist.size(); i++) {
//            InvoiceTablemodel.addRow(new Object[]{InVlist.get(i).getInvNumber(),
//                    InVlist.get(i).getDate(),InVlist.get(i).getCustomerName(),InVlist.get(i).getTotalAmt()});
//        }
//
//        ArrayList<InvoiceLine> InvItemList = FileOperations.InvItemreadFile("DataFiles/InvoiceLine.csv");
//
//
//        //Adding Items To total Invoice Amount
//        for (int i = 0; i < InvItemList.size(); i++) {
//            for (int j = 0; j < InvoiceTablemodel.getRowCount(); j++) {
//                if ((InvoiceTablemodel.getValueAt(j,0)+"").equals(InvItemList.get(i).getInvNumber()+""))
//                {
//                    Double TableValue = Double.parseDouble(InvoiceTablemodel.getValueAt(j,3).toString());
//                    Double ItemPrice = InvItemList.get(i).getItemFullPrice();
//                    InvoiceTablemodel.setValueAt( TableValue +ItemPrice
//                            ,j,3);
//                }
//            }
//        }
//        for (int i = 0; i < InVlist.size(); i++) {
//            String out =  "Invoice" + InVlist.get(i).getInvNumber()+"\n" +
//                    "{\n" +
//                    "\t" + InVlist.get(i).getDate()+","+InVlist.get(i).getCustomerName()+"\n";
//            for (int j = 0; j < InvItemList.size(); j++) {
//                if (InVlist.get(i).getInvNumber() == InvItemList.get(j).getInvNumber())
//                    out += "\t" + InvItemList.get(j).getItemName()+"," + InvItemList.get(j).getItemPrice()
//                            + ","+ InvItemList.get(j).getQuantity()+ "\n";
//            }
//            out += "}";
//            System.out.println(out);
//        }

        InvoiceTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try {
                    InvItemModel1.setRowCount(0);
                    for (int i = 0; i < InvItemList.size(); i++) {
                        if ((InvItemList.get(i).getInvNumber() + "").equals(InvoiceTable.getValueAt(InvoiceTable.getSelectedRow(), 0).toString())) {

                            InvItemModel1.addRow(new Object[]{InvItemList.get(i).getInvNumber(),
                                    InvItemList.get(i).getItemName(),
                                    InvItemList.get(i).getItemPrice(),
                                    InvItemList.get(i).getQuantity(),
                                    InvItemList.get(i).getItemFullPrice()});
                            InvCount.setText(InvoiceTable.getValueAt(InvoiceTable.getSelectedRow(), 0).toString());
                            InvDateTxt.setText(InvoiceTable.getValueAt(InvoiceTable.getSelectedRow(), 1).toString());
                            CustomerNameTxt.setText(InvoiceTable.getValueAt(InvoiceTable.getSelectedRow(), 2).toString());
                            InvAmnt.setText(InvoiceTable.getValueAt(InvoiceTable.getSelectedRow(), 3).toString());
                            InvoiceTable.addNotify();
                        }
                    }
                }catch (Exception e){
                    //do nothing
                    e.printStackTrace();
                }
            }
        });

        setSize(800,800);
        setLocation(200,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Sales Invoice Generator");
        CreateInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField field1 = new JTextField();
                JTextField field2 = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Invoice Date:"));
                panel.add(field1);
                panel.add(new JLabel("Customer Name:"));
                panel.add(field2);
                int result = JOptionPane.showConfirmDialog(null, panel, "Create Invoice",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    InoviceHeader InvHdr = new InoviceHeader();
                    if (InvoiceTablemodel.getRowCount() >0 ){
                        InvHdr.setInvNumber(Integer.parseInt(InvoiceTablemodel.getValueAt((InvoiceTablemodel.getRowCount()-1),0).toString()) + 1);
                        InvoiceTablemodel.addRow(new Object[]{Integer.parseInt(InvoiceTablemodel.getValueAt((InvoiceTablemodel.getRowCount()-1),
                                0).toString()) + 1, field1.getText(), field2.getText(),0.0d});
                    }else {
                        InvHdr.setInvNumber(1);
                    }
                    InvHdr.setDate(field1.getText());
                    InvHdr.setCustomerName(field2.getText());
                    InvHdr.setTotalAmt(0.0d);
                    InVlist.add(InvHdr);
                } else {
                    System.out.println("Cancelled");
                }

            }
        });
        DeleteInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.DeleteInv(InvoiceTable,InvItemList,InvoiceTablemodel);
            }
        });



        DeleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.DeleteBtn(InvItemsTable,InvItemModel1,InvItemList,InvoiceTablemodel);
            }
        });
        CreateLineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (InvoiceTable.getSelectedRow() != -1) {
                    JTextField field1 = new JTextField();
                    JTextField field2 = new JTextField();
                    JTextField field3 = new JTextField();

                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    panel.add(new JLabel("Item name:"));
                    panel.add(field1);
                    panel.add(new JLabel("Item Count:"));
                    panel.add(field2);
                    panel.add(new JLabel("Item Price:"));
                    panel.add(field3);
                    int result = JOptionPane.showConfirmDialog(null, panel, "Create Item",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {

                        InoviceLine Item = new InoviceLine();
                        Item.setInvNumber(Integer.parseInt(InvoiceTable.getValueAt((InvoiceTable.getSelectedRow()), 0).toString()));
                        Item.setItemName(field1.getText());
                        Item.setItemPrice(Double.parseDouble(field3.getText()));
                        Item.setQuantity(Integer.parseInt(field2.getText()));
                        InvItemList.add(Item);
                        InvItemModel1.addRow(new Object[]{Item.getInvNumber()
                                , Item.getItemName(),Item.getItemPrice(), Item.getQuantity(), Item.getItemFullPrice()});
                        for (int i = 0; i < InvoiceTablemodel.getRowCount(); i++) {
                            if (Integer.parseInt(InvoiceTablemodel.getValueAt(i,0).toString()) == Item.getInvNumber()){
                                int sum = 0;
                                for (int j = 0; j < InvItemList.size(); j++) {
                                    if (Item.getInvNumber() == InvItemList.get(j).getInvNumber()){
                                        sum += InvItemList.get(j).getItemFullPrice();
                                    }
                                }
                                InvoiceTablemodel.setValueAt(sum,i,3);
                            }
                        }
                    } else {
                        System.out.println("Cancelled");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Kindly Select Invoice to add Item in");
                }
            }
        });
        LoadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int k = 0; k < 2; k++) {


                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue = jfc.showOpenDialog(null);
                    File selectedFile = null;
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        selectedFile = jfc.getSelectedFile();
                    }

                    DefaultTableModel InvoiceTablemodel = (DefaultTableModel) InvoiceTable.getModel();
                    DefaultTableModel InvItemsTablemodel = (DefaultTableModel) InvItemsTable.getModel();

                    if (selectedFile.getName().contains("InvoiceHeader.csv")) {
                        InvoiceTablemodel.setRowCount(0);
                        ArrayList<InoviceHeader> InVlist1 = FileOperations.readFile(selectedFile.getAbsolutePath());
                        for (int i = 0; i < InVlist1.size(); i++) {
                            InvoiceTablemodel.addRow(new Object[]{InVlist1.get(i).getInvNumber(),
                                    InVlist1.get(i).getDate(), InVlist1.get(i).getCustomerName(), InVlist1.get(i).getTotalAmt()});
                        }
                        InVlist.addAll(InVlist1);
                    }
                    if (selectedFile.getName().contains("InvoiceLine.csv")) {
                        InvItemsTablemodel.setRowCount(0);
                        ArrayList<InoviceLine> InvItemList1 = FileOperations.InvItemreadFile(selectedFile.getAbsolutePath());

                        InvItemList.clear();
                        InvItemList.addAll(InvItemList1);
                        for (int j = 0; j < InvoiceTablemodel.getRowCount(); j++) {
                            InvoiceTablemodel.setValueAt(0d , j, 3);
                        }
                        //Adding Items To total Invoice Amount
                        for (int i = 0; i < InvItemList1.size(); i++) {
                            for (int j = 0; j < InvoiceTablemodel.getRowCount(); j++) {
                                if ((InvoiceTablemodel.getValueAt(j, 0) + "").equals(InvItemList1.get(i).getInvNumber() + "")) {
                                    Double TableValue = Double.parseDouble(InvoiceTablemodel.getValueAt(j, 3).toString());
                                    Double ItemPrice = InvItemList1.get(i).getItemFullPrice();
                                    InvoiceTablemodel.setValueAt(TableValue + ItemPrice
                                            , j, 3);
                                }
                            }
                        }
                    }


                    for (int i = 0; i < InVlist.size(); i++) {
                        String out =  "Invoice" + InVlist.get(i).getInvNumber()+"\n" +
                                "{\n" +
                                "\t" + InVlist.get(i).getDate()+","+InVlist.get(i).getCustomerName()+"\n";
                        for (int j = 0; j < InvItemList.size(); j++) {
                            if (InVlist.get(i).getInvNumber() == InvItemList.get(j).getInvNumber())
                                out += "\t" + InvItemList.get(j).getItemName()+"," + InvItemList.get(j).getItemPrice()
                                        + ","+ InvItemList.get(j).getQuantity()+ "\n";
                        }
                        out += "}";
                        System.out.println(out);
                    }

                }
            }
        });
        SaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame parentFrame = new JFrame();

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");
                fileChooser.setSelectedFile(new File("EditedInvoiceHeader.csv"));
                int userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    String fileContent = "";
                    ArrayList<InoviceHeader> EditInvList = new ArrayList<>();

                    for (int j = 0; j < InvoiceTablemodel.getRowCount(); j++) {

                        InoviceHeader inv = new InoviceHeader();
                        inv.setInvNumber(Integer.parseInt(InvoiceTablemodel.getValueAt(j, 0).toString()));
                        inv.setDate(InvoiceTablemodel.getValueAt(j, 1).toString());
                        inv.setCustomerName(InvoiceTablemodel.getValueAt(j, 2).toString());
                        inv.setTotalAmt(Double.parseDouble(InvoiceTablemodel.getValueAt(j, 3).toString()));
                        EditInvList.add(inv);
                    }
                    FileOperations.Write(EditInvList,fileToSave);
                }

                parentFrame = new JFrame();

                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");
                fileChooser.setSelectedFile(new File("EditedInvoiceLine.csv"));
                userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    FileOperations.InvItemWrite(InvItemList, fileToSave);
                }
            }

        });

    }
}
