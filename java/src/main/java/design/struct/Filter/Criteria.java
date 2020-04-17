package design.struct.Filter;

import java.util.List;

/**
 * Creator      : 20160301301
 * Created Date : 2017/9/19
 * Comment      : 19:11
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
