package design.struct.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 20160301301
 * Date: 2017/9/19 19:13
 * Comment:
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}