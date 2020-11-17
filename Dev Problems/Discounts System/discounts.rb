class Cart
  def initialize(items)
    @total = 0
    @items = items
  end

  def total
    @items.each do |item, quantity|
      item_class = Object.const_get(item.capitalize).new(quantity)
      @total += item_class.calculate_total
    end

    @total
  end
end

class Apples
  def initialize(quantity)
    @discount = 0
    @price = 3
    @quantity = quantity
  end

  def calculate_total
    @discount = 0.2 if @quantity >= 2
    @price * @quantity * (1 - @discount)
  end
end

class Grapes
  def initialize(quantity)
    @discount = 0
    @price = 5
    @quantity = quantity
  end
  
  def calculate_total
    odd_quantities = @quantity.odd? ? true : false
    @discount = 0.5 if @quantity >= 2
    @price * (odd_quantities ? @quantity - 1 : @quantity ) * (1 - @discount) + @price * (odd_quantities ? 1 : 0)
  end
end

class Peaches
  def initialize(quantity)
    @price = 7
    @quantity = quantity
  end

  def calculate_total
    @price * @quantity
  end
end


input = [['grapes', 1], ['apples', 0], ['peaches', 1]]
cart = Cart.new(input)
puts cart.total         # output: 12

input = [['grapes', 1], ['apples', 1], ['peaches', 1]]
cart = Cart.new(input)
puts cart.total         # output: 15

input = [['grapes', 2], ['apples', 2], ['peaches', 1]]
cart = Cart.new(input)
puts cart.total         # output: 16.8

input = [['grapes', 3], ['apples', 5], ['peaches', 2]]
cart = Cart.new(input)
puts cart.total         # output: 36

input = [['grapes', 7], ['apples', 7], ['peaches', 7]]
cart = Cart.new(input)
puts cart.total         # output: 85.8
