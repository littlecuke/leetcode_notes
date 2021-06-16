import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //通过map存储，使用hash寻址对比,内存使用多
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                return new int[]{(int)map.get(val),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
    // 双循环
    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            int val = target - nums[i];
            for(int j = i;j<nums.length;j++){
                if(val == nums[j] && i!=j){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] ints1 = twoSum.twoSum(ints, 9);
        System.out.println(ints1);
    }
}
