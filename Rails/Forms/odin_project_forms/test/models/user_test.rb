require 'test_helper'

class UserTest < ActiveSupport::TestCase
  def setup
    @user = User.new(username: 'Example User', email: 'user@example.com', password: 'foobar')
  end

  test 'show be valid' do
    assert @user.valid?
  end

  test 'username should be present' do
    @user.username = ' '
    assert_not @user.valid?
  end

  test 'email should be present' do
    @user.email = ' '
    assert_not @user.valid?
  end

  test 'password should be present' do
    @user.password = ' '
    assert_not @user.valid?
  end
end
