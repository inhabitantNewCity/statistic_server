Service provide rest operations for

1) number of client per month (in range of moths)
rest method: /clientsPerMonths
params:
    month_from (format MM-YYYY)
    month_to (format MM-YYYY)

2) number of client per doctor (in range type of employee)
rest method: /clientsPerDocTypes
params: type (array of doc type)

3) heaviest time in day (in day in week)
rest method: /timeInDay
params: name of day  - three first later from name of day (in English)