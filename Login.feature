Feature: Login ke Aplikasi Web HRM

@ValidCredentials
Scenario: Login with valid credentials

	Given User home page
	When User input username as "Admin"
	And User input password as "admin123"
	Then User berhasil login
	
@InvalidCredentials
Scenario: Login with invalid credentials

	Given User home page
	When User input username as "Admin111"
	And User input password as "admin123"
	Then User gagal login dengan pesan: "Invalid credentials"