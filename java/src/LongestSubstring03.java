
public class LongestSubstring03 {
    /**
     *
     * 双指针移动
     */
    public int lengthOfLongestSubstring(String s) {
        int len =s.length();
        if(len <2){
            return  len;
        }
        char[] str =s.toCharArray();
        int i=0;
        int j ,k,max=0;
        for(j = 0;j<len;j++){
            for(k = i;k<j;k++)
                if(str[k]==str[j]){
                    i = k+1;
                    break;
                }
            if(j-i+1 > max)
                max = j-i+1;
        }
        return max;
    }

    /**
     * <k:char  v:index>
     */
    public int lengthOfLongestSubstring2(String s) {


        return 0;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstring03 substring03 = new LongestSubstring03();
        int i = substring03.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
