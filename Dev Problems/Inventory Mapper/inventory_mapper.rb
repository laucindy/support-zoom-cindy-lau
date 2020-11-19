class Inventory
  PRODUCT_PART_ID_MAP = { "Shelf" => ["a"], "Stool" => ["b", "c"], "Table" => ["d", "e"] }

  def map_inventory(parts)
    quantities_per_part = parts.chars.tally
    quantities_list = { "Shelf" => 0, "Stool" => 0, "Table" => 0 }

    PRODUCT_PART_ID_MAP.each do |product, part_ids|
      if part_ids.all? { |id| !quantities_per_part[id].nil? }
        map_parts_to_quantity = part_ids.map { |id| quantities_per_part[id] }
        product_class = Object.const_get(product).new(map_parts_to_quantity)
        quantities_list[product] = product_class.number_of_sets
      end
    end

    quantities_list
  end
end

class Shelf
  def initialize(quantity)
    @quantity = quantity[0]
  end

  def number_of_sets
    @quantity
  end
end

class Stool
  TOP_QUANTITY = 1
  LEG_QUANTITY = 3

  def initialize(*quantity)
    quantity.flatten!
    @top_quantity = quantity[0]
    @leg_quantity = quantity[1]
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

  def initialize(*quantity)
    quantity.flatten!
    @top_quantity = quantity[0]
    @leg_quantity = quantity[1]
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
