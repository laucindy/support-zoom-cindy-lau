#include <iostream>

struct song {
  std::string title;
  std::string artist;
  int year;
};

/**
  Loops through each song, and gives each a title, artist, and year
  @param songs - double pointer to array containing entire song list
*/
void initializeSongs(song **songs);

/**
  Combines song information together into one string, in the format "Artist - Song title (Year)"
  @param s - the song struct to convert to a string
  @return song information as a string
*/
std::string songToString(song s);

/**
  Finds songs matching a given year and returns a new array with only these songs
  @param songs - double pointer to array containing entire song list
  @param size - size of the songs array
  @param year - find songs from this year
  @param resultSize - the size of the returned array
  @return a dynamically allocated array with only songs matching the given year
*/
song** songsFromYear(song **songs, int size, int year, int* resultSize);

/**
  Calls songsFromYear to find songs matching a given year and prints out the results
  @param songs - double pointer to array containing entire song list
  @param size - size of the songs array
  @param year - find songs from this year
  @param resultSize - the size of the returned array from the songsFromYear function
*/
void printSongsForYear(song **songs, int size, int year);