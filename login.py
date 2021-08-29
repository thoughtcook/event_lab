# Do NOT do it this way.
cmd = "update people set name='%s' where id='%s'" % (name, id)
curs.execute(cmd)
