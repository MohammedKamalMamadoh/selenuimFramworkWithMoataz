Feature: user Registeration
as a user i want to register to e_commerce website 
       
Scenario Outline:    user registeration

Given  in home page   user click on register 
When   in registeration page user enter "<firstname>","<lastname>","<email>","<password>"
Then   registration page displayed successfully   
Examples:
|firstname|lastname|email|password|
|mohammed | kamal | kimoo@test.com | 12345678 |
|test | rc | test@rc.com | 87654321 |
|kimo | km | km@km.com | 123456 |