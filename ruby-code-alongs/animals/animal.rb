class Animal
  attr_reader :name, :age

  def name=(value)
    if value == ""
      raise "Name can't be blank!"
    end
    
    @name = value
  end

  def age=(value)
    if value < 0
      raise "An age of #{value} isn't valid!"
    end

    @age = value
  end

  def talk
    puts "#{name} says Bark!"
  end

  def move(destination)
    puts "#{@name} runs to the destination."
  end

  def report_age
    puts "#{name} is #{@age} years old."
  end
end

class Dog < Animal

end

class Bird < Animal
  def talk
    puts "#{@name} says Chirp! Chirp!"
  end
end

class Cat < Animal
  def talk
    puts "#{@name} says Meow!"
  end
end

whiskers = Cat.new
whiskers.name = "Whiskers"

polly = Bird.new
polly.name = "Polly"

whiskers.talk
polly.talk