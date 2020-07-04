package com.saurabh.practice.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeadersInAnArrayTest {
    @Test
    public void testAllLeaders() {
        LeadersInAnArray leaders = new LeadersInAnArray();
        int[] leadersArray = leaders.getLeadersInAnArray(new int[]{9, 8, 7, 6, 5, 4});
        assertThat(leadersArray).containsExactly(9, 8, 7, 6, 5, 4);
    }

    @Test
    public void testOnlyRightmostLeader() {
        LeadersInAnArray leaders = new LeadersInAnArray();
        int[] leadersArray = leaders.getLeadersInAnArray(new int[]{0, 1, 2, 3, 4});
        assertThat(leadersArray).containsExactly(4);
    }

    @Test
    public void testArbitraryLeaders() {
        LeadersInAnArray leaders = new LeadersInAnArray();
        int[] leadersArray = leaders.getLeadersInAnArray(new int[]{2, 8, 1, 3, 5, 4});
        assertThat(leadersArray).containsExactly(8, 5, 4);
    }

    @Test
    public void testNegativeNumbers() {
        LeadersInAnArray leaders = new LeadersInAnArray();
        int[] leadersArray = leaders.getLeadersInAnArray(new int[]{-2, -3, -6, -5, -4});
        assertThat(leadersArray).containsExactly(-2, -3, -4);
    }

    @Test
    public void testZeroPositiveNegativeNumbers() {
        LeadersInAnArray leaders = new LeadersInAnArray();
        int[] leadersArray = leaders.getLeadersInAnArray(new int[]{0, 1, 1, -2, -1});
        assertThat(leadersArray).containsExactly(1, 1, -1);
    }

    @Test
    public void testAllSameNumbers() {
        LeadersInAnArray leaders = new LeadersInAnArray();
        int[] leadersArray = leaders.getLeadersInAnArray(new int[]{0, 0, 0, 0, 0});
        assertThat(leadersArray).containsExactly(0, 0, 0, 0, 0);
    }
}
