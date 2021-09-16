package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidsCollision {
    public static void main(String[] args) {
        System.out.println(checkAsteroidsCollision(new int[] {-2, 5, 10, -15}));
    }

    private static List<Integer> checkAsteroidsCollision(int [] ast) {
        if (ast.length <= 1) {
            return Arrays.stream(ast).boxed().collect(Collectors.toList());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ast.length; i++) {
            if (ast[i] > 0) {
                stack.push(ast[i]);
            }else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast[i]))
                    stack.pop();

                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(ast[i]);
                else if (Math.abs(stack.peek()) == ast[i]) {
                    stack.pop();
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.empty())
            list.add(stack.pop());
        return list;
    }
}
