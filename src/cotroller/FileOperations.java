package cotroller;

import model.InoviceHeader;
import model.InoviceLine;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations {
    public static ArrayList<InoviceHeader> readFile(String Path){
        ArrayList<InoviceHeader> InvHDRList = new ArrayList<InoviceHeader>();

        try {
            File myObj = new File(Path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                InoviceHeader invHdr = new InoviceHeader();
                String data = myReader.nextLine();
                String[] dataLine = data.split(",");
                invHdr.setInvNumber(Integer.parseInt(dataLine[0]));
                invHdr.setDate(dataLine[1]);
                invHdr.setCustomerName(dataLine[2]);
                invHdr.setTotalAmt(0d);
                InvHDRList.add(invHdr);
            }
            myReader.close();
        } catch (FileNotFoundException e1) {
            System.out.println("An error occurred.");
            e1.printStackTrace();
        }
        return InvHDRList;
    }
    public static ArrayList<InoviceLine> InvItemreadFile(String Path){
        ArrayList<InoviceLine> InvItemList = new ArrayList<InoviceLine>();

        try {
            File myObj = new File(Path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                InoviceLine InvItem = new InoviceLine();
                String data = myReader.nextLine();
                String[] dataLine = data.split(",");
                InvItem.setInvNumber(Integer.parseInt(dataLine[0]));
                InvItem.setItemName(dataLine[1]);
                InvItem.setItemPrice(Double.parseDouble(dataLine[2]));
                InvItem.setQuantity(Integer.parseInt(dataLine[3]));
                InvItemList.add(InvItem);
            }
            myReader.close();
        } catch (FileNotFoundException e1) {
            System.out.println("An error occurred.");
            e1.printStackTrace();
        }
        return InvItemList;
    }
    public static void Write(ArrayList<InoviceHeader> InvHdrList,File  fileToSave) {
        String fileContent = "";
        for (int i = 0; i < InvHdrList.size(); i++) {
            fileContent += InvHdrList.get(i).getInvNumber() + "," + InvHdrList.get(i).getDate() + ","
                    + InvHdrList.get(i).getCustomerName() + "," + InvHdrList.get(i).getTotalAmt() + "\r\n";
        }
        try {
            String FileName = fileToSave.getPath();
            FileWriter fw = new FileWriter(FileName, false); //the true will append the new data
            fw.write(fileContent);//appends the string to the file
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();

        }
    }
    public static void InvItemWrite(ArrayList<InoviceLine> InvItemList,File fileToSave) {
        String fileContent = "";
        for (int j = 0; j < InvItemList.size(); j++) {
            fileContent += ""
                    +InvItemList.get(j).getInvNumber()+","
                    +InvItemList.get(j).getItemName() +","
                    +InvItemList.get(j).getItemPrice() +","
                    +InvItemList.get(j).getQuantity()+ ","
                    + InvItemList.get(j).getItemFullPrice()
                    +"\r\n";
        }

        try {
            String FileName = fileToSave.getPath();
            FileWriter fw = new FileWriter(FileName,false); //the true will append the new data
            fw.write(fileContent);//appends the string to the file
            fw.close();
            JOptionPane.showMessageDialog(null, "Save File successfully");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
