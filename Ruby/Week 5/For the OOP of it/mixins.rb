module Rating
  def rate_game(rating)
    @rating = rating
    puts "Sucessfully rated game! #{@name} is now rated #{@rating} stars."
  end
end

module Notes
  def add_notes(notes)
    @notes = "Here are some thoughts about #{@name}: " + notes
    puts "Added a note!"
  end

  def check_notes
    puts @notes
  end
end

module ArrayFunctions
  @@is_numeric = proc { |time| time.is_a? Numeric }

  def get_sum(arr)
    arr.reduce(0) { |sum, i| sum + i }
  end

  def add_number(arr, number)
    raise 'Must be a number!' unless @@is_numeric.call(number)
    arr << number
  end

  def remove_number_by_index(arr, index)
    raise "Index is greater than the array length! Array length is: #{arr.length}." if index >= arr.length
    arr.delete_at(index)
  end

  def remove_number(arr, number)
    raise "#{number} is not a number!" unless @@is_numeric.call(number)
    arr.delete(number)
  end
end