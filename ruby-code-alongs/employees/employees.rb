class Employee
  attr_reader :name

  def name=(name)
    # Code to validate and set @name
  end

  def print_name
    puts "Name: #{name}"
  end
end

class SalariedEmployee < Employee
  attr_reader :salary

  def initialize(name = "Anonymous", salary = 0.0)
    super(name)
    self.salary = salary
  end

  def salary=(salary)
    # Code to validate and set @salary
  end

  def print_pay_stub
    print_name
    pay_for_period = (salary / 365.0) * 14
    formatted_pay = format("$%.2f", pay_for_period)
    puts "Pay This Period: #{formatted_pay}"
  end
end

class HourlyEmployee < Employee
  attr_reader :hourly_wage, :hours_per_week

  def initialize(name = "Anonymous", hourly_wage = 0.0, hours_per_week = 0.0)
    super(name)
    self.hourly_wage = hourly_wage
    self.hours_per_week = hours_per_week
  end

  def hourly_wage=(hourly_wage)
    # Code to validate and set @hours_per_week
  end

  def hours_per_week=(hours_per_week)
    # Code to validate and set @hours_per_week
  end

  def print_pay_stub
    print_name
    pay_for_period = hourly_wage * hours_per_week * 2
    formatted_pay = format("$%.2f", pay_for_period)
  end

  def turn_into_cashier
    self.hourly_wage = 12.75
    self.hours_per_week = 25
  end
end

salaried_employee = SalariedEmployee.new("Jane Doe", 50000)
salaried_employee.print_pay_stub

hourly_employee = HourlyEmployee.new("John Smith", 14.97, 30)
hourly_employee.print_pay_stub

ivan = HourlyEmployee.new("Ivan Stokes")
ivan.turn_into_cashier
ivan.print_pay_stub

harold = HourlyEmployee.new("Harold Nguyen", 12.75, 25)
tamara = HourlyEmployee.new("Tamara Wells", 12.75, 25)
susie = HourlyEmployee.new("Susie Powell", 12.75, 25)

edwin = HourlyEmployee.new("Edwin Burgess", 10.50, 20)
ethel = HourlyEmployee.new("Ethel Harris", 10.50, 20)

angela = HourlyEmployee.new("Angela Matthews", 19.25, 30)
stewart = HourlyEmployee.new("Stewart Sanchez", 19.25, 30)