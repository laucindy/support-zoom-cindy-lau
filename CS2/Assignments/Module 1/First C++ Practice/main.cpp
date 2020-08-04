
#include <iostream>

using namespace std;

/* 
This function takes in a temperature in Fahrenheit, and converts it to Celsius, 
rounded to 1 decimal place. The temperature in Celsius is then returned to the user. 
The user doesn't need to know the calculation for converting F to C, 
they just need to call this function
*/
float convertFtoC(float tempF) {
  float tempC = (int) ((tempF - 32) * 10 / 1.8);
  return (float) tempC / 10;
}

int main() {
  // Testing convertFtoC function for a few different inputs below

  // water boiling point
  float waterBoilingPointF = 212;
  float waterBoilingPointC = convertFtoC(waterBoilingPointF);
  cout << "Water boils at " << waterBoilingPointF << "°F, or " << waterBoilingPointC << "°C." << endl;

  // highest temperature
  float highestTempF = 134.1;
  float highestTempC = convertFtoC(highestTempF);
  cout << "The highest air temperature ever recorded in the world was " << highestTempF << "°F, or " << highestTempC << "°C, in California, 1913." << endl;

  // lowest temperature
  float lowestTempF = -128.6;
  float lowestTempC = convertFtoC(lowestTempF);
  cout << "The lowest temperature ever recorded in the world was " << lowestTempF << "°F, or " << lowestTempC << "°C, in Antarctica, 1983." << endl;

  return 0;
}