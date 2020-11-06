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

    @product_name_part_id_mapping.each do |product_name, part_ids|
     if all_parts_complete_in_set?(sets_available_by_part_id, part_ids)
      quantity = total_quantity_for_set(sets_available_by_part_id, part_ids)
      add_set_to_hash(sets_available_by_part_id, product_name, quantity)
     end
    end

    puts @product_names
  end

  def part_id_meets_minimum_quantities?(part_id, quantity)
    return if @part_id_minimum_quantity_mapping[part_id].nil?
    quantity >= @part_id_minimum_quantity_mapping[part_id]
  end

  def all_parts_complete_in_set?(sets_hash, part_ids)
    part_ids.all? { |part_id| sets_hash[part_id] >= 1 }
  end

  def total_quantity_for_set(sets_hash, part_ids)
    quantities = part_ids.map { |i| sets_hash[i] }
    quantities.min
  end

  def add_set_to_hash(sets_hash, name, quantity)
    @product_names[name] += quantity
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