package com.saurabh.source.data_structures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BloomFilterTest {
  @Test
  public void testFalsePositive() {
    // Create a small filter, and fill it up quickly. False positive guaranteed!
    BloomFilter bloomFilter = new BloomFilter(20, 0.9);
    bloomFilter.add("Saurabh");
    bloomFilter.add("Mahesh");
    bloomFilter.add("Somesh");
    bloomFilter.add("Batra");
    bloomFilter.add("Mohan");
    bloomFilter.add("Srijan");

    assertThat(bloomFilter.contains("Saurabh")).isTrue();
    assertThat(bloomFilter.contains("Mahesh")).isTrue();
    assertThat(bloomFilter.contains("Somesh")).isTrue();
    assertThat(bloomFilter.contains("Batra")).isTrue();
    assertThat(bloomFilter.contains("Mohan")).isTrue();
    assertThat(bloomFilter.contains("Srijan")).isTrue();
    assertThat(bloomFilter.contains("Agarwal")).isTrue();
  }

  @Test
  public void testNoFalsePositive() {
    BloomFilter bloomFilter = new BloomFilter(20, 0.1);
    bloomFilter.add("Saurabh");
    bloomFilter.add("Mahesh");
    bloomFilter.add("Somesh");
    bloomFilter.add("Batra");
    bloomFilter.add("Mohan");
    bloomFilter.add("Srijan");

    assertThat(bloomFilter.contains("Saurabh")).isTrue();
    assertThat(bloomFilter.contains("Mahesh")).isTrue();
    assertThat(bloomFilter.contains("Somesh")).isTrue();
    assertThat(bloomFilter.contains("Batra")).isTrue();
    assertThat(bloomFilter.contains("Mohan")).isTrue();
    assertThat(bloomFilter.contains("Srijan")).isTrue();
    assertThat(bloomFilter.contains("Agarwal")).isFalse();
  }
}