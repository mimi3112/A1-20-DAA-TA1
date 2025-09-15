//Problem Statement 2
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();
        int[] heights = new int[n];

        System.out.println("Enter heights of histogram bars:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
