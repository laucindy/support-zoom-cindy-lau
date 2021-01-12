class LegoHat

  attr_accessor :size, :colour, :style

  def initialize(size, colour, style)
    @size = size
    @colour = colour
    @style = style
  end

  def to_s
    "a #{size_word} #{colour} #{@style}"
  end
end

class LegoItem

  attr_accessor :name, :weight

  def initialize(name, weight)
    @name = name
    @weight = weight
  end

  def to_s
    "a #{@weight} gram #{@name}"
  end

  def is_heavy(threshold)
    @weight > threshold
  end
end

class LegoMinifigure

  attr_accessor :name, :hat, :left_item, :right_item

  def initialize(name, hat = nil, left_item = nil, right_item = nil)
    @name = name
    @hat = hat
    @left_item = left_item
    @right_item = right_item
  end

  def to_s
    "A Lego minifigure named #{@name}#{hat_words}#{left_item_words}#{right_item_words}."
  end

  def hat_words
    if @hat
      ", who is wearing #{@hat}"
    else
      ""
    end
  end

  def left_item_words
    if @left_item
      if @hat == nil
        item_connector = ", who is holding"
      else
        item_connector = " and is holding"
      end
      "#{item_connector} #{@left_item} in the left hand"
    else
      ""
    end
  end

  def right_item_words
    if @right_item
      if @hat == nil and @left_item == nil
        item_connector = ", who is holding"
      elsif @left_item == nil
        item_connector = " and is holding"
      else
        item_connector = " and "
      end
      "#{item_connector}#{@right_item} in the right hand"
    else
      ""
    end
  end

  def is_stylish?
    @hat.colour == "red" || @hat.colour == "blue"
  end

  def swap_hands
    temp = @right_item
    @right_item = @left_item
    @left_item = temp
    self
  end

  def wear_hat(new_hat)
    @hat = new_hat
  end

  def place_in_left_hand(new_item)
    @left_item = new_item
  end

  def place_in_right_hand(new_item)
    @right_item = new_item
  end

  def is_strong?
    @left_item.is_heavy(10) || @right_item.is_heavy(10)
  end
end