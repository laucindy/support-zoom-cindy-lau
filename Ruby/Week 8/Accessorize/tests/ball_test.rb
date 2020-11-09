require 'minitest/autorun'
require_relative '../ball'

class BallTest < Minitest::Test
  def setup
    @ball = Ball.new("Soccer ball")
  end

  def test_ball_initialized
    assert_equal("Soccer ball", @ball.name)
  end

  def test_ball_string
    expected = "This is a ball, it's safe for children 6+.\n"
    assert_output(expected) { puts @ball.to_s }
  end
end