class Creature
  attr_reader :name, :items, :mood, :avg_hours_awake

  def initialize(name, items, mood = "content", avg_hours_awake = 8)
    @name = name
    @items = items
    @mood = mood
    @avg_hours_awake = avg_hours_awake
  end

  def mood=(mood)
    raise "mood must be a String" if !mood.is_a?(String)
    @mood = mood
  end

  def avg_hours_awake=(avg_hours_awake)
    raise "avg_hours_awake must be an Integer" if !avg_hours_awake.is_a?(Integer)
    @avg_hours_awake = avg_hours_awake
  end

  def move
    puts "Moving"
  end

  def speak
    puts "#{name} is speaking"
  end

  def give_item(give_to_creature, item, quantity, calling_from_receive_item_method = false)
    if item_exists?(item, give_to_creature)
    #  puts "#{@name}: Give #{quantity} #{item}#{quantity > 1 ? 's' : ''} to #{give_to_creature.name}"
      @items[item.to_sym] -= quantity

      give_to_creature.receive_item(self, item, quantity, true) unless calling_from_receive_item_method
    end
  end

  def receive_item(received_from_creature, item, quantity, calling_from_give_item_method = false)
    if item_exists?(item, received_from_creature)
    #  puts "#{@name}: Received #{quantity} #{item}#{(quantity > 1) ? 's' : ''} from #{received_from_creature.name}"
      @items[item.to_sym] += quantity

      received_from_creature.give_item(self, item, quantity, true) if !calling_from_give_item_method
    end
  end

  private

  def item_exists?(item, obj)
    first_name = nil
    second_name = nil
    item_exists = true

    if @items[item.to_sym].nil?
      first_name = @name
      second_name = obj.name
      item_exists = false
    elsif obj.items[item.to_sym].nil?
      first_name = obj.name
      second_name = @name
      item_exists = false
    end

    puts "Error: #{first_name} isn't currently carrying #{item}s, and as a result, can't give it to #{second_name}." if !item_exists

    item_exists
  end
end