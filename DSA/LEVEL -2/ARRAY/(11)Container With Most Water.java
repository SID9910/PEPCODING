class Solution {
    //approach-0(worst) tc =o(n2) //tle aaegi
    //brute force
//      public int maxArea(int[] height) {
//         int maxwater =Integer.MIN_VALUE;
//          for(int i=0;i<height.length;i++){
//              for(int j=i+1;j<height.length;j++){
//                  int h=Math.min(height[i],height[j]);
//                 int w=j-i;
//                  	maxwater = Math.max(maxwater,h*w);
//              }
//          }
	

// 	return maxwater;
//     }
// }

//height and width dono matter karti hai container main paani dalne main
    //Approach-01(best) tc=o(n)
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
	int maxwater = 0;//shuruat main kum hai

	while (left < right) {
        int w=right - left;//width of container
        int h= Math.min(height[left], height[right]);//minimum height consider karenge kyuki paani udher taak he bhara hoga
		maxwater = Math.max(maxwater,h*w);//aaagr maxwater se jada value then update
		if (height[left] < height[right]) //aagr jis side ki height kum uko eek shoft kar denge taaki or bda mill jay height
			left++;
		else
			right--;
	}

	return maxwater;
    }
}