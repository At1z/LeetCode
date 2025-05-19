class Solution {
    public String triangleType(int[] nums) {
    Arrays.sort(nums);
    if(nums[0] + nums[1] > nums[2]){
    Set<Integer> seen = new HashSet<>();
    for(int num: nums){
        seen.add(num);
    }   
    return (seen.size() == 1)?"equilateral":(seen.size() == 2)?"isosceles":"scalene";
    }
    return "none";
    }
}