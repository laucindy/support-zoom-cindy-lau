class TreasureMap
  attr_accessor :map

  def initialize
    @map = Hash.new(".")
  end

  def add_source(x, y, source)
    if valid_sources?(source)
      map[[x, y]] = source
    else
      raise "The source must be one of either 'F', 'W' or 'X'."
    end
  end

  def remove_source(x, y)
    map.delete([x, y])
  end

  def find_sources()
    return if empty_map?(map)

    map.each { |k, v| puts "#{v} -> (#{k[0]}, #{k[1]})" }
  end

  def get_boundaries    
    direction = [[], []]

    map.keys.each do |k| 
      direction[0] << k[0]
      direction[1] << k[1]
    end

    boundaries = [direction[0].min, direction[0].max, direction[1].min, direction[1].max]
  end

  def print_map(upper_left_boundary, upper_right_boundary, lower_left_boundary, lower_right_boundary)
    map_string = ""

    lower_right_boundary.downto(lower_left_boundary).each do |y|
      (upper_left_boundary..upper_right_boundary).each { |x| map_string += map[[x, y]] }
      map_string += "\n"
    end

    map_string
  end

  def to_s
    return "" if empty_map?(map)

    boundaries = get_boundaries
    print_map(boundaries[0], boundaries[1], boundaries[2], boundaries[3])
  end

  private

  def valid_sources?(sources)
    valid_sources = ["F", "W", "X"]
    valid_sources.any? { |s| s.include?(sources) }
  end

  def empty_map?(map)
    puts "Empty map, no water or food sources found. Also no treasure found." if map.empty?
    map.empty?
  end

end

# Map 1
puts "Map 1"
map = TreasureMap.new
#map.create_map(7, 13)

map.add_source(0, 1, "F")
map.add_source(1, 1, "X")
map.remove_source(1, 1)
map.add_source(11, 0, "F")
map.add_source(6, -2, "W")
map.add_source(-1, -5, "X")
puts map

puts
map.find_sources
puts

# Map 2
puts "Map 2"
map2 = TreasureMap.new

puts map2

# Map 3
puts "Map 3"
map3 = TreasureMap.new
map3.add_source(2, 3, "F")
map3.add_source(8, 2, "X")

puts map3
puts

map3.find_sources
puts
