package main

import "fmt"

// 双指针
func twoSum(nums []int, target int) []int {
	i := 0
	j := len(nums)-1
	for  i < j{
		if target == nums[i]+nums[j]  {
			return []int{i,j}
		}
		j--
		if j == i {
			i++
			j= len(nums)-1
			continue
		}
	}
	return []int{}
}

func twoSum2(nums []int, target int) []int {
	for i := 0; i <len(nums);i++{
		for j :=i+1; j <len(nums);j++{
			if nums[i]+nums[j] == target {
				return []int{i,j}
			}
		}
	}
	return []int{}
}

func main() {
	var sum = []int{2,5,5,11}
	its := twoSum2(sum, 10)
	fmt.Println(its)
}