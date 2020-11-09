require_relative 'fruit'
require_relative 'apple'
require_relative 'banana'
require_relative 'cheese'
require_relative 'sausage'

silver_platter = [Fruit.new, Apple.new, Banana.new, Cheese.new, Sausage.new]

silver_platter.each do |food|
  puts food.to_s
  food.eat if food.respond_to?(:eat)
end