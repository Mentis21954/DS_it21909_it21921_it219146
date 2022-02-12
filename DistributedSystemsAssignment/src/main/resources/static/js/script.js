var selectedRow=null;
function onFormSubmit(e){
	event.preventDefault();
	var formData=readFormData();
	if(selectedRow===null){
		insertNewRecord(formData);
	}else{
		
	}
}

//retrieve the data
function readFormData(){
	var formData={};
	formData["name"]= document.getElementById("name").value;
	formData["lname"]= document.getElementById("lname").value;
	formData["email"]= document.getElementById("email").value;
	formData["birthDate"]= document.getElementById("birthDate").value;
	formData["idNumber"]= document.getElementById("idNumber").value;
	formData["AFM"]= document.getElementById("afm").value;
	formData["AMKA"]= document.getElementById("amka").value;
	formData["maritalStatus"]= document.getElementById("marital").value;
	formData["primaryNationality"]= document.getElementById("nationality").value;
	formData["city"]= document.getElementById("city").value;
	formData["dateOfUnemployment"]= document.getElementById("unemployment").value;
	formData["photo"]= document.getElementById("photo").value;
	formData["income"]= document.getElementById("income").value;
	return formData;	
}

//insert the data
function insertNewRecord(data){
	var table=document.getElementById("showTable").getElementsByTagName('tbody')[0];
	var newRow= table.insertRow(table.length);
	var cell1=newRow.incertCell(0);
		cell1.innerHTML= data.name;
	var cell2=newRow.incertCell(1);
		cell2.innerHTML= data.lname;
	var cell3=newRow.incertCell(2);
		cell3.innerHTML= data.email;	
	var cell4=newRow.incertCell(3);
		cell4.innerHTML= data.birthDate;
	var cell5=newRow.incertCell(4);
		cell5.innerHTML= data.idNumber;
	var cell6=newRow.incertCell(5);
		cell6.innerHTML= data.AFM;
	var cell7=newRow.incertCell(6);
		cell7.innerHTML= data.AMKA;
	var cell8=newRow.incertCell(7);
		cell8.innerHTML= data.maritalStatus;
	var cell9=newRow.incertCell(8);
		cell9.innerHTML= data.primaryNationality;
	var cell10=newRow.incertCell(9);
		cell10.innerHTML= data.city;
	var cell11=newRow.incertCell(10);
		cell11.innerHTML= data.dateOfUnemployment;
	var cell12=newRow.incertCell(11);
		cell12.innerHTML= data.photo;
	var cell13=newRow.incertCell(12);
		cell13.innerHTML= data.income;
	
}




