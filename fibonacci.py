import mysql.connector

mydb = mysql.connector.connect(
          host="localhost",
            user="",
              password="",
                database=""
                )

mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM fibonacci")

myresult = mycursor.fetchall()

for x in myresult:
      print(x)
