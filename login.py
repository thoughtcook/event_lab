import os
from sqlite3 import *
from django.http import HttpResponse

def authenticate(request):
    email = request.query_params.get("email")
    password = request.query_params.get("password")
    sql = "select * from users where (email ='" + email + "' and password ='" + password + "')"

    cursor = connection.cursor()
    cursor.execute(sql)

    row = cursor.fetchone()
    if row:
        loggedIn = "Logged Success"
    else:
        loggedIn = "Login Failure"
        
    return HttpResponse("Logged In Status:" + loggedIn)
