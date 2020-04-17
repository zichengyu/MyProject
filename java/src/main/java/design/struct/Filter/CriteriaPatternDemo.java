package design.struct.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 20160301301
 * Date: 2017/9/19 19:21
 * Comment:
 */
public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria criteria = new AndCriteria(new CriteriaMale(), new CriteriaSingle());
        List<Person> female = criteria.meetCriteria(persons);
        System.out.println(female.toString());
    }
}