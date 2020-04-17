package algorithm.practice;

/**
 * User: 20160301301
 * Date: 2017/10/31 14:02
 * 标题：替换空格
 * 描述：
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class ReplaceSpace {

    public String replace(StringBuffer str) {
        int blankCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
//        String s = str.toString().replaceAll("\\s", "%20");
            if (str.charAt(i) == ' ') {
                blankCount++;
            }
        }
        str.setLength(str.length() + blankCount * 2);
        int newLength = str.length() - 1;
        int oldLength = newLength - blankCount * 2;
        for (int i = oldLength; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            } else {
                str.setCharAt(newLength--, str.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "We Are Happy.";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replace(stringBuffer));
    }
}