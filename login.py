def authenticate(request):
3
    email = request.POST['email']
4
    password = request.POST['password']
5
    sql = "select * from users where (email ='" + email + "' and password ='" + password + "')"
6
​
7
    cursor = connection.cursor()
8
    cursor.execute(sql)
9
    row = cursor.fetchone()
10
    if row:
11
        loggedIn = "Logged Success"
12
    else:
13
        loggedIn = "Login Failure"
14
    return HttpResponse("Logged In Status:" + loggedIn)
