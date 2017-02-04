# Created by ellioe03 at 03/02/2017
Feature: arraySorter
  # sorts a list of integers in descending order

  # Create a program using arrays that sorts a list of integers in descending order.
  # Descending order is highest value to lowest.
  # In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
  # ultimately have an array with 106,81,26, 15, 5 in it.
  # Set up the program so that the numbers to sort are read in from the keyboard.
  # Implement the following methods - getIntegers, printArray, and sortIntegers
  # getIntegers returns an array of entered integers from keyboard
  # printArray prints out the contents of the array
  # and sortIntegers should sort the array and return a new array containing the sorted numbers
  # you will have to figure out how to copy the array elements from the passed array into a new
  # array and sort them and return the new sorted array.

  Scenario Outline: arraySorter sorts a list of integers in descending order and prints out result
    When list of integers <list> with <number> of entries is input
    Then arraySorter sorts list
    And outputs sorter array that matches "<expectedResult>"
    Examples:
      | list                       | number | expectedResult          |
      | 1,2,3,101,45               | 5      | [101, 45, 3, 2, 1]          |
      | 1,2,3,4,5,6,7,8,9,0        | 10     | [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]   |
      | 101,1001,2                 | 3      | [1001, 101, 2]            |


