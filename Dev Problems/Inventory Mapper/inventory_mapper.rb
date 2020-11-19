class Inventory
  def map_inventory(parts)
    quantities_per_part = parts.chars.tally
    quantities_list = { "Shelf" => 0, "Stool" => 0, "Table" => 0 }

    if !quantities_per_part['a'].nil?
      shelf = Shelf.new(quantities_per_part['a'])
      quantities_list["Shelf"] = shelf.number_of_sets
    end

    if !quantities_per_part['b'].nil? && !quantities_per_part['c'].nil?
      stool = Stool.new(quantities_per_part['b'], quantities_per_part['c'])
      quantities_list["Stool"] = stool.number_of_sets
    end

    if !quantities_per_part['d'].nil? && !quantities_per_part['e'].nil?
      table = Table.new(quantities_per_part['d'], quantities_per_part['e'])
      quantities_list["Table"] = table.number_of_sets
    end

    quantities_list
  end
end

class Shelf
  def initialize(quantity)
    @quantity = quantity
  end

  def number_of_sets
    @quantity
  end
end

class Stool
  TOP_QUANTITY = 1
  LEG_QUANTITY = 3

  attr_accessor :top_quantity, :leg_quantity

  def initialize(top_quantity, leg_quantity)
    @top_quantity = top_quantity
    @leg_quantity = leg_quantity
  end

  def number_of_sets
    set_of_legs = @leg_quantity / LEG_QUANTITY
    set_of_tops = @top_quantity

    [set_of_tops, set_of_legs].min
  end
end

class Table
  TOP_QUANTITY = 1
  LEG_QUANTITY = 4

  attr_accessor :top_quantity, :leg_quantity

  def initialize(top_quantity, leg_quantity)
    @top_quantity = top_quantity
    @leg_quantity = leg_quantity
  end

  def number_of_sets
    set_of_legs = @leg_quantity / LEG_QUANTITY
    set_of_tops = @top_quantity

    [set_of_tops, set_of_legs].min
  end
end

input = "abccc"
inventory = Inventory.new
puts "\"#{input}\" => #{inventory.map_inventory(input)}"

input = "beceadee"
inventory = Inventory.new
puts "\"#{input}\" => #{inventory.map_inventory(input)}"

input = "eebeedebaceeceedeceacee"
inventory = Inventory.new
puts "\"#{input}\" => #{inventory.map_inventory(input)}"

input = "zabc"
inventory = Inventory.new
puts "\"#{input}\" => #{inventory.map_inventory(input)}"

input = "deeedeee"
inventory = Inventory.new
puts "\"#{input}\" => #{inventory.map_inventory(input)}"
