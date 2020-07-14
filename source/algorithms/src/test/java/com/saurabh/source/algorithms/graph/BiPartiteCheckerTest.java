package com.saurabh.source.algorithms.graph;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BiPartiteCheckerTest {
  @Test
  public void testNoEdges() {
    BiPartiteChecker biPartiteChecker = new BiPartiteChecker();
    int[][] graph = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
    };
    boolean result = biPartiteChecker.isBiPartite(graph);
    assertThat(result).isTrue();
  }

  @Test
  public void testFullyConnectedGraph() {
    BiPartiteChecker biPartiteChecker = new BiPartiteChecker();
    int[][] graph = {
        {0, 1, 1},
        {1, 0, 1},
        {1, 1, 0},
    };
    boolean result = biPartiteChecker.isBiPartite(graph);
    assertThat(result).isFalse();
  }

  @Test
  public void testSelfLoops() {
    BiPartiteChecker biPartiteChecker = new BiPartiteChecker();
    int[][] graph = {
        {1, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
    };
    boolean result = biPartiteChecker.isBiPartite(graph);
    assertThat(result).isFalse();
  }

  @Test
  public void testNoBipartite_1() {
    BiPartiteChecker biPartiteChecker = new BiPartiteChecker();
    int[][] graph = {
        {0, 1, 1, 1, 0},
        {1, 0, 1, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 0, 0, 1, 0},
    };
    boolean result = biPartiteChecker.isBiPartite(graph);
    assertThat(result).isFalse();
  }

  @Test
  public void testNoBipartite_2() {
    BiPartiteChecker biPartiteChecker = new BiPartiteChecker();
    int[][] graph = {
        {0, 0, 0, 0, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 1, 1, 0, 1},
        {1, 1, 1, 0, 0},
    };
    boolean result = biPartiteChecker.isBiPartite(graph);
    assertThat(result).isFalse();
  }

  @Test
  public void testBipartite() {
    BiPartiteChecker biPartiteChecker = new BiPartiteChecker();
    int[][] graph = {
        {0, 0, 0, 0, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 1, 1, 0, 0},
        {1, 1, 1, 0, 0},
    };
    boolean result = biPartiteChecker.isBiPartite(graph);
    assertThat(result).isTrue();
  }
}