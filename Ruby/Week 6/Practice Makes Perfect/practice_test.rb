require 'minitest/autorun'
require_relative 'practice'

class PracticeTest < Minitest::Test
  def test_studying
    expected = "Studying for a spelling test\nFinished study session #1. The study efficiency was: 2\n\nFinished study session #2. The study efficiency was: 6\n\nFinished study session #3. The study efficiency was: 12\n\nDone studying, after 3 study sessions!\n\n"

    Kernel.stub(:rand, 2) do
      assert_output(expected) do 
        simulate_studying('spelling test') { |study_session| (study_session * Kernel.rand) % 11 }
      end
    end

    expected = "Studying for a music exam\nFinished study session #1. The study efficiency was: 4\n\nFinished study session #2. The study efficiency was: 9\n\nDone studying, after 2 study sessions!\n\n"

    assert_output(expected) do
      simulate_studying('music exam') { |study_session| study_session + 3 }
    end
  end
end