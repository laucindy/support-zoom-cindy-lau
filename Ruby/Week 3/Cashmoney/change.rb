require 'bigdecimal'
require 'bigdecimal/util'

class String
  # https://stackoverflow.com/a/5812949
  def numeric?
    !self.match(/[^0-9.]/)
  end

  def is_negative_or_string?
    self.to_f.negative? || !self.numeric?
  end
end

def calculate_coins_owed(balance, coins, coins_used)
  while balance > 4
    coin = coins.values.find { |coin| (balance - coin) >= 0 }
    coins_used[coins.key(coin)] += 1
    balance -= coin 

    if (balance == 3) || (balance == 4)
      coins_used[:nickel] += 1
    end
  end

  coins_used
end

def print_change_required(coins_used)
  return puts "You don't need to dispense change." if (coins_used.length == 0)

  print "You need to dispense "
  coins_used.keys.each do |coin|
    print "and " if coin == coins_used.keys.last && coins_used.length > 1
    print "#{coins_used[coin]} #{coin}#{(coins_used[coin] > 1) ? 's' : ''}"
    print (coin == coins_used.keys.last) ? ".\n" : ", "
  end
end

change_owed = 0

loop do 
  print "How much change is owed? "
  change_owed = gets.chomp

  break if !change_owed.is_negative_or_string?
end

coins = {
  toonie: 200,
  loonie: 100,
  quarter: 25,
  dime: 10,
  nickel: 5
}

coins_used = Hash.new(0)

change_owed = change_owed.to_f.to_d * 100
coins_used = calculate_coins_owed(change_owed, coins, coins_used)
coins_used.select! { |_key, value| value > 0 }

print_change_required(coins_used)

total_coins = coins_used.values.reduce(0) { |total, current| total + current }
puts "Total coins: #{total_coins}"