package stringExample;

import org.omg.CORBA.MARSHAL;

import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;

public class StringController {

    public int getTotalCharacter(String s, char character) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    public void getIndexCharacter(String s, char character) {
        int start = s.indexOf(character);
        int end = s.lastIndexOf(character);

        System.out.println("Start = " + start + " End = " + end);
        System.out.println("Index n = ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == character) {
                if (i != start && i != end) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public int getTotalString(String s, String string) {
        int count = 0;
        String tmp[] = s.trim().split(" ");
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals(string)) {
                count++;
            }
        }
        return count;
    }

    public void getIndexString(String s, String string) {
        int start = s.indexOf(string);
        int end = s.lastIndexOf(string);
        String tmp[] = s.trim().split(" ");
        System.out.println("Start = " + start + " End = " + end);
        System.out.println("Index n = ");
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals(string)) {
                if (i != start && i != end) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public String concatString(List<String> strings) {
        String result = "";
        String tmp[] = strings.toArray(new String[0]);

        for (int i = 0; i < strings.size(); i++) {
            result = result.concat(tmp[i]);
            if (i != tmp.length - 1) {
                result = result.concat(",");
            }
        }
        return result;
    }

    public List<String> cutString(String strings) {
        List<String> stringList = new ArrayList<>();
        String tmp[] = strings.trim().split(",");
        for (int i = 0; i < tmp.length; i++) {
            stringList.add(tmp[i]);
        }
        return stringList;
    }

    public String replaceString(String raw, String from, String to) {
        String result = raw.replace(from, to);
        return result;
    }

    public Map<String, Integer> getCharacterMax(String s) {
        String tmp[] = s.trim().split("(?!^)");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length; i++) {
            if (!map.containsKey(tmp[i])) {
                map.put(tmp[i], 1);
            } else {
                map.put(tmp[i], map.get(tmp[i]) + 1);
            }
        }
        int max = Collections.max(map.values());
        Map<String, Integer> map1 = new HashMap<>();

        map.forEach((key, value) -> {
            if (value >= max) {
                map1.put(key, value);
            }
        });
        return map1;
    }

    public Map<String, Integer> totalString(String s) {
        String tmp[] = s.trim().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length; i++) {
            if (!map.containsKey(tmp[i])) {
                map.put(tmp[i], 1);
            } else {
                map.put(tmp[i], map.get(tmp[i]) + 1);
            }
        }
        return map;
    }

    public List<String> getListSubString(String s) {
        String tmp[] = s.trim().split(" ");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            stringList.add(tmp[i]);
        }
        Collection<String> list = stringList;
        List<String> distinct = list.stream().distinct().collect(Collectors.toList());
        return distinct;
    }

}