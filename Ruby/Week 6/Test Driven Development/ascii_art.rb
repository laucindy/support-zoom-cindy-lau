class AsciiArt
  def draw(number)
    drawing = ""
    row = 1

    while row <= number
      row.times { drawing += "*" }
      drawing += "\n"
      row += 1
    end

    drawing
  end
end