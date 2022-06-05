package Bank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static long balanceNumber = 1000000;
    List<TransactionHistory> listHistory = new ArrayList<TransactionHistory>();


    public long getBalanceNumber(){
        return balanceNumber;
    }
    public static long transfer(long money) {

        if (money >= 50000 && money <= balanceNumber) {
            System.out.println("Thành công");
        } else if (money > balanceNumber) {
            System.out.println("Trong tài khoản không đủ tiền");
        } else if (money<50000){
            System.out.println("Số tiền tối thiểu trong 1 lần chuyển là 50.000");
        }
        balanceNumber = balanceNumber - money;
        return balanceNumber;
    }

    public void actionTransfer() {
        System.out.println("Nhập ID của tài khoản bạn muốn gửi: ");
        String beneficiaryAccount = new Scanner(System.in).nextLine();
        System.out.println("Nhập tin nhắn kèm : ");
        String description = new Scanner(System.in).nextLine();
        System.out.println("Nhập số tiền muốn chuyển: ");
        long money = new Scanner(System.in).nextInt();
        transfer(money);
        TransactionHistory t = new TransactionHistory(beneficiaryAccount, description, money);
        listHistory.add(t);
    }

    public void getHistory() {
        for (TransactionHistory s: listHistory) {
            s.printHistory();
        }
    }


    public static String formatMoney(long money){
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(money);
    }



}
