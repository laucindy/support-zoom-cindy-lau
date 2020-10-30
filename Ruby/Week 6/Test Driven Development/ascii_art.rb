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

class AsciiArt
  def draw(number)
    drawing = generate_triangle(number)
  end
end

#ascii_art = AsciiArt.new { include LeftTriangle }
#ascii_art = AsciiArt.new.extend CenterTriangle
#puts ascii_art.draw(3)