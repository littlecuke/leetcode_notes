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

func main() {
	var sum = []int{2,7,11,15}
	its := twoSum(sum, 9)
	fmt.Println(its)
}