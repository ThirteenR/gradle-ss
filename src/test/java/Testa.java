import com.chris.project.test.operation.ITestForService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest(classes = MyApp.class)
@Log4j2
public class Testa {
    @Autowired
    ITestForService testForService;
    @Test
    public void test1(){
        String s = "iuuuijkhjkhyt";
//        int len = getAnInt(s);
        int[] nums1 = new int[]{2,3,4,5,6,7};
        int[] nums2 = new int[]{3,6};
        double marge = marge(nums1, nums2);
        System.out.println(marge);
//        int maxLen = getMaxLen(s);
//
//        System.out.println(maxLen);
    }

    public static double marge(int[] nums1, int[] nums2) {
        int[] marge = new int[nums1.length + nums2.length];
        int in1 = 0;
        int in2 = 0;
        for (int i = 0; i < marge.length; i++) {
            int n1,  n2;
            if (in1 < nums1.length) {
                n1 = nums1[in1];
            } else {
                System.arraycopy(nums2, in2, marge, in1 + in2, nums2.length - in2);
                break;
            }
            if (in2 < nums2.length) {
                n2 = nums2[in2];
            } else {
                System.arraycopy(nums1, in1, marge, in1 + in2, nums1.length - in1);
                break;
            }
            if (n1 < n2) {
                in1++;
                marge[i] = n1;
            } else {
                in2++;
                marge[i] = n2;
            }
        }

        if ((marge.length & 1) == 1) {
            return marge[marge.length >> 1];
        } else{
            int s = marge.length >> 1;
            int end = (marge[s] + marge[s - 1]);
            return end == 0 ? 0 : (end & 1) == 0 ? end >> 1 : (end >> 1)+ 0.5;
        }
    }
    private int getMaxLen(String s) {
        int length = s.length();
        HashMap<Character, Integer> charsHash = new HashMap<>();
        charsHash.put(s.charAt(0), 0);
        int maxLen = 1;
        for (int start = 0, end = 1;  start < length && end < length; end++) {
            char c = s.charAt(end);
            if (charsHash.containsKey(c)) {
                start = Math.max(charsHash.get(c) + 1, start);
            }
            charsHash.put(c, end);
            int len = 0;
            if ((len = (end - start + 1)) > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    private int getAnInt(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int len = 0;
        int maxLen = 0;
        HashMap<Character, Integer> characters = new HashMap<>();
        while (end < chars.length) {
            // 获取右指针位置的char
            char aChar = chars[end];
            boolean b = characters.containsKey(aChar);
            // 判断当前字符是否包含在hashmap中,并且字符索引在左指针的右侧或重叠；
            // 说明当前子串有重复；
            // 更新字串起始位置start到上一个重复位置索引的下一位
            if (b && characters.get(aChar) >= start) {
                if (len > maxLen) {
                    maxLen = len;
                }
                start = characters.get(aChar) + 1;
                len = end - start;
            }
            characters.put(aChar, end);
            end++;
            len++;
        }
        return len;
    }
}
