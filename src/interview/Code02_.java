package interview;

//import com.sun.org.apache.bcel.internal.classfile.Code;
//import java.util.concurrent.locks.*;

public class Code02_ {

    /**
     * 给定一个非负数组arr，和一个正数m
     * 返回arr的所有子序列中累加和%m之后的最大值。
     * 1.如果arr中的每个数字不大，怎么做？
     * 2.如果arr中的m的值很小，怎么做？
     * 3.如果arr长度很短，但是arr每个数字比较大并且m比较大呢？
     */
    public static void main(String[] args) {
        String ab = new String("a") + new String("b");
        ab.intern();
        String s1 = "ab";
        System.out.println(ab == s1);

    }
}
