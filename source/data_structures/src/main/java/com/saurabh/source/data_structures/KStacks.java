package com.saurabh.source.data_structures;

import java.util.Arrays;

/**
 * k stacks in a single array in a time and space-efficient way. Problem at: https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
 */
public class KStacks {
  private final int[] elements; // Array of size arraySize to store actual content to be stored in stacks
  private final int[] topElementsIndexesPerStack; // Array of size numStacks to store indexes of topElementsIndexesPerStack elements of stacks
  private final int[] nextFreeSlotOrStackElementIndex; // Array of size arraySize to store nextFreeSlotOrStackElementIndex entry in all stacks and free list
  private int freeSlot; // To store beginning index of free list

  //constructor to create numStacks stacks in an array of size arraySize
  public KStacks(int numStacks, int arraySize) {
    // Initialize arraySize and numStacks, and allocate memory for all arrays
    elements = new int[arraySize];
    topElementsIndexesPerStack = new int[numStacks];
    nextFreeSlotOrStackElementIndex = new int[arraySize];
    initArrays();
  }

  private void initArrays() {
    Arrays.fill(topElementsIndexesPerStack, -1); // Initialize all stacks as empty
    freeSlot = 0; // Initialize all spaces as free
    for (int i = 0; i < nextFreeSlotOrStackElementIndex.length - 1; i++)
      nextFreeSlotOrStackElementIndex[i] = i + 1;
    nextFreeSlotOrStackElementIndex[nextFreeSlotOrStackElementIndex.length - 1] = -1; // -1 is used to indicate end of free list
  }

  public void push(int item, int stackNumber) {
    if (isArrayFull()) {
      throw new IllegalStateException("No space in array to hold anymore items");
    }

    int index = freeSlot; // index of first free slot
    elements[index] = item;
    freeSlot = nextFreeSlotOrStackElementIndex[index]; // Update free slot to index of nextFreeSlotOrStackElementIndex slot in free list
    nextFreeSlotOrStackElementIndex[index] = topElementsIndexesPerStack[stackNumber]; // Update nextFreeSlotOrStackElementIndex of topElementsIndexesPerStack and then topElementsIndexesPerStack for stack number 'stackNumber'
    topElementsIndexesPerStack[stackNumber] = index;
  }

  public int pop(int stackNumber) {
    if (isStackEmpty(stackNumber)) {
      throw new IllegalStateException("No items to pop");
    }

    int i = topElementsIndexesPerStack[stackNumber]; // Find index of topElementsIndexesPerStack item in stack number 'stackNumber'
    topElementsIndexesPerStack[stackNumber] = nextFreeSlotOrStackElementIndex[i]; // Change topElementsIndexesPerStack to store nextFreeSlotOrStackElementIndex of previous topElementsIndexesPerStack
    nextFreeSlotOrStackElementIndex[i] = freeSlot; // Attach the previous topElementsIndexesPerStack to the beginning of free list
    freeSlot = i;
    return elements[i]; // Return the previous topElementsIndexesPerStack item
  }

  private boolean isArrayFull() {
    return freeSlot == -1;
  }

  private boolean isStackEmpty(int stackNumber) {
    return topElementsIndexesPerStack[stackNumber] == -1;
  }
}
