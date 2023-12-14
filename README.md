Steps for installation:

1. Download the Zip file,
2. Open the backend folder in any editor (IntelliJ preferred),
3. Open the Front folder in any editor (VSCode preferred),
4. Build the backend project by doing right click and build and then run all the services: Api Gateway, Connection Service and Chart Service by going to the springbootApplication.java file and doing right click and then running,
5. Do Post: http://localhost:8080/api/excel/import on Postman to fill up the database with the excel data,
6. Excel data is in the static/excel folder of the connection service,
7. Do npm install in the VSCode after navigating to the src/app folder,
8. Then do, npm start: Front end will start running on localhost:4200.
9. The UI will show up 4200 port.






Front Page of Displaying all data in table
    
![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/dd5f76b8-1724-49ca-8272-53cc2349c3de)

![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/1a295c85-326f-4a7f-a2a6-0655175f42eb)

    Using Search Filter by Application Id

 ![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/978317f3-4b92-47ab-a127-dedc8244bdf0)

Editing a Row (not allowed to change the Date of Application, Govt ID Type, and ID Number)
 
![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/84e0a29b-7c48-4ab9-967e-6d984489179e)

Data Validation that the row should not exceed 200 KV while Editing 
 
![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/81a3e4b4-c31f-4fa6-85cd-da00e3ae78cb)

Deleting a Row

 ![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/2ae41ae0-ae19-432e-b6e4-3a0397fdfe9d)


Adding a Row:

 ![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/5f8ccb2e-cee2-4c81-af85-b9a4b8f00796)


Line Chart for Approved Status for Default:
 
![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/52e83f0c-b47e-493f-a425-dd3c79f5e0e7)

Line Chart for Pending status after clicking:
 
![image](https://github.com/vardhan3236/electricity_frontend/assets/126255853/e89af687-beb7-479e-9863-809977957221)
