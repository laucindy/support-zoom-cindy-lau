require 'minitest/autorun'
require_relative '../potato_head'

class PotatoHeadTest < Minitest::Test
  def setup
    @potato_head = MrPotatoHead.new('Mr Potato Head')
  end

  def test_potato_head_initialized
    assert_equal('Mr Potato Head', @potato_head.name)
  end

  def test_add_accessory
    @potato_head.add_accessory('green hat')
    expected = ['green hat']
    assert_equal(expected, @potato_head.accessories)
  end

  def test_add_multiple_accessories
    @potato_head.add_accessory('green hat')
    @potato_head.add_accessory('red shoes')
    @potato_head.add_accessory('orange ears')

    expected = ['green hat', 'red shoes', 'orange ears']
    assert_equal(expected, @potato_head.accessories)
  end

  def test_remove_accessory
    @potato_head.add_accessory('green hat')
    @potato_head.remove_accessory('green hat')
    expected = []
    assert_equal(expected, @potato_head.accessories)
  end

  def test_remove_accessory_that_does_not_exist
    @potato_head.remove_accessory('green hat')
    expected = nil
    assert_nil(@potato_head.accessories)
  end

  def test_accessories_string
    @potato_head.add_accessory('green hat')
    @potato_head.add_accessory('red shoes')

    expected = "accessories:\n\t- green hat\n\t- red shoes"
    assert_equal(expected, @potato_head.accessories_to_s)
  end

  def test_accessories_string_empty
    assert_nil(@potato_head.accessories_to_s)
  end

  def test_to_s
    @potato_head.add_accessory('green hat')
    @potato_head.add_accessory('red shoes')

    expected = "accessories:\n\t- green hat\n\t- red shoes"
    assert_equal(expected, @potato_head.to_s)
  end
end
