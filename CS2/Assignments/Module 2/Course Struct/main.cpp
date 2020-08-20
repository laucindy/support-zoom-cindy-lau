#include <iostream>

using namespace std;

struct Course {
  string department;
  int number;
  string title;
};

int numCoursesInDepartment(Course courseArray[], int numCourses, string department);

int main() {
  Course courses[10] = {
    {"COMP", 1000, "Computer Science - An Introduction"},
    {"COMP", 1001, "Introduction to Programming"},
    {"COMP", 2002, "Data Structures and Algorithms"},
    {"ENGI", 3300, "Circuit Analysis"},
    {"ENGI", 3861, "Digital Logic"},
    {"ENGI", 4854, "Electronic Circuits I"},
    {"CHEM", 1050, "General Chemistry I" },
    {"CHEM", 1051, "General Chemistry II"},
    {"MED", 5710, "Patient I"},
    {"BIO", 2010, "Biology of Plants"}
  };

  cout << numCoursesInDepartment(courses, 10, "COMP") << " courses matching department code COMP" << endl;
  cout << numCoursesInDepartment(courses, 10, "ENGI") << " courses matching department code ENGI" << endl;
  cout << numCoursesInDepartment(courses, 10, "CHEM") << " courses matching department code CHEM" << endl;
  cout << numCoursesInDepartment(courses, 10, "MED") << " course matching department code MED" << endl;
  cout << numCoursesInDepartment(courses, 10, "BIO") << " course matching department code BIO" << endl;

  return 0;
}

int numCoursesInDepartment(Course courseArray[], int numCourses, string department)
{
  int coursesInDepartment = 0;

  for (int i = 0; i < numCourses; i++) {
    if (courseArray[i].department == department) {
      coursesInDepartment++;
    }
  }

  return coursesInDepartment;
}