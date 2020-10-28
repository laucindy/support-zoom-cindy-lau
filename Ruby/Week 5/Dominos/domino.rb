class Domino
  def initialize(side1, side2)
    @sides = [side1, side2]
  end

  def to_s
    print_domino
  end

  def print_domino
    print_border
    print_first_line
    print_second_line
    print_third_line
    print_border
  end

  def print_border
    puts ' ------------ '
  end

  def print_first_line
    @sides.each do |side|
      case side
      when 0, 1
        print '|     |'
      when 2, 3
        print '| *   |'
      when 4, 5, 6
        print '| * * |'
      end
    end
    print "\n"
  end

  def print_second_line
    @sides.each do |side|
      case side
      when 0, 2, 4
        print '|     |'
      when 1, 3, 5
        print '|  *  |'
      when 6
        print '| * * |'
      end
    end
    print "\n"
  end

  def print_third_line
    @sides.each do |side|
      case side
      when 0, 1
        print '|     |'
      when 2, 3
        print '|   * |'
      when 4, 5, 6
        print '| * * |'
      end
    end
    print "\n"
  end
end

puts " ------------ "
puts "|     ||     |"
puts "|  *  ||  *  |"
puts "|     ||     |"
puts " ------------ "

domino = Domino.new(4, 3)
domino.to_s