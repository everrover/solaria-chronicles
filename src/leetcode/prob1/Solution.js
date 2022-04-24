class Num{
    constructor(num, pos){
        this.num = num
        this.pos = pos
    }
}

// using indexed number
var twoSum = function(nums, target) {
    const arr = []
    nums.forEach((a, idx)=>arr.push(new Num(a, idx)))
    arr.sort((a,b)=>(a.num-b.num))
    let l=0, r=arr.length-1
    while(l<r){
        let sum = arr[l].num + arr[r].num
        if(sum<target) l++
        else if(sum>target) r--;
        else return [arr[l].pos, arr[r].pos]
    }
    return []
};

// using map
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

let twoSum = function(nums, target) {
    const map = new Map()
    let ans
    nums.every((a, idx)=>{
        // console.log(idx)
        if(map.has(target-a)) {
            ans = [map.get(target-a), idx]
            return false
        }else map.set(a, idx)
        return true
    })
    return ans
};