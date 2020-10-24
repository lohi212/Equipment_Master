This project deals with the creation of equipment in staging table and then inserting them in master table. So staging tables are used to keep track of different evolutions of a particular equipment ,Whereas master tables have the final data. Here Pagination,Sorting,Filtering,Excel download were implemented.

The flow goes in this way: 1.CREATE equipment in staging table , 2.if UPDATE:a latest version of the same record is created in staging table , 3.The latest version record inserted to master table.
