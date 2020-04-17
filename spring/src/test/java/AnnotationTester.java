import com.yzc.spring.aop.AnnotationAspect;
import com.yzc.spring.transation.TestTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :  20160301301
 * @date : 2018/9/6 10:15
 */
@ContextConfiguration(locations = {"classpath*:/*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationTester {
    @Autowired
    TestTransaction testTransaction;
    @Autowired
    ApplicationContext app;

    @Test
    public void test() {
        System.out.println("=====这是一条华丽的分割线======");
        AnnotationAspect aspect = app.getBean(AnnotationAspect.class);
        testTransaction.transaction();
        System.out.println("=====这是一条华丽的分割线======");
        try {
            testTransaction.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
