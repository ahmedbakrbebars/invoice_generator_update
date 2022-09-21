package model;

import java.util.ArrayList;
import java.util.Date;

public class InoviceHeader {
    private int InvNumber;

    private String Date;
    private String CustomerName;

    private Double TotalAmt;

    public Double getTotalAmt() {
        return TotalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        TotalAmt = totalAmt;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getInvNumber() {
        return InvNumber;
    }

    public void setInvNumber(int invNumber) {
        InvNumber = invNumber;
    }

}
