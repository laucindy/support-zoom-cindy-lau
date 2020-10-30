module LeftTriangle
  def generate_triangle(number)
    drawing = ''
    row = 1

    while row <= number
      row.times { drawing += '*' }
      drawing += "\n"
      row += 1
    end

    drawing
  end
end

module RightTriangle
  def generate_triangle(number)
    drawing = ''
    row = 1

    while row <= number
      (number - row).times { print ' ' }
      row.times { print '*' }
      print "\n"
      row += 1
    end

    drawing
  end
end

module CenterTriangle
  def generate_triangle(number)
    drawing = ''
    row = 1

    while row <= number
      (number - row).times { print ' ' }
      row.times { print '* ' }
      print "\n"
      row += 1
    end

    drawing
  end
end

module DiamondTriangle
  def generate_triangle(number)
    draw_half(number)
    draw_half(number, true)
  end

  def draw_half(number, inverted = false)
    drawing = ''
    row = 1

    while row <= number
      space_count = inverted ? row : (number - row)
      asterisk_count = inverted ? (number - row) : row

      space_count.times { print ' ' }
      asterisk_count.times { print '* ' }
      print "\n"
      row += 1
    end

    drawing
  end
end

class AsciiArt
  def draw(number)
    drawing = generate_triangle(number)
  end
end

#ascii_art = AsciiArt.new { include LeftTriangle }
#ascii_art = AsciiArt.new.extend DiamondTriangle
#puts ascii_art.draw(3)