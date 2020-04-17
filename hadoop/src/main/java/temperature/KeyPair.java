package temperature;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * User: 20160301301
 * Date: 2018/3/8 20:01
 * Comment:
 */
public class KeyPair implements WritableComparable<KeyPair> {

    private int year;
    private int hot;

    @Override
    /**
     * partition时，每个分区内调用job.setSortComparatorClass()设置的key比较函数类排序
     * 如果没有通过job.setSortComparatorClass()设置key比较函数类，则使用key的实现的compareTo方法
     */
    public int compareTo(KeyPair o) {
        int res = Integer.compare(year, o.getYear());
        if (res != 0) {
            return res;
        }
        return Integer.compare(hot, o.getHot());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.write(year);
        dataOutput.write(hot);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.year = dataInput.readInt();
        this.hot = dataInput.readInt();
    }

    @Override
    public int hashCode() {
        return (year + "/" + hot).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        KeyPair k = (KeyPair) obj;
        int res1  = Integer.compare(year, k.getYear());
        int res2 = Integer.compare(hot, k.getHot());

        return (res1 == 0 && res2 == 0) ? true : false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("year", year)
                .append("hot", hot)
                .toString();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
}
