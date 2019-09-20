import java.util.*;

public class Main {
    public static void main(String[] args) {
        BillController billController = new BillController();
        List<Bill> billList = new ArrayList<>();
        billList.add(new Bill(1,"Smith",1500000,"2019-09-18"));

        billList.add(new Bill(1,"Smith",1000000,"2019-09-18"));
        billList.add(new Bill(3,"Alice",200000,"2019-09-17"));
        billList.add(new Bill(4,"Tom",800000,"2019-09-16"));
        billList.add(new Bill(5,"Venus",3000000,"2019-09-16"));
        billList.add(new Bill(6,"Smile",800000,"2019-09-16"));

        System.out.println("Sort by money:");
        System.out.println(billController.sort(billList).toString());

        System.out.println("Money > 1000000 :");
        System.out.println(billController.listBillByMoney(billList).toString());

        System.out.println("Date invoicing:");
        System.out.println(billController.date(billList));

        System.out.println("Bill date :");
        System.out.println(billController.billByDate(billList));

        System.out.println("Bill distinct by id and name :");
        System.out.println(billController.billSet(billList));


    }
}
