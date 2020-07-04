package com.saurabh.practice.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumPlatformsTest {
    @Test
    public void testMinPlatformsNeededSomeCommonPlatforms() {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();
        int[] arrival = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        int platforms = minimumPlatforms.getMinimumPlatforms(arrival, departure);
        assertThat(platforms).isEqualTo(3);
    }

    @Test
    public void testMinPlatformsNeededAllDifferentPlatforms() {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();
        int[] arrival = new int[]{900, 905, 950, 900};
        int[] departure = new int[]{1000, 1200, 1320, 955};
        int platforms = minimumPlatforms.getMinimumPlatforms(arrival, departure);
        assertThat(platforms).isEqualTo(4);
    }

    @Test
    public void testMinPlatformsNeededArrivalDepartureTimeSame() {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();
        int[] arrival = new int[]{1000, 1200, 1320, 955};
        int[] departure = new int[]{1000, 1200, 1320, 955};
        int platforms = minimumPlatforms.getMinimumPlatforms(arrival, departure);
        assertThat(platforms).isEqualTo(1);
    }

    @Test
    public void testMinPlatformsNeededNoOverlap() {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();
        int[] arrival = new int[]{900, 1000, 1100, 1200};
        int[] departure = new int[]{1230, 1030, 1130, 930};
        int platforms = minimumPlatforms.getMinimumPlatforms(arrival, departure);
        assertThat(platforms).isEqualTo(1);
    }
}
