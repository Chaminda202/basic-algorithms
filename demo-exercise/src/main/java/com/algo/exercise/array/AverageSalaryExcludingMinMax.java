package com.algo.exercise.array;

public class AverageSalaryExcludingMinMax {
    public static void main(String[] args) {
        System.out.println(findAverageSalaryExcludingMinMax(new double[] {1000, 3000, 8000, 6000, 4000}));
    }

    private static double findAverageSalaryExcludingMinMax(double [] salaries) {
        double minSalary = salaries[0], maxSalary = salaries[0], total = 0;
        for (int i = 0; i < salaries.length; i++) {
            minSalary = Math.min(minSalary, salaries[i]);
            maxSalary = Math.max(maxSalary, salaries[i]);
        }

        for (int i = 0; i < salaries.length; i++) {
            if (minSalary != salaries[i] && maxSalary != salaries[i]) {
                total += salaries[i];
            }
        }
        return total/(salaries.length - 2);
    }
}
