package design.struct.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 20160301301
 * Date: 2017/9/19 19:12
 * Comment:
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}