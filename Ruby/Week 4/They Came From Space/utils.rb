class Utils
  def self.typing_animation(str)
    str.each_char do |c|
      print c
      sleep 0.1
      $stdout.flush
    end
  end
end