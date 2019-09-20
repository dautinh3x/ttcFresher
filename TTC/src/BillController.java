import java.util.*;
import java.util.stream.Collectors;

public class BillController {
    List<Bill> billList = new ArrayList<>();

    public List<Bill> sort(List<Bill> bills) {
        Collections.sort(bills, new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                if (o1.getMoney() > o2.getMoney()) {
                    return 1;
                } else {
                    if (o1.getMoney() == o2.getMoney()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return bills;
    }


    public List<Bill> listBillByMoney(List<Bill> bills) {
        List<Bill> billList = new ArrayList<>();
        for (Bill bill : bills) {
            if (bill.getMoney() > 1000000) {
                billList.add(bill);
            }
        }
        return billList;
    }

    public List<String> date(List<Bill> bills) {
        List<String> s = new ArrayList<>();
//        for (Bill bill : bills) {
//            s.add(bill.getDate());
//        }
        bills.forEach(bill -> {
            s.add(bill.getDate());
        });
        Collection<String> list = s;
        List<String> distinctDate = list.stream().distinct().collect(Collectors.toList());
        return distinctDate;
    }

    public Map<String, List<Bill>> billByDate(List<Bill> bills) {
        Map<String, List<Bill>> map = new HashMap<String, List<Bill>>();

        bills.forEach(bill -> {
            List<Bill> b;
            if (map.containsKey(bill.getDate())) {
                b = map.get(bill.getDate());
            } else {
                b = new ArrayList<Bill>();
            }
            b.add(bill);
            map.put(bill.getDate(), b);
        });
        return map;
//        for (Bill bill : bills) {
//            if(map.containsKey(bill.getDate())) {
//                b = map.get(bill.getDate());
//            }else {
//                b = new ArrayList<Bill>();
//            }
//            b.add(bill);
//            map.put(bill.getDate(),b);
//        }
    }

    public Set<Bill> billSet(List<Bill> bills){
        Set<Bill> set = new HashSet<Bill>();
        for(Bill bill : bills) {
            set.add(bill);
        }
        return set;
    }
}
