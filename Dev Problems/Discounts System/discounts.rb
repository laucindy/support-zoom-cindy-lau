input = [['grapes', 7], ['apples', 7], ['peaches', 7]]
store_prices = { 'apples': 3, 'grapes': 5, 'peaches': 7 }

total = 0

input.each do |food, quantity|
  discount = 1
  odd = quantity.odd? ? true : false

  if food == 'apples'
    discount = 0.8 if quantity >= 2
    total += store_prices[food.to_sym] * quantity * discount
  end

  if food == 'grapes'
    discount = 0.5 if quantity >= 2
    total += store_prices[food.to_sym] * (odd ? quantity - 1 : quantity) * discount + store_prices[food.to_sym] * (odd ? 1 : 0)
  end

  total += store_prices[food.to_sym] * quantity if food == 'peaches'
end

puts total