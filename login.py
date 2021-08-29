import requests
from django.http import HttpResponse
from sqlite3 import *

#email = requests.GET['email']
#password = requests.GET['password']

email = 'blah@checkmarx.com'
password = 'blah'

sql = "select * from users where (email ='" + email + "' and password ='" + password + "')"

cursor = connection.cursor()
cursor.execute(sql)
row = cursor.fetchone()
if row:
  loggedIn = "Logged Success"
else:
  loggedIn = "Login Failure"
        
return HttpResponse("Logged In Status:" + loggedIn)
 
