class InventoryMapper
  def initialize
    @part_id_minimum_quantity_mapping = { "a" => 1, "b" => 1, "c" => 3, "d" => 1, "e" => 4 }
    @product_name_part_id_mapping = { "Shelf" => ["a"], "Stool" => ["b", "c"], "Table" => ["d", "e"] }
    @product_names = { "Shelf" => 0, "Stool" => 0, "Table" => 0 }
  end

  def map_quantity(input)
    quantities_per_part = input.chars.tally
    sets_available_by_part_id = Hash.new(0)      # eg, { "a": 1, "b": 1, "c": 1  } => there are 1 a, 1 b, 3 c
    
    quantities_per_part.each do |part_id, quantity|
      if part_id_meets_minimum_quantities?(part_id, quantity)
        number_of_sets = quantity / @part_id_minimum_quantity_mapping[part_id]
        sets_available_by_part_id[part_id] = number_of_sets
      end
    end

    add_complete_sets_to_hash(sets_available_by_part_id)
    puts @product_names
  end

  def part_id_meets_minimum_quantities?(part_id, quantity)
    return if @part_id_minimum_quantity_mapping[part_id].nil?
    quantity >= @part_id_minimum_quantity_mapping[part_id]
  end

  def add_complete_sets_to_hash(sets_hash)
    @product_names["Shelf"] += sets_hash["a"] if sets_hash["a"] >= 1
    @product_names["Stool"] += [sets_hash["b"], sets_hash["c"]].min if (sets_hash["b"] >= 1) && (sets_hash["c"] >= 1)
    @product_names["Table"] += [sets_hash["d"], sets_hash["e"]].min if (sets_hash["d"] >= 1) && (sets_hash["e"] >= 1)
  end

  def reset_product_quantities
    @product_names = { 'Shelf' => 0, 'Stool' => 0, 'Table' => 0 }
  end
end

im = InventoryMapper.new
im.map_quantity("abccc")
im.reset_product_quantities       # using the same instance of the class for testing, so need to reset quantities

im.map_quantity("beceadee")
im.reset_product_quantities

im.map_quantity("eebeedebaceeceedeceacee")
im.reset_product_quantities

im.map_quantity("zabc")
im.reset_product_quantities

im.map_quantity("deeedeee")
im.reset_product_quantities