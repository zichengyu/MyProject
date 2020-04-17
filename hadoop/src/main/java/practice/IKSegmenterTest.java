package practice;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * User: 20160301301
 * Date: 2018/3/10 10:31
 * Comment: IK分词器
 */
public class IKSegmenterTest {
    public static void main(String[] args) throws IOException {
        String s = "你知道九阳豆浆机吗？我觉得格力的牌子不错，每天可以自己整点豆浆喝！";
        StringReader reader = new StringReader(s);
        IKSegmenter ikSegmenter = new IKSegmenter(reader, true);
        Lexeme word = null;
        while ((word = ikSegmenter.next()) != null) {
            String w = word.getLexemeText();
            System.out.println(w);
        }
    }
}
