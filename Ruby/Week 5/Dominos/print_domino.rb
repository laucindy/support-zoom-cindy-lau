module PrintMultipleDominoes
  def print_domino(dominoes, start_index, end_index)
    print_border(dominoes, start_index, end_index)
    print_first_line(dominoes, start_index, end_index)
    print_second_line(dominoes, start_index, end_index)
    print_third_line(dominoes, start_index, end_index)
    print_border(dominoes, start_index, end_index)
  end

  def print_border(_dominoes, start_index, end_index)
    (start_index...end_index).each do |_j|
      print ' ------------ '
    end
    print "\n"
  end

  def print_first_line(dominoes, start_index, end_index)
    (start_index...end_index).each do |j|
      dominoes[j].sides.each do |side|
        case side
        when 0, 1
          print '|     |'
        when 2, 3
          print '| *   |'
        when 4, 5, 6
          print '| * * |'
        end
      end
    end
    print "\n"
  end

  def print_second_line(dominoes, start_index, end_index)
    (start_index...end_index).each do |j|
      dominoes[j].sides.each do |side|
        case side
        when 0, 2, 4
          print '|     |'
        when 1, 3, 5
          print '|  *  |'
        when 6
          print '| * * |'
        end
      end
    end
    print "\n"
  end

  def print_third_line(dominoes, start_index, end_index)
    (start_index...end_index).each do |j|
      dominoes[j].sides.each do |side|
        case side
        when 0, 1
          print '|     |'
        when 2, 3
          print '|   * |'
        when 4, 5, 6
          print '| * * |'
        end
      end
    end
    print "\n"
  end
end

module PrintDomino
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
  #  print "\n"
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
  #  print "\n"
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
  #  print "\n"
  end
end