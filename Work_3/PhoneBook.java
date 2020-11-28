package Work_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private final HashMap<String, ArrayList<Person>> mapKey = new HashMap<>();

    public void add(String name, String phone) {
        if (mapKey.containsKey(name)) {
            ArrayList<Person> person = mapKey.get(name);
            person.add(new Person(phone));
        } else {
            ArrayList<Person> person = new ArrayList<>();
            person.add(new Person(phone));
            mapKey.put(name, person);
        }
    }

    public ArrayList<String> getPhone(String name) {
        if (!mapKey.containsKey(name)) return null;
        ArrayList<Person> person = mapKey.get(name);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            res.add(person.get(i).phone);
        }
        return res;
    }
}
