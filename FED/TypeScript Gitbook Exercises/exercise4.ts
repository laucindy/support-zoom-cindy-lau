// ⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇⏇
//   Exercise 4 – Types
// ⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈⏈

// Objectives:
// • Understand how TypeScript performs code flow analysis
// • Create and apply union and intersection types
// • Use basic type guards (narrowing types w/ typeof, instanceof, etc.)

export default () => {
  // ======== Exercise 4.0 ========
  // TypeScript is intelligent about the possible types of a variable,
  // depending on the code path.
  // Instructions:
  // • Simply inspect the possible types by hovering over `text` to see
  //   how the inferred type changes if assumptions can be safely made
  //   about the possible types within the given code path.

  function trimmedLength1(text: string | null | undefined) {
    text; // text: string | null | undefined

    if (typeof text === "string") {
      text; // text: string

      return text.trim().length;
    }

    text; // text: null | undefined
  }

  function trimmedLength2(text: string | null | undefined) {
    text; // text: string | null | undefined

    if (typeof text === "string") {
      text; // text: string

      return text.trim().length;
    } else if (text == null) {
      text; // text: null | undefined (remember == coerces undefined)

      return;
    }

    text; // text: never
  }

  function trimmedLength2(text: string | null | undefined) {
    if (text) {
      return text.trim().length;
    }

    text; // text: string | null | undefined (because '' == false)
  }

  function trimmedLength3(text: string | null | undefined) {
    if (!text) {
      text;
      return;
    }

    return text.trim().length; // text: string
  }

  function trimmedLength4(text: any) {
    text; // text: any

    if (typeof text === "string") {
      return text.trim().length; // text: string
    }

    text; // text: any (note how TS does not subtract types from `any`)
  }

  console.log("[Exercise 4.0]", `${trimmedLength1("   hi     ")}`);

  // ======== Exercise 4.1 ========
  // Instructions:
  // • Restrict type of `value` to `string OR number`
  // • Fix any resulting errors.

  function doStuff(value: string | number): void {
    if (typeof value === "string") {
      console.log(value.toUpperCase().split("").join(" "));
    } else if (typeof value === "number") {
      console.log(value.toPrecision(5));
    }

    //value; // hover over `value` here
  }

  doStuff(2);
  doStuff(22);
  doStuff(222);
  doStuff("hello");
  doStuff("true");
  doStuff("{}");

  console.log("[Exercise 4.1]");

  // ======== Exercise 4.2 ========
  // Instructions:
  // • Use a type guard to fill out the body of the `padLeft` function.

  function padLeft(value: string, padding: number | string): string {
    // if padding is a number, return `${Array(padding + 1).join(' ')}${value}`
    // if padding is a string, return padding + value
    if (typeof padding === "number") {
      return `${Array(padding + 1).join(" ")}${value}`;
    } else {
      return padding + value;
    }
  }

  console.log(
    "[Exercise 4.2]",
    `
    ${padLeft("🐕", 0)}
    ${padLeft("🐕", "🐩")}
    ${padLeft("🐕", "🐩🐩")}
    ${padLeft("🐕", "🐩🐩🐩")}
    ${padLeft("🐕", "🐩🐩🐩🐩")}
  `
  );

  // ======== Exercise 4.3 ========
  // Instructions:
  // • Add type annotations (`any` excluded)
  // • Inspect inferred type of `element` in different code branches
  // • Bonus: turn `flatten` into a generic function

  const numbers = [1, 2, 3, [44, 55], 6, [77, 88], 9, 10];

  function flatten(array: (number[] | number)[]): number[] {
    const flattened = [];

    for (const element of array) {
      if (Array.isArray(element)) {
        element; // any[]
        flattened.push(...element);
      } else {
        element; // any
        flattened.push(element);
      }
    }

    return flattened;
  }

  const flattenedNumbers: number[] = flatten(numbers);

  console.log("[Exercise 4.3]", flattenedNumbers);

  // ======== Exercise 4.4 ========
  //
  // Instructions:
  // • Birds and Fish both lay eggs. Only Birds fly. Only Fish swim. Define
  //   two new types: `BirdLike` and `FishLike` based on these traits.
  // • Create a type alias for `Bird OR Fish` called `Animal`
  // • Use an `instanceof` type guard in `interrogateAnimal` to allow the fishes
  //   to swim the and birds to fly.
  // • Add any missing type annotations, being as explicit as possible.

  interface EggLayer {
    layEggs(): void;
  }

  interface Flyer {
    fly(height: number): void;
  }

  interface Swimmer {
    swim(depth: number): void;
  }

  // add type alias(es) here
  type BirdLike = EggLayer & Flyer;
  type FishLike = EggLayer & Swimmer;
  type Animal = Bird | Fish;

  class Bird implements BirdLike {
    constructor(public species: string) { }

    layEggs(): void {
      console.log("Laying bird eggs.");
    }

    fly(height: number): void {
      console.log(`Flying to a height of ${height} meters.`);
    }
  }

  class Fish implements FishLike {
    constructor(public species: string) { }

    layEggs(): void {
      console.log("Laying fish eggs.");
    }

    swim(depth: number): void {
      console.log(`Swimming to depth of ${depth} meters.`);
    }
  }

  function getRandomAnimal(): Animal {
    const animals = [
      new Bird("puffin"),
      new Bird("kittiwake"),
      new Fish("sea robin"),
      new Fish("leafy seadragon")
    ];

    return animals[Math.floor(Math.random() * animals.length)];
  }

  function interrogateAnimal(animal: Animal = getRandomAnimal()): string {
    if (animal instanceof Fish) {
      animal.swim(10); // call only if it is a fish
    } else if (animal instanceof Bird) {
      animal.fly(10); // call only if it is a bird
    }

    return animal.species;
  }

  console.log(
    "[Exercise 4.4]",
    `We've got a ${interrogateAnimal()} on our hands!`
  );
};
