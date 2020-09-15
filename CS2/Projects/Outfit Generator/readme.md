# Outfit Generator

## Object Hierarchy
[Link to diagram](https://screenshot.click/14-02-pwg1k-7lflh.jpg)

Explain your object hierarchy (why did you design it the way you did?)

Shirts, pants, outerwear and shoes are all types of clothing, and since we want to know the same information about these four categories, a `Clothing` interface was created. There are 4 methods within this interface; to check whether the clothing item has a print, is brightly colored, is formalwear, and if it's good paired with jewelry. 

As well, there are also separate abstract classes for each clothing/accessory category: `Shirts`, `Pants`, `Outerwear`, `Shoes` and `Accessories`. The first four of these implement the `Clothing` interface. Separate abstract classes were created, because each of these categories have specific traits that we also want to look for. For example, in the `Shirts` class, we check if the shirt is also a long sleeve shirt (`boolean isLongSleeve()`), and in the `Pants` class, we check if the pair of pants have pockets, and if they are shorts.

For each clothing/accessory category, a number of subclasses were created. For example, for `Shirts`, the subclasses `Tshirts`, `Sweaters` and `ButtonUps` were created. These subclasses inherit the `Shirts` class, and the actual methods are implemented and given values (for example, the method `public boolean isGoodWithJewelry()` returns `true` in the `Tshirts` class). When each of these classes are instantiated (in the `GenerateOutfit` class), they are also given a random color.

The `Outfit` class stores a randomly selected item from each category, and when the outfit is confirmed to meet the outfit rules, then it is returned from the `generateOutfit()` method in the `GenerateOutfit` class.

## Characteristics checked for:
The characteristics checked for in each clothing/accessory type (the following methods all return a `boolean` value):

#### Clothing (interface shared by `Shirts`, `Pants`, `Outerwear` and `Shoes`)
- whether the clothing item has a print/pattern: `hasPrint()`
- whether the item is for formal ocassions or is more casual: `isFormal()`
- whether the item is brightly colored: `isBrightlyColored()`
- whether the item would be fine paired with jewelry or not: `isGoodWithJewelry()`

#### Shirts (abstract class)
- whether the shirt is a long sleeve shirt: `isLongSleeve()`

#### Pants (abstract class)
- whether the pair of pants has pockets: `hasPockets()`
- whether the pair of pants are shorts: `isShorts()`

#### Outerwear (abstract class)
- whether the outerwear is for winter: `isForColdWeather()`

#### Shoes (abstract class)
- whether the pair of shoes have a heel: `hasHeel()`

#### Accessories (abstract class)
- whether the accessory is for formal occasions: `isFormal()`
- whether the accessory is a piece of jewelry: `isJewelry()`
- whether the accessory can store other items (eg, a bag): `canStoreItems()`

### Outfit Rules

The rules are as follows:

- do not wear a long sleeve shirt with shorts
- outerwear meant for winter should not be worn with shorts
- do not wear heels with shorts
- if pants do not have pockets, then the accessory should be a bag
- if any item shouldn't be paired with jewelry, then the accessory should not be a piece of jewelry
- if the shirt and pants are formal, then the outerwear should be as well
- if all clothing items (shirt, pants, outerwear and shoes) are formal, then the accessory must be as well
- if a shirt, pants and/or shoes are brown, then none of the other items should be grey (ie, do not mix brown with grey)
- only 1 of either a shirt, pants, outerwear or shoes can be brightly colored
- only 1 of either a shirt, pants or shoes can have a print/pattern (however, an outfit can have 1 brightly colored item, and another with a print)
