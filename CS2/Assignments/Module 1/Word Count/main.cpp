#include <iostream>

using namespace std;

bool containsVowel(char character) {
  return ((char) (tolower(character) == 'a') || (char) (tolower(character) == 'e') || (char) (tolower(character) == 'i') || (char) (tolower(character) == 'o') || (char) (tolower(character) == 'u'));
}

bool isNumberOrPunctuation(char character) {
  return isdigit(character) || ispunct(character);
}

bool isLetter(char character) {
  return (character != '\n') && (character != ' ') && !isNumberOrPunctuation(character);
}

int main() {
  char character;
  int wordCount = 0;

  int wordLength = 0;
  int longestWordLength = 0;

  int numVowelsInWord = 0;
  int largestNumVowelsInWord = 0;

  bool previousCharIsSpace = false;

  cout << "Enter text: ";

  character = cin.get();

  if (character == ' ') {
    previousCharIsSpace = true;
  }

  if (isLetter(character)) {
    if (containsVowel(character)) {
      numVowelsInWord++;
    }
    
    // since this is the first letter, explicitly set word count and length to 1
    wordCount = 1;
    wordLength = 1;
  }

  while (character != '\n') {
    character = cin.get();

    // skip if the character is a number or punctuation
    if (isNumberOrPunctuation(character)) {
      continue;
    }

    if (containsVowel(character)) {
      numVowelsInWord++;
    }

    // check if character is a space or newline character
    // if so, set records and reset stats
    if (character == ' ' || character == '\n') {
      if (wordLength > longestWordLength) {
        longestWordLength = wordLength;
      }

      if (numVowelsInWord > largestNumVowelsInWord) {
        largestNumVowelsInWord = numVowelsInWord;
      }
      
      wordLength = 0;
      numVowelsInWord = 0;
      previousCharIsSpace = true;
    } else if (previousCharIsSpace && !isNumberOrPunctuation(character)) {
      // check if character is a letter and is start of a new word
      wordCount++;
      wordLength = 1;
      previousCharIsSpace = false;
    } else {
      // character is part of a word
      wordLength++;
      previousCharIsSpace = false;
    }
  }

  cout << "Word count: " << wordCount << endl;
  cout << "Longest word length: " << longestWordLength << endl;
  cout << "Largest number of vowels in a word: " << largestNumVowelsInWord << endl;

  return 0;
}