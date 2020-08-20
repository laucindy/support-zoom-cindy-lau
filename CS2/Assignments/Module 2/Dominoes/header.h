#include <iostream>

struct Domino {
  int left;
  int right;
};

/**
  Initializes all 28 dominoes in a set with left and right values
  @param dominoes - array of dominoes
*/
void initializeDominoes(Domino (&dominoes)[28]);

/**
  Given 2 dominoes, sort them by the number on the righthand side of the domino
  @param domino1 - first domino
  @param domino2 - second domino to compare against the first
  @return true if the righthand side of domino2 is greater than the righthand side of domino1
*/
bool sortByRightNumber(Domino domino1, Domino domino2);


/**
  Prints the dominoes array using numbers to represent the left and right side of a domino 
  @param dominoes - dominoes array
  @param numDominoes - total number of dominoes
  @param sortByLeft - determines whether to print the output with the lefthand side sorted, or the righthand side sorted
*/
void printArray(Domino dominoes[], int numDominoes, bool sortByLeft);

/**
  Prints dominoes as they would physically appear, with the * character representing number of dots
  @param dominoes - dominoes array
  @param numDominoes - total number of dominoes
  @param sortByLeft - determines whether to print the output with the lefthand side sorted, or the righthand side sorted
*/
void printDominoes(Domino dominoes[], int numDominoes, bool sortByLeft);

/**
  Prints dominoes as they would physically appear - print each row
  @param dominoes - dominoes array
  @param startIndex - the domino to start printing
  @param endIndex - stop printing at this domino index (not including this index)
*/
void printDomino(Domino dominoes[], int startIndex, int endIndex);

/**
  Prints dominoes as they would physically appear - print top or bottom border
  @param dominoes - dominoes array
  @param startIndex - the domino to start printing
  @param endIndex - stop printing at this domino index (not including this index)
*/
void printBorder(Domino dominoes[], int startIndex, int endIndex);

/**
  Prints dominoes as they would physically appear - print first line
  @param dominoes - dominoes array
  @param startIndex - the domino to start printing
  @param endIndex - stop printing at this domino index (not including this index)
*/
void printFirstLine(Domino dominoes[], int startIndex, int endIndex);

/**
  Prints dominoes as they would physically appear - print second line
  @param dominoes - dominoes array
  @param startIndex - the domino to start printing
  @param endIndex - stop printing at this domino index (not including this index)
*/
void printSecondLine(Domino dominoes[], int startIndex, int endIndex);

/**
  Prints dominoes as they would physically appear - print third line
  @param dominoes - dominoes array
  @param startIndex - the domino to start printing
  @param endIndex - stop printing at this domino index (not including this index)
*/
void printThirdLine(Domino dominoes[], int startIndex, int endIndex);