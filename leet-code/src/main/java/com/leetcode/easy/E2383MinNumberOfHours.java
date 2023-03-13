package com.leetcode.easy;

/**
 * 2383. 赢得比赛需要的最少训练时长
 *
 * @author Wu.Chunyang
 */
public class E2383MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hours = 0;
        for (int i = 0; i < energy.length; i++) {
            while (initialEnergy <= energy[i] || initialExperience <= experience[i]) {
                hours++;
                if (initialEnergy <= energy[i]) {
                    initialEnergy++;
                } else {
                    initialExperience++;
                }
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return hours;
    }
}
