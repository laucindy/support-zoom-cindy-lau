#include <iostream>
#include <iomanip>

using namespace std;

struct Time {
  string period;
  int hours;
  int minutes;
  int seconds;
};

void incrementOneHour(Time &time);
int secondsSinceMidnight(Time time);

int main() {
  Time time = {"AM", 11, 25, 07};

  cout << "Current time is: " << time.hours << ":" << setw(2) << setfill('0') << time.minutes << ":" << setw(2) << setfill('0') << time.seconds << " " << time.period << endl;

  cout << secondsSinceMidnight(time) << " seconds have passed since midnight" << endl;

  cout << "Incrememnting time by 1 hour..." << endl;
  incrementOneHour(time);

  cout << "New time is: " << time.hours << ":" << setw(2) << setfill('0') << time.minutes << ":" << setw(2) << setfill('0') << time.seconds << " " << time.period << endl;

  cout << secondsSinceMidnight(time) << " seconds have passed since midnight" << endl;

  return 0;
}

void incrementOneHour(Time &time) {
  if (time.hours == 11) {
    time.period = (time.period == "AM") ? "PM" : "AM";
  }

  if (time.hours == 12) {
    time.hours = 1;
  } else {
    time.hours += 1;
  }
}

int secondsSinceMidnight(Time time) {
  int seconds = (time.minutes * 60) + time.seconds;

  // return if it's 12AM
  if ((time.hours == 12) && (time.period == "AM")) {
    return seconds;
  }

  // check if time period is in the AM, or if it's 12pm
  if ((time.period == "AM") || (time.hours == 12)) {
    seconds += (time.hours * 3600);
  } else {
    seconds += ((time.hours + 12) * 3600);
  }

  return seconds;
}