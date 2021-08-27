#from django.http import HttpResponse
from django.shortcuts import render, HttpResponse, redirect, HttpResponseRedirect, reverse

def authenticate(request):
    email = request.POST['email']
    password = request.POST['password']
    sql = "select * from users where (email ='" + email + "' and password ='" + password + "')"

    cursor = connection.cursor()
    cursor.execute(sql)

    row = cursor.fetchone()
    if row:
        loggedIn = "Logged Success"
    else:
        loggedIn = "Login Failure"
        
    return HttpResponse("Logged In Status:" + loggedIn)
