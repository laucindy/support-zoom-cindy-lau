module Accessorizable
  attr_accessor :accessories

  def add_accessory(text)
    @accessories ||= []
    @accessories << text
  end

  def remove_accessory(text)
    @accessories.delete(text) unless @accessories.nil?
  end

  def accessories_to_s
    return if @accessories.nil?

    accessories_string = "accessories:"
    @accessories.each { |accessory| accessories_string += "\n\t- #{accessory}" }

    accessories_string
  end
end