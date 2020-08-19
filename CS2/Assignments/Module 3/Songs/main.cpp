#include <sstream>
#include <string>
#include "header.h"

using namespace std;

int main() {
  const int SONGS_SIZE = 5;
  song **songs = new song*[SONGS_SIZE] { new song, new song, new song, new song, new song };

  initializeSongs(songs);

  // print all songs in array
  cout << "Printing all songs: " << endl;
  for (int i = 0; i < SONGS_SIZE; i++) {
    cout << songToString(*(songs[i])) << endl;
  }

  // find songs from a certain year and print results
  printSongsForYear(songs, SONGS_SIZE, 1997);
  printSongsForYear(songs, SONGS_SIZE, 1992);
  printSongsForYear(songs, SONGS_SIZE, 2020);


  // delete memory allocated
  for (int i = 0; i < SONGS_SIZE; i++) {
    delete songs[i];
  }

  delete[] songs;

  return 0;
}

void initializeSongs(song **songs) {
  songs[0]->title = "A Case of You";
  songs[0]->artist = "Joni Mitchell";
  songs[0]->year = 1971;

  songs[1]->title = "Wheat Kings";
  songs[1]->artist = "The Tragically Hip";
  songs[1]->year = 1992;

  songs[2]->title = "Building a Mystery";
  songs[2]->artist = "Sarah McLachlan";
  songs[2]->year = 1997;

  songs[3]->title = "Life is a Highway";
  songs[3]->artist = "Tom Cochrane";
  songs[3]->year = 1991;

  songs[4]->title = "End of the World";
  songs[4]->artist = "Great Big Sea";
  songs[4]->year = 1997;
}

string songToString(song s) {
  stringstream ss;
  string songInfo;

  ss << s.artist << " - " << s.title << " (" << s.year << ")";

  return ss.str();
}

song** songsFromYear(song **songs, int size, int year, int* resultSize) {
  for (int i = 0; i < size; i++) {
    if (songs[i]->year == year) {
      (*resultSize)++;
    }
  }

  // add matching songs to new array
  song **songsFromYear = new song*[*resultSize];
  int j = 0;

  for (int i = 0; i < size; i++) {
    if (songs[i]->year == year) {
      songsFromYear[j] = songs[i];
      j++;
    }
  }

  return songsFromYear;
}

void printSongsForYear(song **songs, int size, int year) {
  int resultSize = 0;
  song **songsMatchYear = songsFromYear(songs, size, year, &resultSize);

  cout << "\nSongs from " << year << ": " << endl;

  if (resultSize == 0) {
    cout << "None found." << endl;
  }

  for (int i = 0; i < resultSize; i++) {
    cout << songToString(*(songsMatchYear[i])) << endl;
  }

  delete[] songsMatchYear;
}
