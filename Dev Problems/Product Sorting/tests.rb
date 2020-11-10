require 'minitest/autorun'
require_relative './product_sort'

class ProductRankingTest < Minitest::Test
  def test_sorts_full
    input = [
      'Selfie Stick,98,29',
      'iPhone Case,90,15',
      'Fire TV Stick,48,49',
      'Wyze Cam,48,25',
      'Water Filter,56,49',
      'Blue Light Blocking Glasses,90,16',
      'Ice Maker,47,119',
      'Video Doorbell,47,199',
      'AA Batteries,64,12',
      'Disinfecting Wipes,37,12',
      'Baseball Cards,73,16',
      'Winter Gloves,32,112',
      'Microphone,44,22',
      'Pet Kennel,5,24',
      'Jenga Classic Game,100,7',
      'Ink Cartridges,88,45',
      'Instant Pot,98,59',
      'Hoze Nozzle,74,26',
      'Gift Card,45,25',
      'Keyboard,82,19'
    ]

    expected = [
      'Jenga Classic Game',
      'Selfie Stick',
      'Instant Pot',
      'iPhone Case',
      'Blue Light Blocking Glasses',
      'Ink Cartridges',
      'Keyboard',
      'Hoze Nozzle',
      'Baseball Cards',
      'AA Batteries',
      'Water Filter',
      'Wyze Cam',
      'Fire TV Stick',
      'Ice Maker',
      'Video Doorbell',
      'Gift Card',
      'Microphone',
      'Disinfecting Wipes',
      'Winter Gloves',
      'Pet Kennel',
    ]

    assert_equal expected, ProductSort.sort(input)
  end

  def test_sorts_orders_count
    input = [
      'B,90,100',
      'A,80,100',
      'C,100,100'
    ]

    expected = %w[C B A]

    assert_equal expected, ProductSort.sort(input)
  end

  def test_sorts_prices
    input = [
      'B,100,90',
      'C,100,100',
      'A,100,80'
    ]

    expected = %w[A B C]

    assert_equal expected, ProductSort.sort(input)
  end
end