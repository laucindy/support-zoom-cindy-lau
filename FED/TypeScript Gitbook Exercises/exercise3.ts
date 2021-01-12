// ⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇
//   Exercise 3 – Functions
// ⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈

// Objectives:
// • Convert existing JavaScript functions to TypeScript
// • Understand functions as types
// • Convert specifically-typed functions to more
//   flexible generic functions

export default () => {
  // ======== Exercise 3.1 ========
  // Instructions:
  // • Add explicit parameter types and return type
  // • Fix any errors resulting from invalid types

  function add(x: number, y: number): number {
    return x + y;
  }

  function sumArray(numbers: Array<number>): number {
    return numbers.reduce(add, 0);
  }

  const someSum = sumArray([3, 6, 9]);

  console.log("[Exercise 3.1]", `3 + 6 + 9 === ${someSum}`);

  // ======== Exercise 3.2 ========
  // Instructions:
  // • Add explicit parameter types and return types to the `deposit` function
  // • Make the function's `message` parameter *optional*

  const bankAccount = {
    money: 0,
    deposit(value: number, message?: string): void {
      this.money += value;
      if (message) {
        console.log(message);
      }
    }
  };

  bankAccount.deposit(20);
  bankAccount.deposit(10, "Deposit received");

  console.log("[Exercise 3.2]", `Account value: $${bankAccount.money}`);

  // ======== Exercise 3.3 ========
  // For a given word, we compute its Scrabble® score.
  // Instructions:
  // • Add type annotations wherever possible

  function getPointsFor(letter: string): number {
    const lettersAndPoints: Array<[string, number]> = [
      ["AEOIULNRST", 1],
      ["DG", 2],
      ["BCMP", 3],
      ["FHVWY", 4],
      ["K", 5],
      ["JX", 8],
      ["QZ", 10]
    ];

    return lettersAndPoints.reduce(
      (computedScore: number, pointsTuple: [string, number]) => {
        const [letters, score]: [string, number] = pointsTuple;
        if (letters.split("").find((ll) => ll === letter)) {
          return (computedScore += score);
        }
        return computedScore;
      },
      0
    );
  }

  function computeScore(word: string): number {
    const letters: string[] = word.toUpperCase().split("");
    return letters.reduce(
      (accum: number, curr: string) => (accum += getPointsFor(curr)),
      0
    );
  }

  console.log("[Exercise 3.3]", `zoo is worth ${computeScore("zoo")} points.`);

  // ======== Exercise 3.4 ========
  // Instructions:
  // • Add explicit parameter types and return types
  // • Add a default greeting: "hello"

  function greet(greeting: string = "hello"): string {
    return greeting.toUpperCase();
  }

  const defaultGreeting: string = greet();
  const portugueseGreeting: string = greet("Oi como vai!");

  console.log("[Exercise 3.4]", defaultGreeting, portugueseGreeting);

  // ======== Exercise 3.5 ========
  // Instructions:
  // • Add parameter type annotation
  // • Even though this function doesn't return, add an explicit return type

  function layEggs(quantity: number, color: string): void {
    console.log(
      `[Exercise 3.5] You just laid ${quantity} ${color} eggs. Good job!`
    );
  }

  layEggs(2, "brown");

  // ======== Exercise 3.6 ========
  // Here we've initialized two variables with function types.
  // Later we assign them to functions.
  // Instructions:
  // • Fix the errors

  let multiply: (val1: number, val2: number) => number;
  let capitalize: (val: string) => string;

  capitalize = function (value: string): string {
    return `${value.charAt(0).toUpperCase()}${value.slice(1)}`;
  };

  multiply = function (x: number, y: number): number {
    return x * y;
  };

  console.log("[Exercise 3.6]", capitalize(`nifty ${multiply(5, 10)}`));

  // ======== Exercise 3.7 ========
  // Currently, our function `pushToCollection` accepts *any* item and adds it,
  // (indiscriminantly) to *any* kind of array.
  //
  // A couple problems with this:
  //
  //     1. The `any` type causes us to lose ALL typing information on our params.
  //     2. This looseness has come back to back to bite us during runtime. (Just
  //        look at `incrementByTwo`!)
  //
  // Instructions:
  // • Implement `pushToCollection` as a generic function. (This should create
  //   compile-time errors in places where incorrect values are being added to
  //   a given collection. Fix these values to the correct types.)
  // • Once made generic, `pushToCollection` should be *generic* enough to operate
  //   on items and collections of any type while continuing to enforce that they match.

  const numberCollection: number[] = [];
  const stringCollection: string[] = [];

  function pushToCollection<T>(item: T, collection: T[]): T[] {
    collection.push(item);
    return collection;
  }

  // Add some stuff to the collections
  pushToCollection("false", stringCollection);
  pushToCollection("hi", stringCollection);
  pushToCollection("[]", stringCollection);

  pushToCollection(1, numberCollection);
  pushToCollection(2, numberCollection);
  pushToCollection(3, numberCollection);

  const incrementedByTwo = numberCollection.map((num) => num + 2);

  console.log(
    "[Exercise 3.7]",
    `[${incrementedByTwo}] should deeply equal [3,4,5]`
  );
};
